package com.revature.q6;

public class NoModEven {

	public static void main(String[] args) {

		int num = 98;
		if((num & 1) == 0) {/* Use bitwise AND because when any
		number is changed into its binary representation, when
		that number is combined with 1 using the AND operator, 
		it is even if the result equals 0.*/
			System.out.println("The number " + num + " is even.");
		}else {
			System.out.println("The number " + num + " is not even.");
		}

	}

}
