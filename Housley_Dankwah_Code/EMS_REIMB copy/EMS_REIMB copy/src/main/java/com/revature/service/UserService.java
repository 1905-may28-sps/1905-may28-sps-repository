package com.revature.service;

import java.util.List;

import com.revature.dao.ErsUsersDAO;
import com.revature.pojo.ErsUser;
import com.revature.pojo.ErsUserInformation;

public class UserService {
	ErsUsersDAO ersUserDao = new ErsUsersDAO();
	
	public List<ErsUser> findAllUsers(){
		return ersUserDao.findAll();
	}
	
	public ErsUser login(String ersUsername, String password) {
		ErsUser user = ersUserDao.getByUsername(ersUsername);
		System.out.println("IN USER SERVICE " + user);
		if(user == null)return null;
		if(user.getPassword().equals(password)) return user;
		else {
			return null;
		} 
	}
	
	public ErsUserInformation getInfo(ErsUser user) {
		System.out.println("in user service" + ersUserDao.getUserInfo(user));
		return ersUserDao.getUserInfo(user);
	}

}


