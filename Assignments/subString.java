
public class subString {
//Q5 substring
		public static void main(String[] args) {
			SubstringIdx("Lets make this string", 5);
//			SubstringIdx("Lets make this string", 12);
//			SubstringIdx("Lets make this string", 8);
//			SubstringIdx("Lets make this string", 11);

			

		}

		public static void SubstringIdx(String str, int end) {

			char[] str2 = str.toCharArray();

			for (int i = 0; i < end + 1; i++) {
				System.out.print(str2[i]);
				

			}

		}

	
}

