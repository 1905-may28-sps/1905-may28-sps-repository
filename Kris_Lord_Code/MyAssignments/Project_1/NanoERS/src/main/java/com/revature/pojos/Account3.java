package com.revature.pojos;

import java.sql.Timestamp;

public class Account3 {
	private int accountId;
	private Timestamp resolved;
	private int statusId;
	
	public Account3() {
		
	}

	public Account3(Timestamp resolved, int statusId) {
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

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
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
