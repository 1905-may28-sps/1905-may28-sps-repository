

import org.junit.Assert;
import org.junit.Test;

public class EvenTest {

	@Test
	public void testEoo() {
		String failureMessage = "fails";
		boolean expected = true;
		boolean actual = Even.eoo(522);

		Assert.assertEquals(failureMessage, expected, actual);
		 expected = false;
		actual = Even.eoo(521);

		Assert.assertEquals(failureMessage, expected, actual);
	}

}