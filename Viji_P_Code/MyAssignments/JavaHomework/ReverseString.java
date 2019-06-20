package homework;

import java.util.Scanner;

//Reverse a String without using a temporary variable. Do not use reverse() in the String Buffer
//or the StringBuilder APIs.

public class ReverseString {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter string: ");
		String str = scan.nextLine();
		System.out.println("The Original String: " + str);
		int len = str.length();
		//System.out.println(len);
		String str1 = "";
		for ( int i = (len-1); i >= 0; i--) {
			//System.out.println(str.charAt(i));
			str1 += str.charAt(i);
			}
		System.out.println("Reversed String: " + str1);
	}
}
