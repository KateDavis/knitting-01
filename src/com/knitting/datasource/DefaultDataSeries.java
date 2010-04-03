package com.knitting.datasource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultDataSeries implements DataSeries {

	private final DataSet dataSet;
	private Map<Long, Double[]> map = new HashMap<Long, Double[]>();

	DefaultDataSeries(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	public DataSet getDataset() {
		return dataSet;
	}

	public List<Double> getValues(int index) {
		List<Date> dates = dataSet.getDomainDates();
		List<Double> values = new ArrayList<Double>();
		for (Date date : dates) {
			Double[] ary = map.get(date.getTime());
			if (index < ary.length) {
				values.add(ary[index]);
			} else {
				values.add(null);
			}
		}
		return values;
	}

	public void setValue(Date date, Double... value) {
		dataSet.addDate(date);
		map.put(date.getTime(), value);
	}

}
