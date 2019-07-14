package com.revature.pojo;

public class ErsReimbursement {
	private int reimbId;
	private double reimbAmount;
	private String reimbSubmittedDate;
	private String reimbResolvedDate;
	private String reimbDescription;
	private int reimbAuthor;
	private	int	reimbResolver;
	private int reimbStatusId;
	private int reimbTypeId;
	
	public  ErsReimbursement() {}

	public ErsReimbursement(int reimbId, double reimbAmount, String reimbSubmittedDate, String reimbResolvedDate,
			String reimbDescription, int reimbAuthor, int reimbResolver, int reimbStatusId, int reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmittedDate = reimbSubmittedDate;
		this.reimbResolvedDate = reimbResolvedDate;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
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

	public String getReimbSubmittedDate() {
		return reimbSubmittedDate;
	}

	public void setReimbSubmittedDate(String reimbSubmittedDate) {
		this.reimbSubmittedDate = reimbSubmittedDate;
	}

	public String getReimbResolvedDate() {
		return reimbResolvedDate;
	}

	public void setReimbResolvedDate(String reimbResolvedDate) {
		this.reimbResolvedDate = reimbResolvedDate;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
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

	@Override
	public String toString() {
		return "ErsReimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmittedDate="
				+ reimbSubmittedDate + ", reimbResolvedDate=" + reimbResolvedDate + ", reimbDescription="
				+ reimbDescription + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatusId=" + reimbStatusId + ", reimbTypeId=" + reimbTypeId + "]";
	}

}
