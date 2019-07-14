package com.revature.pojo;

import java.util.List;

public class ErsUserInformation {
	private ErsUser user;
	private List<ErsReimbursementInfo> reimbursmentInfo;
	
	public ErsUserInformation() {}



	public ErsUser getUser() {
		return user;
	}

	public void setUser(ErsUser user) {
		this.user = user;
	}

	public List<ErsReimbursementInfo> getReimbursmentInfo() {
		return reimbursmentInfo;
	}

	public void setReimbursmentInfo(List<ErsReimbursementInfo> reimbursmentInfo) {
		this.reimbursmentInfo = reimbursmentInfo;
	}



}
