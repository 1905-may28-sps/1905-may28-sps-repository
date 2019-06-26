package com.animoBank.pojo;

public class BankAccount {
	
	private int accountId;
	private double balance;
	private int owner;
	private int accType;
	private String type;
	
	public BankAccount() {}

	public BankAccount(int accountId, double balance, int owner, int accType, String Type) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.owner = owner;
		this.accType = accType;
		this.type = Type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "YOUR " + type +  " ACCOUNT #" + accountId + " CURRENT BALANCE = $" + balance  ;
	}
	
	


}
