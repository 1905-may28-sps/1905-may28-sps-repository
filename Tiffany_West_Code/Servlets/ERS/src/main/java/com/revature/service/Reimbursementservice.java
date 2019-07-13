package com.revature.service;

import java.sql.Date;

import com.revature.Dao.ReimbursementDAO;
import com.revature.pojos.Reimbursement;

public class Reimbursementservice {

	
	public Reimbursement addReimb(double amount,String description,int author ,int type) {
		Reimbursement reim  = new Reimbursement();
		ReimbursementDAO reimbdao = new ReimbursementDAO();
		reim.setAmount(amount);
		reim.setDescription(description);
		reim.setAuthor(author);
		reim.setType(type);
		
		return reim=reimbdao.setReimb(reim);
		
	}
	
	
	//Update here < >
	
	public Reimbursement upreimb(int id, int status, int resolver) {
		Reimbursement reim  = new Reimbursement();
		ReimbursementDAO reimbdao = new ReimbursementDAO();
		reim.setStatus(status);
		reim.setResolver(resolver);
		reim.setId(id);
		
	 return reim=reimbdao.updateReimbursement(reim);
	 
		
	}
}
