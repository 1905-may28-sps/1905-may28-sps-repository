package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.ReimbursementInfo;
import com.revature.pojos.User;
import com.revature.pojos.UserInformation;
import com.revature.util.ConnectionFactory;  

public class UserDAO {

	public List<User> findAll(){
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ERS_USERS");
			while(rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString(4));
				a.setLastName(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
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
			String sql = "SELECT * FROM ERS_USERS WHERE LOWER(ERS_USERNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username.toLowerCase()); //compare without case
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new User();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString(4));
				a.setLastName(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setRoleId(rs.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;

	}

	public UserInformation getUserInfo(User u) {
		UserInformation info = new UserInformation();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			
			String sql = "SELECT ERS_REIMBURSEMENT.REIMB_ID, ERS_REIMBURSEMENT.REMIB_AMOUNT, ERS_REIMBURSEMENT.REIMB_SUMBITTED, "
					+ "ERS_REIMBURSEMENT.REIMB_RESOLVED, ERS_REIMBURSEMENT.REIMB_DESCRIPTION, ERS_USERS.USER_FIRST_NAME, ERS_USERS.USER_LAST_NAME, " + 
					"ERS_REIMBURSEMENT_STATUS.REMIB_STATUS, ERS_REIMBURSEMENT_TYPE.REIMB_TYPE "
					+ "FROM ERS_REIMBURSEMENT INNER JOIN ERS_USERS ON ERS_REIMBURSEMENT.REIMB_AUTHOR = ERS_USERS.ERS_USERS_ID " + 
					"INNER JOIN ERS_REIMBURSEMENT_STATUS ON ERS_REIMBURSEMENT.REIMB_STATUS_ID = ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID " + 
					"INNER JOIN ERS_REIMBURSEMENT_TYPE ON ERS_REIMBURSEMENT.REIMB_TYPE_ID = ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID " + 
					"WHERE ERS_REIMBURSEMENT.REIMB_AUTHOR = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());

			
			info.setUser(u);
			List<ReimbursementInfo> reimbursement = new ArrayList<ReimbursementInfo>();

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ReimbursementInfo temp = new ReimbursementInfo();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSumbit(rs.getString(3));
				temp.setResolve(rs.getString(4));
				temp.setDescript(rs.getString(5));
				temp.setEmployeeFirst(rs.getString(6));
				temp.setEmployeeLast(rs.getString(7));
				temp.setBoss(rs.getString(7));
				temp.setStatus(rs.getString(8));
				temp.setType(rs.getString(9));
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

public UserInformation getAllUserInfo(User u) {
		UserInformation info = new UserInformation();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT ERS_REIMBURSEMENT.REIMB_ID, ERS_REIMBURSEMENT.REMIB_AMOUNT, ERS_REIMBURSEMENT.REIMB_SUMBITTED, "
					+ "ERS_REIMBURSEMENT.REIMB_RESOLVED, ERS_REIMBURSEMENT.REIMB_DESCRIPTION, " + 
					"ERS_USERS.USER_FIRST_NAME, ERS_USERS.USER_LAST_NAME, " + 
					"ERS_REIMBURSEMENT_STATUS.REMIB_STATUS, ERS_REIMBURSEMENT_TYPE.REIMB_TYPE FROM ERS_REIMBURSEMENT "
					+"INNER JOIN ERS_USERS ON ERS_REIMBURSEMENT.REIMB_AUTHOR = ERS_USERS.ERS_USERS_ID " + 
					"INNER JOIN ERS_REIMBURSEMENT_STATUS ON ERS_REIMBURSEMENT.REIMB_STATUS_ID=ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID " + 
					"INNER JOIN ERS_REIMBURSEMENT_TYPE ON ERS_REIMBURSEMENT.REIMB_TYPE_ID = ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID " ;
			PreparedStatement ps = conn.prepareStatement(sql);
			info.setUser(u);
			List<ReimbursementInfo> reimbursement = new ArrayList<ReimbursementInfo>();

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ReimbursementInfo temp = new ReimbursementInfo();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSumbit(rs.getString(3));
				temp.setResolve(rs.getString(4));
				temp.setDescript(rs.getString(5));
				temp.setEmployeeFirst(rs.getString(6));
				temp.setEmployeeLast(rs.getString(6));
				temp.setBoss(rs.getString(7));
				temp.setStatus(rs.getString(8));
				temp.setType(rs.getString(9));
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