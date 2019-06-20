package homework.interfacePackage;

/*
 * Q15. Write a program that defines an interface having methods: addition, subtraction, multiplication 
 * and division. create a class that implements this interface and provides
 * appropriate functionality to carry out the required operations.
 * Hard code two operands in a class having a main method that
 * calls the implementing class.
 * 
 */

import java.io.*;

public interface InterfaceMathOperation {

	void addition(int a, int b);
	void subtraction(int a, int b);
	void multiplication(int a, int b);
	void division(int a, int b);
	
}


