package com.revature.pojos;

public class User
{
	private int userId;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String userEmail;	
	private int roleId;

	public User() {}

	public User(int userId, String userName, String passWord, String firstName, String lastName, String userEmail,
			int roleId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userEmail=" + userEmail + ", roleId=" + roleId + "]";
	}

	
}	