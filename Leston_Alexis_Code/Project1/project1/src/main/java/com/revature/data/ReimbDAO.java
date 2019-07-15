package com.revature.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class ReimbDAO {
	

	public Reimbursement addReim(Reimbursement reimb) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			
				String sql = "INSERT INTO REIMBURSEMENT (REMIB_AMOUNT, REIMB_SUMBITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) " + 
						"VALUES (?, CURRENT_TIMESTAMP, ?, ?, 1, ?) ";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				System.out.println("ADDING REIMBURSEMENT " + reimb);
				
				ps.setDouble(1, reimb.getReimbAmount());
				ps.setString(2, reimb.getReimbDescription());
				ps.setInt(3, reimb.getReimbAuthor());
				ps.setInt(4, reimb.getReimbTypeId());
				
				
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	
	return reimb;
			
}
	

	public Reimbursement updateReimb1 (Reimbursement reimb ) {
		
	try (Connection conn = ConnectionFactory.getInstance().getConnection();){
	String sql ="UPDATE REIMBURSEMENT SET REIMB_RESOLVED = CURRENT_TIMESTAMP, "
			+ " REIMB_RESOLVER = ? , REIMB_STATUS_ID = ? WHERE REIMB_ID = ? ";
	
	PreparedStatement ps = conn.prepareStatement(sql);

	ps.setInt(1, reimb.getReimbResolver());
	ps.setInt(2, reimb.getReimbStatusId());
	ps.setInt(3, reimb.getReimbId());
	
	
	ps.executeUpdate();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return reimb;
	
	
}

	
}
	
	
	
	
	