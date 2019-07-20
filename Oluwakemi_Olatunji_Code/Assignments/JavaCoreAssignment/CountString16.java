package Assignements;
import java.util.*;

public class CountString16 {
	public static void main(String[] args) {
		Scanner stringInput = new Scanner (System.in);
		System.out.println("Please, enter a string");
		
		String s = stringInput.nextLine();
		String total = "";
		
		for (int i = 0; i < s.length(); i++) {
            char thisChar = s.charAt(i);

            if (thisChar >= 'a' && thisChar <= 'z') {
                total += thisChar;
            }
        }

        System.out.println("Total amount of characters including spaces & numbers: " + s.length() + " - " + s);
        System.out.println("Number of letters: " + total.length() + " - "+ total);
    }
}
