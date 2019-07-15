package com.revature.service;

import java.util.List;

import com.revature.dao.ErsReimbursementDAO;
import com.revature.pojo.ErsReimbursement;

public class ReimbursementService {

	ErsReimbursementDAO ersReimbursementDao = new ErsReimbursementDAO(); 
	
	public List<ErsReimbursement> findAllUsers(){
		return ersReimbursementDao.findAll();
	}
	

	public ErsReimbursement getApproveReimb (int reimbStatusId, int reimbId ) {
		System.out.println("in reimbursement service " + ersReimbursementDao.approveReimb(reimbStatusId, reimbId));
		return ersReimbursementDao.approveReimb(reimbStatusId, reimbId);
		
	}
	
//	public ErsReimbursement addNewReimbursement (Object newReimb) {
//		
//		return ersReimbursementDao.addReimb(newReimb);
//		
//		
//	}



	public ErsReimbursement addReimb(ErsReimbursement newReimb) {
		return ersReimbursementDao.addReimb(newReimb);
	}
}
