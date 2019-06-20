package homework;

//Q10. Find the minimum of two numbers using ternary operators. 

import java.util.Scanner;

public class TernaryOperator {

	public static void main(String[] args) {
		
		System.out.println("Minimum of Two numbers using Ternary Operators");
		System.out.println("Enter Number 1 : ");
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter Number 2 : ");
		Scanner scan2 = new Scanner(System.in);
		
		int min = 0;
		int num1 = scan1.nextInt();
		int num2 = scan2.nextInt();
		
		//Using if-elseif statement
		/*if (num1==num2) {
			System.out.println("Both are equal");
		}
		else if (num1<num2) {
			System.out.println("The minimum number is : "+ num1);
			}
		else 
			System.out.println("The minimum number is : "+ num2); */
		
		//Using Ternary Operator:
		
		min = (num1 < num2) ? num1: num2;
		System.out.println("The minimum number is: " + min);
		}
	}


