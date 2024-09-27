package com.revature.introduction;
import java.util.Arrays;

public class SecondLargest {
	
	public static void main(String[] args) {
		int arr[]= {43,563,13,54,12};
		SecLargest(arr);
	
	}
		/*Arrays.sort(arr);
		System.out.println(arr[3]);*/
		
		//was trying to sort with a loop and then take
		//the array.length-1 index to print which will be the second
		//largest number
		public static void SecLargest(int arr[]) {
		int temp1= 0;
		int temp2= 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > temp1) {
				temp2=temp1;
				temp1=arr[i];
				
			}
			else if(arr[i] > temp2) {
				temp2 = arr[i];
			}

			}
		System.out.println(temp2);

		}
	}