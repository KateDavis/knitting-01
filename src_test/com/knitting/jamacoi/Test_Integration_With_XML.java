package com.knitting.jamacoi;


import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.knitting.util.K_Calendar;
import com.thoughtworks.xstream.XStream;

public class Test_Integration_With_XML {
	static String  File_Separator        = "/"; 
	static String  FS                    = File_Separator;
	static String  Sub__Dir_Act          = "actual";
	static String  Sub__Dir_Exp          = "expected";
	static String  Dir__Prefix           = "knitting-01/src_test/com/knitting/jamacoi";
	static String  Dir__Out_Base         = "knitting-01/src_test/com/knitting/out_base";
	static String  Dir__Out_Family       =  Dir__Out_Base    + FS + "aapl_amzn_qcom";
	static String  Dir__Out_Request      =  Dir__Out_Family  + FS + "request_001";
	static String  File_In__First_10_Col =  Dir__Out_Request + FS + "first_10_col_test.txt";
	static String  File_Out_Rpt_Detail   =  Dir__Out_Request + FS + "report_detail.txt";
	static String  File_Out_Rpt_Summary  =  Dir__Out_Request + FS + "report_summary.txt";
	static String  Dir__Actual_Out       =  Dir__Prefix      + FS + Sub__Dir_Act; 
	static String  Dir__Expected         =  Dir__Prefix      + FS + Sub__Dir_Exp;
	static String  Dir__Prefix_In        = "knitting-01/src_test/com/knitting/datasource";
	static String  Dir__Knitting         = "knitting-01";
	static String  Dir__Src_Res          = "knitting-01/src_resources";
	static String  Dir__Resources        = "knitting-01/src_resources/com/knitting/resources";
	static String  Dir__Config           = "knitting-01/src_resources/com/knitting/resources/configuration";
	
	static String          AAPL          = Dir__Prefix_In + "/AAPL.txt";
	static String          AMZN          = Dir__Prefix_In + "/AMZN.txt";
	static String          QCOM          = Dir__Prefix_In + "/QCOM.txt";
	static String          GLD           = Dir__Prefix_In + "/GLD.txt";
	static String          xml           = Dir__Config    + "/test_xml_06.xml";
  
	       K_Calendar      kcal          = new  K_Calendar();
	/**************************************************************
	       private String URL_NAME_IN_DIR                = "";  ??? Dir_Config
	       private String URL_NAME_IN_FILE               = "";  ??? xml
	**************************************************************/
	       Workspace       ws;
	       
           URL             url_workspace;
           URL             url_actual;
           URL             url_expected;
           URL             url_knitting;
           URL             url_src_res;
           URL             url_resources;
           URL             url_config;
           URL             url_AAPL;
           URL             url_AMZN;
           URL             url_QCOM;
           URL             url_GLD;
           URL             url_xml;
           URL             url_out_base;
           URL             url_out_family;
           URL             url_out_request;
           URL             url_in__first_10_col;
           URL             url_out_rpt_detail;
           URL             url_out_rpt_summary;
           
