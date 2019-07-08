//Write a method to turn a string into a date

package javaAssignments;

import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Scanner; 

public class StringToDate_27{
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a date in string MM/dd/yyyy format   :");
		String sDate1 = sc.nextLine(); 
		sc.close();
		 
		    Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);  
		    System.out.println("The string  "  + sDate1+"  in date format is :\t"+date1);  
		}  
		}  