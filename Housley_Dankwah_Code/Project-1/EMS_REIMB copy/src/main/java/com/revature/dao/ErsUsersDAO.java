package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ErsReimbursementInfo;
import com.revature.pojo.ErsUser;
import com.revature.pojo.ErsUserInformation;
import com.revature.util.ConnectionFactory;

public class ErsUsersDAO {
	
	
	public List<ErsUser> findAll(){
		List<ErsUser> users = new ArrayList<ErsUser>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS ";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				ErsUser a = new ErsUser();
				a.setErsUserId(rs.getInt(1));
				a.setErsUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setUserFirstName(rs.getString(4));
				a.setUserLastName(rs.getString(5));
				a.setUserEmail(rs.getString(6));
				a.setUserRoleId(rs.getInt(7));
				users.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	
	public ErsUser getByUsername(String ersUsername) {
		ErsUser user = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ERS_USERS  where lower(ERS_USERNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("in UserDao for login" + user);

			ps.setString(1, ersUsername.toLowerCase()); 
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new ErsUser();
				user.setErsUserId(rs.getInt(1));
				user.setErsUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUserFirstName(rs.getString(4));
				user.setUserLastName(rs.getString(5));
				user.setUserEmail(rs.getString(6));
				user.setUserRoleId(rs.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("IN USER DAO for login2 " + user);

		return user;
	}
	
	
	public ErsUserInformation getUserInfo(ErsUser user) {
		if(user.getErsUserId() == 1) {
			System.out.println( " in userDao for getting user info" + user.getErsUserId());
			return  getManagerInfo(user);
			
		}
				return  getEmployeeInfo(user);
			
		}

	
	public ErsUserInformation getManagerInfo(ErsUser user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select rm.reimb_id , us.user_first_name, us.user_lastname, rm.reimb_amount, \n " + 
					"rm.reimb_description, rm.reimb_submitted,  \n" + 
					"rt.reimb_type, rs.reimb_status\n " + 
					"from ers_users us\n " + 
					"join ers_reimbursement rm\n " + 
					"on us.ers_users_id = rm.reimb_author\n " + 
					"join ers_reimbursement_status rs\n " + 
					"on rm.reimb_status_id = rs.reimb_status_id\n " + 
					"join ers_reimbursement_type rt\n " + 
					"on rm.reimb_type_id = rt.reimb_type_id ";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ErsUserInformation info = new ErsUserInformation();
			info.setUser(user);
			List<ErsReimbursementInfo> reimbursement = new ArrayList<ErsReimbursementInfo>();
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ErsReimbursementInfo temp = new ErsReimbursementInfo();
				temp.setReimbId(rs.getInt(1));
				temp.setSubUserFirstName(rs.getString(2));
				temp.setSubUserLastName(rs.getString(3));
				temp.setReimbAmount(rs.getDouble(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbSubmittedDate(rs.getString(6));
				temp.setReimbType(rs.getString(7));
				temp.setReimbStatus(rs.getString(8));
				reimbursement.add(temp);
			}
			info.setReimbursmentInfo(reimbursement);
			System.out.println("in ersuserDao " + info);
			return info;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public ErsUserInformation getEmployeeInfo(ErsUser user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select rm.reimb_id, us.user_first_name, us.user_lastname, rm.reimb_amount,\n " +
					" rm.reimb_description, rm.reimb_submitted,\n " + 
					"rt.reimb_type, rs.reimb_status\n " + 
					"from ers_users us\n " + 
					"join ers_reimbursement rm\n " + 
					"on us.ers_users_id = rm.reimb_author\n " + 
					"join ers_reimbursement_status rs\n " + 
					"on rm.reimb_status_id = rs.reimb_status_id\n " + 
					"join ers_reimbursement_type rt\n " + 
					"on rm.reimb_type_id = rt.reimb_type_id\n " + 
					"where us.ers_users_id = ? ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getErsUserId());
			
			ErsUserInformation info = new ErsUserInformation();
			info.setUser(user);
			List<ErsReimbursementInfo> reimbursement = new ArrayList<ErsReimbursementInfo>();
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ErsReimbursementInfo temp = new ErsReimbursementInfo();
				temp.setReimbId(rs.getInt(1));
				temp.setSubUserFirstName(rs.getString(2));
				temp.setSubUserLastName(rs.getString(3));
				temp.setReimbAmount(rs.getDouble(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbSubmittedDate(rs.getString(6));
				temp.setReimbType(rs.getString(7));
				temp.setReimbStatus(rs.getString(8));
				reimbursement.add(temp);
			}
			info.setReimbursmentInfo(reimbursement);
			System.out.println("in ersuserDao " + info);
			return info;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
		
}

