package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;


public class UserDAO {

	
	public boolean checkUser(User userObject1){
		boolean exUsers = false;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			 String query = "SELECT * FROM BANK_USER WHERE USERNAME = ? AND PASSWORD = ?";
			 PreparedStatement ps = conn.prepareStatement(query);
			 ps.setString(1, userObject1.getUsername());
			 ps.setString(2, userObject1.getPassword());
			 System.out.println("Username: " +userObject1.getUsername());
		
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 exUsers=true;
				 userObject1.setUsername(rs.getString("Username"));
				 userObject1.setPassword(rs.getString("Password"));
				 
			 }
		} 
				
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exUsers;
	}
	
	public User save(User userObj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO BANK_USER (Firstname, Lastname, Username, Password) Values (?,?,?,?)";
			String[] generatedKeys = {"U_ID"};
			
			System.out.println("User OBJECT..."+userObj.toString());
			
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setString(1, userObj.getFirstname());
			ps.setString(2, userObj.getLastname());
			ps.setString(3, userObj.getUsername());
			ps.setString(4, userObj.getPassword());
			
			ps.executeUpdate();
			
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			userObj.setId(pk.getInt(1));
			
			System.out.println("New User added Successfully...");
		}
		
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Username already exists. Please try again!!");
		}
		catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
		return userObj;	
	
	}
	
}
