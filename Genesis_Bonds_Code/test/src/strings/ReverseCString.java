package strings;

public class ReverseCString {

	/*
	 * Write code to reverse a C-style string
	 * (C-String means that "abcd" is represented 
	 * as five characters, including the null character)
	 */
	
	public static void main(String[] args) {
		System.out.println(reverse("abcd"));
	}
	
	static String reverse(String str) {
		StringBuilder cs = new StringBuilder(str);
		String t = null;
		cs.append(t);
		return cs.reverse().toString();
	}
	
	
}

//////////////////////// is this s thing in Java? trying to implement all questions in cracking the coding interview book