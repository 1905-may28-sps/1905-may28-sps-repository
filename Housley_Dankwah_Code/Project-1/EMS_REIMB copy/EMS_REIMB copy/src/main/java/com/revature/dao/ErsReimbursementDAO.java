//package com.revature.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.revature.pojo.ErsReimbursement;
//import com.revature.pojo.ErsReimbursementInfo;
//import com.revature.pojo.ErsUser;
//import com.revature.pojo.ErsUserInformation;
//import com.revature.util.ConnectionFactory;
//
//public class ErsReimbursementDAO {
//	public List<ErsReimbursement> findAll() {
//		List<ErsReimbursement> reimb = new ArrayList<ErsReimbursement>();
//		String sql = "SELECT * FROM ers_reimbursement";
//
//		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			while (rs.next()) {
//				ErsReimbursement re = new ErsReimbursement();
//				re.setReimbId(rs.getInt(1));
//				re.setReimbAmount(rs.getDouble(2));
//				re.setReimbSubmittedDate(rs.getString(3));
//				re.setReimbResolvedDate(rs.getString(4));
//				re.setReimbDescription(rs.getString(5));
//				re.setReimbAuthor(rs.getInt(6));
//				re.setReimbResolver(rs.getInt(7));
//				re.setReimbStatusId(rs.getInt(8));
//				re.setReimbTypeId(rs.getInt(9));
//				reimb.add(re);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return reimb;
//	}
//	
//
//	public ErsUser getByUsername(int reimbId) {
//		ErsUser user = null;
//
//		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			String sql = "update ers_reimbursement set reimb_status_id = 2\n" + "			where reimb_id = ?;";
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ps.setInt(1, user.getErsUserId());
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				user = new ErsUser();
//				user.setErsUserId(rs.getInt(1));
//				user.setErsUsername(rs.getString(2));
//				user.setPassword(rs.getString(3));
//				user.setUserFirstName(rs.getString(4));
//				user.setUserLastName(rs.getString(5));
//				user.setUserEmail(rs.getString(6));
//				user.setUserRoleId(rs.getInt(7));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return user;
//
//	}
//	
//
//	public ErsUserInformation approveReimb(int reimbId, int status) {
//		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			String sql = "update ers_reimbursement set reimb_status_id = ? " + "where reimb_id = ?";
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, status);
//			ps.setInt(2, reimbId);
//
//			ErsUserInformation info2 = new ErsUserInformation();
//			ErsReimbursement info = new ErsReimbursement();
//			info.setReimbStatusId(reimbId);
//			
//			System.out.println("in reimb dao for approved " + reimbId);
//
//			List<ErsReimbursementInfo> reimbursement = new ArrayList<ErsReimbursementInfo>();
//
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				ErsReimbursementInfo temp = new ErsReimbursementInfo();
//				temp.setReimbId(rs.getInt(1));
//				temp.setSubUserFirstName(rs.getString(2));
//				temp.setSubUserLastName(rs.getString(3));
//				temp.setReimbAmount(rs.getDouble(4));
//				temp.setReimbDescription(rs.getString(5));
//				temp.setReimbSubmittedDate(rs.getString(6));
//				temp.setReimbType(rs.getString(7));
//				temp.setReimbStatus(rs.getString(8));
//				reimbursement.add(temp);
//			}
//			info2.setReimbursmentInfo(reimbursement);
//			System.out.println("in ersuserDao 2  info 2" + info2);
//			return info2;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//}

package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ErsReimbursement;
import com.revature.pojo.ErsReimbursementInfo;
import com.revature.pojo.ErsUser;
import com.revature.pojo.ErsUserInformation;
import com.revature.util.ConnectionFactory;

public class ErsReimbursementDAO {
	public List<ErsReimbursement> findAll() {
		List<ErsReimbursement> reimb = new ArrayList<ErsReimbursement>();
		String sql = "SELECT * FROM ers_reimbursement";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ErsReimbursement re = new ErsReimbursement();
				re.setReimbId(rs.getInt(1));
				re.setReimbAmount(rs.getDouble(2));
				re.setReimbSubmittedDate(rs.getString(3));
				re.setReimbResolvedDate(rs.getString(4));
				re.setReimbDescription(rs.getString(5));
				re.setReimbAuthor(rs.getInt(6));
				re.setReimbResolver(rs.getInt(7));
				re.setReimbStatusId(rs.getInt(8));
				re.setReimbTypeId(rs.getInt(9));
				reimb.add(re);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimb;
	}
	

	public ErsUser getByUsername(int reimbId) {
		ErsUser user = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update ers_reimbursement set reimb_status_id = 2\n" + "			where reimb_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getErsUserId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
		return user;

	}
	

	public ErsReimbursement approveReimb2(int reimbStatusId, int reimbId) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update ers_reimbursement set reimb_status_id = ? " + "where reimb_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbStatusId);
			ps.setInt(2, reimbId);

			ErsUserInformation info2 = new ErsUserInformation();
			ErsReimbursement info = new ErsReimbursement();
			info.setReimbStatusId(reimbStatusId);
			
			System.out.println("in reimb dao for approved " + reimbId);

			List<ErsReimbursementInfo> reimbursement = new ArrayList<ErsReimbursementInfo>();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
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
			info2.setReimbursmentInfo(reimbursement);
			System.out.println("in ersuserDao 2  info 2" + info);
			return info;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	public ErsReimbursement approveReimb(int reimbStatusId, int reimbId) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update ers_reimbursement set reimb_status_id = ? " + "where reimb_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbStatusId);
			ps.setInt(2, reimbId);

//			ErsUserInformation info2 = new ErsUserInformation();
			ErsReimbursement info = new ErsReimbursement();
			info.setReimbStatusId(reimbStatusId);
			
			
			System.out.println("in reimb dao for approved 2 " + reimbId + " " + reimbStatusId);
//			List<ErsReimbursement> reimbursement = new ArrayList<ErsReimbursement>();


			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ErsReimbursement re = new ErsReimbursement();
				re.setReimbId(rs.getInt(1));
				re.setReimbAmount(rs.getDouble(2));
				re.setReimbSubmittedDate(rs.getString(3));
				re.setReimbResolvedDate(rs.getString(4));
				re.setReimbDescription(rs.getString(5));
				re.setReimbAuthor(rs.getInt(6));
				re.setReimbResolver(rs.getInt(7));
				re.setReimbStatusId(rs.getInt(8));
				re.setReimbTypeId(rs.getInt(9));
			}
			
			return info;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

