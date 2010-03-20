package com.knitting.datasource;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataSetTest {
	
	@Before
	public void before() {
		System.err.println("before test");
	}
	
	@After
	public void after() {
		System.err.println("after  test");
	}
	
	@Test
	public void testInitialization() {
		DataSet           set    = new DataSet   ();
		assertEquals(0,   set    . size());
		
		DataSeries        series = new DataSeries();
		
		set.addDataSeries(series);
		assertEquals(1, set.size());
		
		set.addDataSeries(series);
		assertEquals(1, set.size());
	}

}
