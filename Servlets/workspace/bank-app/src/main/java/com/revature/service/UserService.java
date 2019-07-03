package com.revature.service;

import java.util.List;

import com.revature.data.UserDAO;
import com.revature.pojos.User;
import com.revature.pojos.UserInformation;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	public List<User> findAllUsers(){
		return userDao.findAll();
	}
	
	public User login(String username, String password) {
		User u = userDao.getByUsername(username);
		if(u == null) return null;
		if(u.getPassword().equals(password)) return u;
		return null;
	}
	
	public UserInformation getInfo(User u) {
		return userDao.getUserInfo(u);
	}

}
