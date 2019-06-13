package com.revature.oop;

/*
 * POJO 
 */
public class Person {

	private String name;
	private int age;
	
	//Person me = new Person();
	public Person() {}
	
	//Person me = new Person("Genesis", 300);
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
