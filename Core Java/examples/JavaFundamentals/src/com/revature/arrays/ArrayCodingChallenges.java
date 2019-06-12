package com.revature.arrays;

import java.util.Arrays;

public class ArrayCodingChallenges {
	
	public static void main(String[] args) {
		System.out.println(testMax());
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
	static int secondLargest(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length-2];
	}
	

}
