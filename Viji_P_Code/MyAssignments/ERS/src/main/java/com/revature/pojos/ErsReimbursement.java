package com.revature.pojos;

public class ErsReimbursement {
	
	private int reimbId;
	private double amount;
	private java.sql.Date rSubDate;
	private java.sql.Date rResDate;
	private String description;
	private int rAuthId;
	private int rResId;
	private int statusId;
	private int typeId;
	
	
	public ErsReimbursement() {}

	public ErsReimbursement(int reimbId, double amount, java.sql.Date rSubDate, java.sql.Date  rResDate, String description, int rAuthId, int rResId,
			int statusId, int typeId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.rSubDate = rSubDate;
		this.rResDate = rResDate;
		this.description = description;
		this.rAuthId = rAuthId;
		this.rResId = rResId;
		this.statusId = statusId;
		this.typeId = typeId;
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

	public java.sql.Date getrSubDate() {
		return rSubDate;
	}

	public void setrSubDate(java.sql.Date rSubDate) {
		this.rSubDate = rSubDate;
	}

	public java.sql.Date getrResDate() {
		return rResDate;
	}

	public void setrResDate(java.sql.Date rResDate) {
		this.rResDate = rResDate;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getrAuthId() {
		return rAuthId;
	}

	public void setrAuthId(int rAuthId) {
		this.rAuthId = rAuthId;
	}

	public int getrResId() {
		return rResId;
	}

	public void setrResId(int rResId) {
		this.rResId = rResId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "ErsReimbursement ReimbId= " + reimbId + ", Amount= " + amount + ", rSubDate= " + rSubDate + ", rResDate= "
				+ rResDate + ", Description= " + description + ", rAuthId=" + rAuthId + ", rResId= " + rResId + ", statusId= " + statusId +
				", typeId= " + typeId;
	}	

}
