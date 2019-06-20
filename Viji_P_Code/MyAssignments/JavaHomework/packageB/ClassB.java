package homework.packageB;

/*
 * Write a program that would access two float-variables from a class that exists in 
 * another package. Note, you will need to create two packages to demonstrate the solution.
 */

import homework.packageA.ClassA;

public class ClassB {

	public static void main(String[] args) {
		
		ClassA obj = new ClassA();
		obj.floatNum();
		
	}

}
