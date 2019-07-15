package com.revature.pojos;

public class ReimbAccount {
	
	private int id;
	private String firstname;
	private String lastname;
	private int reimbId;
	private double amount;
	private String rSubDate;
	private String rResDate;
	private int rResId;
	private String reimStatus;
		
	public ReimbAccount() {}

	public ReimbAccount(int id, String firstname, String lastname, int reimbId, double amount, String rSubDate,
			String rResDate, int rResId, String reimStatus ) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.reimbId = reimbId;
		this.amount = amount;
		this.rSubDate = rSubDate;
		this.rResDate = rResDate;
		this.rResId = rResId;
		this.reimStatus = reimStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getrSubDate() {
		return rSubDate;
	}

	public void setrSubDate(String rSubDate) {
		this.rSubDate = rSubDate;
	}

	public String getrResDate() {
		return rResDate;
	}

	public void setrResDate(String rResDate) {
		this.rResDate = rResDate;
	}

	public int getrResId() {
		return rResId;
	}

	public void setrResId(int rResId) {
		this.rResId = rResId;
	}
	
	public String getReimStatus() {
		return reimStatus;
	}

	public void setReimStatus(String reimStatus) {
		this.reimStatus = reimStatus;
	}

	@Override
	public String toString() {
		return "ReimbAccount UserId=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", reimbId=" + reimbId
				+ ", amount=" + amount + ", rSubDate=" + rSubDate + ", rResDate=" + rResDate + "ResolverId= "+ rResId +  ", reimStatus="
				+ reimStatus;
	}
	
	
	

}