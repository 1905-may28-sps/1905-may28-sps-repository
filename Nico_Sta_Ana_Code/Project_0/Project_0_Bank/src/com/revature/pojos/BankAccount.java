package com.revature.pojos;

public class BankAccount {

	
	
	private String accountNumber;
	private double balance;	
	private String accountType;
	private int userID;
	
	
	
	public BankAccount() {}
	
	public BankAccount(String accountNumber, double balance, String accountType, int userID) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;		
		this.accountType = accountType;
		this.userID = userID;
		
		
	}
	
	
	

	
	
	
	
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getID() {
		return userID;
	}

	public void setID(int userID) {
		this.userID = userID;
	}

	
	
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", accountType=" + accountType + ", userID=" + userID + "]";
	}
	
	
		


	
	
	// End of class
}
