package com.revature.pojos;

public class Reimbursement {
	
	private int id; 
	private double amount;
	private String sumbit;
	private String resolve;
	private String descript;
	private int employee;
	private int boss;
	private int status;
	private int type;
	
	
	public Reimbursement () {}


	public Reimbursement(int id, double amount, String sumbit, String resolve, String descript, int employee, int boss,
			int status, int type) {
		super();
		this.id = id;
		this.amount = amount;
		this.sumbit = sumbit;
		this.resolve = resolve;
		this.descript = descript;
		this.employee = employee;
		this.boss = boss;
		this.status = status;
		this.type = type;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getResolve() {
		return resolve;
	}


	public void setResolve(String resolve) {
		this.resolve = resolve;
	}


	public String getDescript() {
		return descript;
	}


	public void setDescript(String descript) {
		this.descript = descript;
	}


	public int getEmployee() {
		return employee;
	}


	public void setEmployee(int employee) {
		this.employee = employee;
	}


	public int getBoss() {
		return boss;
	}


	public void setBoss(int boss) {
		this.boss = boss;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", sumbit=" + sumbit + ", resolve=" + resolve
				+ ", descript=" + descript + ", employee=" + employee + ", boss=" + boss + ", status=" + status
				+ ", type=" + type + "]";
	}
	
	
}
