package question14;

import java.util.Scanner;
import java.lang.Math;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class caseSwitch {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void squareRoot() {
		System.out.println("Enter a number please");
		String a = scan.nextLine();
		
		Double result = Double.parseDouble(a);
		
		System.out.println(Math.sqrt(result));
		
		
	}
	
	public static void displayDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
	}
	
	public static void splitString() {
		String stringToSplit = "I am learning Core Java";
        String[] tempArray;
        
        String delimiter = " ";
        tempArray = stringToSplit.split(delimiter);
        for (int i = 0; i < tempArray.length; i++)
            System.out.println(tempArray[i]);
        
	}

	public static void main(String[] args) {
		home();
		

	}
	
	static void home() {
		System.out.println("What would you like to do today? \n"
				+ "You can either \n"
				+ "1: Find the square root of a number \n"
				+ "2. Display today's Date \n"
				+ "3. Split the string 'I am learning Core Java' and store it into an Array \n");
		String option = scan.nextLine();
		switch(option) {
		case "1": 
			squareRoot();
			break;
		case "2": 
			displayDate();
//			System.out.println("DISPLAY DATE");
			break;
		case "3": 
			splitString();
//			System.out.println("SPLIT STRING");
			break;
		//end of switch
		}
		//End of Home
		
		
	}
//end of class
}
