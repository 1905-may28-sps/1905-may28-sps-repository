package corejava.revature.q14;

import java.util.Calendar;
import java.util.Date;

public class Q14 {

	static double sqrt(double x) {
		double y = Math.sqrt(x);
		return y;
	}

	static void date() {
		Date today = Calendar.getInstance().getTime();
		System.out.println(today);
	}

	static void splitter(String str) {
		String[] arr = str.split("\\s");
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {

			switch (i) {
			case 1:
				System.out.println(sqrt(100));
				break; // Find the square root of a number using the Math class method.

			case 2:
				date(); // Display today’s date.
				break;

			case 3:
				splitter("I am learning Core Java");
				break; // Split the following string and store it in a sting array. “I am learning Core
						// Java”

			}

		}
	}
}