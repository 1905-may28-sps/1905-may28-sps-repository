package homework;

import java.util.ArrayList;

/*
 * Q9. Create an ArrayList which stores numbers from 1-100 and prints out all the prime
 * numbers to the console.
 */

public class PrimeNumbers {

	public static void main(String[] args) {
		
		ArrayList primeArr = new ArrayList();
		for(int i = 0; i < 100; i++) {
			primeArr.add(i+1);
		}
		System.out.println("Printing numbers from 1-100 in an ArrayList");
		System.out.println(primeArr);
		
		System.out.println("Prime Numbers are: ");
		for (int num=1; num < 100; num ++) {
			boolean isPrime = true;
			for(int j = 2; j < num; j++) {
				if (num % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				System.out.print(num + ", ");
		}
		
	}

}
