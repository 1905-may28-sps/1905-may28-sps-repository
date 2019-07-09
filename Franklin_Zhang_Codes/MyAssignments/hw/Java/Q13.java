package com.revature.hw;

import java.util.ArrayList;
import java.util.Arrays;

public class Q13 {
	public static void main(String[] args) {
		//can add values into arraylist... so if needed something longer i can create a for loop to add more 0 and 1s in 
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0,1,0,1,0,1,0,1,0,1));
		
		
		for (int i=1; i<5;i++) {
			for (int j=0;j<i; j++) {
				System.out.print(a.get(0));
	            a.remove(0) ;
			}
			System.out.println();
		}
	}
}
