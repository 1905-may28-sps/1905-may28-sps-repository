package DateString;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateStringTest {

	
	
	dateString date;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		date = new dateString();
	}

	@After
	public void tearDown() throws Exception {
		date = null;
	}

	@Test
	public void testStrings() {
		
		//assertEquals("Mon May 20 00:00:00 EDT 2019",date.stringToDate("20-May-2019"));
	}

	

}
