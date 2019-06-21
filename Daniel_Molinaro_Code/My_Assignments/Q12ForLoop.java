package corejava.revature.q12;

public class Q12ForLoop {

	public static int[] intArray(int num) {
		int iArr[] = new int[num];
		for (int i = 0; i < num; i++) {
			if ((i + 1) % 2 == 0) {
				iArr[i] = i + 1;
			}
		}
		return iArr;
	}

	public static void main(String[] args) {
		int[] arr = intArray(100);
		for (int i : arr) {
			if (i != 0) {
				System.out.println(i);
			}
		}

	}

}
