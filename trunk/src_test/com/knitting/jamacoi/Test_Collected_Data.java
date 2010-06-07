package com.knitting.jamacoi;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Collected_Data {

	@BeforeClass
	public static void setUpBeforeClass()   throws Exception {
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
	public void test_01_new_Collected_Data(){
		   Collected_Data c_data   = new Collected_Data();
		   
		   String         earliest = c_data.get_fmt_shared_start__earliest();
		   String         lastest  = c_data.get_fmt_shared_ending_lastest ();
		   Integer        max      = c_data.get_lag_max();
		   
		   assertTrue   ( earliest.equals("1900_01_01") );
		   assertTrue   ( lastest .equals("3000_12_31") );
		   assertTrue   ( max      ==      0            );
		   
	}

}
