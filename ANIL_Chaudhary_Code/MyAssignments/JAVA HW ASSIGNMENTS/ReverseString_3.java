//Reverse a string without using a temporary variable.

package javaAssignments;
import java.util.Scanner;

public class ReverseString_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter a string");
			
		 String reverseMe = sc.nextLine(); 
		 sc.close();
		for (int i = 0; i < reverseMe.length(); i++) {
		    reverseMe = reverseMe.substring(1, reverseMe.length() - i)
		        + reverseMe.substring(0, 1)
		        + reverseMe.substring(reverseMe.length() - i, reverseMe.length());
		 }
		 System.out.println("The reverse string is "
		 		+ "  " +reverseMe);
}
}
