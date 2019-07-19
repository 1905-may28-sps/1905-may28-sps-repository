package com.revature.beans;

public class Athlete {
	private int id;
	private String firstname;
	private String lastname;
	private String sport;
	
	public Athlete () {}

	public Athlete(int id, String firstname, String lastname, String sport) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.sport = sport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Override
	public String toString() {
		return "Athlete [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", sport=" + sport + "]";
	}
	
	

}
