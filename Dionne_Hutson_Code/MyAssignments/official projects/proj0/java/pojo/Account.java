package com.revature.pojo;

public class Account {
	private String type;
	private double bal;
	private String name;// needs to be a list
	private String username;
	private int id;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String type, double bal, String name, String username, int id) {
		super();
		this.type = type;
		this.bal = bal;
		this.name = name;
		this.username = username;
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account [type=" + type + ", bal=" + bal + ", name=" + name + ", username=" + username + ", id=" + id
				+ "]";
	}

	
	
	
	
	

}
