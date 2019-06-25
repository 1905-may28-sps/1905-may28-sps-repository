package com.animoBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.animoBank.pojo.BankUser;
import com.animoBank.util.ConnectionFactory;

public class BankUserDAO {

	public List<BankUser> findAll() {
		List<BankUser> bankUsers = new ArrayList<BankUser>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "select * from BANK_USER";

			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				BankUser temp = new BankUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				bankUsers.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bankUsers;
	}

//	public BankUser findById(int id) {
//		BankUser bnkUsr
//	}
	public BankUser findById(int id) {
		BankUser user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "Select * from BANKUSER where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				user = new BankUser();
				user.setUserId(result.getInt(1));
				user.setFirstname(result.getString(2));
				user.setLastname(result.getString(3));
				user.setUsername(result.getString(4));
				user.setUsrPassword(result.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public BankUser findByUsername(String username, String password) {
		BankUser user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from BANK_USER where username = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				user = new BankUser();
				user.setUserId(result.getInt(1));
				user.setFirstname(result.getString(2));
				user.setLastname(result.getString(3));
				user.setUsername(result.getString(4));
				user.setUsrPassword(result.getString(5));
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public BankUser findByUsername(String username) {
		BankUser user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from BANK_USER where username_ = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				user = new BankUser();
				user.setUserId(result.getInt(1));
				user.setFirstname(result.getString(2));
				user.setLastname(result.getString(3));
				user.setUsername(result.getString(4));
				user.setUsrPassword(result.getString(5));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
