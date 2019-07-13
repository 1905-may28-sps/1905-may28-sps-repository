package com.revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.AccountInfo;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.pojos.UserInformation;
import com.revature.util.ConnectionFactory;

public class UserDAO {

	public List<User> findAll(){
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ers_users");
			while(rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setFirstName(rs.getString(4));
				a.setLastName(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setRoleId(rs.getInt(7));
				Users.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return Users;
	}
	
	//start login here
	public User getByUsername(String username) {
		User u = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ers_users where lower(ers_username) =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username.toLowerCase());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setRoleId(rs.getInt(7));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}
	
	//for employees
	public UserInformation getUserInfo(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql= " select main.REIMB_ID, main.reimb_amount, main.reimb_submitted, main.reimb_resolved, main.reimb_description, rtype.reimb_type, status.reimb_status " + 
					"from ers_reimbursement main " + 
					"inner join  ers_reimbursement_type     rtype     on main.reimb_type_id = rtype.reimb_type_id " + 
					"inner join ers_reimbursement_status  status     on main.reimb_status_id = status.reimb_status_id " + 
					"where main.reimb_author =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			
			UserInformation info = new UserInformation();
			info.setUser(u);
			List<AccountInfo> accounts = new ArrayList<AccountInfo>();
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AccountInfo temp = new AccountInfo();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getString(3));
				temp.setResolved(rs.getString(4));
				temp.setDescription(rs.getString(5));
				temp.setType(rs.getString(6));
				temp.setStatus(rs.getString(7));
				accounts.add(temp);
			}
			info.setAccounts(accounts);
			return info;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public UserInformation getEmpInfo(User u) {
		UserInformation info = new UserInformation();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql= "select   main.REIMB_ID,  reimb_author, main.reimb_amount, main.reimb_submitted, main.reimb_resolved, main.reimb_description, rtype.reimb_type, status.reimb_status " + 
					"from ers_reimbursement main " + 
					"inner join  ers_reimbursement_type     rtype     on main.reimb_type_id = rtype.reimb_type_id " + 
					"inner join ers_reimbursement_status  status     on main.reimb_status_id = status.reimb_status_id ";
					
					
			PreparedStatement ps = conn.prepareStatement(sql);
			
			info.setUser(u);
			List<AccountInfo> accounts = new ArrayList<AccountInfo>();
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AccountInfo temp = new AccountInfo();
				temp.setId(rs.getInt(1));
				temp.setAuthor(rs.getInt(2));
				temp.setAmount(rs.getDouble(3));
				temp.setSubmitted(rs.getString(4));
				temp.setResolved(rs.getString(5));
				temp.setDescription(rs.getString(5));
				temp.setType(rs.getString(7));
				temp.setStatus(rs.getString(8));
				accounts.add(temp);
			}
			info.setAccounts(accounts);
			return info;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	
	
	public List<AccountInfo> findEmpAll(User u){
		List<AccountInfo> minfo= new ArrayList<AccountInfo>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select   main.REIMB_ID, main.reimb_amount, main.reimb_submitted, main.reimb_resolved, main.reimb_description, rtype.reimb_type, status.reimb_status " + 
					"from ers_reimbursement main " + 
					"inner join  ers_reimbursement_type     rtype     on main.reimb_type_id = rtype.reimb_type_id " + 
					"inner join ers_reimbursement_status  status     on main.reimb_status_id = status.reimb_status_id";
		PreparedStatement ps = conn.prepareStatement(query);
		
		UserInformation info = new UserInformation();
		info.setUser(u);ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			AccountInfo temp = new AccountInfo();
			temp.setId(rs.getInt(1));
			temp.setAmount(rs.getDouble(2));
			temp.setSubmitted(rs.getString(3));
			temp.setResolved(rs.getString(4));
			temp.setDescription(rs.getString(5));
			temp.setStatus(rs.getString(6));
			temp.setType(rs.getString(7));
			minfo.add(temp);
			
			info.setAccounts(minfo);

		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
	
	

	
}
