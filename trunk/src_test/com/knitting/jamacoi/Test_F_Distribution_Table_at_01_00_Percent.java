package com.knitting.jamacoi;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_F_Distribution_Table_at_01_00_Percent {
       F_Distribution_Table_at_01_00_Percent       ft = new
       F_Distribution_Table_at_01_00_Percent   ();
	
       TreeMap<Integer,TreeMap<Integer,Double>>    tm = new 
       TreeMap<Integer,TreeMap<Integer,Double>>();


	@BeforeClass
	public static void setUpBeforeClass  () throws Exception {
	}

	@Before
	public void setUp   () throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
    @Test
    public void test_01_size(){
           assertTrue( ft.size() == 30 );	
    }
    @Test
    public void test_02_get_row(){
           tm = ft.get_data();
           assertTrue ( tm.size() ==   30   );	
           assertTrue ( tm.containsKey( 1 ) );
           assertFalse( tm.containsKey( 0 ) );
           assertTrue ( tm.containsKey(25 ) );
           assertFalse( tm.containsKey(26 ) );
    }
    @Test
    public void test_03_get_col(){
           tm = ft.get_data();
           assertTrue ( tm.size() ==   30   );
           Integer row_001 =  1;
           Integer col_000 =  0;
           Integer col_001 =  1;
           Integer col_010 = 10;
           Integer col_011 = 11;
           
           assertTrue ( tm.containsKey( row_001 ) );
           TreeMap<Integer,Double> tm_row_001 = tm.get(row_001);
           assertFalse( tm_row_001.containsKey( col_000 ) );
           assertTrue ( tm_row_001.containsKey( col_001 ) );
           assertTrue ( tm_row_001.containsKey( col_010 ) );
           assertFalse( tm_row_001.containsKey( col_011 ) );
    }
    @Test
    public void test_04_get_Double(){
           tm = ft.get_data();
           assertTrue ( tm.size() ==   30   );
           Integer row_001 =   1;
           Integer row_010 =  10;
           Integer col_001 =   1;
           Integer col_120 = 120;
           
           assertTrue     ( tm        .containsKey    (row_001) );
           TreeMap<Integer,Double> tm_row_001 = tm.get(row_001)  ;
           assertTrue     ( tm_row_001.containsKey    (col_001) );
           Double f_value = tm_row_001.get            (col_001)  ;
           assertTrue     ( f_value == 4052.0 );
           
           assertTrue     ( tm        .containsKey    (row_010) );
           TreeMap<Integer,Double> tm_row_010 = tm.get(row_010)  ;
           assertTrue     ( tm_row_010.containsKey    (col_120) );
                  f_value = tm_row_010.get            (col_120)  ;
           assertTrue     ( f_value == 4.0    );
    }
}
