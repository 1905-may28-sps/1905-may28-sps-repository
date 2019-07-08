//store numbers from 1 to 100 in an array. Print out all the even numbers from the array.


package javaAssignments;
import java.util.Arrays;
public class ArrayStore_12 {
//main method
	public static void main(String[] args) {
		// creating new array
		int[] myArray = new int[100];
		
		  for (int i=0; i<100; i++) {
	         myArray[i] = i+1;
		  }
		  // displaying array with 1 to 100 numbers
		  System.out.println("The created Array is : \n"+Arrays.toString(myArray));
		  
		  //creating another array with even numbers
		  int[] evenArray = new int[50];
		  for (int i=0; i<50; i++) {
	         evenArray[i] =(i+1) * 2;
		  } 
	//displaying array with even mumbers
	      System.out.println("The even Array is : \n"+Arrays.toString(evenArray));
	      
	}
	}