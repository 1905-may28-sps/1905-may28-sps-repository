package com.primeNumbers;

import java.util.ArrayList;

public class PrimeNumberJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumber();

	}

	private static void PrimeNumber() {
		ArrayList<Integer> arrlist = new ArrayList<Integer>(10);
		String primeNumbers = "";

		for (int i = 1; i <= 100; i++) {
			arrlist.add(i);
			int counter = 0;
			for (int num = i; num >= 1; num--) {
				if (i % num == 0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
				primeNumbers = primeNumbers + i + " ";
			}
		}
		System.out.println(arrlist);
		System.out.println("Prime numbers from 1 to 100 are :");
		System.out.println(primeNumbers);
	}

}
