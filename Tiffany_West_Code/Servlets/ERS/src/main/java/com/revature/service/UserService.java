package com.revature.service;
import java.util.List;

import com.revature.Dao.UserDAO;
import com.revature.pojos.AccountInfo;
import com.revature.pojos.User;
import com.revature.pojos.UserInformation;

public class UserService {

private UserDAO userDao = new UserDAO();
	//list all for login...
	public List<User> findAllUsers(){
		return userDao.findAll();
	}
	
	//login here
	public User Login(String username, String password) {
		User u = userDao.getByUsername(username);
		if(u == null) return null;
		if(u.getPassword().equals(password)) return u;
		
		return null;
		
	}
	
	//user info

	public UserInformation getInfo(User u) {
		return userDao.getUserInfo(u);
	}
	
	public UserInformation getEInfo(User u) {
		return userDao.getEmpInfo(u);
	}
	
	
	
	
	
}
