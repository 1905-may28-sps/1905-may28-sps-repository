package com.animoBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.animoBank.app.BankMain;
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


	public static BankUser findById(int id) {
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

	public static BankUser findByUsernameAndPassword(String username, String password) {
		BankUser user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from BANK_USER where username = ? and usr_password = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
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
	
	public boolean findByUsername(String username) {
		boolean user = false;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from BANK_USER where LOWER(username)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				user = true;
			}
			
		} catch (SQLException e) {
			System.out.println("USERNAME ALREADY EXIST PLEASE TRY AGAIN!");
			//e.printStackTrace();
			BankMain.RegistrationPage();

			
		}
		return user;
	}


	public static BankUser registerMember(BankUser newMember) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "INSERT INTO BANK_USER (FIRSTNAME, LASTNAME, USERNAME, USR_PASSWORD) \n" + 
					"VALUES (?, ?, ?, ?)";
			String[] generatedKeys = {"User_Id"};
			PreparedStatement ps = conn.prepareStatement(query, generatedKeys);
			
			ps.setString(1, newMember.getFirstname());
			ps.setString(2, newMember.getLastname());
			ps.setString(3, newMember.getUsername());
			ps.setString(4, newMember.getUsrPassword());
			
			ps.executeUpdate();
			
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			newMember.setUserId(1);
		
		
		
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("hiiiii");
			BankMain.RegistrationPage();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		
		
		return newMember;
	}


}
