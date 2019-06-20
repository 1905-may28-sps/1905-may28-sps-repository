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
	static void hexToDec() {
		System.out.println("Please enter the Hexadecimal Number you would like to convert to a Decimal");
		String hex = scan.nextLine();
		
		//string of hexadecimal variables
		String hexList = "0123456789ABCDEF";  
        hex = hex.toUpperCase();  
        int dec = 0;  
        
        for (int i = 0; i < hex.length(); i++)  
        {  
            char hexChar = hex.charAt(i);  
            int d = hexList.indexOf(hexChar);  
            dec = 16*dec + d;  
            
        }  
		
		
		
		//int dec=Integer.parseInt(hex,16);
		System.out.println(hex + " is '" +  dec + "' written as a decimal");
	}
	static void decToHex() {
		System.out.println("Please enter the Decimal Number you would like to convert to a Hexadecimal");
		String Num = scan.nextLine();
		int dec =Integer.parseInt(Num);
		
		int Dec=dec;
		int rem;
        
	     // For storing result
	     String hex=""; 
	 
	     //list of hexadecimal variables
	     char hexlist[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	 
	     while(dec>0)
	     {
	       rem=dec%16; 
	       hex=hexlist[rem]+hex; 
	       dec=dec/16;
	     }
		
		
		//String hex=Integer.toHexString(dec);
		System.out.println(Dec + " is '" +  hex + "' written as a Hexadecimal");
	}
	/*
	 * Greet user and display options 
	 * 1. convert decimal num to hex
	 * 2. convert hex to decimal num 
	 * 
	 * --> numbers will be taken in from user and displayed in console
	 */

}