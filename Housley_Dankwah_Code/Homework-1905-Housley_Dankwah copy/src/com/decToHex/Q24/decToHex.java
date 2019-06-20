package com.decToHex.Q24;

/*Q. 24. Write a method, not using the Integer wrapper class, to turn a number 
in base 10 to hexadecimal

*/

public class decToHex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		base10ToHex(125);

	}

	public static void base10ToHex(int inputNum) {

		int num = inputNum;

		int rem;

		String str2 = "";

		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		while (num > 0) {
			rem = num % 16;
			str2 = hex[rem] + str2;
			num = num / 16;
		}
		System.out.println("The Hex value of Base10 number " + inputNum + " is : 0x" + str2);
	}

}
