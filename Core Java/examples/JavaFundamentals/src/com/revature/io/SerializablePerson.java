package com.revature.io;

import java.io.Serializable;

public class SerializablePerson implements Serializable {
	
	private String name;
	private String dob;
	private long ssn;
	
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	
	
	

}
