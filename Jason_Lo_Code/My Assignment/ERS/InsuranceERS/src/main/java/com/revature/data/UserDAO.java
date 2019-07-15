package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Info;
import com.revature.pojos.User;
import com.revature.utl.ConnectionFactory;

public class UserDAO {
	static UserDAO userDAO = new UserDAO();
	static User user = new User();
	
	
	
	public User getByUsername(String username) {
		User u = null;
				
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_users where lower(ers_username) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase()); 
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setErs_users_id(rs.getInt(1));
				u.setErs_username(rs.getString(2));
				u.setErs_password(rs.getString(3));
				u.setUser_first_name(rs.getString(4));
				u.setUser_lastname(rs.getString(5));
				u.setUser_email(rs.getString(6));
				u.setUser_role_id(rs.getInt(7));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}
	
	
	public List<User> findAll(){
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ers_users");
			while(rs.next()) {
				User a = new User();
				a.setErs_users_id(rs.getInt(1));
				a.setErs_username(rs.getString(2));
				a.setErs_password(rs.getString(3));
				a.setUser_first_name(rs.getString(4));
				a.setUser_lastname(rs.getString(5));
				a.setUser_email(rs.getString(6));
				a.setUser_role_id(rs.getInt(7));

				Users.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}
	
	public Info getRemibInfo(User u) {
		
	}
	
	


	
}
