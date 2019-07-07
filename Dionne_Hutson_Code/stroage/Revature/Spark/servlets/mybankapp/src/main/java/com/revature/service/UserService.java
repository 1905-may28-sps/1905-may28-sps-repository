package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.pojo.User;
import com.revature.pojo.UserInformation;

public class UserService {
	private UserDAO userDAO=new UserDAO();
	
	public List<User> findAll(){
		return userDAO.findAll();
		
	}
	public User login(String username, String password) {
		User u= userDAO.getByUsername(username);
		if (u==null) {
			System.out.println("no username");
			return null;}
		if (u.getPassword().equals(password)) { 
			System.out.println("a username");
			return u;}
		return null;
	}
	
	public UserInformation getInfo(User u) {
		return userDAO.getUserInfo(u);
	}

}
