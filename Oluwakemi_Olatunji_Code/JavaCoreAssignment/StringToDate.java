package Assignements;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class StringToDate {
	public static void main(String[] args) {

		SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter a date using this format MM-dd-yyyy");
		System.out.print("Enter date: ");
		String str = sc.nextLine();

		try {
			java.util.Date date = formatDate.parse(str);

			formatDate = new SimpleDateFormat("EEE, MMM d, yyyy"); //Date and Time Pattern
			System.out.println("Date: " + formatDate.format(date));
		} catch (ParseException e) {
			System.out.println("Parse Exception");
		}
	}
}
