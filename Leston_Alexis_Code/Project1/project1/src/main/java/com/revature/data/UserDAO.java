package com.revature.data;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.ReimbInfo;
import com.revature.pojos.User;
import com.revature.pojos.UserInfo;
import com.revature.util.ConnectionFactory;

public class UserDAO {
	
	
	public List<User> findAll(){
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM USERS");
			while(rs.next()) {
				User a = new User();
				a.setUserId(rs.getInt(1));
				a.setFirstName(rs.getString(4));
				a.setLastName(rs.getString(5));
				a.setUserEmail(rs.getString(6));
				a.setUserName(rs.getString(2));
				a.setPassWord(rs.getString(3));
				a.setRoleId(rs.getInt(7));
				Users.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}

	public User getByUsername(String username) {
		User a = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM USERS WHERE LOWER(USERNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username.toLowerCase()); //compare without case
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new User();
				a.setUserId(rs.getInt(1));
				a.setFirstName(rs.getString(4));
				a.setLastName(rs.getString(5));
				a.setUserEmail(rs.getString(6));
				a.setUserName(rs.getString(2));
				a.setPassWord(rs.getString(3));
				a.setRoleId(rs.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;

	}

	public UserInfo getUserInfo(User u) {
		UserInfo info = new UserInfo();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			
			String sql = "SELECT REIMBURSEMENT.REIMB_ID, REIMBURSEMENT.REIMB_AMOUNT, REIMBURSEMENT.REIMB_SUBMITTED, REIMBURSEMENT.REIMB_RESOLVED, "+
					  "REIMBURSEMENT.REIMB_DESCRIPTION, USERS.FIRST_NAME, USERS.LAST_NAME,  "+
					  "REIMBURSEMENT_STATUS.REIMB_STATUS, REIMBURSEMENT_TYPE.REIMB_TYPE "+
					  "FROM REIMBURSEMENT INNER JOIN USERS ON REIMBURSEMENT.REIMB_AUTHOR = USERS.USER_ID "+
										"INNER JOIN REIMBURSEMENT_STATUS ON REIMBURSEMENT.REIMB_STATUS_ID = REIMBURSEMENT_STATUS.REIMB_STATUS_ID "+ 
									"INNER JOIN REIMBURSEMENT_TYPE ON REIMBURSEMENT.REIMB_TYPE_ID = REIMBURSEMENT_TYPE.REIMB_TYPE_ID "+
										"WHERE REIMBURSEMENT.REIMB_AUTHOR  = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserId());

			
			info.setUser(u);
			List<ReimbInfo> reimb = new ArrayList<ReimbInfo>();

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ReimbInfo temp = new ReimbInfo();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getString(3));
				temp.setReimbResolved(rs.getString(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthorFirst(rs.getString(6));
				temp.setReimbAuthorLast(rs.getString(7));
				temp.setReimbResolver(rs.getString(7));
				temp.setReimbStatusId(rs.getString(8));
				temp.setReimbTypeId(rs.getString(9));
				reimb.add(temp);
			}
			info.setReimbursement(reimb);
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

public UserInfo getAllUserInfo(User u) {
		UserInfo info = new UserInfo();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT REIMBURSEMENT.REIMB_ID, REIMBURSEMENT.REIMB_AMOUNT, REIMBURSEMENT.REIMB_SUBMITTED, "
					+ "REIMBURSEMENT.REIMB_RESOLVED, REIMBURSEMENT.REIMB_DESCRIPTION, " + 
					"USERS.FIRST_NAME, USERS.LAST_NAME, " + 
					"REIMBURSEMENT_STATUS.REIMB_STATUS, REIMBURSEMENT_TYPE.REIMB_TYPE FROM REIMBURSEMENT "
					+"INNER JOIN USERS ON REIMBURSEMENT.REIMB_AUTHOR = USERS.USER_ID " + 
					"INNER JOIN REIMBURSEMENT_STATUS ON REIMBURSEMENT.REIMB_STATUS_ID=REIMBURSEMENT_STATUS.REIMB_STATUS_ID " + 
					"INNER JOIN REIMBURSEMENT_TYPE ON REIMBURSEMENT.REIMB_TYPE_ID = REIMBURSEMENT_TYPE.REIMB_TYPE_ID " ;
			PreparedStatement ps = conn.prepareStatement(sql);
			info.setUser(u);
			List<ReimbInfo> reimbursement = new ArrayList<ReimbInfo>();

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ReimbInfo temp = new ReimbInfo();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getString(3));
				temp.setReimbResolved(rs.getString(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthorFirst(rs.getString(6));
				temp.setReimbAuthorLast(rs.getString(7));
				temp.setReimbResolver(rs.getString(7));
				temp.setReimbStatusId(rs.getString(8));
				temp.setReimbTypeId(rs.getString(9));
				reimbursement.add(temp);
			}
			info.setReimbursement(reimbursement);
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	