package com.revature.pojo;

public class Manager {
	public int id;
	public String firstname;
	public String lastname;
	public String email;
	public int amount;
	public String submitted;
	public String resolved;
	public String description;
	public String status;
	public String type;
	
	public Manager() {}

	public Manager(int id, String firstname, String lastname, String email, int amount, String submitted,
			String resolved, String description, String status, String type) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.status = status;
		this.type = type;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved + ", description="
				+ description + ", status=" + status + ", type=" + type + "]";
	}
	
	

}
