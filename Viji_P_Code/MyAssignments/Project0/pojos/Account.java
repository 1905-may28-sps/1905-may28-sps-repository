package com.revature.pojos;

public class Account {

	private int acc_id;
	private int balance;
	private int owner;
	private String accType;
	
	public Account() {}

	public Account(int acc_id, int balance, int owner, String accType) {
		super();
		this.acc_id = acc_id;
		this.balance = balance;
		this.owner = owner;
		this.accType = accType;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "BankAccount: Acc_id= " + acc_id + ", Balance= " + balance + ", Owner= " + owner + ", AccType= " + accType;
	} 
	
	
	
}
