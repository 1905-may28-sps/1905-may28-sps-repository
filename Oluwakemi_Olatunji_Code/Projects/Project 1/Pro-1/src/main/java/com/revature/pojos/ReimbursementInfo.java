package com.revature.pojos;

public class ReimbursementInfo {
	
	private int id; 
	private double amount;
	private String sumbit;
	private String resolve;
	private String descript;
	private String employeeFirst;
	private String employeeLast;
	private String boss;
	private String status;
	private String type;

	public ReimbursementInfo () {}

	public ReimbursementInfo(int id, double amount, String sumbit, String resolve, String descript,
			String employeeFirst, String employeeLast, String boss, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.sumbit = sumbit;
		this.resolve = resolve;
		this.descript = descript;
		this.employeeFirst = employeeFirst;
		this.employeeLast = employeeLast;
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

	public String getEmployeeFirst() {
		return employeeFirst;
	}

	public void setEmployeeFirst(String employeeFirst) {
		this.employeeFirst = employeeFirst;
	}

	public String getEmployeeLast() {
		return employeeLast;
	}

	public void setEmployeeLast(String employeeLast) {
		this.employeeLast = employeeLast;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
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
		return "ReimbursementInfo [id=" + id + ", amount=" + amount + ", sumbit=" + sumbit + ", resolve=" + resolve
				+ ", descript=" + descript + ", employeeFirst=" + employeeFirst + ", employeeLast=" + employeeLast
				+ ", boss=" + boss + ", status=" + status + ", type=" + type + "]";
	}
	
	
}
