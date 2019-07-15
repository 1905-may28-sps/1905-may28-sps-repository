package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Users;
import com.revature.util.ConnectionFactory;

public class UsersDAO {

	public List<Users> findALL(){
		List<Users> Users = new ArrayList<Users>();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select * from ERS_Users");
				while(rs.next()) {
					Users a = new Users();
					a.setUserID(rs.getInt(1));
					a.setUName(rs.getString(2));
					a.setPWord(rs.getString(3));
					a.setFName(rs.getString(4));
					a.setLName(rs.getString(5));
					a.setEMail(rs.getString(6));
					a.setURoleID(rs.getInt(7));
					Users.add(a);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return Users;
	}
	public Users getByUsername(String username) {
		Users u = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ERS_USERS where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username.toLowerCase()); //compare without case
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new Users();
				u.setUserID(rs.getInt(1));
				u.setUName(rs.getString(2));
				u.setPWord(rs.getString(3));
				u.setFName(rs.getString(4));
				u.setLName(rs.getString(5));
				u.setEMail(rs.getString(6));
				u.setURoleID(rs.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;

	}
	
	
//	public Users register(Users user) {
//		
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			String sql = "INSERT INTO ERS_USERS (User_FIRST_NAME, User_LAST_NAME, ERS_USERNAME , USER_EMAIL, ERS_PASSWORD, USER_ROLE_ID) VALUES (?, ?, ?, ?, ?,2)";
//			String[] generatedKeys = {"ERS_USERS_ID"}; //takes an array just in case we have more than 1 key
//			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
//			ps.setString(1, user.getFName());
//			ps.setString(2, user.getLName());
//			ps.setString(3, user.getUName());
//			ps.setString(4, user.getEMail());
//			ps.setString(5, user.getPWord());
//			ps.executeUpdate();
//			ResultSet pk = ps.getGeneratedKeys();
//			pk.next();
//	
//		} 
//		catch (SQLIntegrityConstraintViolationException e){
//		System.out.println("Username has been taken.");}
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return user;
//	
//	}
	
	
	
}