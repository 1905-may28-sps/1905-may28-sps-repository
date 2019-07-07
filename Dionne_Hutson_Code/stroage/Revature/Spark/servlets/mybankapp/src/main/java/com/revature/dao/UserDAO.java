package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.AccountInfo;
import com.revature.pojo.User;
import com.revature.pojo.UserInformation;
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


				a.setUsername(rs.getString(5));

				a.setPassword(rs.getString(4));
				Users.add(a);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}
	
	
public User getByUsername(String un) {
		User a=null;
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="select * From Bank_User WHERE lower(USERNAME)=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,un.toLowerCase());
			ResultSet rs=ps.executeQuery();
		
			if(rs.next()) {
				a= new User();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				a.setPassword(rs.getString(4));
				a.setUsername(rs.getString(5));
				
			
			}else {
				return a;}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	 public UserInformation getUserInfo(User u) {
		 try(Connection conn=ConnectionFactory.getInstance().getConnection()){
		 String sql="SELECT * FROM BANK_ACCOUNT WHERE  lower(USERNAME)=?  ";
		 PreparedStatement ps=conn.prepareStatement(sql);
		 ps.setString(1,u.getUsername());
		 UserInformation info= new UserInformation();
		 info.setUser(u);
		 List<AccountInfo> accounts= new ArrayList<AccountInfo>();
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
			 AccountInfo temp =new AccountInfo();
			 temp.setId(rs.getInt(1));
			 temp.setBalance(rs.getDouble(3));
			 temp.setType(rs.getString(2));
			 accounts.add(temp);
		 }
		 info.setAccounts(accounts);
			return info;
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }
}
	
