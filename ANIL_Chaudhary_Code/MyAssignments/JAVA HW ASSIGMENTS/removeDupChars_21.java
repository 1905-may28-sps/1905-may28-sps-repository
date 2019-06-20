package javaAssignments;

import java.util.Scanner;


public class removeDupChars_21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter a string");
			String string = sc.nextLine(); 
			sc.close();	
	 
		 String result = "";
		    for (int i = 0; i < string.length(); i++) {
		        if(!result.contains(String.valueOf(string.charAt(i)))) {
		            result += String.valueOf(string.charAt(i));
		        }
		    }
		    System.out.println( "The duplicates removed string is : "+result);
		}
}