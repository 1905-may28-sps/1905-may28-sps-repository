package com.revature.introduction;

public class FunctiondandReturns {
	
	
	public static void main(String[] args) {
		System.out.println("program is starting");
		int numA = 20;
		int numB = 10;
		printName();
		addNumbers(numA, numB);
		multiplyNumbers(numA, numB);
		//System.out.println("addnumbers doesn't have a return type so :" + addNumbers(numA, numB));
		System.out.println("multiplynumbers has a return type so it can be returned and not voided: " + multiplyNumbers(numA, numB));
		
	}
	
	static void printName() {
			System.out.println("Tiffy");
	}
	 
	static void addNumbers(int numA , int numB) {
		  int sum = numA + numB;
		  System.out.println("the sum of " + numA + " and "+ numB + " is " + sum);
		  multiplyNumbers(sum,sum);
		
	}
	
	   static int multiplyNumbers(int numA,int numB) {
		   int product = numA * numB;
		   System.out.println("the product is : "+ product);
		   
		   //addNumbers(product,product);
		   int sum3 = product + product;
		   	System.out.println("sum2 is " +sum3);
		   return product;
		
	}


}
