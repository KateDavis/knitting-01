package com.knitting.datasource;

import java.util.HashSet;
import java.util.Set;

public class DataSet {
	private Set<DataSeries> seriesSet = new HashSet<DataSeries>();
	
	public int size() {
		return seriesSet.size();
	}

	public void addDataSeries(DataSeries dataSeries) {
		seriesSet.add(dataSeries);
	}
}
 