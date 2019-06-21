package q14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class SwitchCase {

	private static int num;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {

			System.out.println("1. Find the square root of a number using the Math class methhod");
			System.out.println("2. Display today's date.");
			System.out.println("3. Split 'I am learning Core Java' in a string array.");

			num = sc.nextInt();
			Switchchoice();

		}
	}

	private static void Switchchoice() {

		int choice = SwitchCase.num;
		switch (choice) {
		case 1:
			SquareRoot();
			break;
		case 2:
			ToDate();
			break;
		case 3:
			SplitJava();
			break;
		}		
	}
	
	
	private static void SplitJava() {
		String LearnJava = "I am learning Core Java";
		try {
		    String[] arr = LearnJava.split(" ");
		    for (String i : arr) {
		    System.out.println(i);}
		} catch (PatternSyntaxException ex) {
		}
		
	}

	private static void SquareRoot() {
		
		System.out.println("Please enter number..");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(Math.sqrt(num));
		
	}

	private static void ToDate() {
		LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
	}
	
	
}