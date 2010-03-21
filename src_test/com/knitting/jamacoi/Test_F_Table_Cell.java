package com.knitting.jamacoi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_F_Table_Cell {
	F_Table_Cell  cell ;
	
	final int     row     = 1;
	final int     col     = 2;
	final double  f_value = 3.14;
	
	@Before
	public void setUp() {
	
	  cell = new F_Table_Cell    ( row
                                 , col  
                                 , f_value
                                 );	
	}

	@After
	public void tearDown() {
      cell = null;  
	}

	@Test
	public void  test_Get_Row()  {
	       final Integer Row     = row;
		   assertEquals( Row     , cell.get_Row() );
	}
	@Test
	public void  test_Get_Col()  {
		   final Integer Col     = col;
		   assertEquals( Col     , cell.get_Col() );
	}
	@Test
	public void  test_Get_F()    {
		   final Double  F_value = f_value;
		   assertEquals( F_value , cell.get_F()   );
	}
}
