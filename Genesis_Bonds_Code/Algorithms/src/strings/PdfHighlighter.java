package strings;

import java.util.HashSet;
import java.util.Set;

public class PdfHighlighter {
	
	public static void main(String[] args) {
		
		int[] heights = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
		String word = "zaba";
		System.out.println(findArea(heights, word));
	}
	
	static int findArea(int[] heights, String word) {
		char[] chars = word.toCharArray();
		int max = 0;
		for(int i = 0; i < chars.length; i++) {
			int index = (int) chars[i] - 97;
			int temp = heights[index];
			if (temp> max) max = temp;
		}
		
		return max*word.length();
	}

}
