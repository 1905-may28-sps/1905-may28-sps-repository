package com.revature.arrays;

import java.util.Arrays;

public class UnderstandingArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[5];
		nums[0]=1;
		nums[4]=10;
		int nums2[]=new int [10];
		nums2[nums2.length-1]=5;

		int [] nums3= {1,3,4,5};
		Arrays.sort(nums3);
		System.out.println();
		System.out.println(nums[0]+nums3[10]);
		System.out.println(add(2,3));
		System.out.println(add(1,4,6));
		System.out.println(add(2,4,6,2,3,4,5));
		
	}
	//Method overloading different params/implementations same name
	static int add(int a, int b) {
		return a+b;
	}

	static int add(int a, int b, int c) {
		return a+b+c;
	}
	//var args allows us to take ins a varying amount of the same satatype a a parameter to a method
	static int add(int... nums) {
		int sum=0;
				for (int num:nums) {
					sum+=num;
					
				}
		return sum;
	}
}

