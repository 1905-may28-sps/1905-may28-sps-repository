package com.revature.q10;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TernaryOpTest {
	
	TernaryOp ternaryOp;

	
	@Before
	public void setUp() throws Exception {
		ternaryOp = new TernaryOp();
	}

	@After
	public void tearDown() throws Exception {
		ternaryOp = null;
	}

	@Test
	public void test() {
		assertEquals(50, ternaryOp.TernaryOperate(678,50));
		assertEquals(-89, ternaryOp.TernaryOperate(-89,-10));
		assertEquals(-212, ternaryOp.TernaryOperate(-212,212));
	}

}
