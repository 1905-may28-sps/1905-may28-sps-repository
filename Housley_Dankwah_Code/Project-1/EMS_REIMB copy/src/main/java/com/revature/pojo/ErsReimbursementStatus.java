package com.revature.pojo;

public class ErsReimbursementStatus {
	private int reimbStatusId;
	private String reimbStatus;
	
	public ErsReimbursementStatus() {}

	public ErsReimbursementStatus(int reimbStatusId, String reimbStatus) {
		super();
		this.reimbStatusId = reimbStatusId;
		this.reimbStatus = reimbStatus;
	}

	public int getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public String getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	@Override
	public String toString() {
		return "ErsReimbursementStatus [reimbStatusId=" + reimbStatusId + ", reimbStatus=" + reimbStatus + "]";
	}
	
	

}
