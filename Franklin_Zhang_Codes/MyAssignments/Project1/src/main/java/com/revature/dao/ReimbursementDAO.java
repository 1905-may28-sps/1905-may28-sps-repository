package com.revature.dao;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LoggingMXBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.pojo.ReimbursementInfo;
import com.revature.pojo.StatusInfo;
import com.revature.pojo.UserInfo;
import com.revature.pojo.Users;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO {

	public List<ReimbursementInfo> findALLREIMB() {
		List<ReimbursementInfo> Reimbursement = new ArrayList<ReimbursementInfo>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ERS_REIMBURSEMENT");
			while (rs.next()) {
				ReimbursementInfo r = new ReimbursementInfo();
				r.setReimb_id(rs.getInt(1));
				r.setReimb_amount(rs.getDouble(2));
				r.setReimb_submitted(rs.getString(3));
				r.setReimb_resolved(rs.getString(4));
				r.setReimb_description(rs.getString(5));
				r.setReimb_receipt(rs.getString(6));
				r.setReimb_author(rs.getString(7));
				r.setReimb_resolver(rs.getString(8));
				r.setReimb_status_id(rs.getString(9));
				r.setReimb_type_id(rs.getString(10));
				Reimbursement.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Reimbursement;
	}

	public UserInfo getAllreimb(Users u) {
		//UserInfo info = new UserInfo();
				try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
					UserInfo info = new UserInfo();
					String sql = "select reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, b.user_first_name as Auth ,a.user_first_name as mng, stat.reimb_status, t.reimb_type " + 
							"from ers_reimbursement reimb " + 
							"left join ers_users a on a.ERS_USERS_ID=reimb.reimb_resolver " + 
							"inner join ers_users b on b.ERS_USERS_ID=reimb.reimb_author " + 
							"inner join ers_reimbursement_status stat on stat.reimb_status_id=reimb.reimb_status_id " + 
							"inner join ers_reimbursement_type t on t.reimb_type_id=reimb.reimb_type_id";
							
					//String sql = "select * from ers_reimbursement where reimb_author=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					
				
					List<ReimbursementInfo> accounts = new ArrayList<ReimbursementInfo>();

					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						
						ReimbursementInfo temp = new ReimbursementInfo();
						temp.setReimb_id(rs.getInt(1));
						temp.setReimb_amount(rs.getDouble(2));
						temp.setReimb_submitted(rs.getString(3));
						temp.setReimb_resolved(rs.getString(4));
						temp.setReimb_description(rs.getString(5));
						//temp.setReimb_receipt(rs.getString(6));
						temp.setReimb_author(rs.getString(7));
						temp.setReimb_resolver(rs.getString(8));
						temp.setReimb_status_id(rs.getString(9));
						temp.setReimb_type_id(rs.getString(10));
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

	//
	
	
	public UserInfo getUserInfo(Users u) {
		//UserInfo info = new UserInfo();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			UserInfo info = new UserInfo();
			String sql = "select reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, b.user_first_name as Auth ,a.user_first_name as mng, stat.reimb_status, t.reimb_type " + 
					"from ers_reimbursement reimb " + 
					"left join ers_users a on a.ERS_USERS_ID=reimb.reimb_resolver " + 
					"inner join ers_users b on b.ERS_USERS_ID=reimb.reimb_author " + 
					"inner join ers_reimbursement_status stat on stat.reimb_status_id=reimb.reimb_status_id " + 
					"inner join ers_reimbursement_type t on t.reimb_type_id=reimb.reimb_type_id " + 
					"where reimb_author = ?";
			//String sql = "select * from ers_reimbursement where reimb_author=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserID());
			info.setUserID(u);
			List<ReimbursementInfo> accounts = new ArrayList<ReimbursementInfo>();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ReimbursementInfo temp = new ReimbursementInfo();
				temp.setReimb_id(rs.getInt(1));
				temp.setReimb_amount(rs.getDouble(2));
				temp.setReimb_submitted(rs.getString(3));
				temp.setReimb_resolved(rs.getString(4));
				temp.setReimb_description(rs.getString(5));
				//temp.setReimb_receipt(rs.getString(6));
				temp.setReimb_author(rs.getString(7));
				temp.setReimb_resolver(rs.getString(8));
				temp.setReimb_status_id(rs.getString(9));
				temp.setReimb_type_id(rs.getString(10));
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
	
	
	//change this to callable statment for dates to show
	public ReimbursementInfo addReimbursement1(ReimbursementInfo user, Users usersess) {
		//UserInfo info = new UserInfo();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			UserInfo info = new UserInfo();
			
			String sql = "insert into  ers_reimbursement (REIMB_AMOUNT,reimb_submitted,REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID,  REIMB_TYPE_ID) "
					+ "VALUES (?,current_date,?,?,?,?)";
			String[] generatedKeys = {"REimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			
			ps.setDouble(1, user.getReimb_amount());
			//ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setString(2, user.getReimb_description());
			ps.setInt(3, usersess.getUserID());
			ps.setInt(4, 1);
			ps.setString(5, user.getReimb_type_id());
	
			ps.executeQuery();
			ResultSet pk = ps.getGeneratedKeys();
			pk.next();

			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

public ReimbursementInfo addReimbursement(ReimbursementInfo user,Users usersess) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//insql(uId IN Number, ANum IN NUMBER, WithDep in number) 
			String sql = "{call ADDREIMBURSMENTS(?,?,?,?)}";
		
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, user.getReimb_amount());;
			cs.setString(2, user.getReimb_description());
			cs.setInt(3, usersess.getUserID());
			cs.setString(4, user.getReimb_type_id());
			cs.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
public StatusInfo getReimbByStatus(StatusInfo user) {
	
	
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
				StatusInfo info = new StatusInfo();
				String sql = "select reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, b.user_first_name as Auth ,a.user_first_name as mng, stat.reimb_status, t.reimb_type " + 
						"from ers_reimbursement reimb " + 
						"left join ers_users a on a.ERS_USERS_ID=reimb.reimb_resolver " + 
						"inner join ers_users b on b.ERS_USERS_ID=reimb.reimb_author " + 
						"inner join ers_reimbursement_status stat on stat.reimb_status_id=reimb.reimb_status_id " + 
						"inner join ers_reimbursement_type t on t.reimb_type_id=reimb.reimb_type_id where reimb.reimb_status_id =?";
						
				//String sql = "select * from ers_reimbursement where reimb_author=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getReimb_status_id());
				
			
				List<ReimbursementInfo> accounts = new ArrayList<ReimbursementInfo>();

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					ReimbursementInfo temp = new ReimbursementInfo();
					temp.setReimb_id(rs.getInt(1));
					temp.setReimb_amount(rs.getDouble(2));
					temp.setReimb_submitted(rs.getString(3));
					temp.setReimb_resolved(rs.getString(4));
					temp.setReimb_description(rs.getString(5));
					//temp.setReimb_receipt(rs.getString(6));
					temp.setReimb_author(rs.getString(7));
					temp.setReimb_resolver(rs.getString(8));
					temp.setReimb_status_id(rs.getString(9));
					temp.setReimb_type_id(rs.getString(10));
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
	
	public ReimbursementInfo updateReimbursement(ReimbursementInfo user,Users usersess) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//insql(uId IN Number, ANum IN NUMBER, WithDep in number) 
			String sql = "{call ApproveDeny(?,?,?)}";
		
			System.out.println( user.getReimb_id());
			System.out.println(usersess.getUserID());
			System.out.println(user.getReimb_status_id());
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, user.getReimb_id());
			cs.setDouble(2, usersess.getUserID());
			cs.setString(3, user.getReimb_status_id());
			cs.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
// Get back to this...	
//	public void addblob() {
//	
//    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8809/Project1/Main.html", "root", "root");
//    Blob b1 = conn.createBlob();
//    b1.setBytes(1, new byte[10]); 
//    // first position is 1. Otherwise you get: Value of offset/position/start should be in the range [1, len] where len is length of Large Object[LOB]
//
//    PreparedStatement ps = conn.prepareStatement("update Ers_reiumbursement set ERS_reimbursement_receipt = ?");
//    ps.setBlob(1, wheremyblobimageisstored);
//    ps.executeUpdate();
//
//    Statement st = conn.createStatement();
//    ResultSet rs = st.executeQuery("select c1 from t1");
//    Blob b2 = rs.getBlob(1);
//	}
}
