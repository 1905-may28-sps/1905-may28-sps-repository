package com.revature.data;

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
	
	public List<User> findAll(){
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Bank_User");
			while(rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				a.setEmail(rs.getString(5));
				a.setUsername(rs.getString(4));
				a.setPassword(rs.getString(6));
				Users.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}
	
	public User getByUsername(String username) {
		User u = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from bank_user where lower(username) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username.toLowerCase()); //compare without case
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setEmail(rs.getString(5));
				u.setUsername(rs.getString(4));
				u.setPassword(rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
		
	}

}
