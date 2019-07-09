package com.revature.pojo;

public class User {
	private String fn;
	private String ln;
	private String un;
	private String pass;
	private int id;
	

	public User() {}


	public User(String fn, String ln, String un, String pass) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.un = un;
		this.pass = pass;
	}


	public User(String un, String pass) {
		super();
		this.un = un;
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


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}



	@Override
	public String toString() {
		return   fn + " " + ln + " Username=" + un + ", Password=" + pass ;
	}
	
	
	

}