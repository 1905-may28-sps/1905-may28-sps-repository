package com.bubbleSort.Q1;

import java.util.Arrays;

// Q1. Perform a bubble sort on the following integer 

// array: 1,0,5,6,3,2,3,7,9,8,4



public class bubbleSortJava {
	
    


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


		int[] arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		
		System.out.println("original Array was: " + Arrays.toString(arr));
				
		SortNum(arr);
		System.out.println("The new arry:");
		printArray(arr);

	}


	public static void  SortNum(int[] arr) {

		int num = arr.length;

		for (int i = 0; i < num - 1; i++) {
			for (int j = 0; j < num - 1- i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public  static void printArray(int arr[]) {
		int num = arr.length;
		for (int i = 0; i < num; i++) {
			System.out.print( arr[i] + ",");
		}
	}
}
