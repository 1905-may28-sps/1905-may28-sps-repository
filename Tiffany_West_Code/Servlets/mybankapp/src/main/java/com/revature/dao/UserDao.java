package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.AccountInfo;
import com.revature.pojos.User;
import com.revature.pojos.UserInformation;
import com.revature.util.ConnectionFactory;

public class UserDao {

	
	public List<User> findAll(){
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from bank_user");
			while(rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				a.setUsername(rs.getString(4));
				a.setPassword(rs.getString(5));
				Users.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}
	
	//add get username  change the lower username that's probably giving you the error
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
				u.setUsername(rs.getString(4));
				u.setPassword(rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
		
	}
	
	public UserInformation getUserInfo(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select  acc.account_id , acc.balance, type.type " + 
					"from bank_account_ acc " + 
					"inner join bank_account_type type " + 
					"on acc.type_id = type.type_id " + 
					"where acc.user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());

			UserInformation info = new UserInformation();
			info.setUser(u);
			List<AccountInfo> accounts = new ArrayList<AccountInfo>();

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AccountInfo temp = new AccountInfo();
				temp.setId(rs.getInt(1));
				temp.setBalance(rs.getDouble(2));
				temp.setType(rs.getString(3));
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
