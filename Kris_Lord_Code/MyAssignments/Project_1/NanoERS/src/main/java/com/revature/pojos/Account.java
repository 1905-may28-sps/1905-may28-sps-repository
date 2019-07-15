package com.revature.pojos;

import java.sql.Blob;

public class Account {

	private Integer accountId;
	private Double balance;
	private String submitted;
	private String resolved;
	private String description;
	private Blob receipt;
	private int author;
	private int resolver;
	private int statusId;
	private int accountType;
	
	public Account() {}
	
	public Account(Integer accountId, Double balance, String submitted, String resolved, String description,
			Blob receipt, int author, int resolver, int statusId, int accountType) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.accountType = accountType;
	}

	public Account(String resolved, int statusId) {
		super();
		this.resolved = resolved;
		this.statusId = statusId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
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

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
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
		return "Account [accountId=" + accountId + ", balance=" + balance + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", statusId=" + statusId + ", accountType=" + accountType + "]";
	}

	

}