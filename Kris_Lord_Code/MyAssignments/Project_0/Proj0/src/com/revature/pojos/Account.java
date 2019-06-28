package com.revature.pojos;

public class Account {

	private Integer accountId;
	private Double balance;
	private Integer userId;
	private String accountType;
	
	public Account() {}
	
	public Account(Integer accountId, Double balance, Integer userId, String accountType) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.userId = userId;
		this.accountType = accountType;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance= $" + balance + ", userId=" + userId + ", accountType="
				+ accountType + "]"+"\n";
	}

}