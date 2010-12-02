package com.knitting.jamacoi;


import java.net.MalformedURLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Integration_With_XML_02 {
	
	static String      Dir__Out_Base         =  "knitting-01/src_test/com/knitting/out_base";
	static String      Dir__Out_Family       =  "aapl_amzn_qcom";
	static String      Dir__Out_Request      =  "request_001";
	
	static String      Dir__Exp_Act          =  "knitting-01/src_test/com/knitting/jamacoi";
	static String      Dir__Exp              =  "expected";
	static String      Dir__Act              =  "actual";
	
	static String      Dir__Src_Res          = "knitting-01/src_resources";
	static String      Dir__Resources        = "knitting-01/src_resources/com/knitting/resources";
	
	Directory_Triples  dir_t01;
	Directory_Triples  dir_t02;
	Directory_Triples  dir_t03;
	
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
	public void setUp() throws Exception {
		
    create_dir_t01_and_dir_m01();
    create_dir_t02_and_dir_m02();
    create_dir_t03_and_dir_m03();
    
	}
	private  void        create_dir_t01_and_dir_m01() 
	         throws      MalformedURLException 
	{
		     dir_t01     =  new Directory_Triples ( "Dir__Out_Base"
		                                          ,  Dir__Out_Base
				                                  );	
		     dir_t01.put ( "Dir__Out_Family"
				         , "Dir__Out_Base"
				         ,  Dir__Out_Family
				         );
		
		     dir_t01.put ( "Dir__Out_Request"
		                 , "Dir__Out_Family"
		                 ,  Dir__Out_Request
		                 );
		
		     dir_m01     =  new  Directory_Manager ( dir_t01 );
	}
	private  void    create_dir_t02_and_dir_m02() 
	         throws  MalformedURLException 
	{
	         dir_t02     =  new  Directory_Triples ( "Dir__Exp_Act"
				                                   ,  Dir__Exp_Act
				                                   );
		
	        dir_t02.put ( "Dir__Exp"
                        , "Dir__Exp_Act"
				        ,  Dir__Exp
				        );
		
		    dir_t02.put ( "Dir__Act"
			   	        , "Dir__Exp_Act" 
				        ,  Dir__Act
				        );
		
		    dir_m02     =  new  Directory_Manager ( dir_t02 );
	}
	private  void        create_dir_t03_and_dir_m03() 
	         throws      MalformedURLException 
	{
	   	     dir_t03     =  new Directory_Triples  ( "Dir__Src_Res"
		                                           ,  Dir__Src_Res
		                                           );	
   
             dir_t03.put ( "Dir__Resources"
			             , "Dir__Src_Res"
			             ,  Dir__Resources
			             );
		
	         dir_m03     =  new  Directory_Manager ( dir_t03 );
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public  void    test_List_Parents()
	{
		         dir_t01.List_Parents();
	}
	@Test
	public  void    test_List_Subdirs()
	{
		         dir_t01.List_Subdirs();
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
