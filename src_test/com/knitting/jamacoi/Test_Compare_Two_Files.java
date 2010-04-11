package com.knitting.jamacoi;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class   Test_Compare_Two_Files {
	
static String  File_Separator       = "/";  //File.pathSeparator;
	
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
       
       Compare_Two_Files c_e;
       Compare_Two_Files c_m;

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
                
   		   File_Existing_Actual     =  Dir__Actual_Full
                                    +  File_Separator
                                    +  File_Name;

   		   File_Existing_Expected   =  Dir__Expected_Full
                                    +  File_Separator
                                    +  File_Name;

           File_Difference          =  Dir__Difference_Full
                                    +  File_Separator
                                    +  File_Name;
           
  		   File_Missing__Actual     =  Dir__Actual_Full
                                    +  File_Separator
                                    +  File_Name_Missing;
  		   
  		   File_Missing__Expected   =  Dir__Expected_Full
                                    +  File_Separator
                                    +  File_Name_Missing;
  		   
           c_e                      =  new  Compare_Two_Files 
        		                    (  File_Existing_Expected
                                    ,  File_Existing_Actual
                                    ,  File_Difference
                                    )  ;
           
           c_m                      =  new  Compare_Two_Files 
                                    (  File_Missing__Expected
                                    ,  File_Missing__Actual
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
        
		    System.out.println   ( "Dir__Difference_Full .... = >"
                                 +  Dir__Difference_Full
                                 + "<"
                                 ) ;
	}
	private void show_File_Existing_Actual(){
		
            System.out.println   ( "File_Existing_Actual .... = >"
                                 +  File_Existing_Actual
                                 + "<"
                                 ) ;
	}
	private void show_File_Existing_Expected(){
		
            System.out.println   ( "File_Existing_Expected .. = >"
                                 +  File_Existing_Expected
                                 + "<"
                                 ) ;
	}
	private void show_File_Missing__Actual() {
		
            System.out.println   ( "File_Missing__Actual .... = >"
                                 +  File_Missing__Actual
                                 + "<"
                                 ) ;		
	}
	private void show_File_Difference(){
		
            System.out.println   ( "File_Difference ......... = >"
                                 +  File_Difference
                                 + "<"
                                 ) ;
	}
	@After
	public void tearDown() throws Exception {
	}
    @Test
    public void test_Show_Info() {
		   show_Dir__Actual_Full    ();
   		   show_Dir__Expected_Full  ();
   		   show_Dir__Difference_Full();	
   		   
   		   show_File_Existing_Actual();
   		   show_File_Existing_Expected();
   		   show_File_Difference();
   		   
   		   show_File_Missing__Actual();
    }
	@Test
	public void testGet_Dir_Actaul(){

		assertTrue ( c_e.exists_Expected() );
		assertTrue ( c_e.exists_Actual  () );	
	}
	@Test
	public void test_02_file_exists_expected(){

		assertTrue ( c_e.exists_Expected() );
	}
	@Test
	public void test_03_file_exists_actual(){

		assertTrue ( c_m.exists_Actual  () );
	}
	@Test
	public void test_04_file_missing_actual(){

		assertTrue ( c_m.exists_Actual  () );
	}

}
