package src.com.revature.pojo;

public class ERS_USERS {
	private int userID;
	private String un;
	private String pass;
	private String fn;
	private String ln;
	private String email;
	private int role;
	public ERS_USERS() {
	}
	public ERS_USERS(int userID, String un, String pass, String fn, String ln, String email, int role) {
		super();
		this.userID = userID;
		this.un = un;
		this.pass = pass;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.role = role;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getERS_USERNAME() {
		return un;
	}
	public void setUn(String un) {
		this.un =un;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
	
	
}
