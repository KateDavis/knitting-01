package com.knitting.jamacoi;


import java.util.ArrayList;
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
		             List_Keys    ( dt );
	}
	@Test
	public void Test_List_Subdirs()
	{
		             List_Subdirs ( dt );
	}
	@Test
	public void Test_List_Parents()
	{
		             List_Parents ( dt );
	}	
	@Test
	public void Test_Add_Subdir_1()
	{
		   String  Key    = "request";
		   String  Parent =  dt.get_Key_Rel_Base_Dir(); 
		   String  Subdir = "appl_amzn_qcom";
		   dt.put( Key,  Parent,  Subdir );
		   
		   System.out.println ("");
		   System.out.println ("Test_Add_Subdir_1 -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		
	}
	@Test
	public void Test_Add_Subdir_2()
	{
		   String  Key    = "reports";
		   String  Parent =  dt.get_Key_Rel_Base_Dir(); 
		   String  Subdir = "report_dir";
		   dt.put( Key,  Parent,  Subdir );
		   
		           Key    = "summary";
		           Parent = "reports";
		           Subdir = "report_summary";
		   dt.put( Key,  Parent,  Subdir );
		   
                   Key    = "detail";
                   Parent = "reports";
                   Subdir = "report_detail";
           dt.put( Key,  Parent,  Subdir );
		   
                   Key    = "auto";
                   Parent = "detail";
                   Subdir = "correlations_auto";
           dt.put( Key,  Parent,  Subdir );
           
                   Key    = "partial";
                   Parent = "detail";
                   Subdir = "correlations_partial";
           dt.put( Key,  Parent,  Subdir );
           
           System.out.println ("");
		   System.out.println ("Test_Add_Subdir_2 -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		
	}
	@Test
	public void Test_Chg_Subdir_1()
	{
		   String  Key    = "details";
		   String  Parent =  dt.get_Key_Rel_Base_Dir();
		   String  Subdir = "report_details";
		   dt.put( Key,  Parent,  Subdir );
		   
           
           System.out.println ( "" );
		   System.out.println ( "Test_Chg_Subdir_1 before Change --------------------");
		   System.out.println ( "" );
		   List_Subdirs       ( dt );
		   List_Parents       ( dt );
		   
		           Key    = "details";
		           Subdir = "report_details_new";
		   dt.set_Subdir(Key, Subdir );
		   

           
           System.out.println ("");
		   System.out.println ("Test_Chg_Subdir_1 after Change ---------------------");
		   System.out.println ("");
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		
	}
	@Test
	public void Test_Clone_Method()
	{
		   dt = create_6a_level();
		              
           System.out.println ("");
		   System.out.println ("Test_Clone_Method dt's contents--------------------");
		   System.out.println ("");
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		   
		   Directory_Triples dt_clone = dt.clone();  //test fails here! cannot cast to LHMSS

           System.out.println ("");
		   System.out.println ("Test_Clone_Method dt_clone's contents -------------");
		   System.out.println ("");
		   List_Subdirs  ( dt_clone );
		   List_Parents  ( dt_clone );
		
	}
	@Test
	public void Test_Clone_With_Different_Values()
	{
		   dt = create_6a_level();
           
           System.out.println ("");
		   System.out.println ("Test_Clone_With_Different_Values dt's contents(0)--------------------");
		   System.out.println ("");
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		   
		   Directory_Triples dt_clone = dt.clone();

           System.out.println ("");
		   System.out.println ("Test_Clone_With_Differenrt_Values dt_clone's contents(0) ------------");
		   System.out.println ("");
		   List_Subdirs  ( dt_clone );
		   List_Parents  ( dt_clone );
		   
		   String  Key    = "details";
		   String  Subdir = "report_details_1";
		   dt_clone.set_Subdir(Key, Subdir );   // change the clone instance
		   
		   System.out.println ("");
		   System.out.println ("Test_Clone_With_Different_Values dt's contents(1)-------------------");
		   System.out.println ("");
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		   
	       System.out.println ("");
		   System.out.println ("Test_Clone_With_Differenrt_Values dt_clone's contents(1) ------------");
		   System.out.println ("");
		   List_Subdirs  ( dt_clone );
		   List_Parents  ( dt_clone );
			   
		   Key    = "auto";
		   Subdir = "corr_auto";
		   dt.set_Subdir(Key, Subdir);      // change the original instance
		   
		   Key    = "partial";
		   Subdir = "corr_partial";      
		   dt.set_Subdir(Key, Subdir);      // change the original instance
		   
		   System.out.println ("");
		   System.out.println ("Test_Clone_With_Different_Values dt's contents(2)-------------------");
		   System.out.println ("");
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		   
	       System.out.println ("");
		   System.out.println ("Test_Clone_With_Differenrt_Values dt_clone's contents(2) ------------");
		   System.out.println ("");
		   List_Subdirs  ( dt_clone );
		   List_Parents  ( dt_clone );		   
	}
	@Test
	public void Test_Remove_Bottom_Level_Subdir()
	{
		   dt = create_6a_level();
           
           String     Key = "auto";
           System.out.println ("");
		   System.out.println ("Test_Remove_Bottom_Level_Subdir (before removal of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		   
		                 
		                     
		   dt.remove_Subdir( Key );
		   
           
           System.out.println ("");
		   System.out.println ("Test_Remove_Bottom_Level_Subdir (after  removal of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
	}
	@Test
	public void Test_Remove_Middle_Level_Subdir()
	{
		   dt = create_6a_level();
		   
           String Key = "details";
           System.out.println ("");
		   System.out.println ("Test_Remove_Middle_Level_Subdir (before removal of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		   
		                                   
		   dt.remove_Subdir( Key );
		   
           
           System.out.println ("");
		   System.out.println ("Test_Remove_Middle_Level_Subdir (after  removal of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
	}
	@Test
	public void Test_No_Parent_Add_Attempt()
	{
		   dt = create_6a_level();
		   
		   String  Key    = "orphan";
		   String  Parent = "parent_1";
		   String  Subdir = "annie";
         
           System.out.println ("");
		   System.out.println ("Test_No_Parent_Add_Attempt (before attempted add of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		   
           
		   try      {dt.put( Key,  Parent,  Subdir );
		            }
		   catch    (IllegalArgumentException  e   )
		            {
			         System.out.println ( "put of >"
			        		            +  Key
			        		            + "< failed because: >"
			        		            +  e.getMessage()
			        		            + "<"
			        		            );
		            }

           System.out.println ("");
		   System.out.println ("Test_No_Parent_Add_Attempt (after  attempted add of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
	}
	@Test
	public void Test_Duplicate_Sub_Directory_For_Parent_Add_Attempt()
	{
		   dt = create_6a_level();
		   
		   String  Key    = "duplicate";
		   String  Parent = "family";
		   String  Subdir = "request_01";
         
           System.out.println ("");
		   System.out.println ("Test_Duplicate_Sub_Directory_For_Parent_Add_Attempt (before attempted add of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
		   
           
		   try      { dt.put( Key,  Parent,  Subdir );
		            }
		   catch    ( IllegalArgumentException  e   )
		            {
			          System.out.println ( "put of >"
                                         +  Key
			        		             + "< failed because: >"
			        		             +  e.getMessage()
			        		             + "<"
			        		             );
		            }

           System.out.println ("");
		   System.out.println ("Test_Duplicate_Sub_Directory_For_Parent_Add_Attempt (after  attempted add of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   List_Subdirs  ( dt );
		   List_Parents  ( dt );
	}
	protected Directory_Triples create_6a_level()
	{
	          Directory_Triples  d       =   new  Directory_Triples( "family" 
	        		                                               , "appl_amzn_qcom"
	        		                                               );
	          
//	          String  Default_Parent     =   d.get_Key_Rel_Base_Dir();
//	          
//	          System.out.println ( "" );
//	          System.out.println ( "Default_Parent = >"
//	        		             +  Default_Parent
//	        		             + "<"
//	        		             );
//	          System.out.println ( "" );
//	          
//			  System.out.println ( "" );
//			  List_Keys          ( dt );
//			  List_Subdirs       ( dt );
//			  List_Parents       ( dt );

			   
			  String             Key     =  "request";
			  String             Parent  =  "family";
			  String             Subdir  =  "request_01";
			                     d       .   put( Key,  Parent,  Subdir );
			   
			                     Key     =  "details";
			                     Parent  =  "request";
			                     Subdir  =  "report_details";
			                     d       .   put( Key,  Parent,  Subdir );
			   
			                     Key     =  "summary";
			                     Parent  =  "request";
			                     Subdir  =  "report_summary";
			                     d       .   put( Key,  Parent,  Subdir );
			   
	                             Key     =  "auto";
	                             Parent  =  "details";
	                             Subdir  =  "correlations_auto";
	                             d       .   put( Key,  Parent,  Subdir );
	           
	                             Key     =  "partial";
	                             Parent  =  "details";
	                             Subdir  =  "correlations_partial";
	                             d       .   put( Key,  Parent,  Subdir );
	          
	 return                      d;
	}
	public void List_Keys( final  Directory_Triples  dt )
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
