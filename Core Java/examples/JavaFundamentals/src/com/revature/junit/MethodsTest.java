package com.revature.junit;

/*
 * static imports allow us to reference the static 
 * fields of a class without the class name
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MethodsTest {
	
	Methods m;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("set up before class method");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tear down after class method");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("set up before test");
		m = new Methods();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tear down after test so that if our test affects"
				+ "our object, that test doesn't affect the outcome of the "
				+ "next test ");
		m = null;
	}

	@Test
	public void testAdd() {
		int actualVal = m.add(1, 2, 3, 4);
		int expectedVal = 10;
		assertEquals(actualVal, expectedVal);
		assertEquals(20, m.add(10, 5, 5));
		assertNotEquals(0, m.add(-1, 5, 90));
	}
	
	@Test
	public void testAdd2() {
		assertNotEquals(-10, m.add(10));
	}

}
