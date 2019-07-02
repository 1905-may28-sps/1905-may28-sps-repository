package com.revature.pojos;



public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	public User() {}
	
	public User(int id, String firstName, String lastName, String email, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username= username;
		this.password= password;
		
		
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
		this.firstName= firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;	
	
	}
	
	@Override
	public String toString() {
		//return ("Thank you  "+ firstName +" "+ lastName +" for registering with the Bank \n\n");
		//return "User [id =" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", username= " + username +" , password = "+ password +"]";
		return  "Hello  ! " + firstName + " " + lastName +"  Customer Id "+ id +"";
	
	}

}










