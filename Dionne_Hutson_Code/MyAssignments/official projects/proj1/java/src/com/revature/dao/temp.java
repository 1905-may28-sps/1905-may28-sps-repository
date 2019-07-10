package src.com.revature.dao;

import src.com.revature.pojo.ERS_REIMBURSEMENT;
import src.com.revature.pojo.ERS_USERS;

public class temp {
public static void main(String[] args) {
	ERS_RIEIMBURSEMENTDAO reimDAO=new ERS_RIEIMBURSEMENTDAO();
	ERS_REIMBURSEMENT reim= new ERS_REIMBURSEMENT();
	ERS_USERS user=new ERS_USERS();
	ERS_USERSDAO userDAO=new ERS_USERSDAO();
	
	reim.setAmount(96.04);
	reim.setDescrp("Testing this again");
	reim.setEmp(122);
	reim.setType(6);
	reim.setStatus(3);
	reim.setMan(126);
	reim.setId(142);
	user.setUn("tom");
	
	
	
	//userDAO.getUserByUN(user);
	reimDAO.getReimbursementByID(3);
	
	
}
}
