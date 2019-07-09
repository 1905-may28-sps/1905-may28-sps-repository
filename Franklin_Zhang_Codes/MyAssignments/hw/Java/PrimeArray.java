package com.revature.hw;
//print
public class PrimeArray {
	public static void main(String[] args) {
		int[] arr=createArray();

	
// we start checking from arr[1] because we know 1 is not a prime number.	                                                                                                 
	for(int i=1; i<100;i++) {
//use this to check if any numbers between 1 and the current number is divisible by the number, if so it is not prime
		boolean ifPrime = true;
		for (int j =2; j<i; j++) {
			if(arr[i]%j==0) {
				ifPrime=false;
				break;
			}		
		}
		if(ifPrime) {
			System.out.print(arr[i]+" ");
		}
	}
}
	
			
	



	public static int[] createArray() {
		// TODO Auto-generated method stub
		int[] arr;
		arr = new int[100];
		for (int i = 0; i<100;i++) {
			arr[i]=i+1;
		}
		return arr;
	}
}


