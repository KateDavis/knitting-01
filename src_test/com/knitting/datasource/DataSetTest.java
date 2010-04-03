package com.knitting.datasource;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class DataSetTest {
	enum TestSeriesKey implements DataSeriesKey {TWO_LINE};
	

	@Test
	public void testTwoLineSeries() throws Exception {
		DataSet set = new DataSet();
		assertEquals(0, set.size());
		assertEquals(0, set.domainSize());

		DataSeries series = set.createDataSeries(TestSeriesKey.TWO_LINE);
		assertEquals(1, set.size());
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = df.parse("04/02/2010");
		Date date2 = df.parse("04/03/2010");
		Date date3 = df.parse("04/04/2010");
		series.setValue(date3, 3.0, 3.5);
		series.setValue(date1, 1.0, 1.5);
		series.setValue(date2, 2.0, 2.5);
		series.setValue(date2, 2.0, 2.5);
		
		assertEquals(3, set.domainSize());
		
		assertEquals(series, set.getSeries(TestSeriesKey.TWO_LINE));
		
		List<Date> dates = series.getDataset().getDomainDates();
		assertEquals(3, dates.size());
		assertEquals(date1, dates.get(0));
		assertEquals(date2, dates.get(1));
		assertEquals(date3, dates.get(2));

		List<Double> values = series.getValues(0);
		assertEquals(3, values.size());
		assertEquals(1.0, values.get(0), 0);
		assertEquals(2.0, values.get(1), 0);
		assertEquals(3.0, values.get(2), 0);
		
		values = series.getValues(1);
		assertEquals(3, values.size());
		assertEquals(1.5, values.get(0), 0);
		assertEquals(2.5, values.get(1), 0);
		assertEquals(3.5, values.get(2), 0);
		
		
	}

	@Test
	public void testSingleSeries() {

	}

}
