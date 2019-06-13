package com.revature.scanner;
import java.util.Scanner;

public class ReadFromConsole {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi, what's your name?");
		
		String name = scan.nextLine();

		System.out.println("Hey, " + name+ "!"); 
		menu();
		scan.close();
		
		
	}
	
	static void menu() {
		System.out.println("What would you like to do today? "
				+ "You can either \n"
				+ "1. Dec -> Hex\n"
				+ "2. Hex -> Dec");
		String option = scan.nextLine();
	
		
		switch(option) {
		case "1": System.out.println("Please enter decimal value"); 
		int decimal = scan.nextInt();
		System.out.println(Integer.toHexString(decimal));
		break;
		case "2": System.out.println("Please enter hex value"); 
		String hex = scan.nextLine();
		System.out.println(hexToDec(hex));
		break;
		default: 
			System.out.println("please enter 1 or 2");
			menu();
			
		}
	}
	
	
	static int hexToDec(String hex) {
		int dec = Integer.parseInt(hex,16); 
		return dec;
		
	}
}
