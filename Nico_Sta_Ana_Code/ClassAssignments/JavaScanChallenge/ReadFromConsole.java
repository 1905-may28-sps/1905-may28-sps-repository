package com.revature.Console;

import java.util.Scanner;

public class ReadFromConsole {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello! como se llama?");
		
		Scanner scan = new Scanner(System.in);
				
		String name = scan.nextLine();
		
		System.out.println("Buenos Dias," + name + " mucho gusto!");
		
		menu();
		
	}
	
	
	static void menu() {
		
		System.out.println("What would you like to do today?" + " You can either"
							+ "1. Dec => Hex"
							+ "2. Hex => Dec ");
	
		
		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();
		
		switch(option) {
		case "1":
			decToHex();
				break;
		case "2":
			hexToDec();
			break;
			default:
				System.out.println("please enter 1 or 2");
				
		}
	}
	
	
	static void decToHex() {
		System.out.println("1 chosen");
		
		Scanner input = new Scanner( System.in );
	      System.out.print("Enter a decimal number : ");
	      int num =input.nextInt();
	        
	      // calling method toHexString()
	      String str = Integer.toHexString(num);
	      System.out.println("Method 1: Decimal to hexadecimal: "+str);
		
		
	};
	
	static void hexToDec() {
		
		Scanner scan = new Scanner(System.in);
		
		String hex = scan.nextLine();
		
		System.out.println(hex);
		
//		Float num = 0;
//		for(int i = 0; i < hex.length; i ++) {
//			Object Char = hex.charAt(hex.length-1-i);
//			
//		}
		
	}

}
