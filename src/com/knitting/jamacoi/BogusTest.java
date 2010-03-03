package com.knitting.jamacoi;

import static org.junit.Assert.*;

import org.junit.Test;

public class BogusTest {
	
	@Test
	public void testSomething() {
		assertTrue(1 == 1);
		
		double expected = 7.0;
		double calculated = 7.00001;
		
		assertEquals(expected, calculated, .01);
		assertEquals(expected, calculated, .000001);
	}


}
