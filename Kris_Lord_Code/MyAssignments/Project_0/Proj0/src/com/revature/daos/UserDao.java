package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.utils.ConnectionFactory;

public class UserDao {
	
	public List<User> findAll(){
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Bank_User");
			while(rs.next()) {
				User a = new User();
				a.setUserId(rs.getInt(1));
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setLoginName(rs.getString(5));
				a.setPassword(rs.getString(6));
				Users.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}

	public User getUserByUserName(String user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_user WHERE lower(loginname)=?");
	        ps.setString(1, user.toLowerCase());
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	User b = new User();
	        	b.setUserId(rs.getInt(1));
				b.setFirstName(rs.getString(2));
				b.setLastName(rs.getString(3));
				b.setEmail(rs.getString(4));
				b.setLoginName(rs.getString(5));
				b.setPassword(rs.getString(6));
	            return b;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public User getUserByUserNameAndPassword(String user, String pass) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_user WHERE lower(loginname)=? AND password=?");
	        ps.setString(1, user.toLowerCase());
	        ps.setString(2, pass);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	User b = new User();
	        	b.setUserId(rs.getInt(1));
				b.setFirstName(rs.getString(2));
				b.setLastName(rs.getString(3));
				b.setEmail(rs.getString(4));
				b.setLoginName(rs.getString(5));
				b.setPassword(rs.getString(6));
	            return b;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public User save(User bku) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Bank_User (FIRSTNAME, LASTNAME, email, loginname, password) VALUES (?, ?, ?, ?, ?)";
			String[] generatedKeys = {"USERID"}; 
			
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setString(1, bku.getFirstName());
			ps.setString(2, bku.getLastName());
			ps.setString(3, bku.getEmail());
			ps.setString(4, bku.getLoginName());
			ps.setString(5, bku.getPassword());
			
			ps.executeUpdate();
			
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();
			bku.setUserId(pk.getInt(1));
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bku;
	}
}