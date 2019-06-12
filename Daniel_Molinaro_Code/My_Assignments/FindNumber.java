package com.revature.introduction;
import java.util.Arrays; 

public class FindNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,5,6,1,3,40,10,20};
		System.out.println(secLargestNum(arr1));

	}
	public static int secLargestNum(int[]arry) {
		Arrays.sort(arry);
		int secLargeNum = arry[arry.length-2];
		return secLargeNum;
	}
}
