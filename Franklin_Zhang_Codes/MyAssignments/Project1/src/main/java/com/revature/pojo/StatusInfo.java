package com.revature.pojo;

import java.util.List;

public class StatusInfo {
	private String reimb_status_id;
	private List<ReimbursementInfo> accounts;
	public StatusInfo() {}
	public StatusInfo(String reimb_status_id, List<ReimbursementInfo> accounts) {
		super();
		this.reimb_status_id = reimb_status_id;
		this.accounts = accounts;
	}
	public String getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(String reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	public List<ReimbursementInfo> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<ReimbursementInfo> accounts) {
		this.accounts = accounts;
	}

}
