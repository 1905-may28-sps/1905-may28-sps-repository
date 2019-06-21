package Assignements;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		String string, backwards = " ";
		Scanner in = new Scanner(System.in);

		System.out.println("Enter string to reverse");
		string = in.nextLine();

		int length = string.length();

		for (int i = length - 1; i >= 0; i--)
			backwards = backwards + string.charAt(i);

		System.out.println("The reverse: " + backwards);

	}

}
