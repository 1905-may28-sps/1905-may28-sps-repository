package com.revature.oop;

public class Person {
	private String name;
	private int age;

	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name=name;//this refers to the curren instance name. this line sets it equal to the parameter
		this.age=age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
