package com.revature.pojos;

public class Account {

private int id;
private int balance;
private int customer;
private int acctype;

public Account(){}

public Account (int id, int balance, int customer, int acctype) {
	super();
	this.id = id;
	this.balance = balance;
	this.customer = customer;
	this.acctype = acctype;
	
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
	
}

public int getbalance() {
	return balance;
}

public void setbalance(int balance) {
	this.balance = balance;	
	
}

public int getcustomer() {
	return customer;
}

public void setcustomer(int customer) {
	this.customer = customer;	
	
}

public int getacctype() {
	return acctype;
}

public void setacctype(int acctype) {
	this.acctype = acctype;	
	
}

@Override
public String toString() {
	return "Account balance is  " + balance + " for Account ID " + id;
}

}


