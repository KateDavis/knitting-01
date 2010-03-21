package com.knitting.jamacoi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_F_Table_Cell {
	F_Table_Cell  cell ;
	
	final int     row     = 1;
	final int     col     = 2;
	final double  F_Value = 3.14;
	
	@Before
	public void setUp() {
	
	  cell = new F_Table_Cell   ( row
                                , col  
                                , F_Value
                                );	
	}

	@After
	public void tearDown() {
      cell = null;  
	}

	@Test
	public void  test_Get_Row()    {
	       final Integer I_row     = row;
		   assertEquals( I_row     , cell.get_Row() );
	}
	@Test
	public void  test_Get_Col()    {
		   final Integer I_col     = col;
		   assertEquals( I_col     , cell.get_Col() );
	}
	@Test
	public void  test_Get_F()      {
		   final Double  D_F_Value = F_Value;
		   assertEquals( D_F_Value , cell.get_F()  );
	}

}
