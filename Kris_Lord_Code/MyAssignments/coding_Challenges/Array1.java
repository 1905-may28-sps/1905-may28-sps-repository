package com.revature.coding;

import java.util.Arrays;

public class Array1 {

	public static void main(String[] args) {
		int secMax[]={10, 3, 1000, 0, 2, -2, 4};
		System.out.println(arraySecMax(secMax));

	}
	
	static int arraySecMax (int[] arr) {
		Arrays.sort(arr);
		int secMax = arr[arr.length - 2];
			
		return secMax;
	}

}
