package com.revature.pojos;

public class UserRoles {

	private int id;
	private String role;

	public UserRoles() {
	}

	public UserRoles(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", role=" + role + "]";
	}

}
