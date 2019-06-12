package strings;

public class OneEdit {
	
	/*
	 * Write a function to return if two words are exactly "one edit" away, where an edit is:
			Inserting one character anywhere in the word (including at the beginning and end)
			Removing one character
			Replacing exactly one character
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static boolean words(String a, String b) {
		if(Math.abs(a.length()-b.length())>1) {
			return false;
		}
		else if(Math.abs(a.length()-b.length())==1) {
			// do we need to add a char before or after
			
		}
			//loop through to see changed characters 
			
		
		
		return false;
	}

}
