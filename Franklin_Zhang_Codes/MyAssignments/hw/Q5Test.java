package com.revature.hw;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q5Test {


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("he", Q5.subString("hello",2));
		assertEquals("hel", Q5.subString("hello",3));
		assertEquals("", Q5.subString("hello",0));
		//not sure what to set expected value if the expected is to rerun
		assertNotSame ("hello", Q5.subString("hello",6));
		assertNotSame ("hello ", Q5.subString("hello",6));
	}

}
