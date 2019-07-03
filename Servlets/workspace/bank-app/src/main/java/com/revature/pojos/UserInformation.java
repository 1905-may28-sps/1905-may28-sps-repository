package com.revature.pojos;

import java.util.List;

public class UserInformation {
	
	private User user;
	private List<AccountInfo> accounts;
	
	public UserInformation() {}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<AccountInfo> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountInfo> accounts) {
		this.accounts = accounts;
	}
	
	

}

class AccountInfo{
	private int id;
	private double balance;
	private String type;
	
	public AccountInfo() {}

	public AccountInfo(int id, double balance, String type) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
