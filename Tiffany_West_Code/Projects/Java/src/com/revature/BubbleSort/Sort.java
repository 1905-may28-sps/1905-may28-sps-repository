package com.revature.BubbleSort;

public class Sort {
	
public static void bubbleSort(int[] dataSet) {
		
		//Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
	boolean swapped = false;
	System.out.println("Original Array:\n");
		printArr(dataSet);
		do {
		for(int i =0; i <dataSet.length-1; i++) {
			if(dataSet[i] > dataSet[i+1]) {
				int temp = dataSet[i];
				dataSet[i] = dataSet[i+1];
				dataSet[i+1] = temp;
				System.out.print("Sort : ");

				printArr(dataSet);
				swapped= true;

			}
		}
		}while(swapped);
	}
	
	private static void printArr(int[] arr) {

		for (int i : arr) {
			System.out.print(i+ " ");
		}
		System.out.println();
	}
	

}
