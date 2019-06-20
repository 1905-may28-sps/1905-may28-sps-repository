package homework;

import java.util.Date;
import java.util.Scanner;

/*
 * Q14. Write a program that demonstrates the switch case, implement
 * the following functionalities in the cases.
 * Case 1: Find the square root of a number using the math class method.
 * Case 2: Display today's date
 * Case 3: Split the following string and store it in a string array.
 * "I am learning Core Java"
 * 
 */

public class SwitchCase {

	
		public static void main(String[] args) {
			
			String option;
			String str;
			int num;
			
		System.out.println("Please Enter your option: \n"+
							"1. Find Square Root \n" +
							"2. Display Date \n" + 
							"3. Split the String \n");
		Scanner scan = new Scanner(System.in);
		option = scan.nextLine();
		

			switch(option) {
			case "1":
				System.out.println("Enter number: ");
				num = scan.nextInt();
				System.out.println("Square Root: ");
				System.out.println(Math.sqrt(num));
				break;
			
			case "2":
				System.out.println("Today's Date is: ");
				System.out.println(new Date());
				break;
				
			case "3":
				str = "I am learning Core Java";
				String[] strArr = str.split(" ");
				System.out.println("Words split");
				for (int i=0; i < strArr.length; i++) {
					System.out.println(strArr[i]);
				}
				
				break;
				
			default: System.out.println("Please enter valid option either 1 or 2 or 3");
				 
			}
	}

}

