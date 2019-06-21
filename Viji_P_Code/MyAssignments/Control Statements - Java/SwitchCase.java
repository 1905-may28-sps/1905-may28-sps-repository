package com.revature.introduction;

public class SwitchCase {

//Switch case example

 public static void main(String[] args) {
		int result = 0;
		int option = 2;
		int x = 28;
		int y = 3;
		
	switch (option) {
	case 1:
	result = x + y;
	System.out.println("The addition of two numbers is " + result);
	break;
	
	case 2:
	result = x - y;
	System.out.println("The subtraction of two numbers is " + result);
	break;
	
	case 3:
	result = x * y;
	System.out.println("The multiplication of two numbers is " + result);
	break;
		
	case 4:
	result = x / y;
	System.out.println("The division of two numbers is " + result);
	break;
		
	case 5:
	result = x % y;
	System.out.println("The modulus of two numbers is " + result);
	break;
	
	default:
	System.out.println("Invalid Option");
	break;
	
			}
	
	// While loop
	
	int a = 10;
	while (a > 5) {
		
		System.out.println("The value of a is " + a);
		a -= 10;
	}
	
	// Do-While loop
	int num = 30;
	do {
		
		System.out.println("Hello world!");
		num/=5;
		} while (num > 4);
	
	
 		}	
	}

