package src.com.revature.pojo;

import java.sql.Timestamp;

public class ERS_REIMBURSEMENT {
	private int id;
	private double amount;
	private String submit;
	private String resolved;
	private String descrp;
	//private PIC////////////
	private int emp;
	private int man;
	private int status;
	private int type;
	public ERS_REIMBURSEMENT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ERS_REIMBURSEMENT(int id, double amount, String submit, String resolved, String descrp, int emp,
			int man, int status, int type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submit = submit;
		this.resolved = resolved;
		this.descrp = descrp;
		this.emp = emp;
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
	public void setAmount(double d) {
		this.amount = d;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	public String getDescrp() {
		return descrp;
	}
	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}
	public int getEmp() {
		return emp;
	}
	public void setEmp(int emp) {
		this.emp = emp;
	}
	public int getMan() {
		return man;
	}
	public void setMan(int man) {
		this.man = man;
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
		return "ERS_REIMBURSEMENT [id=" + id + ", amount=" + amount + ", submit=" + submit + ", resolved=" + resolved
				+ ", descrp=" + descrp + ", emp=" + emp + ", man=" + man + ", status=" + status + ", type=" + type
				+ "]";
	}

	
	
	
	
	

}
