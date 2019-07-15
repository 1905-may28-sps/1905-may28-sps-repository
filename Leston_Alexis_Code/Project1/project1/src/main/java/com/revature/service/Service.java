package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.data.ReimbDAO;
import com.revature.data.UserDAO;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.pojos.UserInfo;


public class Service {
	
private UserDAO userDao = new UserDAO();
	
	public List<User> findAllUsers(){
		return userDao.findAll();
	}
	
	public User login(String username, String password) {
		User u = userDao.getByUsername(username);
		if(u == null) return null;
		if(u.getPassWord().equals(password)) return u;
		return null;
	}
	
	public UserInfo getInfo(User u) {
		return userDao.getUserInfo(u);
	}
	
	public UserInfo getAllUserInfo(User u) {
		return userDao.getAllUserInfo(u);
	}
	
	
	
	
	
private ReimbDAO reDao = new ReimbDAO();
	
	public Reimbursement updateReimb (int man, int stat, int id) {
		Reimbursement reimb = new  Reimbursement();
		ReimbDAO reDao = new ReimbDAO();
		
		reimb.setReimbResolver(man);
		reimb.setReimbStatusId(stat);
		reimb.setReimbId(id);
		
		return reDao.updateReimb1(reimb);
	} 
	

	public Reimbursement addReimb(double amount, String description, int emp, int type) {
		Reimbursement reimb = new  Reimbursement();
		ReimbDAO reimbDao = new ReimbDAO();
		
	
		reimb.setReimbAmount(amount);
		reimb.setReimbDescription(description);
		reimb.setReimbAuthor(emp);
		reimb.setReimbTypeId(type);

	return reimbDao.addReim(reimb);
}

	
	
	
}	
	
	
	
	
