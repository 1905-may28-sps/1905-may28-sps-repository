package com.revature.pojos;

import java.util.List;

public class UserInformation {

	private User user;
	private List<ReimbursementInfo> reimbursement;
	
	
	public UserInformation() {}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<ReimbursementInfo> getReimbursement() {
		return reimbursement;
	}


	public void setReimbursement(List<ReimbursementInfo> reimbursement) {
		this.reimbursement = reimbursement;
	}


	@Override
	public String toString() {
		return "UserInformation [user=" + user + ", reimbursement=" + reimbursement + "]";
	}
	
	
	
	
}
