package com.revature.pojos;

public class Genre {

	private int id;
	private String name;
	
	
	
	
	
	public Genre(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "genre [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
