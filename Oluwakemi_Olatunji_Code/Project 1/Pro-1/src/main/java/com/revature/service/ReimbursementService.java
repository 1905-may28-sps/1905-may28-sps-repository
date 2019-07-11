package com.revature.service;

import com.revature.data.ReimbursementDAO;
import com.revature.pojos.Reimbursement;



public class ReimbursementService {
	private ReimbursementDAO reimburseDao = new ReimbursementDAO();
	
	public Reimbursement updateReimbursement (int boss, int status, int id) {
		Reimbursement reimburse = new  Reimbursement();
		ReimbursementDAO reimburseDao = new ReimbursementDAO();
		
		reimburse.setBoss(boss);
		reimburse.setStatus(status);
		reimburse.setId(id);
		
		return reimburseDao.updateReimbursement(reimburse);
	} 

}
