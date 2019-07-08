//display the number of characters for a string input

package javaAssignments;

import java.util.Scanner;

public class CountString_16 {
	// main method
		    public static void main(String[] args) {    
		    	//taking input string from user using scanner
		    	
		    	Scanner sc = new Scanner(System.in);
				System.out.println("Enter a string");
				String input = sc.nextLine(); 
				sc.close();
		    	 int count = 0;    
		            
		        //Counts each character except space    
		        for(int i = 0; i < input.length(); i++) {    
		            if(input.charAt(i) != ' ')    
		                count++;    
		        }    
		            
		        //Displays the total number of characters present in the given string    
		        System.out.println("Total number of characters in a string: " + count);    
		    }    
		   
	}
