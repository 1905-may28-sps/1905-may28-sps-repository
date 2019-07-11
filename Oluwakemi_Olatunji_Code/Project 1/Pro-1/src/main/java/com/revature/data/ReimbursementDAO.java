package com.revature.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.ReimbursementInfo;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO {

	public Reimbursement addReimburment(Reimbursement reimburse) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			
				String sql = "{call ADD_REIBURSE (?, ?, ?, ?)}";
				
				CallableStatement cs = conn.prepareCall(sql);
				cs.setDouble(2, reimburse.getAmount());
				cs.setString(5, reimburse.getDescript());
				cs.setInt(10, reimburse.getType());
				
				cs.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	
	return reimburse;
			
}
	

	public Reimbursement updateReimbursement (Reimbursement reimburse ) {
		
	try (Connection conn = ConnectionFactory.getInstance().getConnection();){
	String sql ="UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = CURRENT_TIMESTAMP, "
			+ " REIMB_RESOLVER = ? , REIMB_STATUS_ID = ? WHERE REIMB_ID = ? ";
	
	PreparedStatement ps = conn.prepareStatement(sql);

	ps.setInt(1, reimburse.getBoss());
	ps.setInt(2, reimburse.getStatus());
	ps.setInt(3, reimburse.getId());
	
	
	ps.executeUpdate();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return reimburse;
	
	
}
}