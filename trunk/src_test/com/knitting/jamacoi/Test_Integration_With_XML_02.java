package com.knitting.jamacoi;


import java.net.MalformedURLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Integration_With_XML_02 {
	
	
	Directory_Triples  dir_t02;
	Directory_Triples  dir_t03;
	
	;
	Directory_Manager  dir_m01;
	Directory_Manager  dir_m02;
	Directory_Manager  dir_m03;

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
             dir_m01  =  create_dir_m01();
             dir_m02  =  create_dir_m02();
             dir_m03  =  create_dir_m03();
	}
	private  Directory_Manager     create_dir_m01() 
             throws                MalformedURLException 
    {
             String                Dir__Out_Base         =  "knitting-01/src_test/com/knitting/out_base";
             String                Dir__Out_Family       =  "aapl_amzn_qcom";
             String                Dir__Out_Request      =  "request_001";	

             Directory_Triples     dt     =  new Directory_Triples ( "Dir__Out_Base"
                                                                   ,  Dir__Out_Base
                                                                   );	
                                   dt.put ( "Dir__Out_Family"
                                          , "Dir__Out_Base"
                                          ,  Dir__Out_Family
                                          );

                                   dt.put ( "Dir__Out_Request"
                                          , "Dir__Out_Family"
                                          ,  Dir__Out_Request
                                          );

             return                new    Directory_Manager ( dt );
    }
    private  Directory_Manager     create_dir_m02() 
             throws                MalformedURLException 
    {
             String                Dir__Exp_Act          =  "knitting-01/src_test/com/knitting/jamacoi";
             String                Dir__Exp              =  "expected";
             String                Dir__Act              =  "actual";

             Directory_Triples     dt     =  new  Directory_Triples ( "Dir__Exp_Act"
                                                                    ,  Dir__Exp_Act
                                                                    );
                                   dt.put ( "Dir__Exp"
                                          , "Dir__Exp_Act"
                                          ,  Dir__Exp
                                          );

                                   dt.put ( "Dir__Act"
	                                      , "Dir__Exp_Act" 
                                          ,  Dir__Act
                                          );

             return                new    Directory_Manager ( dt );
    }
private  Directory_Manager     create_dir_m03() 
         throws                MalformedURLException 
{
         String                Dir__Src_Res          = "knitting-01/src_resources";
         String                Dir__Resources        = "com/knitting/resources";	

         Directory_Triples     dt     =  new Directory_Triples  ( "Dir__Src_Res"
                                                                ,  Dir__Src_Res
                                                                );	
                               dt.put ( "Dir__Resources"
                                      , "Dir__Src_Res"
                                      ,  Dir__Resources
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
		                      +  dir_m01.get_URL_Workspace_as_String()
		                      + "<"
		                      );
	        System.out.println("");
	}
	@Test
	public  void    test_last_subdirectory()
	        throws  java.net.MalformedURLException
    {
	        System.out.println( "Last Subdirectory =>"
	        		          + dir_m01.get_Last_Subdirectory( dir_m01.get_URL_Workspace_as_String()
	        		        		                         )
	        		          + "<"          
	        		          );
	        System.out.println("");
    }
	@Test
	public  void  test_out_directories()
	{
		    dir_m01.check_urls();
	        System.out.println("");
	}	
	@Test
	public  void  test_expected_actual_directories()
	{
		    dir_m02.check_urls();
	        System.out.println("");
	}
	@Test
	public  void  test_resources()
	{
		    dir_m03.check_urls();
	        System.out.println("");
	}
}
