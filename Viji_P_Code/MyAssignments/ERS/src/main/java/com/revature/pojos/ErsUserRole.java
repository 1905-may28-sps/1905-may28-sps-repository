package com.revature.pojos;

public class ErsUserRole {

	private int userRoleid;
	private String roleType;
	
	public ErsUserRole() {}

	public ErsUserRole(int userRoleid, String roleType) {
		super();
		this.userRoleid = userRoleid;
		this.roleType = roleType;
	}

	public int getUserRoleid() {
		return userRoleid;
	}

	public void setUserRoleid(int userRoleid) {
		this.userRoleid = userRoleid;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return "EsrUserRole UuserRoleid=" + userRoleid + ", RoleType=" + roleType;
	}
	
	
	
}
