package com.knitting.jamacoi;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class   Test_Compare_Two_Files {
	
static String  File_Separator       = File.pathSeparator;
	
static String  File_Name            = "Test_400_not_significant.txt";
static String  File_Name_Missing    = "missing";

static String  Dir__Actual          = "actual";
static String  Dir__Expected        = "expected";
static String  Dir__Difference      = "difference";

       String  Dir__Actual_Full;
       String  Dir__Expected_Full;
       String  Dir__Difference_Full;
       
       String  File_Existing_Actual;
       String  File_Existing_Expected;
       
       String  File_Missing__Actual;
       String  File_Missing__Expected;
       
       String  File_Difference;
       
       Compare_Two_Files c;

	@BeforeClass
	public static void setUpBeforeClass  () throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
           URL  actual          = this       . getClass()
                                             . getResource(Dir__Actual    );
           Dir__Actual_Full     = actual     . getPath(); 
           
           URL  expected        = this       . getClass()
                                             . getResource(Dir__Expected  );
           Dir__Expected_Full   = expected   . getPath();
           
           URL  difference      = this       . getClass()
                                             . getResource(Dir__Difference);
           Dir__Difference_Full = difference . getPath();
           
   		   show_Dir__Actual_Full    ();
   		   show_Dir__Expected_Full  ();
   		   show_Dir__Difference_Full();
           
   		   File_Existing_Actual     =  Dir__Actual_Full
                                    +  File.pathSeparator
                                    +  File_Name;

   		   File_Existing_Expected   =  Dir__Expected_Full
                                    +  File.pathSeparator
                                    +  File_Name;

           File_Difference          =  Dir__Difference_Full
                                    +  File.pathSeparator
                                    +  File_Name;
           
           c                        =  new  Compare_Two_Files 
        		                    (  File_Existing_Expected
                                    ,  File_Existing_Actual
                                    ,  File_Difference
                                    )  ;

	}
	private void show_Dir__Expected_Full(){
		
            System.out.println   ( "Dir__Expected_Full ... = >"
                                 +  Dir__Expected_Full
                                 + "<"
                                 ) ;
	}
	private void show_Dir__Actual_Full()  {
		
		    System.out.println   ( "Dir__Actual_Full ..... = >"
                                 +  Dir__Actual_Full
                                 + "<"
                                 ) ;
	}
	private void show_Dir__Difference_Full(){
        
		    System.out.println   ( "Dir__Difference_Full . = >"
                                 +  Dir__Difference_Full
                                 + "<"
                                 ) ;
		
	}
	@After
	public void tearDown() throws Exception {
	}
 
	@Test
	public void testGet_Dir_Actaul(){

		assertTrue ( c.exists_Expected() );
		assertTrue ( c.exists_Actual  () );
		
	}
	   @Test
	    public void test_02_file_exists_expected(){

		assertTrue ( c.exists_Expected() );
   	
	    }

}
