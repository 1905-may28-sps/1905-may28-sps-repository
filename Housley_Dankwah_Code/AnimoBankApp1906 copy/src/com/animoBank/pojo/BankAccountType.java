package com.animoBank.pojo;

public class BankAccountType {
	
	private int accountTypeId;
	private String type;
	
	public BankAccountType() {}

	public BankAccountType(int accountTypeId, String type) {
		super();
		this.accountTypeId = accountTypeId;
		this.type = type;
	}

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BankAccountType [accountTypeId=" + accountTypeId + ", type=" + type + "]";
	}
	

}
