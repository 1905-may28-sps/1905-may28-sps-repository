package com.revature.pojos;

public class ErsUser {
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private int userRoleId;
	
	public ErsUser() {}

	public ErsUser(int id, String firstname, String lastname, String email, String username, String password,
			int userRoleId) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.userRoleId = userRoleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "ErsUser Id=" + id + ", Firstname=" + firstname + ", Lastname=" + lastname + ", Email=" + email
				+ ", Username=" + username + ", Password=" + password + ", UserRoleId=" + userRoleId ;
	}
	
	
	
	
	
	

}
