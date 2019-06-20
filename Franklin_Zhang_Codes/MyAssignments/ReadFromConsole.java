package com.revature.io;

import java.util.Scanner;

public class ReadFromConsole {

	static Scanner scan = new Scanner(System.in)
			;
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
		default: 
			System.out.println("please enter 1 or 2");
			menu();
			//invalid option, maybe repeat the menu 
		}
	}
		static void decToHex() {
			System.out.println("Enter a Numerical number: ");
			String DecString = scan.nextLine();
			int DecInt = Integer.parseInt(DecString);
			
			do {
				int i = DecInt%16;
					switch(i) {
					case 10: System.out.println("A"); break;
					case 11: System.out.println("B"); break;
					case 12: System.out.println("C"); break;
					case 13: System.out.println("D"); break;
					case 14: System.out.println("E"); break;
					case 15: System.out.println("F"); break;
					default : System.out.println(i); break;
					}
				
				DecInt = DecInt/16;
				
			} while(DecInt/16>0);
		}
		static void hexToDec() {
			System.out.println("Enter a Numerical number: ");
			String HexString = scan.nextLine();
		}
		
		
	
	
	/*
	 * Greet user and display options 
	 * 1. convert decimal num to hex
	 * 2. convert hex to decimal num 
	 * 
	 * --> numbers will be taken in from user and displayed in console
	 */

}