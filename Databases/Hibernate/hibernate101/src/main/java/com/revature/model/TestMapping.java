package com.revature.model;

public class TestMapping {
	
	/*
	 * As we know, for most configuration details, we 
	 * can handle it in multiple ways. 
	 * We have seen configuring classes as entities with
	 * annotations, but we must also explore 
	 * configuring classes as entities with XML
	 * We do this via a hibernate mapping file 
	 * The mapping files must be named
	 * ClassName.hbm.xml
	 */
	
	private int id;
	private String info;
	
	public TestMapping() {}

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
