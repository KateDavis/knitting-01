package com.knitting.jamacoi;

public class Row_Pair 
{
	private Integer            row_matrix;
	private Integer            row_source;

	public  Row_Pair ( Integer row_matrix
	                 , Integer row_source
	                 )
	{
	        this.row_matrix  = row_matrix;
	        this.row_source  = row_source;
	}                

	public Integer get_row_matrix() { return row_matrix; }
	public Integer get_row_source() { return row_source; }

}
