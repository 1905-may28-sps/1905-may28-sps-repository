package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.*;
import com.revature.util.ConnectionFactory;

public class UserDao {
	
	public List<ErsUser> findAll(){
		List<ErsUser> Users = new ArrayList<ErsUser>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ERS_USERS");
			while(rs.next()) {
				ErsUser a = new ErsUser();
				a.setId(rs.getInt(1));
				a.setFirstname(rs.getString(2));
				a.setLastname(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setUsername(rs.getString(5));
				a.setPassword(rs.getString(6));
				Users.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}

public ErsUser getByUsername(String username) {
	ErsUser u = null;
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		String query = "SELECT * FROM ERS_USERS WHERE USERNAME = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,username.toLowerCase());
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			u = new ErsUser();
			u.setId(rs.getInt(1));
			u.setFirstname(rs.getString(2));
			u.setLastname(rs.getString(3));
			u.setEmail(rs.getString(4));
			u.setUsername(rs.getString(5));
			u.setPassword(rs.getString(6));
			u.setUserRoleId(rs.getInt(7));
			return u;
			}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return u; 
	}

public UserInformation getUserInfo(ErsUser u) {
	UserInformation info = new UserInformation();
	
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		String sql = "SELECT U.USER_ID, U.FIRSTNAME, U.LASTNAME, R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_SUBMITTED, R.REIMB_RESOLVED, R.REIMB_RESOLVER, RS.REIMB_STATUS"
				+ " FROM ERS_REIMBURSEMENT R " 
				+ " INNER JOIN ERS_USERS U ON R.REIMB_AUTHOR = U.USER_ID "
				+ " INNER JOIN ERS_REIMBURSEMENT_STATUS RS ON R.REIMB_STATUS_ID = RS.REIMB_STATUS_ID "
				+ " WHERE USERNAME = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, u.getUsername());
		info.setUser(u);
		List<ReimbAccount> accounts = new ArrayList<ReimbAccount>();

		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ReimbAccount temp = new ReimbAccount();
			temp.setId(rs.getInt(1));
			temp.setFirstname(rs.getString(2));
			temp.setLastname(rs.getString(3));
			temp.setReimbId(rs.getInt(4));
			temp.setAmount(rs.getInt(5));
			temp.setrSubDate(rs.getString(6));
			temp.setrResDate(rs.getString(7));
			temp.setrResId(rs.getInt(8));
			temp.setReimStatus(rs.getString(9));
			accounts.add(temp);
		}
		info.setAccounts(accounts);
		return info;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return info;
 }

public UserInformation getManagerPage(ErsUser u) {
	UserInformation info = new UserInformation();
	
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		String sql = "SELECT U.USER_ID, U.FIRSTNAME, U.LASTNAME, R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_SUBMITTED, R.REIMB_RESOLVED, R.REIMB_RESOLVER, RS.REIMB_STATUS"
				+ " FROM ERS_REIMBURSEMENT R " 
				+ " INNER JOIN ERS_USERS U ON R.REIMB_AUTHOR = U.USER_ID "
				+ " INNER JOIN ERS_REIMBURSEMENT_STATUS RS ON R.REIMB_STATUS_ID = RS.REIMB_STATUS_ID ";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		info.setUser(u);
		List<ReimbAccount> accounts = new ArrayList<ReimbAccount>();

		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ReimbAccount temp = new ReimbAccount();
			temp.setId(rs.getInt(1));
			temp.setFirstname(rs.getString(2));
			temp.setLastname(rs.getString(3));
			temp.setReimbId(rs.getInt(4));
			temp.setAmount(rs.getInt(5));
			temp.setrSubDate(rs.getString(6));
			temp.setrResDate(rs.getString(7));
			temp.setrResId(rs.getInt(8));
			temp.setReimStatus(rs.getString(9));
			accounts.add(temp);
		}
		info.setAccounts(accounts);
		return info;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return info;
}
}