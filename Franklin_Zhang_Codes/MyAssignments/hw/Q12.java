package com.revature.hw;
/*
 * Write a program to store numbers from 1 to 100 in an array. Print out all 
 * the even numbers from the array. Use the enhanced FORloop for printing out
 *  the numbers.
 */
public class Q12 {
	
	public static void main(String[] args) {
		int[] arr=arr();
		for (int a: arr) {
			if(a%2==0) {
			System.out.println(a);
			}
		}
		
	}
	
	public static int[] arr() {
		int arr[]= new int[100];
		for (int i = 0; i<100;i++) {
			arr[i]=i+1;
		}
		return arr;
	}
	
}

