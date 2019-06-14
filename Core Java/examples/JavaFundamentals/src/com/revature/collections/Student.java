package com.revature.collections;

public class Student implements Comparable<Student>{

	private int id;
	private String firstName;
	private String lastName;
	private int grade;

	public Student(int id, String firstName, String lastName, int grade) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
	}



	@Override
	public int compareTo(Student o) {
		return this.firstName.hashCode() - o.firstName.hashCode();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade + "]";
	}
	


}
