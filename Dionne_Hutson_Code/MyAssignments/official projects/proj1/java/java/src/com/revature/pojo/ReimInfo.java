package src.com.revature.pojo;

import java.sql.Blob;

public class ReimInfo {
	private int id;
	private double amount;
	private String submit;
	private String resolved;
	private String descrp;
	private Blob pic;
	private String manfn;
	private String manln;
	
	private String empfn;
	private String empln;

	public String getManfn() {
		return manfn;
	}
	public void setManfn(String manfn) {
		this.manfn = manfn;
	}
	public String getManln() {
		return manln;
	}
	public void setManln(String manln) {
		this.manln = manln;
	}
	public String getEmpfn() {
		return empfn;
	}
	public void setEmpfn(String empfn) {
		this.empfn = empfn;
	}
	public String getEmpln() {
		return empln;
	}
	public void setEmpln(String empln) {
		this.empln = empln;
	}
	private String status;
	private String type;
	public ReimInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ReimInfo(int id, double amount, String submit, String resolved, String descrp, Blob pic, String manfn,
			String manln, String empfn, String empln, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submit = submit;
		this.resolved = resolved;
		this.descrp = descrp;
		this.pic = pic;
		this.manfn = manfn;
		this.manln = manln;
		this.empfn = empfn;
		this.empln = empln;
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
	public Blob getPic() {
		return pic;
	}
	public void setPic(Blob pic) {
		this.pic = pic;
	}
	
	

	
	
}
