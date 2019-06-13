package com.revature.arrays;

public class ArrayChallenge {

	/*
	 *  Write a program that finds the second largest value in an array
	 */
	public static void main(String[] args) {
		isArray();
	}
	
	public  static void testArray () {
		//int test1 = isArray(34);
	}

	public static int isArray  ( ) {
		//array & do while for loop
		
		int []   nums = new int[4];
				nums[0] = 4;
				nums[1] = 10;		
				nums[2] = 30;
				nums[3] = 25;
				int i=0;
				do {
					System.out.println(nums[i]);
					i=i+1;
				}while (i<4);	
				
			int max= nums[0];
			for(i =1; i <nums.length; i++)
				if (nums[i] > max)
					max = nums[i];
			
			System.out.println("the largest number in the array is : " + max);
			System.out.println("the second largest number is: "   );
			return max;

	}
	}
