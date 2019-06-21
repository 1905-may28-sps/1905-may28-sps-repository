package com.revature.q17;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleInterestTest {
	
	SimpleInterest simpleinterest;

	@Before
	public void setUp() throws Exception {
		simpleinterest = new SimpleInterest();
	}

	@After
	public void tearDown() throws Exception {
		simpleinterest = null;
	}

	@Test
	public void test() {
		assertEquals(6033, simpleinterest.interestSimple(10_056, 0.06, 10));
		assertEquals(0, simpleinterest.interestSimple(10, 0.012, 2));
		assertEquals(7800000, simpleinterest.interestSimple(20_000_000, 0.078, 5));
	}

}
