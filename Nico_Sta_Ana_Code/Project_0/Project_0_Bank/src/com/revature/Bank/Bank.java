package com.revature.Bank;

import com.revature.dao.*;
import com.revature.pojos.User;

public class Bank {
	
	private UserDao userDao;
	private AccountDao accountDao;
	private User user;
	
	
	//CREATE ACCOUNT
	public Bank() {
		userDao = new UserDao();
		accountDao = new AccountDao();
	}
	
	
	
	public boolean createUser(String firstName, String lastName, String username, String password) {
		return userDao.createUser(firstName, lastName, username, password);
	}
	
	

	
	public boolean createAccount(double balance, String accountType) {
		return accountDao.createAccount(balance, accountType, user.getId());
		
	}

	public boolean signIn(String username, String password) {
		user = userDao.findUser(username);
		if(user.getId() != 0) {
			if(user.getPassword().equals(password)) {
				return true;
			}else {
				user = null;
				return false;
			}
		}else {
			user = null;
			return false;
		}
		
	}
	
	public boolean signOut() {
		user = null;
		return true;
	}
	
	
	public boolean deposit(double depositAmount, String accountNumber) {
		return accountDao.deposit(depositAmount, accountNumber, user.getId());
		
	}
	
	public boolean withdrawal(double withdrawalAmount, String accountNumber) {

		return accountDao.withdrawl(withdrawalAmount, accountNumber, user.getId());
	}
	
	public double checkBalance(String accountNumber) {
		return accountDao.checkbalance(accountNumber, user.getId());
	}
	


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
