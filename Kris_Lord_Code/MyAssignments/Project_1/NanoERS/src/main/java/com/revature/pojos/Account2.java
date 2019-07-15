package com.revature.pojos;

public class Account2 {

	private int accountId;
	private Double balance;
	private String submitted;
	private String description;
	private int author;
	private int resolver;
	private int statusId;
	private int accountType;
	
	public Account2() {
		
	}
	
	public Account2(Double balance, String submitted, String description, int author, int resolver, int statusId,
			int accountType) {
		super();
		this.balance = balance;
		this.submitted = submitted;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.accountType = accountType;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}
	
	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account2 [balance=" + balance + ", submitted=" + submitted + ", description=" + description
				+ ", author=" + author + ", resolver=" + resolver + ", statusId=" + statusId + ", accountType=" + accountType + "]";
	}
}
