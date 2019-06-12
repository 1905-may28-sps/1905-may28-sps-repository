package strings;

public class RemoveDuplicateChars {
	/*
	 * Design an algorithm and write code to remove the 
	 * duplicate characters in a string without using 
	 * any additional buffer 
	 * 
	 * NOTE: one or two additional vars are fine. An extra
	 * copy of the array is not 
	 * 
	 * FOLLOW UP: Write test cases for this method
	 */
	
	
	static String removeDups(String str) {
		//assuming str is at least 1 char
		String temp = "";
		temp += str.charAt(0);

		for(int i = 1; i < str.length(); i++){
			String t = "" + str.charAt(i);
			if(!temp.contains(t)){
				temp+=t;
			}
		}
		return temp;
	}

	
	// solution from the book below.. does no additional buffer mean no strings? bc?
	
	public static void removeDuplicates(char[] str) {
		if(str == null) return; 
		int len = str.length;
		if(len < 2) return;
		
		int tail = 1;
		
		for(int i = 1; i < len; ++i) {
			int j;
			for(j = 0; j < tail; ++j) {
				if(str[i]==str[j]) break;
			}
			if(j==tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail]=0;
		
	}
}
