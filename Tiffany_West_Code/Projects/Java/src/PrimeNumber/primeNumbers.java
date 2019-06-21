package PrimeNumber;

import java.util.ArrayList;

public class primeNumbers {

	
	public static void main(String[] args) {
		
		
		Primes();
	}

	private static void Primes() {
		ArrayList<Integer> arrlist = new ArrayList<Integer>(100);
		String primeNum = "";

		for (int i = 1; i <= 100; i++) {
			arrlist.add(i);
			int counter = 0;
			for (int num = i; num >= 1; num--) {
				if (i % num == 0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
				primeNum = primeNum + i + " ";
			}
		}
		
		System.out.println("Prime numbers from 1 to 100 are : " +primeNum);
		
	}
}
