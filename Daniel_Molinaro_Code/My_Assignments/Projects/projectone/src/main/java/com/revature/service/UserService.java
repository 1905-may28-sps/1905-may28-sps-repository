package com.revature.service;

import java.util.List;

import com.revature.data.ReimbDAO;
import com.revature.data.UserDAO;
import com.revature.pojos.User;
import com.revature.pojos.Reimb;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	private ReimbDAO reimbDao = new ReimbDAO();
	
	public void submit(double amount, String description, String auth, String typeId) {
		reimbDao.submit(amount, description, auth, typeId);
	}
	public List<User> findAllUsers(){
		return userDao.findAll();
	}
	
	public List<Reimb> findAllReimb(){
		return reimbDao.findAll();
	}
	
	public User login(String username, String password) {
		User u = userDao.getByUsername(username);
		if(u == null) return null;
		if(u.getPassword().equals(password)) return u;
		return null;
	}
	
	public List<Reimb> getInfo(User u) {
		return userDao.getUserInfo(u);
	}

}