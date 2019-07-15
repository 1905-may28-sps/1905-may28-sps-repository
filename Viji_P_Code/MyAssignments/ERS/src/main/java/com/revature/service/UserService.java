package com.revature.service;

import java.util.List;

import com.revature.DAO.ReimbursementDao;
import com.revature.DAO.UserDao;
import com.revature.pojos.ErsReimbursement;
import com.revature.pojos.ErsUser;
import com.revature.pojos.UserInformation;

public class UserService {
	
	private UserDao userDao = new UserDao();
	private ErsReimbursement reim = new ErsReimbursement();
	private ReimbursementDao reimDao = new ReimbursementDao();
	
	public List<ErsUser> findAllUsers(){
		return userDao.findAll();
	}
	
	public ErsUser login(String username, String password) {
		ErsUser u = userDao.getByUsername(username);
		if(u == null) return null;
		if(u.getPassword().equals(password)) return u;
		return null;
	}
	
	public UserInformation getInfo(ErsUser u) {
		return userDao.getUserInfo(u);
	}
	
	public UserInformation getManagerPage(ErsUser u) {
		return userDao.getManagerPage(u);
	}

	public ErsReimbursement addReimbursement(double amount, String description, 
			int rResId, int statusId, int typeId,int rAuthId) {
		reim.setAmount(amount);
		reim.setDescription(description);
		reim.setrResId(rResId);
		reim.setStatusId(statusId);
		reim.setTypeId(typeId);
		reim.setrAuthId(rAuthId);
		return reimDao.addReimbursement(reim);
	}
	
	public ErsReimbursement updateReimbursement(int reimbStatusId, int reimbId,int rResId) {
		reim.setStatusId(reimbStatusId);
		reim.setReimbId(reimbId);
		reim.setrResId(rResId);
		return reimDao.updateReimbursement(reim);
	}

	
}