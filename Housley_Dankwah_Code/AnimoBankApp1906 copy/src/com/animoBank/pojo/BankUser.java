package com.animoBank.pojo;

public class BankUser {
	
	private int userId;
	private String firstname;
	private String lastname;
	private String username;
	private String usrPassword;
	
	public BankUser() {}
	
	public BankUser (int userId, String firstname, String lastname,
			String username, String usrPassword) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.usrPassword = usrPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	@Override
	public String toString() {
		return "BankUser [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", usrPassword=" + usrPassword + "]";
	}

	
	
	

}
