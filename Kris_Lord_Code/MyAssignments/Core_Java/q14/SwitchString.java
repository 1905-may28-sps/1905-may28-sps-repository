package com.revature.q14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SwitchString {
	
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	static int num = 56;
	static double doubleNum = num;//casting because sqrt only works with doubles
	public static String str = "I am learning Core Java";
	
	public static void switchString(int i) {

		switch(i) {
		case 1:
			System.out.println(Math.sqrt(doubleNum));
			break;
		case 2:
			LocalDate localDate = LocalDate.now();//showing local date only without time
			System.out.println(dtf.format(localDate));
			break;
		case 3:
			String[] ofString = str.split(" ", -2);//use negative regex to obtain all possible string words
			for (String aStr : ofString) 
			System.out.println(aStr);

		}
	}

	public static void main(String[] args) {
		switchString(1);
		switchString(2);
		switchString(3);

	}

}
