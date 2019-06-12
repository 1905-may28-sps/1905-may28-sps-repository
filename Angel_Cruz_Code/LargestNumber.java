package com.revature.arrays;
import java.util.Arrays;

public class LargestNumber {

	public static void main(String... args) {
//		declaration, instantiation and initialization
		
		int numList[]= {33,3,4,5,69};
		System.out.println("This is the length of array: " + numList.length);
//		Sort Arrays ascending order
		Arrays.sort(numList);
		System.out.println("");
//		Print an Array using standard library Arrays
//			System.out.println(Arrays.toString(array));

		System.out.println(Arrays.toString(numList));
		
//		System.out.println("Maximum = " + array[array.length-1]);
		int answer = numList[numList.length-1];
		System.out.println("Max value is: "+ answer);

		
		
		

	}

}
