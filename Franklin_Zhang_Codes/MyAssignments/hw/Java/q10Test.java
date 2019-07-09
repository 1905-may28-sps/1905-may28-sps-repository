package com.revature.hw;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class q10Test {
	
	q10 min;
	
	
	@Before
	public void setUp() throws Exception {
		min= new q10();
	
	}

	@After
	public void tearDown() throws Exception {
		min=null;
	}

	@Test
	public void test1() {
		assertEquals(20, min.Min(20,30));
		assertEquals(30, min.Min(200,30));
		assertEquals(-200, min.Min(-200,30));
		assertEquals(-30, min.Min(200,-30));
		assertEquals(-200, min.Min(-200,-30));
		assertEquals(12, min.Min(12,12));
		assertEquals(-0, min.Min(-0,0));
		assertEquals(0, min.Min(-0,0));
		}

}
