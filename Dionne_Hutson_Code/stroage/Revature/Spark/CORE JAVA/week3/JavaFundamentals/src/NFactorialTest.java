import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class NFactorialTest {

	@Test
	public final void testNfact() {
		String failureMessage = "fails";
		int expected = 362880;
		int actual = NFactorial.nfact(9);

		Assert.assertEquals(failureMessage, expected, actual);
	}

}
