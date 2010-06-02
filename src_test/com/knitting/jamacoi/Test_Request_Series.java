package com.knitting.jamacoi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URL;
import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Request_Series {
	static String          Dir__Prefix   = "knitting-01/src_test/com/knitting/datasource";
	static String          AAPL          = Dir__Prefix + "/AAPL.txt";
	static String          AMZN          = Dir__Prefix + "/AMZN.txt";
	static String          QCOM          = Dir__Prefix + "/QCOM.txt";
	static String          GLD           = Dir__Prefix +  "/GLD.txt";
	
           String          name;
           URL             url_this;
           URL             url_workspace;
           URL             url_AAPL;
           URL             url_AMZN;
           URL             url_QCOM;
           URL             url_GLD;
           
           URI             uri_AAPL;
           URI             uri_AMZN;
           URI             uri_QCOM;
           URI             uri_GLD;
           
           Request_Series  rs__AAPL;
           Request_Series  rs__AAPL_dup;
           Request_Series  rs__AMZN;
           Request_Series  rs__QCOM;
           Request_Series  rs__GLD;

	@BeforeClass
	public static void setUpBeforeClass  () throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void    setUp   () throws Exception {
                   name           = this.getClass().getSimpleName();
	    
                   url_this       = this.getClass   ()
                                        .getResource( name + ".class" );
    assertNotNull( url_this );

                   url_workspace  = new URL( url_this     , "../../../../../");
    assertNotNull( url_workspace  ) ;

                   url_AAPL       = new URL( url_workspace, AAPL );
    assertNotNull( url_AAPL       ) ;
                   url_AMZN       = new URL( url_workspace, AMZN );
    assertNotNull( url_AMZN       ) ;
                   url_QCOM       = new URL( url_workspace, QCOM );
    assertNotNull( url_QCOM       ) ;
                   url_GLD        = new URL( url_workspace, GLD  );
    assertNotNull( url_GLD        ) ;
    
                   uri_AAPL       =          url_AAPL.toURI();
                   uri_AMZN       =          url_AMZN.toURI();
                   uri_QCOM       =          url_QCOM.toURI();
                   uri_GLD        =          url_GLD .toURI();
           
                   rs__AAPL       = new Request_Series( uri_AAPL
                		                              ,    "AAPL"
                		                              );
                   rs__AMZN       = new Request_Series( uri_AMZN );
                   
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRequest_Series() {
		
	}

	@Test
	public void test_02_Get_data_location() {
		   URI  uri = rs__AAPL.get_data_location();
		   System.out.println( "rs__APPL   = >"
				             +  uri.toString()
				             + "<"
				             );
		   assertTrue        ( uri.toString() == uri_AAPL.toString() );
	}

	@Test
	public void test_04_Get_human_name() {
		   String s0  = "AAPL";
		   String s1  =  rs__AAPL.get_human_name();
		   System.out.println( "human_name = >"
				             +  s1
				             + "<"
				             );
		   assertTrue        (  s1.equals(s0) );
	}

	@Test
	public void test_05_Set_human_name() {
		String s0 = "AAPL_LAG_0";
		rs__AAPL.set_human_name( s0 );
		assertTrue ( s0.equals( rs__AAPL.get_human_name() ) );
	}
	@Test
	public void test_06_Get_lags() {
		TreeSet<Integer> ss = rs__AAPL.get_lags();
		assertTrue     ( ss . isEmpty() );
	}
	@Test
	public void test_07_Set_lags() {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		                 ts . add( 3 );
		                 ts . add( 4 );

		assertTrue     ( 2 == ts.size() );
		
		rs__AAPL.set_lags( ts );
		
		assertTrue ( 2 == rs__AAPL.get_lags().size() );
		
		assertTrue ( rs__AAPL.get_lags().first() == 3   );
		assertTrue ( rs__AAPL.get_lags().contains  (3)  );
		assertTrue ( rs__AAPL.get_lags().contains  (4)  );
	}
	@Test
	public void test_08_not_equal_null(){
		assertFalse ( rs__AAPL.equals(null) );
		
	}
	@Test
	public void test_09_equal_to_itself(){
		assertTrue  ( rs__AAPL.equals(rs__AAPL) );
		
	}
	@Test
	public void test_10_equal_to_duplicate(){
		rs__AAPL_dup   = new Request_Series(  uri_AAPL
                                           , "AAPL_dup"
                                           );
		assertTrue  ( rs__AAPL.equals(rs__AAPL_dup) );	
	}
	@Test
	public void test_11_get_short_file_name(){
		String s0 = rs__AAPL.get_data_location()
		                   .toString();
		String s1 = rs__AAPL.get_short_file_name(s0);
		System.out.println( "short_name = >"
				          +  s1
				          + "<"
				          );
		assertTrue ( s1.equals("AAPL.txt") );
	}
	@Test
	public void test_12_get_trimmed_file_name(){
		String s0 = rs__AAPL.get_data_location()
                            .toString();
        String s1 = rs__AAPL.get_short_file_name(s0);
        String s2 = rs__AAPL.remove_file_type   (s1);
        assertTrue( s2.equals( "AAPL" ) );
	}
	@Test
	public void test_13_get_human_name(){
		String s  = rs__AMZN.get_human_name();
		System.out.println( "human_name = >"
		                  +  s
		                  + "<"
		                  );

        assertTrue( s.equals( "AMZN" ) );
	}
}
