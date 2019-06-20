package com.triangle.Q13;

/*
 * Q13. Display the triangle on the console as follows using any type of loop. 
 * Do NOT use a simple group of print statements to accomplish this.
 * 0
 * 10 
 * 101 
 * 0101
 * 
 * 
 * */

public class TriangleJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DisplayTriangle();

	}

	public static void DisplayTriangle() {
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= i; j++) {
				if ((i + j) % 2 == 1) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}

			}
			System.out.println();
		}
	}

}
