package com.knitting.jamacoi;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Compare_Two_Files {
	
static String  File_Name       = "Test_400_not_significant.txt";
static String  Dir__Actual     = "actual";
static String  Dir__Expected   = "expected";
static String  Dir__Difference = "difference";
static String  File_Separator  = File.pathSeparator;
       String  Dir__Actual_Full;
       String  Dir__Expected_Full;
       String  Dir__Difference_Full;

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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet_Dir_Actaul(){
		System.out.println          ( "Dir__Actual_Full ..... = >"
				                    +  Dir__Actual_Full
				                    + "<"
				                    ) ;
		
		System.out.println          ( "Dir__Expected_Full ... = >"
                                    +  Dir__Expected_Full
                                    + "<"
                                    ) ;
		
		String Full_File_Actual     =  Dir__Actual_Full
		                            +  File.pathSeparator
		                            +  File_Name;
		
		String Full_File_Expected   =  Dir__Expected_Full
                                    +  File.pathSeparator
                                    +  File_Name;
		
		String Full_File_Difference =  Dir__Difference_Full
                                    +  File.pathSeparator
                                    +  File_Name;
		
		Compare_Two_Files c         =  new Compare_Two_Files( Full_File_Expected
				                                            , Full_File_Actual
				                                            , Full_File_Difference
				                                            ) ;
		
		System.out.println          ( "Dir__Actual_Full for c = >"
			                        +  c.get_Dir_Actaul()
			                        + "<"
			                        ) ;
		
	}

}
