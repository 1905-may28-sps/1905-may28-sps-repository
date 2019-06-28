package com.revature.pojos;

public class BankAccount {
	
	private int id;
	private double balance;
	private int userId;
	
	public BankAccount() {}
	
	public BankAccount(int id, double balance, int userId) {
		super();
		this.id = id;
		this.balance = balance;
		this.userId = userId;
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
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", balance=" + balance + ", userId=" + userId + "]";
	}

}
