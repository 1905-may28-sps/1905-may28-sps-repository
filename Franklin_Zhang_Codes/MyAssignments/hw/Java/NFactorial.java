package com.revature.hw;

import java.util.Scanner;

public class NFactorial {
	//use to get user imput
	private static Integer Numb() {
		Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Please enter value u would like to calculate factorial for: ");
	    String stringNum = myObj1.nextLine();  // Read user input
	    Integer num = Integer.valueOf(stringNum);
	    return num;
	}
	//calculate  the n factorial
	public static void main(String[] args) {
		int num=Numb();
		int ans =1;
		//hard coding 0 and 1 since we know they equal one
		if (num==0||num==1) {
			System.out.println("1");
		}
		else {
			//iterate down from number
			for(int i = num; i>1; i--) {
				ans=ans*i;
			}
		System.out.println(ans);	
		}
	}

}
