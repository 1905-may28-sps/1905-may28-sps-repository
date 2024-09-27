package com.billy.triangle;

public class Tri {
	
	public static void row(int n, int cols) {
		int i = 1;
		while (i <= cols) {
			
			System.out.printf("%4d", 0 );
			i = i + 1;
		}
		System.out.println();
			
		}
	public static void table(int rows) {
		int i = 1;
		while (i <= rows) {
			row(i, i);
			i = i + 1;
		}
	}
	
	public static void main(String[] args) {
		table(4);
		//Able to print the triangle. Figuring out how to print
		//0 1 0 1
	}
	}


