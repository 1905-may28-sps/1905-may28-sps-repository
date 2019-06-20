package Q3;

import java.util.Scanner;

public class reverseString {

	public static void reverseString(char[] ch, int length) {
		if (length > 0) {
			System.out.print(ch[length - 1]);
			length--;
			reverseString(ch, length);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String");

		String str = scan.nextLine();

		char[] ch = str.toCharArray();
		int length = ch.length;

		reverseString(ch, length);
	}
}
