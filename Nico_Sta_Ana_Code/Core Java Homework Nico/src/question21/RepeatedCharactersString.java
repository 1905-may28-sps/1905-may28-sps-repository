package question21;

public class RepeatedCharactersString {

	
	public static String str = "hello";
	
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		int idx;
		for (int i = 0; i < str.length(); i++) {
		    char c = str.charAt(i);
		    idx = str.indexOf(c, i + 1);
		    if (idx == -1) {
		        sb.append(c);
		    }
		}

	}

}
