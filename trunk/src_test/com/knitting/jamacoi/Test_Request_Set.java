package com.knitting.jamacoi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URL;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Request_Set {
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
           
           Request_Set     r_set;

	@BeforeClass
	public static void setUpBeforeClass  () throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp   () throws Exception {
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
     		                                      , get_name( uri_AAPL.toString() )
     		                                      );
               rs__AAPL_dup   = new Request_Series( uri_AAPL
                                                  , "AAPL_dup" 
                                                  );
               rs__AMZN       = new Request_Series( uri_AMZN
                                                  , get_name( uri_AMZN.toString() )
                                                  );
               rs__QCOM       = new Request_Series( uri_QCOM
                                                  , get_name( uri_QCOM.toString() )
                                                  );
               rs__GLD        = new Request_Series( uri_GLD
                                                  , get_name( uri_GLD .toString() )
                                                  );
               r_set          = new Request_Set();

	}
	private void assertTrue(boolean add) {
		// TODO Auto-generated method stub
		
	}

	public String get_name ( String s ){
        StringTokenizer st            = new StringTokenizer (  s 
                                                            , "/"
                                                            );

        StringBuffer    sb            = new StringBuffer    ( "" );

        while ( st.hasMoreTokens() )
              {
                sb = new StringBuffer( st.nextToken() );
              }
        
        st                            = new StringTokenizer (  sb.toString() 
     		                                               , "."
     		                                               );
        sb                            = new StringBuffer    ( "" );
        
        if   ( st.hasMoreTokens() )
             {
     	      return (new StringBuffer( st.nextToken() ) 
     	             .    toString()
     	             );
             }
        else {
     	      return "error";
             }
     	    
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_01_add_series() {
		   assertTrue  ( r_set.instruments.isEmpty()       );
		   assertTrue  ( r_set.instruments.add( rs__AAPL ) );
           assertTrue  ( r_set.instruments.add( rs__AMZN ) );
           assertTrue  ( r_set.instruments.add( rs__QCOM ) );
           assertTrue  ( r_set.instruments.add( rs__GLD  ) );
           assertTrue  ( r_set.instruments.size() == 4     );
	}

	@Test
	public void test_02_add_duplicate() {
		   assertTrue  ( r_set.instruments.isEmpty()       );
		   assertTrue  ( r_set.instruments.add( rs__AAPL ) );
		   assertTrue  ( r_set.instruments.size() == 1     );
           assertFalse ( r_set.instruments.add( rs__AAPL ) );
           assertTrue  ( r_set.instruments.size() == 1     );
	}
	@Test
	public void test_03_add_duplicate() {
		   assertTrue  ( r_set.instruments.isEmpty()            );
		   assertTrue  ( r_set.instruments.add ( rs__AAPL     ) );
		   assertTrue  ( r_set.instruments.size() == 1          );
           assertFalse ( r_set.instruments.add ( rs__AAPL_dup ) );
           assertTrue  ( r_set.instruments.size() == 1          );
	}

}
