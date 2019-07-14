package com.revature.pojo;

import java.util.Date;

public class ErsReimbursementInfo {
	private int reimbId;
	private String subUserFirstName;
	private String subUserLastName;
	private double reimbAmount;
	private String reimbDescription;
	private String reimbSubmittedDate;
	private String reimbType;
	private String reimbStatus;
	
	public ErsReimbursementInfo(int reimbId, String subUserFirstName, String subUserLastName, double reimbAmount,
			String reimbDescription, String reimbSubmittedDate, String reimbType, String reimbStatus) {
		super();
		this.reimbId = reimbId;
		this.subUserFirstName = subUserFirstName;
		this.subUserLastName = subUserLastName;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbSubmittedDate = reimbSubmittedDate;
		this.reimbType = reimbType;
		this.reimbStatus = reimbStatus;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public String getSubUserFirstName() {
		return subUserFirstName;
	}

	public void setSubUserFirstName(String subUserFirstName) {
		this.subUserFirstName = subUserFirstName;
	}

	public String getSubUserLastName() {
		return subUserLastName;
	}

	public void setSubUserLastName(String subUserLastName) {
		this.subUserLastName = subUserLastName;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public String getReimbSubmittedDate() {
		return reimbSubmittedDate;
	}

	public void setReimbSubmittedDate(String reimbSubmittedDate) {
		this.reimbSubmittedDate = reimbSubmittedDate;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	public String getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public ErsReimbursementInfo() {}


	
	

	

}
