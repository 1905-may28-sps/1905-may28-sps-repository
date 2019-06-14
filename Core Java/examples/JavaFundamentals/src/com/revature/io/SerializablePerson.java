package com.revature.io;

import java.io.Serializable;

public class SerializablePerson implements Serializable {


//	private static final long serialVersionUID = -4481734381900408956L;

	//private static final long serialVersionUID = -4953431933722666794L;
	
	  private static final long serialVersionUID = -4953431933722666794L;
	  
	private String name;
	private String dob;
	private transient long ssn;
	
	public SerializablePerson(String name, String dob, long ssn) {
		super();
		this.name = name;
		this.dob = dob;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public String getDob() {
		return dob;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", dob=" + dob + ", ssn=" + ssn;
	}
	
	

}
