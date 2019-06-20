package com.revature.introduction;

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
