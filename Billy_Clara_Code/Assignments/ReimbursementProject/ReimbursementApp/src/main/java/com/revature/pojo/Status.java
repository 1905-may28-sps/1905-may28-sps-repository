package com.revature.pojo;

public class Status {
	
	private int statusid;
	private String status;
	
	public Status () {}

	public Status(int statusid, String status) {
		super();
		this.statusid = statusid;
		this.status = status;
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [statusid=" + statusid + ", status=" + status + "]";
	}
	
	

}
