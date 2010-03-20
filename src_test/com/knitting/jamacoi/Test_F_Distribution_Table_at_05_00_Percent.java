package com.knitting.jamacoi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public    class Test_F_Distribution_Table_at_05_00_Percent   {

	@Test
	public void test_F_Distribution_Table_at_05_00_Percent() {
		
		F_Distribution_Table_at_05_00_Percent  F_Table = new
		F_Distribution_Table_at_05_00_Percent();
		
		assertEquals( 30, F_Table.size() );
	}

}
