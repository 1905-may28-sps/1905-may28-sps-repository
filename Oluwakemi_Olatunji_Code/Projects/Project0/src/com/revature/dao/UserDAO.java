package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.BankUser;
import com.revature.util.ConnectionFactory;

public class UserDAO {

	
	public BankUser save (BankUser user) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "INSERT INTO BANK_USER (FIRST_NAME, LAST_NAME, USERNAME, EMAIL, USER_PASSWORD)"
					+ " VALUES (?, ?, ?, ?, ?)";
			String[] generatedKeys = {"USER_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			
			ps.executeUpdate();
			
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			user.setId(pk.getInt(1));
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		return user;
		
	}
}
	
//	public boolean getUserByUsername (BankUser user) {
//			boolean isItTaken = false;
//			String username = user.getUsername();
//			String sql = "SELECT * FROM BANK_USERS WHERE USERNAME = ?";
//			ResultSet rs = null;
//			
//			try (Connection con = ConnectionUtil.getConnection();
//					PreparedStatement ps = con.prepareStatement(sql);) {
//				ps.setString(1, username);
//				rs = ps.executeQuery();
//				
//				if (!rs.isBeforeFirst()) {
//					isItTaken = true;
//				}
//			} catch (SQLException|IOException e) {
//				logger.error(e.getMessage());
//			} finally {
//				if (rs != null) {
//					try {
//						rs.close();
//					} catch (SQLException e) {
//						System.out.println("Username is taken");
//		
//					}
//				}
//			}
//			return isUnique;
//		}
//	}
//
//}
