package com.revature.q12;

import java.util.Arrays;

public class StoreArray {
	
	public static void storeArray(int[] storeArr){
		int i;
		for(i=1; i<=storeArr.length; i++) {
			storeArr[i-1]=i;
		}
	}
	
	public static void evenArray(int[] evenArr) {
		for(int j:evenArr) {
			if(evenArr[j]%2==0) {
				evenArr[j]=j;/*since index j starts from 0, 
				there is a mismatch between index and value 
				the index represents.  Using the for enhanced
				loop was required, so I have to tweak the 
				value of j in the output, to only output 
				even numbers. Using a for enhanced loop in this
				way is not preferred because I have no control
				over the index values.*/
				System.out.print(j+1+ " ");
			}
		}
	}

	public static void main(String[] args) {
		
		int storedArr[] = new int[100];
		storeArray(storedArr);
		System.out.println(Arrays.toString(storedArr));
		evenArray(storedArr);
	}
}
