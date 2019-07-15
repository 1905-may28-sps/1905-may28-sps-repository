package com.revature.pojos;

public class ErsReimType {
	
	private int reimTypeId;
	private String reimType;
	
	public ErsReimType() {}

	public ErsReimType(int reimTypeId, String reimType) {
		super();
		this.reimTypeId = reimTypeId;
		this.reimType = reimType;
	}

	public int getReimTypeId() {
		return reimTypeId;
	}

	public void setReimTypeId(int reimTypeId) {
		this.reimTypeId = reimTypeId;
	}

	public String getReimType() {
		return reimType;
	}

	public void setReimType(String reimType) {
		this.reimType = reimType;
	}

	@Override
	public String toString() {
		return "EsrReimType ReimTypeId=" + reimTypeId + ", ReimType=" + reimType;
	}
	
	

}
