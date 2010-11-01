package com.knitting.jamacoi;


import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Directory_Triples {
	Directory_Triples dt;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	dt = new Directory_Triples ( "family" );
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Test_List_Keys()
	{
		ArrayList<String>  keys = dt.list_Keys();
		Iterator <String>  iter = keys.iterator();
		
		while ( iter.hasNext() )
		      {
			    String key = iter.next();
			    
			    System.out.println( "key = >"
			    		          +  key
			    		          + "<"
			    		          );
		      }
		        System.out.println( "");
	}
	@Test
	public void Test_List_Subdirs()
	{
		LinkedHashMap  <String, String>  lhm  =  dt  . get_Map_Key_Subdir();
		Set      <Entry<String, String>> es   =  lhm . entrySet();
		Map.Entry      <String, String>  me;
		Iterator <Entry<String, String>> iter =  es  . iterator();
		
		while ( iter.hasNext() )
		      {
			            me      =  iter.next();
		        String  Key     =  me  .getKey();
		        String  Subdir  =  me  .getValue();
		        
		        Formatter line  =  new Formatter();
		        
		        line .format    ( "key = %-15s  Subdir=>%s<"
		        		        ,  ">" + Key + "<"
		        		        ,  Subdir
		        		        );
		        System.out.println ( line );
		      }
		        System.out.println ("");
	}
	@Test
	public void Test_List_Parents()
	{
		LinkedHashMap  <String, String>  lhm  =  dt  . get_Map_Key_Parent();
		Set      <Entry<String, String>> es   =  lhm . entrySet();
		Map.Entry      <String, String>  me;
		Iterator <Entry<String, String>> iter =  es  . iterator();
		
		while ( iter.hasNext() )
		      {
			            me      =  iter.next();
		        String  Key     =  me  .getKey();
		        String  Subdir  =  me  .getValue();
		        
		        Formatter line  =  new Formatter();
		        
		        line .format    ( "key = %-15s  Parent=>%s<"
		        		        ,  ">" + Key + "<"
		        		        ,  Subdir
		        		        );
		        System.out.println ( line );
		      }
		        System.out.println ("");
	}	
	@Test
	public void Test_Add_Subdir_1()
	{
		   String  Key    = "request";
		   String  Parent = "Base_Dir";
		   String  Subdir = "appl_amzn_qcom";
		   dt.put( Key,  Parent,  Subdir );
		   
		   System.out.println ("");
		   System.out.println ("Test_Add_Subdir_1 -------------------------------");
		   System.out.println ("");
		   Test_List_Keys     ();
		   Test_List_Subdirs  ();
		   Test_List_Parents  ();
		
	}
	@Test
	public void Test_Add_Subdir_2()
	{
		   String  Key    = "details";
		   String  Parent = "Base_Dir";
		   String  Subdir = "report_details";
		   dt.put( Key,  Parent,  Subdir );
		   
		           Key    = "summary";
		           Parent = "Base_Dir";
		           Subdir = "report_summary";
		   dt.put( Key,  Parent,  Subdir );
		   
                   Key    = "auto";
                   Parent = "request";
                   Subdir = "correlations_auto";
           dt.put( Key,  Parent,  Subdir );
           
                   Key    = "partial";
                   Parent = "request";
                   Subdir = "correlations_partial";
           dt.put( Key,  Parent,  Subdir );
           
           System.out.println ("");
		   System.out.println ("Test_Add_Subdir_2 -------------------------------");
		   System.out.println ("");
		   Test_List_Keys     ();
		   Test_List_Subdirs  ();
		   Test_List_Parents  ();
		
	}
}
