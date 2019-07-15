package com.revature.pojos;

import java.util.List;

public class Info {
	private User user;
	private List<ErsReimb> reims;
	
	public Info() {}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ErsReimb> getReims() {
		return reims;
	}

	public void setReims(List<ErsReimb> reims) {
		this.reims = reims;
	}
	
	
	
}
