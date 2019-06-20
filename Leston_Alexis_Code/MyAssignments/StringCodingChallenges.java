package com.revature.Strings;
//This Method also works!!!!
/*public class StringCodingChallenges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.out.println(isPalindrome());
	}
	
	
	
	public static boolean isPalindrome(String str) {
		
		String wrd1= "racecar";
		String wrd2 = "";
		boolean out = false;
		for(int i = str.length() - 1; i >= 0; i--)
        {
            wrd2 = wrd2 + str.charAt(i);
        }
		
		if(wrd1.equalsIgnoreCase(wrd2));{
		 out = true;
		}
		return out;
	}
	

}*/
public class StringCodingChallenges {
	
	public static void main(String[] args) {
		System.out.println(testPalindrome());
	}
	
	public static boolean testPalindrome() {
		boolean test1 = isPalindrome("rAcEcAr");
		boolean test2 = !isPalindrome("testing not");
		boolean test3 = isPalindrome("  tt  ");
		boolean test4 = isPalindrome("!12321!");
		return test1 && test2 && test3 && test4;
	}
	
	/*
	 * Write a method that takes in a string and 
	 * returns a boolean value true if it is a 
	 * palindrome and a boolean value false if it is not
	 */
	public static boolean isPalindrome(String str) {
		boolean out = true;
		for(int i = 0; i < str.length()/2; i++) {
			String letter = "" + str.charAt(i);
			if(!letter.equalsIgnoreCase("" + str.charAt(str.length()-1-i))) {
				out = false;
			}
		}
		return out;
	}

}
