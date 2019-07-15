package com.revature.pojo;

import java.util.List;

public class UserInfo {
	private Users userID;
	private List<ReimbursementInfo> accounts;
	
	public UserInfo() {}

	public UserInfo(Users userID, List<ReimbursementInfo> accounts) {
		super();
		this.userID = userID;
		this.accounts = accounts;
	}

	public Users getUserID() {
		return userID;
	}

	public void setUserID(Users userID) {
		this.userID = userID;
	}

	public List<ReimbursementInfo> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<ReimbursementInfo> accounts) {
		this.accounts = accounts;
	}
	
	

}
