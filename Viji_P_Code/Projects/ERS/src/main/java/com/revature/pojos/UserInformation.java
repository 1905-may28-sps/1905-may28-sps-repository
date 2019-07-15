package com.revature.pojos;

import java.util.List;

public class UserInformation {
	
	private ErsUser user;
	private List<ReimbAccount> accounts;
	
	public UserInformation() {}

	public UserInformation(ErsUser user, List<ReimbAccount> accounts) {
		super();
		this.user = user;
		this.accounts = accounts;
	}

	public ErsUser getUser() {
		return user;
	}

	public void setUser(ErsUser user) {
		this.user = user;
	}

	public List<ReimbAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<ReimbAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "UserInformation User=" + user + ", Accounts=" + accounts;
	}
	
}
