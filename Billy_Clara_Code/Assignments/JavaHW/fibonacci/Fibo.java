package com.billy.fibonacci;

public class Fibo {
	
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int fibo = 25;
		
		for (int i = 0; i <= fibo; i++) {
			int sumofnums = a + b;
			System.out.print(a + " ");

			a = b;
			b = sumofnums;
		}
	}

}
