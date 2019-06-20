

import org.junit.Assert;
import org.junit.Test;

public class InterestTest {

	@Test
	public void testInterest() {
		String failureMessage = "fails";
		int expected = 672;
		int actual = (int) Interest.interest(7.9,2.3,37);

		Assert.assertEquals(failureMessage, expected, actual);
	}

}
