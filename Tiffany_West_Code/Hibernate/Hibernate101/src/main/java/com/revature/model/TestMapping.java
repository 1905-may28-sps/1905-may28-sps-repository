package com.revature.model;


public class TestMapping {

	private int id;
	private String info;
	
	public TestMapping() {}

	public TestMapping(int id, String info) {
		super();
		this.id = id;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
