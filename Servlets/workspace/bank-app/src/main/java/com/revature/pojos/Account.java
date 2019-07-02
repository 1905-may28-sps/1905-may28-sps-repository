package com.revature.pojos;

public class Account {
	
	private int id;
	private double balance; //apparently best practice is BigDecimal
	private int owner; //user id FK
	private int type; //account type id FK
	
	public Account() {}
	
	public Account(double balance, int owner, int type) {
		super();
		this.balance = balance;
		this.owner = owner;
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

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", owner=" + owner + ", type=" + type + "]";
	}
	
	

}
