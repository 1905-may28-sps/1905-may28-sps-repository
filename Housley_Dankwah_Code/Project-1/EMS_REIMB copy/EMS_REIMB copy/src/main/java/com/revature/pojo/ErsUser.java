package com.revature.pojo;


public class ErsUser {
	private int ersUserId;
	private String ersUsername;
	private String password;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private int userRoleId;
	
	public ErsUser() {}

	public ErsUser(int ersUserId, String ersUsername, String password, String userFirstName, String userLastName,
			String userEmail, int userRoleId) {
		super();
		this.ersUserId = ersUserId;
		this.ersUsername = ersUsername;
		this.password = password;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}

	public int getErsUserId() {
		return ersUserId;
	}

	public void setErsUserId(int ersUserId) {
		this.ersUserId = ersUserId;
	}

	public String getErsUsername() {
		return ersUsername;
	}

	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "ErsUser [ersUserId=" + ersUserId + ", ersUsername=" + ersUsername + ", password=" + password
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRoleId=" + userRoleId + "]";
	}


	

}
