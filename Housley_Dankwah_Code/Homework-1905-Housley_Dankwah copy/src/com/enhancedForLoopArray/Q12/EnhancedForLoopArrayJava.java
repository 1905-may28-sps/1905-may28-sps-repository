package com.enhancedForLoopArray.Q12;

/* Q12. Write a program to store numbers from 1 to 100 in an array. 
	Print out all the even numbers from the array. Use the enhanced 
	FOR loop for printing out the numbers.
*/

import java.util.ArrayList;

public class EnhancedForLoopArrayJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enhancedForLoopArray();

	}

	public static void enhancedForLoopArray() {
		ArrayList<Integer> arrlist = new ArrayList<Integer>(100);
		ArrayList<Integer> myarr = new ArrayList<Integer>(100);


		for (int i = 1; i <= 100; i++) {
			arrlist.add(i);

		}
		for (int item : arrlist) {
			if (item % 2 == 0) {
				myarr.add(item);

			}

		}
		System.out.println("The Even Numbers of arrlist using enhanced ForLoop are : ");
		System.out.println(myarr);

	}

}
