package com.revature.introduction;

public class ClassAndObject {
	

	
	public static void main(String[] args) {
		
		//instantiang an object... take a variable and point it to  a class.... [new] java allocating space for this variable
		Person person1 = new Person ();
		
		//define some properties
		person1.name = "Tiffy";
		person1.email = "tiff@gmail.com";
		person1.phone = "7189875437";
		
		
		//Abstraction ... you don't see behind the scenes
		person1.walk();
		person1.email();
		person1.sleep();
	}

}






class Person{
	String name;
	String email;
	String phone;
	
	void walk() {
		System.out.println(name + " is walking");
	}
	
	void email() {
		System.out.println(email);
	}
	
	void sleep() {
		System.out.println(name +  " is sleeping");
	}
}