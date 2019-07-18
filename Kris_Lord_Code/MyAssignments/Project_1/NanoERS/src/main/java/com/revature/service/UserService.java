package com.revature.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.revature.dao.UserDao;
import com.revature.pojos.Account;
import com.revature.pojos.Account2;
import com.revature.pojos.User;
//import com.revature.pojos.UserInformation;
import com.revature.pojos.UserInformation;

public class UserService {

	private UserDao userDao = new UserDao();/*
	* First import the (UserDao) class.
	* import packageName.ClassName; (import com.revature.dao.UserDao;)
	* 
	* If the method is static, I could simply do this:
	* ClassName.method(); (UserDao.getUserByUserName(username);)
	* 
	* If it is not, I need to create a new object and call it on that:
	* ClassName c = new ClassName(); (UserDao userDao = new UserDao();)
	* c.method(); (userDao.getUserByUserName(username);)
	*/
	
	public List<User> findAllUsers(){
		return userDao.findAll();
	}
	
	public List<Account> findAllReimbs(){
		return userDao.findAllReimb();
	}
	
	public User login(String username, String password) {//login method
		User u = userDao.getUserByUserName(username);/*
		* declare reference to an object of class User
		* the variable name, u, plus a reference pointing to the object.method()
		* The value of u is object.method() or userDao.getUserByUserName(username)
		*/
		if(u == null) return null;//username is not found in database
		if(u.getPassword().equals(password)) {return u;}//username found but need to check password
		return null;
	}
	
	public UserInformation getInfo(User u) {
		if(u.getUserRoleId() == 2) return userDao.getUserInfo(u);
		else return userDao.getMgrInfo(u);
	}

	public Account2 esubmit(Double balance, String description, int author, int accountType) {
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String time = dateFormat.format(date);
//		Date time = new java.sql.Date(System.currentTimeMillis());
		int resolver;
		Random random13 = new Random();
		if(random13.nextInt(2)==0) resolver = 3; else resolver = 1; 

		Account2 esubobj = new Account2(balance, time, description, author, resolver, 101, accountType);
		
		return userDao.save(esubobj);
	}
	
	public Account findUser(int id) {
		return userDao.findById(id);
	}
	
	public Account updateStatus(int id, int statusId) {

		Account statId = userDao.findById(id);
		statId.setStatusId(statusId);
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String time = dateFormat.format(date);
//		Timestamp time = new Timestamp(System.currentTimeMillis());
		statId.setResolved(time);

		return userDao.update(statId);
	}
	
}