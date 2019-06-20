package com.revature.introduction;

public class ControlStatements {
public static void main(String[] args) {
	//forLoop and if else
	for (int i =0; i<20;i++) {
		
		if(i%15==0) {
			System.out.println("FizzBuzz");
		}
		else if(i%5==0) {
			System.out.println("Fizz");
		}
		else if(i%3==0) {
			System.out.println("Buzz");
		}
		else System.out.println(i);
		
		}
		int[] array= {1,2,3,4,5};
		//ForEach/enhancedLoop
		for(int j : array) {
			System.out.println(j);
		}
		//while
		int k=1;
		while(k<5) {
			System.out.print(k);
			++k;
		}
		int x=20;
		//dowhile
		do {
			System.out.println(x);
			x=x-4;
		} while(x>0);
		
		
	//switch
		int num=2;
		switch(num) {
		case 1: System.out.println("1");
		case 2: System.out.println("2");
		case 3: System.out.println("3");
		case 4: System.out.println("unless num is 4, there should be 1 2 and 3");break;
		case 5: System.out.println("this shouldn't show unless num was 5, then only this should show");
		
		}
	}
}
