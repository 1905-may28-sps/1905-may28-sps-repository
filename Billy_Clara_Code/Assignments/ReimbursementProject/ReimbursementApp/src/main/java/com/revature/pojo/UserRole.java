package com.revature.pojo;

public class UserRole {
	private int roleid;
	private String role;

	public UserRole() {}

	public UserRole(int roleid, String role) {
		super();
		this.roleid = roleid;
		this.role = role;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [roleid=" + roleid + ", role=" + role + "]";
	}
	
	
}
