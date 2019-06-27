package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.*;
import com.revature.util.ConnectionFactory;

public class UserDao {

	public UserDao() {}
	
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "select * from BANK_USER";
			 
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			
	
			while(rs.next()) {
				User temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				users.add(temp);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public boolean createUser(String firstName, String lastName, String username, String password) {
	User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "INSERT INTO BANK_USER VALUES (USER_SEQ.NEXTVAL, ?, ?, ?, ?)";			 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.executeQuery();

		
			
						
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
		
	}
	
	
	public User findUser(String username){
		
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "select * from BANK_USER WHERE USERNAME = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {					
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
								
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	
	
}
