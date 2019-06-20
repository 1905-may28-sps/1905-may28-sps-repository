package Q4;

import java.util.Random;

public class nFactorial {

	public static void main(String[] args) {
		int i, fact = 1;
		Random rand = new Random();
		int number = rand.nextInt(10);
		for (i = 1; i <= number; i++) {
			fact = fact * i;
		}
		System.out.println("Factorial of " + number + " is: " + fact);

	}

}
