//store numbers from 1 to 100 in an array. Print out Prime Numbers.
package javaAssignments;

import java.util.Arrays;

public class ArrayPrime_9 {
// main method
	public static void main(String[] args) {
		// creating new array
		int[] myArray = new int[100];
		// using 'for' loop for 1 to 100 numbers
		  for (int i=0; i<100; i++) {
	         myArray[i] = i+1;
		  }
	         
		  //using 2nd 'for' loop
		  for (int i=1; i<100; i++) { 
	         boolean isPrime = true;
				//using 3rd 'for' loop				
				for(int j=2; j < i ; j++){
					//applying 'if' condition if not prime number
					if(i % j == 0){
						isPrime = false;
						break;
					}
				}
				
				//applying 'if' condition if prime number
				if(isPrime)
					//displaying primary numbers
					System.out.print(i + " ");
			}
		  System.out.print("are Prime numbers\n");
		  // displaying array having numbers 1 to 100
		System.out.println("The created Array is : \n"+Arrays.toString(myArray));
		}
	}

	  
			