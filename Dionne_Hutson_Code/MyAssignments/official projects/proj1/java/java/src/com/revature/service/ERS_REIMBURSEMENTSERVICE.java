package src.com.revature.service;

import src.com.revature.dao.ERS_RIEIMBURSEMENTDAO;
import src.com.revature.pojo.ERS_REIMBURSEMENT;

public class ERS_REIMBURSEMENTSERVICE {
	
	public ERS_REIMBURSEMENT addReim(double amount, String descrp, int emp, int type ) {
		ERS_REIMBURSEMENT reim= new ERS_REIMBURSEMENT();
		ERS_RIEIMBURSEMENTDAO reimDAO=new ERS_RIEIMBURSEMENTDAO();
		reim.setAmount(amount);
		reim.setDescrp(descrp);
		reim.setEmp(emp);
		reim.setType(type);
		return reim=reimDAO.addReimbursement(reim);
		
	
	}

}
