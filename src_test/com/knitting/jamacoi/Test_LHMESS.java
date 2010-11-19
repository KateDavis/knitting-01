package com.knitting.jamacoi;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.knitting.util.LHMESS;


public class Test_LHMESS {
	
	@Test
	public void Test_size()
	{
		LHMESS  l  =  new LHMESS();
		System.out.println( "size = >"
				          + l.size()
				          + "<"
				          );
	}
	@Test
	public void Test_add_entry()
	{
		LHMESS       l                =  new LHMESS();
		
		String       returned_string  =  l . put( "key_1", "value_1" );
		assertNull ( returned_string );
		
		int          size             =  l . size();
		assertTrue ( size == 1 );
		       
	}

}
