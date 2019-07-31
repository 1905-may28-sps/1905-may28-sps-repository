package JavaAssignmentDemo.src.com.rev.p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RomanNumeralsTest {
	
	RomanNumerals roman;


	@Before
	public void setUp() throws Exception {
		roman = new RomanNumerals();
	}

	@After
	public void tearDown() throws Exception {
		roman = null;
	}

	@Test
	public void testLargeNums() {
		// 3549 --> MMMDXLIX
		assertEquals("Converted 3549", "MMMDXLIX", roman.convert(3549));
		assertEquals("Converted 3500", "MMMD", roman.convert(3500));
		assertEquals("Convered 4213", "MMMMCCXIII", roman.convert(4213));
	}

}
