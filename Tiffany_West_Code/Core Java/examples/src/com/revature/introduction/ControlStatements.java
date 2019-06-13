package com.revature.introduction;
/*
 * When we need to execute a set of statements based 
 * on a condition then we need to use control flow 
 * statements. For example, if a number is greater than 
 * zero then we want to print “Positive Number” but if 
 * it is less than zero then we want to print “Negative 
 * Number”. In this case we have two print statements in 
 * the program, but only one print statement executes at 
 * a time based on the input value. We will see how to 
 * write such type of conditions in the java program 
 * using control statements.
 * 
 * Assignment: With a partner, 
 * go through the control statements tab in this site
 * https://beginnersbook.com/2017/08/if-else-statement-in-java/ 
 * and code one example of each of the following:
 * if statement, nested if statement, if-else statement, 
 * if-else if- else statement, for loop, for each loop,
 * while loop, do while loop, and switch statement
 * 
 */
public class ControlStatements {

	String name;
	//Constructor
	 ControlStatements() {
		this.name = "rev.com";
	}

	public static void main(String[] args) {
																		//add an enhanced for loop
		//IfElse();
		//Switch();
		//forLoop();
		//forLoopArray();
		//WhileLoop();
		//DoWhileLoop();
		
		ControlStatements obj = new ControlStatements();
		System.out.println(obj.name);
	
		
	}

public static void IfElse() {
	/*
	 * if statements 
	 */
	
	int num = 60;
	if(num < 100) {
		/*
		 * will only execute, if the above condtion is true
		 */
		System.out.println("number is less than 100");
	}
	System.out.println("***********");
	//nested if statements
	if (num <100) {
		System.out.println("number is less than 100");
		if (num > 50) {
			System.out.println("number is greater than 50");
		}
	}
	System.out.println("***********");
	//if else statement
	 int num2 = 120;
	 if (num2 < 50) {
		 System.out.println(" number 2 is less than 50");
	 }
	 else {
		 System.out.println("number 2 is greater than or equal 50");
	 }
		System.out.println("***********");
// if - else - if
		
		int num3  = 1234;
		if (num3 <100 && num3 >= 1) {
			System.out.println("It's a two digit number");
			
		} else  if(num3 <1000 &&  num3>=100){
			System.out.println("its a three digit number");

		}else if (num3 <10000 && num3 >=1000)
		{
			System.out.println("Its a four digit number");
		}	
		else if(num3 <100000 && num3>=10000) {
			  System.out.println("Its a five digit number");			
			}
			else {
			  System.out.println("number is not between 1 & 99999");			
			}
}
	
public  static char Switch() {
	
	/*
	 * BREAK vs CONTINUE
	 * break will exit the loop or block of code
	 * continue will move on to the next iteration of the loop 
	 */

	
	char food = 'b';
	switch (food) {
	case 'a':
		System.out.println("frech fries");
		break;
	case 'b':
		System.out.println("empanadas");
		break;
	case 'c':
		System.out.println("pizza");
		break;
	case 'd':
		System.out.println("burgers");
		break;
	}
	return food;
	
	
	
} 

public static void forLoop() {
	for(int i=32; i>1; i--) {
		System.out.println("The value of i is:" +i);
	}
	
}

public static void forLoopArray() {


	int arr[]= {2,24,4,28,5,20};
	//int i=0; i<arr.length; i++
	for(int num : arr) {
		System.out.println(num);
	}
}//
 
public static void WhileLoop() {

	
	
	int i=10;
    while(i>1){
         System.out.println(i);
         i--;
    }

	
		}
	
public static void DoWhileLoop() {
	int arr[]={2,11,45,9};
    //i starts with 0 as array index starts with 0
    int i=0;
    do{
         System.out.println(arr[i]);
         i++;
    }while(i<4);
}
//

	
	
	

}




