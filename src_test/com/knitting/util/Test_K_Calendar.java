package com.knitting.util;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_K_Calendar {
	
	K_Calendar kal = new K_Calendar();

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
	public void test_01_Set_ccyy_mm_dd() {
		   Date d = kal.set_ccyy_mm_dd( 2004   // ccyy
				                      , 12     // mm
				                      , 31     // dd
				                      );
		   System.out.println("Date_2004_12_31 = >"
				             + kal.get_ccyy_mm_dd(d)
				             +"<"
				             );
	}

	@Test
	public void testToStringDate() {
		   Date d = kal.set_ccyy_mm_dd( 2005   // ccyy
                                      , 01     // mm
                                      , 01     // dd
                                      );
           System.out.println("Date_2005_01_01 = >"
                             + kal.toString(d)
                             +"<"
                             );
	}

}
