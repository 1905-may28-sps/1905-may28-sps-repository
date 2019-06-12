package com.revature.introduction;



public class CodingChallenge1 {
	public static void main(String[] args) {
		SecondLargest();
		
	}

	
	
	 static void SecondLargest() {
		 int[] array = {7,3,66,7,8,2};
		 int temp;
		 for (int i=1; i<array.length; i++) {
			 for(int a =i; a>0; a --) {
				 if (array[a] < array[a - 1]) {
					 temp = array[a];
					 array[a]=array[a-1];
					 array[a-1] = temp;
					 
				 }
			 }
		 }
			 System.out.println(array[1]);
		 }
	 }