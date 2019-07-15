package com.revature.pojo;

public class Users {
	public int UserID;
	protected String UName;
	protected String PWord;
	protected String FName;
	protected String LName;
	protected String EMail;
	protected int URoleID;

	public Users() {}

	public Users(int userID, String uName, String pWord, String fName, String lName, String eMail, int uRoleID) {
		super();
		UserID = userID;
		UName = uName;
		PWord = pWord;
		FName = fName;
		LName = lName;
		EMail = eMail;
		URoleID = uRoleID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getUName() {
		return UName;
	}

	public void setUName(String uName) {
		UName = uName;
	}

	public String getPWord() {
		return PWord;
	}

	public void setPWord(String pWord) {
		PWord = pWord;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String eMail) {
		EMail = eMail;
	}

	public int getURoleID() {
		return URoleID;
	}

	public void setURoleID(int uRoleID) {
		URoleID = uRoleID;
	}

	@Override
	public String toString() {
		return "Users [UserID=" + UserID + ", UName=" + UName + ", PWord=" + PWord + ", FName=" + FName + ", LName="
				+ LName + ", EMail=" + EMail + ", URoleID=" + URoleID + "]";
	}
	
	
	
}
