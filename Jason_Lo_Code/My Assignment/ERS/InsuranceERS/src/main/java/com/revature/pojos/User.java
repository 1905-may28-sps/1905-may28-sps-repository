package com.revature.pojos;

public class User {
	
	private int ers_users_id;
	private String ers_username;
	private String ers_password;
	private String user_first_name;
	private String user_lastname;
	private String user_email;
	private int user_role_id;
	
	public User() {}

	public User(String ers_username, String ers_password, String user_first_name, String user_lastname,
			String user_email, int user_role_id) {
		super();
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.user_first_name = user_first_name;
		this.user_lastname = user_lastname;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
	}

	public int getErs_users_id() {
		return ers_users_id;
	}

	public void setErs_users_id(int ers_users_id) {
		this.ers_users_id = ers_users_id;
	}

	public String getErs_username() {
		return ers_username;
	}

	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}

	public String getErs_password() {
		return ers_password;
	}

	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	@Override
	public String toString() {
		return "User [ers_users_id=" + ers_users_id + ", ers_username=" + ers_username + ", ers_password="
				+ ers_password + ", user_first_name=" + user_first_name + ", user_lastname=" + user_lastname
				+ ", user_email=" + user_email + ", user_role_id=" + user_role_id + "]";
	}
	
	

}