           URI             uri_AAPL;
           URI             uri_AMZN;
           URI             uri_QCOM;
           URI             uri_GLD;
           URI             uri_xml;
            
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
	public void setUp() throws Exception {

    Workspace  ws             = new Workspace();
               url_workspace  = ws.get_Workspace();

               url_expected   = new URL( url_workspace, Dir__Expected    );
assertNotNull( url_expected   );

               url_actual     = new URL( url_workspace, Dir__Actual_Out  );
assertNotNull( url_actual     );

               url_knitting   = new URL( url_workspace, Dir__Knitting    );
assertNotNull( url_knitting   );

               url_src_res    = new URL( url_workspace, Dir__Src_Res     );
assertNotNull( url_src_res    );

               url_resources  = new URL( url_workspace, Dir__Resources   );
assertNotNull( url_resources  );

               url_config     = new URL( url_workspace, Dir__Config      );
assertNotNull( url_config     );


               url_AAPL             = new URL( url_workspace , AAPL );
assertNotNull( url_AAPL             ) ;
               url_AMZN             = new URL( url_workspace , AMZN );
assertNotNull( url_AMZN             ) ;
               url_QCOM             = new URL( url_workspace , QCOM );
assertNotNull( url_QCOM             ) ;
               url_GLD              = new URL( url_workspace , GLD  );
assertNotNull( url_GLD              ) ;
               url_xml              = new URL( url_workspace , xml  );
assertNotNull( url_xml              ) ;
               url_out_base         = new URL( url_workspace , Dir__Out_Base        );
assertNotNull( url_out_base         ) ;
               url_out_family       = new URL( url_workspace , Dir__Out_Family      );               
assertNotNull( url_out_family       ) ;
               url_out_request      = new URL( url_workspace , Dir__Out_Request     );               
assertNotNull( url_out_request      ) ;
               url_in__first_10_col = new URL( url_workspace , File_In__First_10_Col  );               
assertNotNull( url_in__first_10_col ) ;
               url_out_rpt_detail   = new URL( url_workspace , File_Out_Rpt_Detail  );               
assertNotNull( url_out_rpt_detail   ) ;
               url_out_rpt_summary  = new URL( url_workspace , File_Out_Rpt_Summary );               
assertNotNull( url_out_rpt_summary  ) ;

               uri_AAPL       =          url_AAPL.toURI();
               uri_AMZN       =          url_AMZN.toURI();
               uri_QCOM       =          url_QCOM.toURI();
               uri_GLD        =          url_GLD .toURI();
               uri_xml        =          url_xml .toURI();

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
	public void    tearDown() throws Exception {
	}
	@Test
	public void    test_01_new_Collected_Data()
	       throws  IOException
	       ,       not_estimated
	       ,       not_invertable
	       ,       not_rectangular
           ,       not_significant
	{
	       Date      d_2004_10_25    =       kcal.set_ccyy_mm_dd(2004, 10, 25);
	       System.out.println( "d_2004_10_25    = >"
	    		             +  kcal.get_ccyy_mm_dd( d_2004_10_25 )
	    		             + "<"
	    		             );
		   Collected_Data      aapl  =  new  Collected_Data( rs__AAPL.get_human_name   ()
				                                           , rs__AAPL.get_data_location() 
				                                           , rs__AAPL.get_lags         ()
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
				                                           , rs__AMZN.get_lags         ()
				                                           , kcal
				                                           ) ;
		   Collected_Data      qcom  =  new  Collected_Data( rs__QCOM.get_human_name   ()
				                                           , rs__QCOM.get_data_location()
				                                           , rs__QCOM.get_lags         ()
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
		                     /***********************************************************************
		                     lm  .     write_ix_entries( prf
                                                       , "/Temp/Residuals_attempt_01/first_10_col_test"
                                                       );
                             ***********************************************************************/                          
		                     lm  .     write_ix_entries( prf
                                                       , url_in__first_10_col
                                                       );
		   System.out.println(" ");
		    
 check_directory    ( url_workspace   );
 check_directory    ( url_knitting    );
 check_directory    ( url_src_res     );
 check_directory    ( url_resources   );
 check_directory    ( url_config      );
 check_directory    ( url_out_base    );
 check_directory    ( url_out_family  );
 check_directory    ( url_out_request );
 
 
 System.out.println ( " " );
 
 check_file         ( url_AAPL             );
 check_file         ( url_xml              );
 check_file         ( url_in__first_10_col );
 check_file         ( url_out_rpt_detail   );
 check_file         ( url_out_rpt_summary  );
 
 
 System.out.println ( " " );
 		                     
 Build_xml_string   xml_in      = new  Build_xml_string   ( url_xml );
 XStream            xstream     = new  XStream();
 Analysis_Parms     my_parms_02 =     (Analysis_Parms)
		                               xstream.fromXML( xml_in.get_xml_string() );

		            my_parms_02 . report_values();
		            
 System.out.println(" ");
 
                    my_parms_02 . setCOL_END            ( 8);
                    my_parms_02 . setCOUNT_MAX_COLUMNS  (10);
             //     my_parms_02 . setROW_BASE           (10);
                    
                    my_parms_02 . setNAME_IN_FILE       ( "first_10_col_test"       );
                    my_parms_02 . setNAME_OUT_DETAILS   ( "first_10_col_details"    );
                    my_parms_02 . setNAME_OUT_SUMMARY   ( "first_10_col_summary"    );
                    
                    my_parms_02 . setNAME_REL_APP_BASE  ( "knitting-01/src_test/com/knitting/regression" );
                    my_parms_02 . setNAME_REL_FAMILY    ( "aapl_amzn_qcom" );
                    my_parms_02 . setNAME_REL_REQUEST   ( "request_0001"   );
                    
                    my_parms_02 . setURL_NAME_IN_DIR            ( url_out_request     . toExternalForm() ); 
                    my_parms_02 . setURL_NAME_IN_FILE           ( url_in__first_10_col. toExternalForm() );
                    
                    my_parms_02 . setURL_NAME_WORKSPACE         ( url_workspace       . toExternalForm() );  
                    my_parms_02 . setURL_NAME_OUT_DIR_BASE      ( url_out_base        . toExternalForm() );
                    my_parms_02 . setURL_NAME_OUT_DIR_FAMILY    ( url_out_family      . toExternalForm() );
                    my_parms_02 . setURL_NANE_OUT_DIR_REQUEST   ( url_out_request     . toExternalForm() );  
                    my_parms_02 . setURL_NAME_OUT_FILE_DETAILS  ( url_out_rpt_detail  . toExternalForm() );
                    my_parms_02 . setURL_NAME_OUT_FILE_SUMMARY  ( url_out_rpt_summary . toExternalForm() );
                    
                    my_parms_02 . setNAME_REL_APP_BASE( "knitting_01/src_test/com/knitting/regression"   );
                    my_parms_02 . setNAME_REL_FAMILY  ( "aapl_amzn_qcom"                                 );
                    my_parms_02 . setNAME_REL_REQUEST ( "request_0001"                                   );
                    
                    my_parms_02 . setNAME_REL_REPORTS        ( "reports"                                );
                    my_parms_02 . setNAME_REL_REQUEST_SERIES ( "request_series"                         );
                    my_parms_02 . setNAME_REL_REQUEST_SET    ( "request_set"                            );
                    my_parms_02 . setNAME_REL_RESIDUALS      ( "residuals"                              );
                    
                    my_parms_02 . setNAME_RPT_DETAILS        ( "rpt_details.txt"                        );
                    my_parms_02 . setNAME_RPT_SUMMARY        ( "rpt_summary.txt"                        );
                    
                    my_parms_02 . setURL_REL_APP_BASE        ( "" );
                    my_parms_02 . setURL_REL_FAMILY          ( "" );
                    my_parms_02 . setURL_REL_REQUEST         ( "" );
                    my_parms_02 . setURL_REL_REPORTS         ( "" );
                    my_parms_02 . setURL_REL_REQUEST_SERIES  ( "" );
                    my_parms_02 . setURL_REL_REQUEST_SET     ( "" );
                    my_parms_02 . setURL_REL_RESIDUALS       ( "" );
    Workspace       ws1           =  new Workspace();
    Build_Directory_Structure bds1= 
new Build_Directory_Structure	  ( ws1.get_Workspace()
                                  , my_parms_02.getNAME_REL_APP_BASE()
                                  , my_parms_02.getNAME_REL_FAMILY()
                                  , my_parms_02.getNAME_REL_REQUEST()
                                  );
    
	                bds1.create_urls();
	                bds1.show_urls  ();
	                bds1.check_urls ();
	                bds1.create_directories();
                    
	                my_parms_02 . setURL_REL_APP_BASE       ( bds1.get_application_base().toExternalForm() );
	                my_parms_02 . setURL_REL_FAMILY         ( bds1.get_family()          .toExternalForm() );
	                my_parms_02 . setURL_REL_REQUEST        ( bds1.get_request()         .toExternalForm() );
	                my_parms_02 . setURL_REL_REPORTS        ( bds1.get_reports()         .toExternalForm() );
	                my_parms_02 . setURL_REL_REQUEST_SERIES ( bds1.get_request_series()  .toExternalForm() );
	                my_parms_02 . setURL_REL_REQUEST_SET    ( bds1.get_request_set()     .toExternalForm() );
	                my_parms_02 . setURL_REL_RESIDUALS      ( bds1.get_residuals()       .toExternalForm() );
	                
	                URL    rpt_base    = new URL ( my_parms_02.getURL_REL_REPORTS () );
	                URL    rpt_details = new URL ( rpt_base
	                		                     , my_parms_02.getNAME_RPT_DETAILS()
	                		                     );
	                URL    rpt_summary = new URL ( rpt_base
	                		                     , my_parms_02.getNAME_RPT_SUMMARY()
	                		                     );
	                my_parms_02.setURL_REL_RPT_DETAILS ( rpt_details.toExternalForm() );
	                my_parms_02.setURL_REL_RPT_SUMMARY ( rpt_summary.toExternalForm() );
                    my_parms_02 . report_values();
                    
                    xml_in.write_to_disk ( url_xml
                    		             , my_parms_02
                    		             );
        
        initialize_to_empty_file             ( my_parms_02.getURL_REL_RPT_DETAILS() );
        initialize_to_empty_file             ( my_parms_02.getURL_REL_RPT_SUMMARY() );
        
    	Workspace                  ws  = new   Workspace();
    	
    	Build_Directory_Structure  bds = new
    	Build_Directory_Structure            ( ws.get_Workspace() 
    			                             , my_parms_02.getNAME_REL_APP_BASE()
    			                             , my_parms_02.getNAME_REL_FAMILY()
    			                             , my_parms_02.getNAME_REL_REQUEST()
    			                             );
    	bds.create_urls();
    	bds.show_urls  ();
    	bds.check_urls ();
    	bds.create_directories();
       
        
 Rectangular_CVS_Matrix m = new Rectangular_CVS_Matrix ( my_parms_02 );
                        m . show_input_names();
                        
 System.out.println (            "getCOUNT_MAX_MATRIX_ROWS = >"
		            + my_parms_02.getCOUNT_MAX_MATRIX_ROWS()
		            + "<"
		            );
 System.out.println (            "getCOUNT_MAX_COLUMNS     = >"
		            + my_parms_02.getCOUNT_MAX_COLUMNS()
		            + "<"
		            );

 Sub_Matrix  sub_matrix   =  new Sub_Matrix ( my_parms_02.getCOUNT_MAX_MATRIX_ROWS()
                                            , my_parms_02.getCOUNT_MAX_COLUMNS()
                                            );
             sub_matrix   .      Load_Name_Security ( lm.get_name_security() );
             sub_matrix   .      Load_Name_Lag      ( lm.get_name_lag()      );
             
 
 for ( int ir_base  =   my_parms_02.getROW_BASE()
     ;     ir_base  < ( my_parms_02.getROW_BASE()
                      + my_parms_02.getCOUNT_MAX_REGRESSION_ANALYSIS()
                      )
     ;     ir_base++
     )   
     {
	 /****************************************************************
           System.out.println ( "ir_base = >"
        		              +  ir_base
        		              + "<"
        		              );
     ****************************************************************/
     //    sub_matrix.Load_Data_Backwards( ir_base
     //                                  , m
     //                                  );
           sub_matrix.Load_Data_Forwards ( ir_base
                                         , m
                                         );  
           try
               {                            
                 Regression        r = new Regression ( sub_matrix ); 

                 if  ( ir_base == my_parms_02.getROW_BASE() )
                     {
                        Report_Regression_Summary   rrs  =
                   new  Report_Regression_Summary        ( r
	                                                     , sub_matrix
	                                                     , my_parms_02
	                                                     );
                                                    rrs  . report_headers();
                     }                                  
                                                   
                 Report_Regression_Results          rrr =
             new Report_Regression_Results              ( r
                                                        , sub_matrix
                                                        , my_parms_02
                                                        );
                                                    rrr . report_All();
                                            
                                                    
                 Report_Regression_Summary          rrs =
             new Report_Regression_Summary              ( r
            		                                    , sub_matrix
            		                                    , my_parms_02
            		                                    );
                                                    rrs . report_All();
                                                    
                                                    
                 Report_Standardized_Y_Residuals    syr =
             new Report_Standardized_Y_Residuals        ( ir_base
            		                                    , r
            		                                    , sub_matrix
            		                                    , my_parms_02
            		                                    );	 
                                                    syr . create_rpt();
               }
           catch (not_enough_rows e)
                 {}                  
           catch (not_invertable  e)
                 {}        
           catch (not_significant e)
                 {}
           catch (java.io.FileNotFoundException e)
                 {}
           }
		            
		                          	                     
	} 
public void   check_directory ( final  URL  u){
	   File   d = new  File   ( u.getFile()  );
	   if   ( d.exists() )
	        {
              System.out.println(        "exists:            =>" +  u.toString() + "<" );
	          if   ( d.isDirectory() )
	               { System.out.println( "is a directory     =>" +  u.toString() + "<" ); }
	          else
	               { System.out.println( "is NOT a directory =>" +  u.toString() + "<" ); }
	        }
	   else
	        {        System.out.println( "does NOT exists    =>" +  u.toString() + "<" ); }
}
public void   check_file     ( final  URL  u ){
	   File   f = new  File  (u.getFile()    );
	   if   ( f.exists() )
	        {
              System.out.println(        "exists:            =>" +  u.toString() + "<" );
	          if   ( f.isFile() )
	               { System.out.println( "is a file:         =>" +  u.toString() + "<" ); }
	          else
	               { System.out.println( "is NOT a file:     =>" +  u.toString() + "<" ); }  
	        }
	   else 
	        {        System.out.println( "does NOT exists    =>" +  u.toString() + "<" ); }
	
}
public void   initialize_to_empty_file ( String URL_name ) 
       throws MalformedURLException{
	
	   URL    u  = new URL    ( URL_name );
	   File   f  = new File   ( u . getFile() );
	                                            
	   if   ( f  . isFile() ) { f . delete(); }	
}

}
