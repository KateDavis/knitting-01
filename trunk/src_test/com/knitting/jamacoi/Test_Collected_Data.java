package com.knitting.jamacoi;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URL;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.knitting.util.K_Calendar;
import com.knitting.util.Print_Dates_Prices;

public class Test_Collected_Data {
	static String          Dir__Prefix   = "knitting-01/src_test/com/knitting/datasource";
	static String          AAPL          = Dir__Prefix + "/AAPL.txt";
           K_Calendar      kcal          = new K_Calendar();
	
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
                rs__AAPL = new Request_Series( uri_AAPL );
                rs__AAPL .     add_lag(1);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void test_01_valid_URI(){
		   Collected_Data c  = new Collected_Data("AAPL"
				                                 , uri_AAPL
				                                 , rs__AAPL.lags
				                                 , kcal
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
		   assertTrue        ( c.get_date_count() == 1374 );
	}
	@Test
	public void test_02_get_first_date(){
		 Collected_Data c   =  new Collected_Data("AAPL"
                                                 , uri_AAPL
                                                 , rs__AAPL.get_lags()
                                                 , kcal
                                                 ) ;
		 String date__first =  c.get_first_date();
		 System.out.println ( "date__first = >"
				            +  date__first
				            + "<"
				            ); 
		 String s           = "2004_10_25";
		 assertTrue         (  date__first.equals( s ) );
	}
	@Test
	public void test_03_get_first_price(){
		 Collected_Data c   =  new Collected_Data("AAPL"
                                                 , uri_AAPL
                                                 , rs__AAPL.get_lags()
                                                 , kcal
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
                                                , rs__AAPL.get_lags()
                                                , kcal
                                                ) ;
		 String date__last =  c.get_last__date();
		 System.out.println( "date__last  = >"
				           +  date__last
				           + "<"
				           );
		 String s          = "2010_04_09";
		 assertTrue        (  date__last.equals(s) ); 
	}
	@Test
	public void test_05_get_last__price(){
		 Collected_Data c  = new Collected_Data("AAPL"
                                               , uri_AAPL
                                               , rs__AAPL.get_lags()
                                               , kcal
                                               ) ;
		 Double price_last = c.get_last__price();
		 System.out.println( "price_last  = >"
				           +  price_last
				           + "<"
				           );
		 assertTrue        (  price_last  ==  241.7899932861328 ); 
	}
	@Test
	public void test_06_first_10_dates_and_prices(){
		Collected_Data     c            = new Collected_Data  ("AAPL"
                                                              , uri_AAPL
                                                              , rs__AAPL.get_lags()
                                                              , kcal
                                                              ) ;
		Print_Dates_Prices pdp          = new Print_Dates_Prices();
		                   pdp.print_data(c, 10);
	}	
	@Test
	public void test_07_get_price_on_date(){
		Collected_Data    c             = new Collected_Data     ("AAPL"
                                                                 , uri_AAPL
                                                                 , rs__AAPL.get_lags()
                                                                 , kcal
                                                                 ) ;
		Date              d_2004_10_25  =     kcal.set_ccyy_mm_dd( 2004
		                		                                 , 10
		                		                                 , 25
		                		                                 ) ;
	    System.out.println( "d_2004_10_25        = >"
	    	              +  kcal.get_ccyy_mm_dd(d_2004_10_25)
	    	              + "<"
	                      );
	    Double            price         =     c.get_price_on_date(d_2004_10_25);
	    System.out.println( "price on 2004_10_25 = >"
	    		          +  price
	    		          + "<"
	    		          );

        Date              d_2004_10_26  =     kcal.set_ccyy_mm_dd( 2004
                                                                 , 10
                                                                 , 26
                                                                 ) ;
        System.out.println( "d_2004_10_26        = >"
                          +  kcal.get_ccyy_mm_dd(d_2004_10_26)
                          + "<"
                          );
                          price         =     c.get_price_on_date(d_2004_10_26);
        System.out.println( "price on 2004_10_26 = >"
                          +  price
                          + "<"
                          );

        Date              d_2004_10_27  =     kcal.set_ccyy_mm_dd( 2004
                                                                 , 10
                                                                 , 27
                                                                 ) ;
        System.out.println( "d_2004_10_27        = >"
                          +  kcal.get_ccyy_mm_dd(d_2004_10_27)
                          + "<"
                          );
                          price         =     c.get_price_on_date(d_2004_10_27);
        System.out.println( "price on 2004_10_27 = >"
                          +  price
                          + "<"
                          );
		
	}
	@Test
	public void test_08_compare_price_get_prices(){
		Collected_Data     c             = new Collected_Data  ("AAPL"
                                                               , uri_AAPL
                                                               , rs__AAPL.get_lags()
                                                               , kcal
                                                               ) ;

	    Date               d_2004_10_25  =     kcal.set_ccyy_mm_dd( 2004
                                                                  , 10
                                                                  , 25
                                                                  ) ;
	    System.out.println ( "d_2004_10_25        = >"
	    	               +  kcal.get_ccyy_mm_dd(d_2004_10_25)
	    	               + "<"
	                       );
	    Double             price         =     c.get_price_on_date(d_2004_10_25);
	    System.out.println ( "price on 2004_10_25 = >"
	    		           +  price
	    		           + "<"
	    		           );
		Date  date__first  =  c.get_firstKey();
	    System.out.println ( "date__first         = >"
				           +  kcal.get_ccyy_mm_dd(date__first)
			               + "<"
			               ); 
	    System.out.println ( "d_2004_10_25        = >"
	    		           +  kcal.toString(d_2004_10_25)
	    		           );
	    System.out.println ( "date__first         = >"
		                   +  kcal.toString(date__first)
		                   );
	   
	    if   ( d_2004_10_25.equals(date__first) )
	         {
	    	   System.out.println("Dates are equal.");
	         }
	    else
	         {
	    	   System.out.println("Dates are NOT equal.");
	         }
	    }
}
