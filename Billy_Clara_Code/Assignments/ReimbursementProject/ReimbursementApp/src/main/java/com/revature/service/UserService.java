package com.revature.service;

import java.util.List;

import com.revatrue.Dao.UserDao;
import com.revature.pojo.Manager;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	private Reimbursement reim = new Reimbursement();
	private User user= new User();
	
//	public List<User> findAllUsers(){
//		return userDao.findAll();
//	}
	
	public User login(String Username, String password) {
		User u =userDao.findByUsername(Username);
		if(u == null) return null;
		if(u.getPassword().contentEquals(password)) return u;
		return null;
	}
	
	public List<Reimbursement> getInfo(User u) {
		return userDao.getUserInfo(u);
	

}

	public List<Manager> findAllReimb() {
		return userDao.getallRe();
	}
	
	public Reimbursement submit(int amount, String resolved, String description, int author,
			int resolver, int statusid, int typeid) {
		userDao.submit(amount, resolved, description, author, resolver, statusid, typeid);
		return reim;
}
	
	public Reimbursement updateReimbursement(int id, int statusid) {
		
		reim.setId(id);
		reim.setStatusid(statusid);
		

		
		return userDao.updateReim(reim);
		
	}
}