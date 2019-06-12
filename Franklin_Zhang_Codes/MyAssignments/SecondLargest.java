package com.revature.arrays;
import java.util.Arrays;
public class SecondLargest {

	public static void main(String[] args) {
		int [] array=  {2,5,1,6,2,8,91,51};
				Arrays.sort(array);
		System.out.println(array[array.length-2]);
	}
}
