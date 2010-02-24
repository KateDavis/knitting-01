package com.knitting.jamacoi;

public class Row_Map_Info 
{
	private Row_Pair                              row_first;
	private Row_Pair                              row_last;

	public  Row_Map_Info ( Row_Pair               row_first
	                     , Row_Pair               row_last
	                     )
	{
	        this.row_first     =                  row_first;
	        this.row_last      =                  row_last ;
	}
	public Row_Pair get_row_pair_first() { return row_first; }
	public Row_Pair get_row_pair_last () { return row_last ; }

}
