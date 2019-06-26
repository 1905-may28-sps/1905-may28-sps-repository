package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class UserDAO {

	public static String table = "bank_user";
	public static String id = "user_id";
	public static String firstName = "first_name";
	public static String lastName = "last_name";
	public static String userName = "username";
	public static String password = "password";
	
	
	
	
	/*
	 * 
	 * 	//prepared statement for adding user w/ create new user in main, not sure if i'll have
	 * to do the same for account to add and account or when you sign in you can add an account

	 */
	public User addUser (User add) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "insert into bank_user(first_name, last_name,username,password)"
					+ "values(?,?,?,?)";
			
			
			String[] generatedkeys = {"user_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql,generatedkeys);
			ps.setString(1, add.getFirstName());
			ps.setString(2, add.getLastName());
			ps.setString(3, add.getUserName());
			ps.setString(4, add.getPassword());
			
			ps.execute();
			
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			add.setId(pk.getInt(1));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

				
		return add;
		
		
		
	}
	 
	public User login(User cred) {
		 
		 
		 try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			 
			 
			 String sql = "select username, password  from bank_user where username = ? and password = ?";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1, cred.getUserName());
			 pst.setString(2, cred.getPassword());
			 
			 pst.execute();
			 
			 
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
		return cred;
		 
	 }

	
	public User findById(int id) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query  = "select * from bank_user where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				u = new User();
				u.setId(result.getInt(1));
				u.setFirstName(result.getString(2));
				u.setLastName(result.getString(3));
				u.setUserName(result.getString(4));
				u.setPassword(result.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
}
