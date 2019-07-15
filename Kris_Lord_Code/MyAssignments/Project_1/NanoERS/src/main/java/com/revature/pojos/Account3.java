package com.revature.pojos;

public class Account3 {
	private int accountId;
	private String resolved;
	private int statusId;
	
	public Account3() {
		
	}

	public Account3(String resolved, int statusId) {
		super();
		this.resolved = resolved;
		this.statusId = statusId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "Account3 [accountId=" + accountId + ", resolved=" + resolved + ", statusId=" + statusId + "]";
	}
	
	
	
}
