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
		case "1": decToHex(); break;
		case "2": hexToDec(); break;
		default: 
			System.out.println("please enter 1 or 2");
			menu();
			//invalid option, maybe repeat the menu 
		}
	}
	
	static void decToHex() {
		System.out.println("Enter the number you'd like to convert to Hexadecimal");
		String numStr = scan.nextLine();
		int num;
		try {
			num = Integer.parseInt(numStr);
			String out =  "";
			int rem = 0;
			while(num>0){
				rem = num%16;
				out =  (rem > 9 ?  (Character.toString((char)(rem+87))) : rem) + out;
				num/=16;
			}
			System.out.println(numStr + " -> Hex: " + out);
		}
		catch(NumberFormatException e) {
			System.out.println("Please enter a whole number");
			decToHex();
		}
	}
	
	static void hexToDec() {
		System.out.println("Enter the hexadecimals string youd like to convert to decimal");
		String hexVal = scan.nextLine();
		if(!hexVal.matches("^[0-9A-Fa-f]+$")) {
			System.out.println("Please enter a valid hex string");
			hexToDec();
		}
		else {
			int out = 0;
			for(int i = 0; i < hexVal.length(); i++) {
				char ch = hexVal.charAt(hexVal.length()-i-1);
				String curr = "" + ch;
				try {
					int num = Integer.parseInt(curr);
					out += num*Math.pow(16, i);
				}
				catch(NumberFormatException e) {
					//means char is a-f
					int num = ((int)(ch))-87;
					out += num*Math.pow(16, i);
				}
				
			}
			System.out.println(hexVal + " -> Decimal: " + out);
		}
	}
	
	/*
	 * Greet user and display options 
	 * 1. convert decimal num to hex
	 * 2. convert hex to decimal num 
	 * 
	 * --> numbers will be taken in from user and displayed in console
	 */

}
