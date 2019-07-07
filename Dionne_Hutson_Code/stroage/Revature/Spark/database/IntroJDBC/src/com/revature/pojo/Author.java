package com.revature.pojo;

public class Author {

	private int id=0;
	private String firstName;
	private String lastName;
	private String bio;
	
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Author(int id, String firstName, String bio) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.bio = bio;
	}



	public Author(int id, String firstName, String lastName, String bio) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	@Override
	public String toString() {
		return "Author " + id + ": "+ firstName + ", " + lastName + "               bio :" + bio;
	}
	
	
	
	
}
