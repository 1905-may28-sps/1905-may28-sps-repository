//package com.revature.pojos;
//
//import java.util.List;
//
//public class UserInformation {
//	
//	private User user;
//	private List<ReimbursementInfo> reimbursements;
//	
//	public UserInformation() {}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public List<ReimbursementInfo> getReimbursements() {
//		return reimbursements;
//	}
//
//	public void setReimbursements(List<ReimbursementInfo> reimbursements) {
//		this.reimbursements = reimbursements;
//	}
//	
//	
//
//}

package com.revature.pojos;

import java.util.List;

public class UserInformation {
	
	private User user;
	private List<AccountInfo> accounts;
	
	public UserInformation() {}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<AccountInfo> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountInfo> accounts) {
		this.accounts = accounts;
	}
}