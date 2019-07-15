package com.revature.pojos;

import java.sql.Blob;

public class Reimbursement {

	
	private int reimbId;
	private double reimbAmount;
	private int reimbAuthor;
	private int reimbResolver;
	private int reimbStatusId;
	private int reimbTypeId;

	private String reimbSubmitted;
	private String reimbResolved;
	private String reimbDescription;
	private Blob reimbReceipt;
	
	public Reimbursement () {}
	
	public Reimbursement(int reimbId, double reimbAmount, int reimbAuthor, int reimbResolver, int reimbStatusId,
			int reimbTypeId, String reimbSubmitted, String reimbResolved, String reimbDescription, Blob reimbReceipt) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public int getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public int getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public int getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public int getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public Blob getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(Blob reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbAuthor=" + reimbAuthor
				+ ", reimbResolver=" + reimbResolver + ", reimbStatusId=" + reimbStatusId + ", reimbTypeId="
				+ reimbTypeId + ", reimbSubmitted=" + reimbSubmitted + ", reimbResolved=" + reimbResolved
				+ ", reimbDescription=" + reimbDescription + ", reimbReceipt=" + reimbReceipt + "]";
	}
	
	
}