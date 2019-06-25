package POJO;

public class Users {
	private int User_id;
	private String UName;
	private String PWord;
	private String FName;
	private String LName;
	
	public Users() {}

	public Users(int user_id, String uName, String pWord, String fName, String lName) {
		super();
		this.User_id = user_id;
		this.UName = uName;
		this.PWord = pWord;
		this.FName = fName;
		this.LName = lName;
	}

	public int getUser_id() {
		return User_id;
	}

	public void setUser_id(int user_id) {
		User_id = user_id;
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

	@Override
	public String toString() {
		return "Users [User_id=" + User_id + ", UName=" + UName + ", PWord=" + PWord + ", FName=" + FName + ", LName="
				+ LName + "]";
	}
	
	
	
}
