package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class UserDAO {

	public List<User> findAll() {

		List<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from BANK_USER");

			while (rs.next()) {
				User temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User findById(int id) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from BANK_USER where USER_ID = ?");
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				u = new User();
				u.setId(result.getInt(1));
				u.setFirstName(result.getString(2));
				u.setLastName(result.getString(3));
				u.setUserName(result.getString(4));
				u.setPw(result.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public User findByUn(String name) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from BANK_USER where USERNAME = ?");
			ps.setString(1, name);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				u = new User();
				u.setId(result.getInt(1));
				u.setFirstName(result.getString(2));
				u.setLastName(result.getString(3));
				u.setUserName(result.getString(4));
				u.setPw(result.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public User save(User use) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "INSERT INTO BANK_USER (USER_ID, FIRSTNAME, LASTNAME, USERNAME, PASS) VALUES (?,?,?,?,?)";
			// String[] gKeys = { "USER_ID" };

			PreparedStatement ps = conn.prepareStatement(sql/* , gKeys */);
			ps.setInt(1, use.getId());
			ps.setString(2, use.getFirstName());
			ps.setString(3, use.getLastName());
			ps.setString(4, use.getUserName());
			ps.setString(5, use.getPw());
			ps.executeUpdate();
//			ResultSet pk = ps.getGeneratedKeys();
//
//			while (pk.next()) {
//				use.setId(pk.getInt(1));
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return use;
	}

	public User update(User u, String pass) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			PreparedStatement ps = conn.prepareStatement("update BANK_USER set pass = ? where user_id  = ?");
			ps.setString(1, pass);
			System.out.println("SETTING PW TO " + pass);

			ps.setInt(2, u.getId());

			int rowsChanged = ps.executeUpdate();
//			System.out.println("EXECUTED UPDATE");
//
//			if (rowsChanged == 1) {
//				u.setPw(pass);
//			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return u;
	}

}