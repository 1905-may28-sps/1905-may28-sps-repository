package com.revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.AccountInfo;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.pojos.UserInformation;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO {
	static ReimbursementDAO reimbdao = new ReimbursementDAO();
	static Reimbursement reim= new Reimbursement();
	
	
	
	
	
	
		public Reimbursement updateReimbursement(Reimbursement reim) {
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		
		String sql = "update ers_reimbursement " + 
				"set reimb_resolved = CURRENT_TIMESTAMP, reimb_resolver= ?, reimb_status_id =? " + 
				"where reimb_id =?";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(reim);
		ps.setInt(1, reim.getResolver());
		ps.setInt(2, reim.getStatus());
		ps.setInt(3, reim.getId());
		
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return reim;
		}
		//new reimb
		
		public Reimbursement setReimb(Reimbursement reim) {
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				String sql= " insert into ers_reimbursement (reimb_amount,reimb_submitted,reimb_description,reimb_author, reimb_type_id,reimb_status_id) " + 
						"values (?,CURRENT_TIMESTAMP,?,?,?,3)";
				String[] generatedkeys = {"reimb_id"};
				
				System.out.println("REIMBURSEMENT DAO "   + reim);
				PreparedStatement ps = conn.prepareStatement(sql,generatedkeys);
									
					ps.setDouble(1, reim.getAmount());
					//ps.setDate(2, Reimbursement.getCurrentDate());  //should I change this?
					ps.setString(2, reim.getDescription());
					ps.setInt(3, reim.getAuthor());
					ps.setInt(4, reim.getType());
			
					
					ps.executeUpdate();
					ResultSet pk = ps.getGeneratedKeys();
					pk.next();
					reim.setId(pk.getInt(1));
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return reim;

		}
}

	