package arrays;

public class ReverseString {

	public static void main(String[] args) {
		char[] letters = {'a', 'b', 'c', 'd'};
		reverse(letters);
		System.out.println(letters);
	}

	public static void reverse(char[] arrayOfChars) {

		char temp = ' ';
		for(int i = 0; i < (arrayOfChars.length/2); i++){
			temp = arrayOfChars[i];
			arrayOfChars[i] = arrayOfChars[arrayOfChars.length-i-1];
			arrayOfChars[arrayOfChars.length-i-1] = temp;
		}
	}
}
