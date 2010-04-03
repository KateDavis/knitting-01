package com.knitting.datasource;

import java.util.Date;
import java.util.List;

/**
 * The definition of a DataSeries where each 'point' contains one domain coordinate that is associated with a date,
 * and multiple range values that represent the y coordinates for that domain point.
 *
 */
public interface DataSeries {

	/**
	 * Sets the Y values for the date domain coordinate.  If the domain coordinate already exists, its values are
	 * replaced with these.
	 * 
	 * @param date that defines the domain coordinate
	 * @param values to add as range points for the domain
	 */
	void setValue(Date date, Double... values);

	/**
	 * Returns a list of range values for the given index.
	 * 
	 * @param index for the range values to retrieve
	 * @return a list of range values for the given index
	 */
	List<Double> getValues(int index);

	/**
	 * Returns the DataSet that this DataSeries is contained in.
	 * 
	 * @return the DataSet that this DataSeries is contained in
	 */
	DataSet getDataset();

}
