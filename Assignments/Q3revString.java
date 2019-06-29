import java.util.Scanner;
// Q3 Reverse a string without using reverse method
public class revString {

	public static void reverseString(char[] ch, int length) {
		if (length > 0) {
			System.out.print(ch[length - 1]);
			length--;
			reverseString(ch, length);
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a word, youd like to reverse");

		String str = scan.nextLine();

		char[] rev = str.toCharArray();
		int length = rev.length;

		reverseString(rev, length);
	}
}
