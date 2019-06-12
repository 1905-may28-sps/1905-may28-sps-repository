package com.revature.arrays;

import java.util.Arrays;

public class UnderstandingArrays {
	
	/*
	 * Grouping of entities of the same type 
	 * - not dynamically sized, meaning we MUST declare
	 * them either with a size or with the values 
	 * explicitly defined
	 * - 0 indexed
	 */
	
	public static void main(String... args) {
		usingArraysClass();
	}
	
	static void testArrays() {
		int[] nums = new int[5];
		nums[0] = 1;
		nums[4] = 10;
		
		int nums2[] = new int[10];
		nums2[nums2.length-1] = 5; //setting last number in nums2 to 5
		
		int[] nums3 = {1,3,4,5};
	//	System.out.println(nums3[10]); //THROWS EXCEPTION! ARRAYINDEXOUTOFBOUNDS
		System.out.println(add(2, 3));
		System.out.println(add(1, 2, 3));
		System.out.println(add(5,6, 7, 8, 9, 3423, 3254, 2 , 1, 3, 4));
	}
	
	static int add(int a, int b) {
		System.out.println("ADD WITH TWO PARAMS");
		return a + b;
	}
	
	//this is method OVERLOADING! same name, different params/implementation
	static int add(int a, int b, int c) {
		System.out.println("ADD WITH THREE PARAMS");
		return a + b + c;
	}
	
	/*
	 * VAR ARGS - a feature of Java that allows us to take in 
	 * a varying amount of the same datatype as a parameter to a method
	 * 
	 * Inside of the method, this parameter is retrieved as an array 
	 * 
	 * varargs can only be used as the last argument in a parameter list 
	 * of a method, and there can only be one per method. 
	 * 
	 * we can even use them to replace our String[] args in our main method!
	 */
	static int add(int... nums) {
		System.out.println("ADD WITH VAR ARGS");
		int sum = 0;
		for(int num : nums) {
			sum+=num;
		}
		return sum;
	}
	/*
	 * In order to manipulate arrays simply using pre-defined 
	 * Java functionality, we can use the Arrays class 
	 */
	static void usingArraysClass() {
		int arr[] = {10, 3, 1000, 0, 2, -2, 4};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	


}
