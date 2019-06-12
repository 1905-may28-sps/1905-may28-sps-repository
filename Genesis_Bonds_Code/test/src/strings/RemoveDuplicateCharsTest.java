package strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveDuplicateCharsTest {

	RemoveDuplicateChars obj;
	
	@Test
	public void test() {
		
		assertEquals("abc", RemoveDuplicateChars.removeDups("abc"));
		assertEquals("abc", RemoveDuplicateChars.removeDups("abcccc"));
		assertEquals("abc", RemoveDuplicateChars.removeDups("aabbbbccccc"));
		assertEquals(" ", RemoveDuplicateChars.removeDups("     "));
		assertEquals(" abc", RemoveDuplicateChars.removeDups(" aa b c "));
		
		/*
		 * Book's suggested test cases 
		 * String doesnt contain duplicates eg "abcd"
		 * String contains all duplicates eg "aaa"
		 * Null String 
		 * String with all continuous duplicates eg "aaabbb"
		 * String with non-continuous duplicate eg "ababa"
		 */
	}

}
