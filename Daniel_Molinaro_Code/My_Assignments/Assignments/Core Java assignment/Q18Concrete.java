package corejava.revature.q18;

public class Q18Concrete extends Q18Abstract {

	boolean checkUpper(String arg) {

		int count = 0;
		for (int i = 0; i < arg.length(); i++) {
			if (Character.isUpperCase(arg.charAt(i))) {
				count++;
			}
		}
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	String convertToUpper(String arg) {

		char[] charAr = arg.toCharArray();
		for (int i = 0; i < arg.length(); i++) {
			if (Character.isLowerCase(arg.charAt(i))) {
				charAr[i] = Character.toUpperCase(arg.charAt(i));
			}
		}
		String newS = new String(charAr);
		return newS;

	}

	void convertToInt(String arg) {
		int num = (Integer.parseInt(arg)) + 10;
		System.out.println(num);

	}

	public static void main(String[] args) {
		Q18Concrete a = new Q18Concrete();
		Q18Concrete b = new Q18Concrete();
		Q18Concrete c = new Q18Concrete();

		c.convertToInt("98");

		System.out.println(a.convertToUpper("Hello, World"));
		System.out.println(b.checkUpper("hello, world"));

	}

}
