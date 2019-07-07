

import org.junit.Assert;
import org.junit.Test;

public class decHexTest {

	@Test
	public final void testDecHexMeth() {
		String failureMessage = "fails";
		String expected = "27a6";
		String actual = decHex.decHexMeth(10150);

		Assert.assertEquals(failureMessage, expected, actual);
	}

}
