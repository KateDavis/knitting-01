package com.knitting.jamacoi;


import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URL;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.knitting.util.K_Calendar;

public class Test_Integration_With_XML {
	static String          Dir__Prefix   = "knitting-01/src_test/com/knitting/datasource";
	static String          AAPL          = Dir__Prefix + "/AAPL.txt";
	static String          AMZN          = Dir__Prefix + "/AMZN.txt";
	static String          QCOM          = Dir__Prefix + "/QCOM.txt";
	static String          GLD           = Dir__Prefix +  "/GLD.txt";
	       K_Calendar      kcal          = new  K_Calendar();
	
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
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
               name           = this.getClass().getSimpleName();
        
               url_this       = this.getClass   ()
                              . getResource( name + ".class" );
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

               rs__AAPL       = new Request_Series( uri_AAPL );
               rs__AAPL       .     add_lag(1);
               rs__AAPL       .     add_lag(2);
               rs__AAPL       .     add_lag(3);
               rs__AAPL       .     add_lag(4);
    
               rs__AMZN       = new Request_Series( uri_AMZN );
               rs__AMZN       .     add_lag(2);
               rs__AMZN       .     add_lag(4);
    
               rs__QCOM       = new Request_Series( uri_QCOM );
               rs__QCOM       .     add_lag(1);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void test_01_new_Collected_Data(){
	       Date      d_2004_10_25    =       kcal.set_ccyy_mm_dd(2004, 10, 25);
	       System.out.println( "d_2004_10_25    = >"
	    		             +  kcal.get_ccyy_mm_dd( d_2004_10_25 )
	    		             + "<"
	    		             );
		   Collected_Data      aapl  =  new  Collected_Data( rs__AAPL.get_human_name   ()
				                                           , rs__AAPL.get_data_location() 
				                                           , rs__AAPL.get_lags             ()
				                                           , kcal 
				                                           ) ;
		   if ( rs__AAPL.get_lags() == null )
		      {
			    System.out.println(" rs__AAPL.get_lags() == null" );
		      }
		   else
		      {
			    System.out.println(" rs__AAPL.get_lags() != null" );
		      }
		   Collected_Data      amzn  =  new  Collected_Data( rs__AMZN.get_human_name   ()
				                                           , rs__AMZN.get_data_location()
				                                           , rs__AMZN.get_lags             ()
				                                           , kcal
				                                           ) ;
		   Collected_Data      qcom  =  new  Collected_Data( rs__QCOM.get_human_name   ()
				                                           , rs__QCOM.get_data_location()
				                                           , rs__QCOM.get_lags             ()
				                                           , kcal 
				                                           ) ;
		   System.out.println( "appl 2004_10_25 = >"
				             + (aapl.get_price_on_date ( d_2004_10_25 ) )
				             + "<"
				             );
		   System.out.println( "aapl_date_first = >"
				             +  aapl.get_first_date()
				             + "<"
				             );
		   System.out.println( "aapl_date_last  = >"
		                     +  aapl.get_last__date()
		                     + "<"
		                     );
		   System.out.println( "amzn_date_first = >"
		                     +  amzn.get_first_date()
		                     + "<"
		                     );
		   System.out.println( "amzn_date_last  = >"
                             +  amzn.get_last__date()
                             + "<"
                            );
		   System.out.println( "qcom_date_first = >"
                             +  qcom.get_first_date()
                             + "<"
                             );
		   System.out.println( "qcom_date_last  = >"
                             +  qcom.get_last__date()
                             + "<"
                             );
		   Collected_Data_Set  cds   =  new  Collected_Data_Set(kcal);
		   
		                       cds   .       add_data( aapl );
		                       cds   .       add_data( amzn );
		                       cds   .       add_data( qcom );
		                       
		                       cds   .       set_date_intersection();
		   System.out.println(        "data_set_size          = >"
				             +  cds.get_data_size()
				             + "<"
				             );                    
		   System.out.println(        "date_intersection_size = >"
				             + cds.get_date_intersection_size()
				             + "<"
				             );   
		   System.out.println(        "date_first             = >"
				             +  cds.get_first_ccyy_mm_dd()
				             + "<"
				             );
		   System.out.println(        "date_last              = >"
		                     +  cds.get_last__ccyy_mm_dd()
		                     + "<"
		                     );
		   Lagged_Matrix lm  = cds.set_lagged_matrix();
		   System.out.println(" ");
		   String_Row_Format srf = new String_Row_Format
		                             ( String_Row_Format.fmt_type.SPACE_DECIMAL );
		                     lm  .     print_name_security( srf );
		                     lm  .     print_name_lag     ( srf );
		                     
		   Price_Row_Format  prf = new Price_Row_Format
		                             ( Price_Row_Format.fmt_type .SPACE_DECIMAL );
		                     lm  .     print_ix_entries( 10
		                    		                   , prf
		                    		                   ) ;
		   System.out.println(" ");
		                     srf = new String_Row_Format
                                     ( String_Row_Format.fmt_type.COMMA_DECIMAL );
		                     lm  .     print_name_security( srf );
                             lm  .     print_name_lag     ( srf );
            
		                     prf = new Price_Row_Format
                                     ( Price_Row_Format.fmt_type .COMMA_DECIMAL );
		                     lm  .     print_ix_entries( 10
		                    		                   , prf
		                    		                   ) ;              
		   System.out.println(" ");
  		                     srf = new String_Row_Format
                                     ( String_Row_Format.fmt_type.COMMA_SCIENTIFIC );
                             lm  .     print_name_security( srf );
                             lm  .     print_name_lag     ( srf );

		                     prf = new Price_Row_Format
                                     ( Price_Row_Format.fmt_type .COMMA_SCIENTIFIC );
		                     lm  .     print_ix_entries( 10
		                    		                   , prf
		                    		                   );
	}
}
