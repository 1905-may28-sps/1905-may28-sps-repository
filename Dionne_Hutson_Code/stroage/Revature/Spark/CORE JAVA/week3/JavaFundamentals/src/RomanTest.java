

import org.junit.Assert;
import org.junit.Test;



public class RomanTest {

	@Test
	public final void testRoman() {
		String failureMessage = "fails";
		String expected = "DXXVII";
		String actual = Roman.roman(527);

		Assert.assertEquals(failureMessage, expected, actual);
		
		 // TODO
	}

}