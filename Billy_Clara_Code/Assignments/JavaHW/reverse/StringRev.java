package com.billy.reverse;


public class StringRev {
	
	public static void main(String[] args) {
	      String myString, 
	      end = "";
	      myString = "Trying Out Reverse String";
	 
	      int length = myString.length();
	      
	      //The loop begins from the end tail of the string
	      //length - 1 will begin at the last character while the
	      //length of the string is greater than 0
	 
	      for ( int i = length - 1 ; i >= 0 ; i-- )
	         end = end + myString.charAt(i);
	 
	      System.out.println (end);
	   }
	}


