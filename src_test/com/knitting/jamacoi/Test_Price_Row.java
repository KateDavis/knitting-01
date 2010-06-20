package com.knitting.jamacoi;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Price_Row {

	Price_Row pr = new Price_Row( 3 );
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_01_Get_cols() {
		assertTrue( pr.get_cols() == 3 );
	}

	@Test
	public void test_02_Add_price() {
		pr.add_price( 12.345 );
		pr.add_price( 23.456 );
		pr.add_price( 34.567 );
		
		System.out.println( "row =>"
			     	      +  pr.fmt_row_space_and_decimal()
				          + "<"
				          );
		String s = "    12.3450    23.4560    34.5670";
		assertTrue ( s.equals( pr.fmt_row_space_and_decimal() ));
	}
	@Test
	public void test_03_comma_and_decimal() {
		pr.add_price( 12.345 );
		pr.add_price( 23.456 );
		pr.add_price( 34.567 );
		
		System.out.println( "row =>"
			     	      +  pr.fmt_row_comma_and_decimal()
				          + "<"
				          );
		String s = ",  12.3450,  23.4560,  34.5670";
		assertTrue ( s.equals( pr.fmt_row_comma_and_decimal() ));
	}
	@Test
	public void test_04_comma_and_scientific() {
		pr.add_price( 12.345 );
		pr.add_price( 23.456 );
		pr.add_price( 34.567 );
		
		System.out.println( "row =>"
			     	      +  pr.fmt_row_comma_and_scientific()
				          + "<"
				          );
		String s = ", 1.23450E+01, 2.34560E+01, 3.45670E+01";
		assertTrue ( s.equals( pr.fmt_row_comma_and_scientific() ));
	}
//	@Test
//	public void test_03_Get_price() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void test_04_Print_decimal() {
//		fail("Not yet implemented");
//	}

}
