package com.revature.hw;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IfEvenTest {
	IfEven x;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		x=new IfEven();
	}

	@After
	public void tearDown() throws Exception {
		x=null;
	}

	@Test
	public void test() {
		//its ok for x.ifEven to have yellow underline...
		assertEquals("Test to see if 3500","even",x.ifEven(3500));
		assertEquals("Test to see if 35","odd",x.ifEven(35));
		assertEquals("Test to see if 0","even",x.ifEven(0));
		assertEquals("Test to see if 3500","even",x.ifEven(-3500));
	}

}
