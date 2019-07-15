package com.revature.pojos;

public class ErsReimStatus {
	
	private int reimStatusId;
	private String reimStatus;
	
	public ErsReimStatus() {}
	
	public ErsReimStatus(int reimStatusId, String reimStatus) {
	super();
	this.reimStatusId = reimStatusId;
	this.reimStatus = reimStatus;
	}

	public int getReimStatusId() {
		return reimStatusId;
	}

	public void setReimStatusId(int reimStatusId) {
		this.reimStatusId = reimStatusId;
	}

	public String getReimStatus() {
		return reimStatus;
	}

	public void setReimStatus(String reimStatus) {
		this.reimStatus = reimStatus;
	}

	@Override
	public String toString() {
		return "EsrReimStatus ReimStatusId=" + reimStatusId + ", ReimStatus=" + reimStatus;
	}
	
	

}
