package com.revature.hw;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q17Test {

	Q17 interest;

	@Before
	public void setUp() throws Exception {
		interest=new Q17();
	}

	@After
	public void tearDown() throws Exception {
		interest=null;
	}

	
	@Test
	public void test() {
		assertEquals(1815.48, interest.simpInte(123,123,12));
		
	}

}
