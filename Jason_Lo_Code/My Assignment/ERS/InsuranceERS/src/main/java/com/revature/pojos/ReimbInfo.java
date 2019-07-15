package com.revature.pojos;

public class ReimbInfo {
	private int id;
	private String fn;
	private String ln;
	private int type;
	private double amount;
	private String sumbit;
	private int status;
	private String resolved;
	
	
	public ReimbInfo(int id, String fn, String ln, int type, double amount, String sumbit, int status,
			String resolved) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.type = type;
		this.amount = amount;
		this.sumbit = sumbit;
		this.status = status;
		this.resolved = resolved;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFn() {
		return fn;
	}


	public void setFn(String fn) {
		this.fn = fn;
	}


	public String getLn() {
		return ln;
	}


	public void setLn(String ln) {
		this.ln = ln;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getSumbit() {
		return sumbit;
	}


	public void setSumbit(String sumbit) {
		this.sumbit = sumbit;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getResolved() {
		return resolved;
	}


	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	
	
	
	
	
	

}
