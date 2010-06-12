package com.knitting.jamacoi;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Collected_Data {
	static String          Dir__Prefix   = "knitting-01/src_test/com/knitting/datasource";
	static String          AAPL          = Dir__Prefix + "/AAPL.txt";

	
           String          name;
           URL             url_this;
           URL             url_workspace;
           URL             url_AAPL;
           
           URI             uri_AAPL;
           URI             uri_AMZN;
           URI             uri_QCOM;
           URI             uri_GLD;
           
           Request_Series  rs__AAPL;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
                name           = this.getClass().getSimpleName();
	    
                url_this       = this.getClass   ()
                                     .getResource( name + ".class" );
assertNotNull ( url_this );

                url_workspace  = new URL( url_this     , "../../../../../");
assertNotNull ( url_workspace  ) ;

                url_AAPL       = new URL( url_workspace, AAPL );
assertNotNull ( url_AAPL       ) ;


                uri_AAPL       =          url_AAPL.toURI();
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void test_01_valid_URI(){
		   Collected_Data c  = new Collected_Data("AAPL"
				                                 , uri_AAPL
				                                 ) ;
		   System.out.println( "State       = >"
				             +  c.get_state_desc()
				             + "<" 
				             ) ;
		   System.out.println( "date__count = >"
				             +  c.get_date_count()
				             + "<"
				             );
		   assertFalse       ( c.is_data_empty ()         );
		   assertTrue        ( c.get_date_count() == 1353 );
	}
	@Test
	public void test_02_get_first_date(){
		 Collected_Data c   =  new Collected_Data("AAPL"
                                                 , uri_AAPL
                                                 ) ;
		 String date__first =  c.get_first_date();
		 System.out.println ( "date__first = >"
				            +  date__first
				            + "<"
				            ); 
		 String s           = "2004_11_25";
		 assertTrue         (  date__first.equals( s ) );
	}
	@Test
	public void test_03_get_first_price(){
		 Collected_Data c   =  new Collected_Data("AAPL"
                                                 , uri_AAPL
                                                 ) ;
		 Double price_first =  c.get_first_price();
		 System.out.println ( "price_first = >"
				            +  price_first
				            + "<"
				            );
		 assertTrue         (  price_first  ==  23.775 );
		                   ++  price_first;
		 assertTrue         (  price_first  ==  24.775 );                   
	}
	@Test
	public void test_04_get_last__date(){
		 Collected_Data c  =  new Collected_Data("AAPL"
                                                , uri_AAPL
                                                ) ;
		 String date__last =  c.get_last__date();
		 System.out.println( "date__last  = >"
				           +  date__last
				           + "<"
				           );
		 String s          = "2010_05_09";
		 assertTrue        (  date__last.equals(s) ); 
	}
	@Test
	public void test_05_get_last__price(){
		 Collected_Data c  = new Collected_Data("AAPL"
                                               , uri_AAPL
                                               ) ;
		 Double price_last = c.get_last__price();
		 System.out.println( "price_last  = >"
				           +  price_last
				           + "<"
				           );
		 assertTrue        (  price_last  ==  241.7899932861328 ); 
	}
}
