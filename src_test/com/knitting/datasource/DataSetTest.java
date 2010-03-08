package com.knitting.datasource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataSetTest {
	
	@Test
	public void testInitialization() {
		DataSet set = new DataSet();
		assertEquals(0, set.size());
		DataSeries series = new DataSeries();
		set.addDataSeries(series);
		assertEquals(1, set.size());
		set.addDataSeries(series);
		assertEquals(1, set.size());
	}

}
