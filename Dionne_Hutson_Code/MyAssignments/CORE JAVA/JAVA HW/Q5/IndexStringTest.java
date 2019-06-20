
import org.junit.Assert;
import org.junit.Test;

public class IndexStringTest {

	@Test
	public void testSubString() {
		String failureMessage = "fails";
		String expected = "bowli";
		String actual = IndexString.subString("bowling", 5);

		Assert.assertEquals(failureMessage, expected, actual);
	}

}
