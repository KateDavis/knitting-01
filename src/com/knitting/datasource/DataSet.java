package com.knitting.datasource;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A container class to store a collection of DataSeries having a common domain between them.  This class uses
 * basic collection utilities, and is not thread safe.
 *
 */
public class DataSet {
	private Map<DataSeriesKey, DataSeries> seriesSet = new HashMap<DataSeriesKey, DataSeries>();
	private List<Date> domainDate = new LinkedList<Date>();
	
	/**
	 * Return the number of DataSeries contained in this instance.
	 * 
	 * @return the number of DataSeries contained in this instance
	 */
	public int size() {
		return seriesSet.size();
	}

	/**
	 * Return the domain length for this instance.
	 * 
	 * @return the domain length for this instance.
	 */
	public int domainSize() {
		return domainDate.size();
	}

	/**
	 * Creates a new DataSeries and adds it to this instance by the associated key.  Returns the new DataSeries.
	 * If a DataSeries already exists with key, it is replaced with this new series.
	 * 
	 * @param key to associate the new DataSeries with
	 * @return the new DataSeries
	 */
	public DataSeries createDataSeries(DataSeriesKey key) {
		DataSeries series = new DefaultDataSeries(this);
		seriesSet.put(key, series);
		return series;
	}

	/**
	 * Returns the DataSeries associated with key.  Returns null if no series exists for key.
	 * 
	 * @param key of the requested DataSeries
	 * @return the DataSeries associated with key
	 */
	public DataSeries getSeries(DataSeriesKey key) {
		return seriesSet.get(key);
	}

	public List<Date> getDomainDates() {
		return Collections.unmodifiableList(domainDate);
	}

	/**
	 * INTERNAL method called by contained DataSeries to add a date to the domain.  If the date already exists, no
	 * action is taken. 
	 * 
	 * @param date to add
	 */
	void addDate(Date date) {
		if (! domainDate.contains(date)) {
			domainDate.add(date);
			Collections.sort(domainDate);
		}
	}
}
 