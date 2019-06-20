package homework;

//Q23: Write a method to turn a string into date.

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String Date : ");
		String strDate = scan.nextLine();
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
		System.out.println(strDate +"\t" + date1);
		
		
		//https://www.javatpoint.com/java-string-to-date

	}

}
