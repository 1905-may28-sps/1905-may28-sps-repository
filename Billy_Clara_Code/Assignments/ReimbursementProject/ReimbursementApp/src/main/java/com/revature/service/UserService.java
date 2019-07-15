package com.revature.service;

import java.util.List;

import com.revatrue.Dao.UserDao;
import com.revature.pojo.Manager;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	private Reimbursement reim = new Reimbursement();

	
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
	
	public void submit(int amount, String submitted, String resolved, String description, int author,
			int resolver, int statusid, int typeid) {
		userDao.submit(amount, submitted, resolved, description, author, resolver, statusid, typeid);
}
	
	public Reimbursement updateReimbursement(int id, int Statusid) {
		reim.setId(id);
		reim.setStatusid(Statusid);
		
		return userDao.updateReim(reim);
		
	}
}