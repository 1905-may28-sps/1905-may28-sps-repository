import java.util.Scanner;
//Q21 find and remove duplicate Strings
public class remDuplicate {
		public static void main(String[] args) {

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("enter a string with some repeated characters");
			String str = sc.nextLine();
			System.out.println(remove(str));
		}

	public static String remove(String str) {
        	String theString="";
        	for(int i=0; i<str.length(); i++) {
        		if(i==0) {
        			theString = ""+str.charAt(i);
        		}else {
        			if(str.charAt(i-1) != str.charAt(i)) {
        				theString = theString + str.charAt(i);
	       			}
	       		}
	       	}
	   			return theString;
	}
}

