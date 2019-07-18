package com.revature.io;

import java.util.Scanner;

public class ReadFromConsole {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("hi, what's your name?");
		
		String name = scan.nextLine();

		System.out.println("Hey, " + name+ "!"); 
		menu();
		
	//	scan.close(); //close resource to prevent leaks
	}
	
	static void menu() {
		System.out.println("What would you like to do today? "
				+ "You can either \n"
				+ "1. Dec -> Hex\n"
				+ "2. Hex -> Dec");
		String option = scan.nextLine();
		switch(option) {
		case "1": decToHex();
		break;
		case "2": hexToDec();
		break;
		default: 
			System.out.println("please enter 1 or 2");
			menu();
			//invalid option, maybe repeat the menu 
		}
	}
	
	static void decToHex() {
		
		System.out.print("Enter a decimal number : ");
	      int num =scan.nextInt();
	        
	      // calling method toHexString()
	      String str = Integer.toHexString(num);
	      System.out.println("Method 1: Decimal to hexadecimal: "+str);
	}
	
	static void hexToDec() {
		
		System.out.print("Enter a Hexadecimal number : ");
	      String hex =scan.nextLine();
	        
	      // calling method toHexString() 
	      double decimal = Integer.parseInt(hex,16);
	      System.out.println("Method 1: Hexadecimal to decimal: "+decimal);
	}
	
	/*
	 * Greet user and display options 
	 * 1. convert decimal num to hex
	 * 2. convert hex to decimal num 
	 * 
	 * --> numbers will be taken in from user and displayed in console
	 */

}