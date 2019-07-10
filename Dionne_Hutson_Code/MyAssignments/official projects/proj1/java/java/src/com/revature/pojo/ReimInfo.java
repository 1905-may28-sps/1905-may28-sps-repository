package src.com.revature.pojo;

import java.sql.Timestamp;

public class ReimInfo {
	private int id;
	private double amount;
	private Timestamp submit;
	private Timestamp resolved;
	private String descrp;
	//private PIC////////////
	private String man;
	private String emp;
	private String status;
	private String type;
	public ReimInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimInfo(int id, double amount, Timestamp submit, Timestamp resolved, String descrp, String man,
			String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submit = submit;
		this.resolved = resolved;
		this.descrp = descrp;
		this.man = man;
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
	public Timestamp getSubmit() {
		return submit;
	}
	public void setSubmit(Timestamp submit) {
		this.submit = submit;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getDescrp() {
		return descrp;
	}
	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}
	public String getMan() {
		return man;
	}
	public void setMan(String man) {
		this.man = man;
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
	public String getEmp() {
		return emp;
	}
	public void setEmp(String emp) {
		this.emp = emp;
	}
	
	
}
