package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.revature.pojos.Account;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class UserDAO {

	//New registration
	//creating prepared statement		
		public User save(User cust) {
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
								
				String sql = "INSERT INTO BANK_USER(FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD"
						+ ") VALUES (?, ?, ?, ?, ?)";
				String[] generatedKeys = {"U_ID"}; //takes an array just in case we have more than 1 key
				
				PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
				ps.setString(1, cust.getFirstName());
				ps.setString(2, cust.getLastName());
				ps.setString(3, cust.getEmail());
				ps.setString(4, cust.getUsername());
				ps.setString(5, cust.getPassword());
				
				 ps.executeUpdate();
				 
				 ResultSet pk = ps.getGeneratedKeys();
				 pk.next();
				 cust.setId(pk.getInt(1));
				 System.out.println("Registration successful.........\n");
				
				 			 
			} catch (SQLException e) {
				e.printStackTrace();
				
				System.out.println("\n\nInvalid data.........\n");
				System.out.println("\nRegistration failed.........\n\n");
				
			}
			return cust;
		}

	// User login 
		
		public boolean userLogin(User myObj) {
			boolean allUsers=false;
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
				String query  = "SELECT * FROM BANK_USER WHERE USERNAME=? AND PASSWORD=?"; 
						
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, myObj.getUsername());
				ps.setString(2, myObj.getPassword());
				
				//System.out.println(  +myObj.getUsername());
				//System.out.println(  +myObj.getPassword());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					allUsers=true;
					myObj.setUsername(rs.getString("Username"));
					myObj.setPassword (rs.getString ("Password"));
					myObj.setFirstName(rs.getString("FirstName"));
					myObj.setLastName(rs.getString("LastName"));
					myObj.setId(rs.getInt("u_id"));
					//System.out.println(( myObj));
					System.out.println(("Hello !   "+rs.getString("FirstName")+" "+rs.getString("LastName")+"   "+ "Customer ID :"+rs.getInt("u_id")));
		}
				
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
		}
			
		
		
	//validating username	

public boolean userValidate(User myObj1) {
	boolean allUse=false;
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	
		String query  = "SELECT * FROM BANK_USER WHERE USERNAME=?";
				
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, myObj1.getUsername());
				
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		allUse=true;
			myObj1.setUsername(rs.getString("Username"));
			
			
			System.out.println("Hello !" );
			//System.out.println(("Hello !   "+rs.getString("FirstName")+" "+rs.getString("LastName")));
}
		
	} catch (SQLException e) {
	e.printStackTrace();
}
return allUse;
}
}



