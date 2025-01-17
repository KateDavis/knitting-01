package com.knitting.jamacoi;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Directory_Triples {
	        Directory_Triples   dt;
	final   String              default_key     =  "Rel_Base_Dir";
	final   String              default_parent  =  "-1";
	final   String              family          =  "family";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	dt = new Directory_Triples ( family );
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Test_List_Keys()
	{
		             List_Keys  ( dt );
		             assertTrue ( dt.get_Size_Key_Parent() == 1 );
		             assertTrue ( dt.get_Size_Key_Subdir() == 1 );
		             assertTrue ( dt.containsKey    ( default_key    )  );
		             assertTrue ( dt.get_Subdir     ( default_key    ).equals(family)  );
	}
	@Test
	public void Test_List_Subdirs()
	{
		          dt.List_Subdirs();
	}
	@Test
	public void Test_List_Parents()
	{
		          dt.List_Parents();
	}
	@Test
	public void Test_Get_Key_Rel_Base_Dir()
	{
		   String  Parent =  dt.get_Key_Rel_Base_Dir();
		   
		   System.out.println ( "Key = >"
				              +  Parent
				              + "< of the top Sub-Directory"
				              );
	}
	@Test
	public void Test_Add_Subdir_1()
	{
		   String  Subdir = "appl_amzn_qcom";
		   String  Key    = "request";
		   String  Parent =  dt.get_Key_Rel_Base_Dir(); 

		   dt.put( Subdir,  Key,  Parent );
		   
		   System.out.println ("");
		   System.out.println ("Test_Add_Subdir_1 -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   dt.List_Subdirs();
		   dt.List_Parents();
           assertTrue ( dt.get_Size_Key_Parent() == 2 );
           assertTrue ( dt.get_Size_Key_Subdir() == 2 );
           assertTrue ( dt.containsKey    ( Key  )  );
           assertTrue ( dt.containsParent (Parent)  );
           assertTrue ( dt.get_Subdir     ( Key  )  . equals(Subdir)  );
	}
	@Test
	public void Test_Add_Subdir_2()
	{
		   String  Subdir = "report_dir";
		   String  Key    = "reports";
		   String  Parent =  dt.get_Key_Rel_Base_Dir(); 
		   dt.put( Subdir,   Key,  Parent );
		   
                   Subdir = "report_summary";   
		           Key    = "summary";
		           Parent = "reports";
		   dt.put( Subdir,  Key,  Parent );
		   
                   Subdir = "report_detail";
                   Key    = "detail";
                   Parent = "reports";
           dt.put( Subdir,  Key,  Parent );
		   
                   Subdir = "correlations_auto";
                   Key    = "auto";
                   Parent = "detail";
           dt.put( Subdir,  Key,  Parent );
           
                   Subdir = "correlations_partial";
                   Key    = "partial";
                   Parent = "detail";
           dt.put( Subdir,  Key,  Parent );
           
           System.out.println ("");
		   System.out.println ("Test_Add_Subdir_2 -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   dt.List_Subdirs();
		   dt.List_Parents();
		   assertTrue ( dt.get_Size_Key_Parent() == 6 );
           assertTrue ( dt.get_Size_Key_Subdir() == 6 );
		
	}
	@Test
	public void Test_Chg_Subdir_1()
	{
		   String  Subdir = "report_details";
		   String  Key    = "details";
		   String  Parent =  dt.get_Key_Rel_Base_Dir();
		   dt.put( Subdir,  Key,  Parent );
		   
           
           System.out.println ( "" );
		   System.out.println ( "Test_Chg_Subdir_1 before Change --------------------");
		   System.out.println ( "" );
		   dt.List_Subdirs();
		   dt.List_Parents();
		   assertTrue ( dt.get_Size_Key_Parent() == 2 );
           assertTrue ( dt.get_Size_Key_Subdir() == 2 );
           assertTrue ( dt.containsKey    ( Key  )  );
           assertTrue ( dt.containsParent (Parent)  );
           assertTrue ( dt.get_Subdir     ( Key  )  . equals(Subdir)  );
		   
           Subdir = "report_details_new";
           Key    = "details";
		   dt.set_Subdir( Subdir,  Key);
		   

           
           System.out.println ("");
		   System.out.println ("Test_Chg_Subdir_1 after Change ---------------------");
		   System.out.println ("");
		   dt.List_Subdirs();
		   dt.List_Parents();
		   assertTrue ( dt.get_Size_Key_Parent() == 2 );
           assertTrue ( dt.get_Size_Key_Subdir() == 2 );
           assertTrue ( dt.containsKey    ( Key  )  );
           assertTrue ( dt.containsParent (Parent)  );
           assertTrue ( dt.get_Subdir     ( Key  )  . equals(Subdir)  );
		
	}
	@Test
	public void Test_Clone_Method()
	{
		   dt = create_6a_level();
		              
           System.out.println ("");
		   System.out.println ("Test_Clone_Method dt's contents--------------------");
		   System.out.println ("");
		   dt.List_Subdirs();
		   dt.List_Parents();
		   
		   Directory_Triples dt_clone = dt.clone();  //test fails here! cannot cast to LHMSS

           System.out.println ("");
		   System.out.println ("Test_Clone_Method dt_clone's contents -------------");
		   System.out.println ("");
		   dt_clone.List_Subdirs();
		   dt_clone.List_Parents();
		
	}
	@Test
	public void Test_Clone_With_Different_Values()
	{
		   dt = create_6a_level();
           
           System.out.println ("");
		   System.out.println ("Test_Clone_With_Different_Values dt's contents(0)--------------------");
		   System.out.println ("");
		   dt.List_Subdirs();
		   dt.List_Parents();
		   assertTrue ( dt.get_Size_Key_Parent() == 6 );
           assertTrue ( dt.get_Size_Key_Subdir() == 6 );
		   
		   Directory_Triples dt_clone = dt.clone();

           System.out.println ("");
		   System.out.println ("Test_Clone_With_Differenrt_Values dt_clone's contents(0) ------------");
		   System.out.println ("");
		   dt_clone.List_Subdirs();
		   dt_clone.List_Parents();
		   assertTrue ( dt_clone.get_Size_Key_Parent() == 6 );
           assertTrue ( dt_clone.get_Size_Key_Subdir() == 6 );
		   
		   String  Subdir = "report_details_11111";
		   String  Key    = "details";
		   String  Subdir_Old = dt_clone.set_Subdir(Subdir, Key );   // change the clone instance
		   
		   System.out.println ("");
		   System.out.println ("Test_Clone_With_Different_Values dt's contents(1)-------------------");
		   System.out.println ("");
		   dt.List_Subdirs();
		   dt.List_Parents();
		   assertTrue ( dt.get_Size_Key_Parent() == 6 );
           assertTrue ( dt.get_Size_Key_Subdir() == 6 );
           assertTrue ( dt_clone.containsKey    ( Key  )  );
           assertTrue ( dt_clone.get_Subdir     ( Key  )  . equals( Subdir )  );
		   
	       System.out.println ("");
		   System.out.println ("Test_Clone_With_Differenrt_Values dt_clone's contents(1) ------------");
		   System.out.println ("");
		   System.out.println ("For key = >" + Key + "<  Subdir_Old = >" + Subdir_Old + "<" );
		   System.out.println ("For key = >" + Key + "<  Subdir New = >" + Subdir     + "<" );
		   System.out.println ("");
		   dt_clone.List_Subdirs();
		   dt_clone.List_Parents();
		   assertTrue ( dt_clone.get_Size_Key_Parent() == 6 );
           assertTrue ( dt_clone.get_Size_Key_Subdir() == 6 );
           assertTrue ( dt_clone.containsKey    ( Key  )  );
           assertTrue ( dt_clone.get_Subdir     ( Key  )  . equals(Subdir)  );
			   
		   Subdir = "corr_auto";
		   Key    = "auto";
		   dt.set_Subdir(Subdir, Key);      // change the original instance
		   
		   Subdir = "corr_partial";  
		   Key    = "partial";
		   dt.set_Subdir(Subdir, Key);      // change the original instance
		   
		   System.out.println ("");
		   System.out.println ("Test_Clone_With_Different_Values dt's contents(2)-------------------");
		   System.out.println ("");
		   dt.List_Subdirs();
		   dt.List_Parents();
		   
	       System.out.println ("");
		   System.out.println ("Test_Clone_With_Differenrt_Values dt_clone's contents(2) ------------");
		   System.out.println ("");
		   dt_clone.List_Subdirs();
		   dt_clone.List_Parents();		   
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
		   dt.List_Subdirs();
		   dt.List_Parents();
		   
		                 
		                     
		   dt.remove_Subdir( Key );
		   
           
           System.out.println ("");
		   System.out.println ("Test_Remove_Bottom_Level_Subdir (after  removal of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   dt.List_Subdirs();
		   dt.List_Parents();
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
		   dt.List_Subdirs();
		   dt.List_Parents();
		   
		                                   
		   dt.remove_Subdir( Key );
		   
           
           System.out.println ("");
		   System.out.println ("Test_Remove_Middle_Level_Subdir (after  removal of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   dt.List_Subdirs();
		   dt.List_Parents();
	}
	@Test
	public void Test_No_Parent_Add_Attempt()
	{
		   dt = create_6a_level();
		   
		   String  Subdir = "annie";
		   String  Key    = "orphan";
		   String  Parent = "parent_1";
         
           System.out.println ("");
		   System.out.println ("Test_No_Parent_Add_Attempt (before attempted add of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   dt.List_Subdirs();
		   dt.List_Parents();
		   
           
		   try      {dt.put( Subdir,  Key,  Parent );
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
		   dt.List_Subdirs();
		   dt.List_Parents();
	}
	@Test
	public void Test_Duplicate_Sub_Directory_For_Parent_Add_Attempt()
	{
		   dt = create_6a_level();
		   
		   String  Subdir = "request_01";
		   String  Key    = "duplicate";
		   String  Parent = "family";
         
           System.out.println ("");
		   System.out.println ("Test_Duplicate_Sub_Directory_For_Parent_Add_Attempt (before attempted add of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   dt.List_Subdirs();
		   dt.List_Parents();
		   
           
		   try      { dt.put(  Subdir,  Key,  Parent );
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
		   dt.List_Subdirs();
		   dt.List_Parents();
	}
	@Test
	public void Test_Duplicate_Sub_Directory_For_Non_Parent_Add_Attempt()
	{
		   dt = create_6a_level();
		   
		   String  Subdir = "report_summary";
		   String  Key    = "test";
		   String  Parent = "family";
         
           System.out.println ("");
		   System.out.println ("Test_Duplicate_Sub_Directory_For_Non_Parent_Add_Attempt (before attempted add of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   dt.List_Subdirs();
		   dt.List_Parents();
		   
           
		   try      { dt.put( Subdir,  Key,  Parent );
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
		   System.out.println ("Test_Duplicate_Sub_Directory_For_Non_Parent_Add_Attempt (after  attempted add of Key = >"
				              + Key
				              + "< ) -------------------------------");
		   System.out.println ("");
		   List_Keys     ( dt );
		   dt.List_Subdirs();
		   dt.List_Parents();
	}
	protected Directory_Triples create_6a_level()
	{
	          Directory_Triples  d       =   new  Directory_Triples( "appl_amzn_qcom"
	        		                                               , "family" 
	        		                                               );
			   
			  String             Subdir  =  "request_01";
			  String             Key     =  "request";
			  String             Parent  =  "family";
			                     d       .   put( Subdir,  Key,  Parent );
			   
			                     Subdir  =  "report_details";
			                     Key     =  "details";
			                     Parent  =  "request";
			                     d       .   put( Subdir,  Key,  Parent );
			   
			                     Subdir  =  "report_summary";
			                     Key     =  "summary";
			                     Parent  =  "request";
			                     d       .   put( Subdir,  Key,  Parent );
			   
		                         Subdir  =  "correlations_auto";
		                         Key     =  "auto";
	                             Parent  =  "details";
	                             d       .   put( Subdir,  Key,  Parent );
	           
	                             Subdir  =  "correlations_partial";
	                             Key     =  "partial";
	                             Parent  =  "details";
	                             d       .   put( Subdir,  Key,  Parent );
	                             
	          check_6a_level   ( d );
	          
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
	void check_6a_level( final  Directory_Triples  d )
	{
		   assertTrue ( d.get_Size_Key_Parent() == 6 );
           assertTrue ( d.get_Size_Key_Subdir() == 6 );
	       
	       check_for_Key_Subdir ( "appl_amzn_qcom"        ,"family"   ,d );
	       check_for_Key_Subdir ( "request_01"            ,"requestx" ,d );
	       check_for_Key_Subdir ( "report_details"        ,"details"  ,d );
	       check_for_Key_Subdir ( "report_summary"        ,"summary"  ,d );
	       check_for_Key_Subdir ( "correlations_auto"     ,"auto"     ,d );
	       check_for_Key_Subdir ( "correlations_partial"  ,"partial"  ,d );
	}
	void check_for_Key_Subdir ( final  String             Subdir
			                  , final  String             Key
			                  , final  Directory_Triples  d
			                  )
	{
		   String     msg = "does NOT contain key = >"
			              +  Key
			              + "<";
	       assert       d.containsKey    ( Key  )  : msg;
	    		     
	       assertTrue ( d.get_Subdir     ( Key  )  . equals( Subdir )  );
	}
	
}
