package com.knitting.jamacoi;

//   org.eclipse.core.resources 
//   public interface IProject
//   IFile        if = getFile(String name) 
//   public interface IFile
//   InputStream  is =  getContents() 
//   String       n  = getName() 
//   IPath        fp = getFullPath() 
//   InputStream  is = getContents()
//   void              setContents  ( IFileState       source
//                                  , boolean          force
//                                  , boolean          keepHistory
//                                  , IProgressMonitor monitor
//                                  ) 


//
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class   Test_Compare_Two_Files {
	
static String  File_Separator       = "/";  //File.pathSeparator;

static String  Dir__Prefix          = "knitting-01/src_test/com/knitting/jamacoi/";
static String  File_Prefix          = "knitting-01/src_test/com/knitting/jamacoi/";

static String  File_Expected        = File_Prefix + "expected";
static String  File_Matches         = File_Prefix + "actual_matches";
static String  File_Dif_Line_01     = File_Prefix + "actual_no_match_line_01";
static String  File_Dif_Line_02     = File_Prefix + "actual_no_match_line_02";
static String  File_Dif_Line_03     = File_Prefix + "actual_no_match_line_03";
static String  File_Line_Missing    = File_Prefix + "actual_less_one_line";
static String  File_Line_Extra      = File_Prefix + "actual_plus_one_line";

static String  File_Name            = "Test_400_not_significant.txt";
static String  File_Name_Missing    = "missing";

static String  Dir__Actual          = Dir__Prefix + "expected";  // "actual";
static String  Dir__Expected        = Dir__Prefix + "expected";
static String  Dir__Difference      = Dir__Prefix + "difference";

       String  Dir__Actual_Full;
       String  Dir__Expected_Full;
       String  Dir__Difference_Full;
       
       String  Full_File_Actual;
       String  Full_File_Expected;
          
       String  Full_File_Difference;
       
       String  name;
       URL     url_this;
       URL     url_workspace;
       URL     url_actual;
       URL     url_expected;
       URL     url_difference;
       
       Compare_Two_Files c;

	@BeforeClass
	public static void setUpBeforeClass  () throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	    name        =  this.getClass().getSimpleName();
	    
	                   url_this       = this.getClass   ()
	                                        .getResource( name + ".class" );
	    assertNotNull( url_this );
	    	    
	                   url_workspace  = new URL( url_this     , "../../../../../");
	    assertNotNull( url_workspace );
	    
	                   url_actual     = new URL( url_workspace, Dir__Actual      );
	    assertNotNull( url_actual     );
	    
                       url_expected   = new URL( url_workspace, Dir__Expected    );
	    assertNotNull( url_expected   );
	    
                       url_difference = new URL( url_workspace, Dir__Difference  );
	    assertNotNull( url_difference );
	    

/**		
           URL  actual          = this       . getClass()
                                             . getResource(Dir__Actual    );
           Dir__Actual_Full     = actual     . getPath(); 
          
           URL  expected        = this       . getClass()
                                             . getResource(Dir__Expected  );
           Dir__Expected_Full   = expected   . getPath();
           
           URL  difference      = this       . getClass()
                                             . getResource(Dir__Difference);
           Dir__Difference_Full = difference . getPath();
                
   		   Full_File_Actual         =  Dir__Actual_Full
                                    +  File_Separator
                                    +  File_Name;

   		   Full_File_Expected       =  Dir__Expected_Full
                                    +  File_Separator
                                    +  File_Name;

           Full_File_Difference     =  Dir__Difference_Full
                                    +  File_Separator
                                    +  File_Name;
 **/
                      
	}
	private void show_Dir__Expected_Full(){
		
            System.out.println   ( "Dir__Expected_Full .... = >"
                                 +  Dir__Expected_Full
                                 + "<"
                                 ) ;
	}
	private void show_Dir__Actual_Full()  {
		
		    System.out.println   ( "Dir__Actual_Full ...... = >"
                                 +  Dir__Actual_Full
                                 + "<"
                                 ) ;
	}
	private void show_Dir__Difference_Full(){
        
		    System.out.println   ( "Dir__Difference_Full .. = >"
                                 +  Dir__Difference_Full
                                 + "<"
                                 ) ;
	}
	private void show_Full_File_Actual(){
		
            System.out.println   ( "Full_File_Actual ...... = >"
                                 +  Full_File_Actual
                                 + "<"
                                 ) ;
	}
	private void show_Full_File_Expected(){
		
            System.out.println   ( "Full_File_Expected .... = >"
                                 +  Full_File_Expected
                                 + "<"
                                 ) ;
	}
	private void show_Full_File_Difference(){
		
            System.out.println   ( "Full_File_Difference .. = >"
                                 +  Full_File_Difference
                                 + "<"
                                 ) ;
	}
	private void set_Full_File_Actual      (  String  Name  ){
	                 Full_File_Actual      =  Dir__Actual_Full
                                           +  File_Separator
                                           +  Name;
	}
	private void set_Full_File_Expected    (  String  Name  ){
	                 Full_File_Expected    =  Dir__Expected_Full
                                           +  File_Separator
                                           +  Name;
	}
    private void set_Full_File_Difference  (  String  Name  ){
	                 Full_File_Difference  =  Dir__Difference_Full
                                           +  File_Separator
                                           +  Name;
    }
    private void check_url_directory( URL url ){
    	
    	    File       f    = new File(   url.getFile() );
            assertTrue(f.exists     ());
            assertTrue(f.isDirectory());  	
    }
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void         test_01_show_info(){
   	     
		   System.out.println( "Class name ............. = >"
		                     + name
		                     + "<"
		                     );  
		
	       System.out.println( "url_this as string ....  = >"
                             +  url_this.toString()
                             + "<"
                             );	    
           System.out.println( "url_workspace as string  = >"
                             +  url_workspace .toString()
                             + "<"
                             );
           System.out.println( " " );

           System.out.println( "url_actual    as string  = >"
                             +  url_expected.toString()
                             + "<"
                             );  
           System.out.println( "url_actual    file name  =      >"
                             +  url_expected.getFile()
                             + "<"
                             ); 
           System.out.println( "url_actual    path name  =      >"
                             +  url_expected.getPath()
                             + "<"
                             );
           System.out.println( " " );

           System.out.println( "url_expected  as string  = >"
                             +  url_expected.toString()
                             + "<"
                             );  
           System.out.println( "url_expected  file name  =      >"
                             +  url_expected.getFile()
                             + "<"
                             ); 
           System.out.println( "url_expected  path name  =      >"
                             +  url_expected.getPath()
                             + "<"
                             ); 
           System.out.println( " " );

           System.out.println( "url_difference as string = >"
                             +  url_difference.toString()
                             + "<"
                             );  
           System.out.println( "url_difference file name =      >"
                             +  url_difference.getFile()
                             + "<"
                             ); 
           System.out.println( "url_difference path name =      >"
                             +  url_difference.getPath()
                             + "<"
                             ); 
           System.out.println( " " );

		
	}
    @Test
    public void         test_02_url_actual    (){ 
    	   check_url_directory( url_actual     );
    }
    @Test
    public void         test_03_url_expected  (){ 
    	   check_url_directory( url_expected   );
    }
    @Test
    public void         test_04_url_difference(){ 
    	   check_url_directory( url_difference );
    }
