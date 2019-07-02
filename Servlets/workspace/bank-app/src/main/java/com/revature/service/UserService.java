package com.revature.service;

import java.util.List;

import com.revature.data.UserDAO;
import com.revature.pojos.User;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	public List<User> findAllUsers(){
		return userDao.findAll();
	}

}
