package com.revature.minTest;
	import static org.junit.Assert.*;

	import org.junit.After;
	import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
public class MinTest {
	

		
		static TernaryMinimum m;

		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			m=new TernaryMinimum();
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			m=null;
		}

		@Before
		public void setUp() throws Exception {
		}

		@After
		public void tearDown() throws Exception {
		}

		@Test
		public void test() {
			String failureMessage = "fails";
			int expected = 4;
			int actual = (int) TernaryMinimum.min(4.0,5.7);

			Assert.assertEquals(failureMessage, expected, actual);
		}

	}

