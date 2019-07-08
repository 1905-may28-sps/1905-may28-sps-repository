//switch statements

package javaAssignments;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.Math;

public class SwitchCase_14 {
public static void main(String args[]){
Scanner ch = new Scanner(System.in);
System.out.print("Enter a choice"
		+ "\n 1 for square root"
		+ "\n 2 for todays date"
		+ "\n 3 for string to Array\n");
		int choice =ch.nextInt();
		   

	      switch(choice)
	      {
	 case 1:
			 //Find the square root of a number using the Math class method.
		 Scanner in = new Scanner(System.in);
			System.out.println("Enter a number  : ");
			double num = in.nextDouble();
			ch.close();
			in.close();
					
		 	System.out.println("The square root is : " +Math.sqrt(num)); 
		  		break;
	 case 2:
			//Display today’s date. 
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDate localDate = LocalDate.now();
				System.out.println("Todays date is : " +dtf.format(localDate)); //2016/11/16
				break;
		 case 3:
			 //Split the string and store it in a sting array.	
							  
				    String testString = "I am learning Core Java";
				    System.out.println (java.util.Arrays.toString(testString.split("-")));
					break;	 
	   }
}
}
