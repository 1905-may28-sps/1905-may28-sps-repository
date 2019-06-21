package com.revature.pojo;

public class Account {
	private String type;
	private int bal;
	private int name;// needs to be a list
	private int username;
	private int id;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String type, int bal, int name, int username) {
		super();
		this.type = type;
		this.bal = bal;
		this.name = name;
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}
	public int setId() {
		return id;
	}

	
	
	
	

}
