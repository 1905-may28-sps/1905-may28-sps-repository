package com.revature.hw;

import java.util.Scanner;
import java.lang.StringIndexOutOfBoundsException;

//Write a substring method that accepts a string str and an integer idx and 
//returns the substring  contained  between  0  and  idx-1inclusive.Do  NOT  
//use  any  of  the  existing substring methods in the String, StringBuilder, 
//or StringBuffer APIs.
public class Q5 {
	
		
		private static String str() {
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Please enter a word: ");
		    String words = myObj.nextLine();  // Read user input
			return words;
		}

		private static Integer idx() {
			Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Please enter how many letters u want returned ");
		    String stringNum = myObj1.nextLine();  // Read user input
		    Integer num = Integer.valueOf(stringNum);
		    return num;
		}
		
		
		
		public static void main(String[] args) {
			String ChosenWord = str();
			int num=idx();
			try {
				for (int i =0; i<num; i++) {
					System.out.print(ChosenWord.charAt(i));	
				}
			}
			catch(StringIndexOutOfBoundsException e){
				System.out.println(" Number chosen is more then length of word cannot display more.");
				}
			}
		}
	