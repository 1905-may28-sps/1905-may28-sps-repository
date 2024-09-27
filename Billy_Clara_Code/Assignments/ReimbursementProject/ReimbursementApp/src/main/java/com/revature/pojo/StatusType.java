package com.revature.pojo;

public class StatusType {
	
	private int typeid;
	private String type;
	
	public StatusType () {}

	public StatusType(int typeid, String type) {
		super();
		this.typeid = typeid;
		this.type = type;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "StatusType [typeid=" + typeid + ", type=" + type + "]";
	}
	
}
