package com.animoBank.pojo;

public class BankAccount {
	
	private int accountId;
	private double balance;
	private int owner;
	private int accType;
	
	public BankAccount() {}

	public BankAccount(int accountId, double balance, int owner, int accType) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.owner = owner;
		this.accType = accType;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getAccType() {
		return accType;
	}

	public void setAccType(int accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", balance=" + balance + ", owner=" + owner + ", accType="
				+ accType + "]";
	}
	


}
