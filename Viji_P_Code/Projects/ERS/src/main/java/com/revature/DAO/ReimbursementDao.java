package com.revature.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.pojos.ErsReimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDao {
	
	static ReimbursementDao reimDao = new ReimbursementDao();
	static ErsReimbursement reim = new ErsReimbursement();
	
	public ErsReimbursement addReimbursement(ErsReimbursement reim) {
		
			try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "INSERT INTO ERS_REIMBURSEMENT " + 
					" (REIMB_SUBMITTED, REIMB_AMOUNT, REIMB_DESCRIPTION, " + 
					" REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) " + 
					" VALUES (?, ?, ?, ?, ?, ?, ?)";
			String[] generatedKeys = {"REIMB_ID"};
						
			reim.setrSubDate(new java.sql.Date(System.currentTimeMillis()));
		
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setDate(1, reim.getrSubDate());
			ps.setDouble(2, reim.getAmount());		
			ps.setString(3, reim.getDescription());
			ps.setInt(4, reim.getrAuthId());
			ps.setInt(5, reim.getrResId());
			ps.setInt(6, 1);
			ps.setInt(7, reim.getTypeId());
			
			ps.executeUpdate();
						
			System.out.println("Account Added Successfully...");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return reim;
	}
	
	
		
	public ErsReimbursement updateReimbursement(ErsReimbursement reim) {
			boolean updatedStatus = false;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			//Using Prepared Statement
//			String query = "UPDATE ERS_REIMBURSEMENT SET  "
//					+ " REIMB_RESOLVED,  "
//					+ " REIMB_STATUS_ID = ?, "
//					+ " WHERE REIMB_ID = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			
//			reim.setrResDate(new java.sql.Date(System.currentTimeMillis()));
//			
//			ps.setDate(1, reim.getrResDate());
//			ps.setInt(2, reim.getStatusId());
//			ps.setInt(3, reim.getReimbId());
//			
//			ps.executeUpdate();
			
			//Using Callable Statement - Stored Procedure
			
			//reim.setrResDate(new java.sql.Date(System.currentTimeMillis()));
			
			String query = "{call update_status(?, ?) }";
			CallableStatement cs = conn.prepareCall(query);
			
			cs.setInt(1, reim.getStatusId());
			//cs.setDate(2, reim.getrResDate());
			cs.setInt(2, reim.getReimbId());
			cs.execute();
			
			updatedStatus = true;
			
			System.out.println("Reimbusement updated successfully");
						
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reim;
	}

}
