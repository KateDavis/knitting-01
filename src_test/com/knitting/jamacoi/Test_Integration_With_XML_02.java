package com.knitting.jamacoi;


import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.knitting.util.LHMESS;

public class Test_Integration_With_XML_02 {
	
	static String  Dir__Out_Base         =  "knitting-01/src_test/com/knitting/out_base";
	static String  Dir__Out_Family       =  "aapl_amzn_qcom";
	static String  Dir__Out_Request      =  "request_001";
	
	Directory_Triples  dir_t01;
	Directory_Manager  dir_m01;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
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

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public  void    test_List_Parents()
	{
		    List_Parents( dir_t01 );
	}
	@Test
	public  void    test_List_Subdirs()
	{
		    List_Subdirs( dir_t01 );
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
	}
	
	public  void  List_Parents( final  Directory_Triples  dt )
	{	
		    LHMESS              lhm    =  dt   . get_Map_Key_Parent();		
		    list_Values       ( lhm,  "Parent" );
	}
	public  void  List_Subdirs( final  Directory_Triples  dt )
	{	
		    LHMESS              lhm    =  dt   . get_Map_Key_Subdir();		
		    list_Values       ( lhm,  "Subdir" );
	}
	private void list_Values  ( final  LHMESS  lhm
			                  , final  String  title
			                  )
	{
		for ( Iterator <Entry<String, String>>   iter    =  lhm  . entrySet ()
				                                                 . iterator ();
			                                     iter            . hasNext  (); 	
			)		
		    {
			   Map.Entry  <String, String>       me      =  iter . next     ();
		       String                            Key     =  me   . getKey   ();
		       String                            Value   =  me   . getValue ();
		       Formatter                         line    =  new    Formatter();
		       line .format       ( "key = %-15s  %s=>%s<"
		        		          ,  ">" + Key + "<"
		        		          ,  title
		        		          ,  Value
		        		          );
		       System.out.println ( line );
		    }
		       System.out.println ("");
	}	
}
