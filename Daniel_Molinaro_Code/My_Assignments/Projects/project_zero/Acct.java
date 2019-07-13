package com.revature.pojos;

public class Acct {

	private int acct_id;
	private double bal;
	private int user_id;
	private String type;

	public Acct() {
	}

	public Acct(int acct_id, double bal, int user_id, String type) {
		super();
		this.acct_id = acct_id;
		this.bal = bal;
		this.user_id = user_id;
		this.type = type;
	}

	public int getAcct_id() {
		return acct_id;
	}

	public void setAcct_id(int acct_id) {
		this.acct_id = acct_id;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Acct [acct_id=" + acct_id + ", bal=" + bal + ", user_id=" + user_id + ", type=" + type + "]";
	}

}