/**    
	@Test
	public void test_02_files_match (){
		
	  	   set_Full_File_Expected   ( File_Expected );
		   set_Full_File_Actual     ( File_Matches  );
		   set_Full_File_Difference ( File_Matches  );
		
		  show_Full_File_Expected   ();
		  show_Full_File_Actual     ();
		  show_Full_File_Difference ();
		  
		  File e = new File    ( Full_File_Expected   );
		  File a = new File    ( Full_File_Actual     );
		  File d = new File    ( Full_File_Difference );
		  
		  assertTrue  ( e.exists() );
		  assertTrue  ( a.exists() );
		  assertFalse ( d.exists() );
		
          c                         =  new  Compare_Two_Files 
                                            (  Full_File_Expected
                                            ,  Full_File_Actual
                                            ,  Full_File_Difference
                                            )  ;
		  assertTrue ( c.exists_Expected() );
		  assertTrue ( c.exists_Actual  () );
		  assertTrue ( c.equal_Files    () );
	}
	@Test
	public void test_03_files_Dif_Line_01 (){
		
	  	   set_Full_File_Expected   ( File_Expected     );
		   set_Full_File_Actual     ( File_Dif_Line_01  );
		   set_Full_File_Difference ( File_Dif_Line_01  );
		
		  show_Full_File_Expected   ();
		  show_Full_File_Actual     ();
		  show_Full_File_Difference ();
		  
		  File e = new File    ( Full_File_Expected   );
		  File a = new File    ( Full_File_Actual     );
		  File d = new File    ( Full_File_Difference );
		  
		  assertTrue  ( e.exists() );
		  assertTrue  ( a.exists() );
		  assertFalse ( d.exists() );
		
          c                         =  new  Compare_Two_Files 
                                            (  Full_File_Expected
                                            ,  Full_File_Actual
                                            ,  Full_File_Difference
                                            )  ;
		  assertTrue  ( c.exists_Expected() );
		  assertTrue  ( c.exists_Actual  () );
		  assertFalse ( c.equal_Files    () );
	}
**/	
}
