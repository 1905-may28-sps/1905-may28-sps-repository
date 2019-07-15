package com.revature.pojos;

import java.sql.Blob;

public class ReimbInfo {
	private int reimbId;
	private double reimbAmount;
	private String reimbAuthorFirst;
	private String reimbResolver;
	private String reimbStatusId;
	private String reimbTypeId;
	private String reimbAuthorLast;
	private String reimbSubmitted;
	private String reimbResolved;
	private String reimbDescription;
	private Blob reimbReceipt;
	
	public ReimbInfo () {}

	public ReimbInfo(int reimbId, double reimbAmount, String reimbAuthorFirst, String reimbResolver,
			String reimbStatusId, String reimbTypeId, String reimbAuthorLast, String reimbSubmitted,
			String reimbResolved, String reimbDescription, Blob reimbReceipt) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbAuthorFirst = reimbAuthorFirst;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
		this.reimbAuthorLast = reimbAuthorLast;
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

	public String getReimbAuthorFirst() {
		return reimbAuthorFirst;
	}

	public void setReimbAuthorFirst(String reimbAuthorFirst) {
		this.reimbAuthorFirst = reimbAuthorFirst;
	}

	public String getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(String reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public String getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(String reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public String getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(String reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	public String getReimbAuthorLast() {
		return reimbAuthorLast;
	}

	public void setReimbAuthorLast(String reimbAuthorLast) {
		this.reimbAuthorLast = reimbAuthorLast;
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
		return "ReimbInfo [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbAuthorFirst="
				+ reimbAuthorFirst + ", reimbResolver=" + reimbResolver + ", reimbStatusId=" + reimbStatusId
				+ ", reimbTypeId=" + reimbTypeId + ", reimbAuthorLast=" + reimbAuthorLast + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + reimbReceipt + "]";
	}



}