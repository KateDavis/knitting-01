package com.knitting.jamacoi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.TreeMap;

import org.junit.Test;

public class Test_F_Distribution_Table_at_01_00_Percent {

	@Test
	public void testF_Distribution_Table_at_01_00_Percent() {
		
		F_Distribution_Table_at_01_00_Percent    F_Table = new
		F_Distribution_Table_at_01_00_Percent    ();
		
        TreeMap<Integer,TreeMap<Integer,Double>> tm      = new
		TreeMap<Integer,TreeMap<Integer,Double>> ();
		
		tm = F_Table.get_data();
		
		assertEquals(30, tm.size());
	}

	@Test
	public void testGet_data() {
		fail("Not yet implemented");
	}

}
