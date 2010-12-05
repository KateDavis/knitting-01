package com.knitting.jamacoi;


import java.net.MalformedURLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Integration_With_XML_02 {
	
	Directory_Manager  dir_m01_investment_family;
	Directory_Manager  dir_m02_exp_act;
	Directory_Manager  dir_m03_resources;
	Directory_Manager  dir_m04_data_sources;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public   void        setUp() 
	         throws      Exception 
	{	
             dir_m01_investment_family  =  create_dir_m01_investment_family();
             dir_m02_exp_act            =  create_dir_m02_exp_act();
             dir_m03_resources          =  create_dir_m03_resources();
             dir_m04_data_sources       =  create_dir_m04_data_sources();
	}
	private  Directory_Manager     create_dir_m01_investment_family() 
             throws                MalformedURLException 
    {
             String                Dir__Out_Base         =  "knitting-01/src_test/com/knitting/out_base";
             String                Dir__Out_Family       =  "aapl_amzn_qcom";
             String                Dir__Out_Request      =  "request_001";	

             Directory_Triples     dt     =  new Directory_Triples (  Dir__Out_Base
                                                                   , "Dir__Out_Base"
                                                                   );	
                                   dt.put (  Dir__Out_Family
                                		  , "Dir__Out_Family"
                                          , "Dir__Out_Base"
                                          );

                                   dt.put (  Dir__Out_Request
                                		  , "Dir__Out_Request"
                                          , "Dir__Out_Family"
                                          );

             return                new    Directory_Manager ( dt );
    }
    private  Directory_Manager     create_dir_m02_exp_act() 
             throws                MalformedURLException 
    {
             String                Dir__Exp_Act          =  "knitting-01/src_test/com/knitting/jamacoi";
             String                Dir__Exp              =  "expected";
             String                Dir__Act              =  "actual";

             Directory_Triples     dt     =  new  Directory_Triples (  Dir__Exp_Act
                                                                    , "Dir__Exp_Act"
                                                                    );
                                   dt.put (  Dir__Exp
                                		  , "Dir__Exp"
                                          , "Dir__Exp_Act"
                                          );

                                   dt.put (  Dir__Act
                                		  , "Dir__Act"
	                                      , "Dir__Exp_Act" 
                                          );

             return                new    Directory_Manager ( dt );
    }
    private  Directory_Manager     create_dir_m03_resources() 
             throws                MalformedURLException 
    {
             String                Dir__Src_Res          = "knitting-01/src_resources";
             String                Dir__Resources        = "com/knitting/resources";
             String                Dir__Config           = "configuration";

             Directory_Triples     dt     =  new Directory_Triples  (  Dir__Src_Res 
                                                                    , "Dir__Src_Res"
                                                                    );	
                                   dt.put (  Dir__Resources
                                		  , "Dir__Resources"
                                          , "Dir__Src_Res"
                                          );

                                   dt.put (  Dir__Config
                                		  , "Dir__Config"
                                          , "Dir__Resources"
                                          );
                                   
             return                new    Directory_Manager ( dt );
    }
    private  Directory_Manager     create_dir_m04_data_sources() 
             throws                MalformedURLException 
    {
             String                Dir__Prefix_In        = "knitting-01/src_test/com/knitting/datasource";

             Directory_Triples     dt     =  new Directory_Triples  (  Dir__Prefix_In
                                                                    , "Dir__Prefix_In"
                                                                    );	

             return                new    Directory_Manager ( dt );
    }
	@After
	public  void    tearDown() 
	        throws  Exception 
	{
	}
	@Test
	public  void    test_workspace()
	        throws  java.net.MalformedURLException 
	{
	        System.out.println( "WorkSpace = >"
		                      +  dir_m01_investment_family.get_URL_Workspace_as_String()
		                      + "<"
		                      );
	        System.out.println("");
	}
	@Test
	public  void    test_last_subdirectory()
	        throws  java.net.MalformedURLException
    {
	        System.out.println( "Last Subdirectory =>"
	        		          + dir_m01_investment_family
	        		          . get_Last_Subdirectory     ( dir_m01_investment_family
	        		        		                      . get_URL_Workspace_as_String()
	        		        	                          )
	        		          + "<"          
	        		          );
	        System.out.println("");
    }
	@Test
	public  void  test_out_directories()
	{
		    dir_m01_investment_family.check_urls();
	        System.out.println("");
	}	
	@Test
	public  void  test_expected_actual_directories()
	{
		    dir_m02_exp_act.check_urls();
	        System.out.println("");
	}
	@Test
	public  void  test_resources()
	{
		    dir_m03_resources.check_urls();
	        System.out.println("");
	}
	@Test
	public  void  test_resources_data()
	{
		    dir_m04_data_sources.check_urls();
	        System.out.println("");
	}
}
