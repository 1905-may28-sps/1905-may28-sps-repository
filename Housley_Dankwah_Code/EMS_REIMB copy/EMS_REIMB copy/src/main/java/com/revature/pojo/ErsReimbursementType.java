package com.revature.pojo;

public class ErsReimbursementType {
	public int reimbTypeId;
	public String reimbType;
	
	public ErsReimbursementType() {}

	public ErsReimbursementType(int reimbTypeId, String reimbType) {
		super();
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
	}

	public int getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "ErsReimbursementType [reimbTypeId=" + reimbTypeId + ", reimbType=" + reimbType + "]";
	}
	
	
}