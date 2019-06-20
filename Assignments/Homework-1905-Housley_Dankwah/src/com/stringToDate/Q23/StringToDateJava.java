package com.stringToDate.Q23;

/*Q. 23. Write a method to turn a string into a date */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringToDateJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// Enter date in dd-MMM-yyyy format
		stringToDate("7-Jun-2013");
	}
	
	public static void stringToDate(String str) {
		
	     SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

	        try {

	            Date date = formatter.parse(str);
	            System.out.println(date);
	            System.out.println(formatter.format(date));

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	    }

}
