
/*
 * 	Factorial of a number n can be defined as product of all positive numbers less than or equal to n.
 *  It the multiplying sequence of numbers in a descending order till 1. It is defined by the symbol of exclamation (!).

		1!=1
		
		2!=2×1
		
		3!=3×2×1
		
		4!=4×3×2×1
		...
		n! = n×(n−1)×(n−2)...×2×1
 * 
 */

package com.revature.nfacorial;
//Q4 compute Nfactorial
class Nfactorial{  
	 public static void main(String args[]){  
	  int i,fact=1;  
	  int number=54;    
	  for(i=1;i<=number;i++){    
	      fact=fact*i;    
	  }    
	  System.out.println("Factorial of "+number+" is: "+fact);    
	 }  
	}  
