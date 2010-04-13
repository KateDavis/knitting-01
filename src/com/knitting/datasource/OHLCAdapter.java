package com.knitting.datasource;

import java.util.Date;

public class OHLCAdapter {

	private final DataSet ds;

	public OHLCAdapter(DataSet ds) {
		this.ds = ds;
	}

	public void addBar(Date date, double open, double hi,
			double lo, double close, long volume) 
	{
		getSeries(OHLCSeriesKey.OPEN).setValue(date, open);
		getSeries(OHLCSeriesKey.HIGH).setValue(date, hi);
		getSeries(OHLCSeriesKey.LOW).setValue(date, lo);
		getSeries(OHLCSeriesKey.CLOSE).setValue(date, close);
		getSeries(OHLCSeriesKey.VOLUME).setValue(date, (double)volume);
	}

	private DataSeries getSeries(DataSeriesKey key) {
		if (!ds.containsSeries(key)) {
			ds.createDataSeries(key);
		}
		return ds.getSeries(key);
	}

}
