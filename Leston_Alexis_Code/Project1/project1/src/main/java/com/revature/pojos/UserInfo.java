package com.revature.pojos;

import java.util.List;

public class UserInfo {
	private User user;
	private List<ReimbInfo> reimbursement;
	
	
	public UserInfo() {}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<ReimbInfo> getReimbursement() {
		return reimbursement;
	}


	public void setReimbursement(List<ReimbInfo> reimbursement) {
		this.reimbursement = reimbursement;
	}


	@Override
	public String toString() {
		return "UserInfo [user=" + user + ", reimbursement=" + reimbursement + "]";
	}
	
	
	
	

}
