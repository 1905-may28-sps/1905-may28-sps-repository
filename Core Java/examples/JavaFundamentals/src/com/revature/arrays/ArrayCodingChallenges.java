package com.revature.arrays;

import java.util.Arrays;

public class ArrayCodingChallenges {
	
	public static void main(String[] args) {
		System.out.println(testMax());
		UnderstandingArrays.usingArraysClass();
	}
	/*
	 * Find largest number in an array
	 */
	static int maxValue(int... array) {
		int max = Integer.MIN_VALUE;
		for(int num : array) {
			if(num>max) max = num;
		}	
		return max;
	}
	
	static boolean testMax() {
		int out1 = maxValue(5, -100, 1000, 0, 2, 4, 5,99);
		boolean test1 = out1 == 1000;
		
		return test1;
		
	}
	
	
	/*
	 * Find second largest number in an array
	 */
//	static int secondLargest(int[] arr) {
//		Arrays.sort(arr);
//		return arr[arr.length-2];
//	}
//	
//	static void usingArraysClass() {
//		int arr[] = {10, 3, 1000, 0, 2, -2, 4};
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
//	}
	
	public static void secondlargestNum(int[] arr) {
	int largest = arr[0];
	int secondLargest = arr[0];
	
	System.out.println("The given array is:" );
	for (int i = 0; i < arr.length; i++) {
		System.out.print(arr[i]+"\t");
	}
	for (int i = 0; i < arr.length; i++) {

		if (arr[i] > largest) {
			secondLargest = largest;
			largest = arr[i];

		} else if (arr[i] > secondLargest) {
			secondLargest = arr[i];

		}
	}

	System.out.println("\nSecond largest number is:" + secondLargest);

}
	

}
