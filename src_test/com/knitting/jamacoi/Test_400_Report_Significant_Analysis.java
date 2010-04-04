package com.knitting.jamacoi;

import static org.junit.Assert.assertNotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class   Test_400_Report_Significant_Analysis {
static private boolean     concatentate_true    = true ;	
static private boolean     concatentate_false   = false;
static private String      test_name            = "Test_400_not_significant.txt";

static private String      file_name_expected   = "expected/"
	                                            +  test_name;

static private String      file_name_actual_2   = "actual/"
                                                +  test_name;

static private String      file_name_actual     = "C:/Temp/actual"	
	                                            + "/"
	                                            + test_name;
static private FileWriter  Rpt       ;
	   private FileWriter  Rpt_Detail;
	   private FileWriter  Rpt_Detail_2;
	   
    @BeforeClass
    public static void setUpBeforeClass() 
           throws Exception            {
    	   Rpt  = new FileWriter       ( file_name_actual
                                       , concatentate_false
                                       );
    	   Rpt  . close();
		}

	@Before
	public void   setUp     () 
	       throws Exception {
		   Rpt_Detail  = new FileWriter( file_name_actual
                                       , concatentate_true
                                       );
	}

	@After
	public void   tearDown   () 
	       throws Exception  {
		   Rpt_Detail . close();
	}
	@Test
	public void   test_400_not_significant_Get()   {
		   int    r_d_of_freedom             =  3  ;
		   int    y_d_of_freedom             = 10  ;
		   double f_value                    =  2.5;
		   Report_Significant_Analysis  rsa  =  new
		   Report_Significant_Analysis       (  Rpt_Detail
				                             ,  r_d_of_freedom
				                             ,  y_d_of_freedom
				                             ,  f_value
				                             )  ;
		   try   {
			      rsa.get();
		         } 
		   catch (not_estimated   e) {
		          // TODO Auto-generated catch block
			      e.printStackTrace();
                 } 
		   catch (not_invertable  e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
                 } 
		   catch (not_significant e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
                 } 
		   catch (IOException e    ) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
		         };
	}
	
	
	@Test
	public void test_400_01_exists_expected() throws Exception {
	
		InputStream   stream   = this.getClass()
		                             .getResourceAsStream(file_name_expected);
		assertNotNull(stream);
		
		Scanner               scanner = new Scanner( stream );
		while (               scanner . hasNextLine()
			  )
		      { String line = scanner . nextLine();
		        System.out.println(line);
		      }
		stream.close();	
	}
	@Test
	public void test_400_02_exists_actual_2() throws Exception {
	
		InputStream   stream   = this.getClass()
		                             .getResourceAsStream(file_name_actual_2);
		assertNotNull(stream);
		
		Scanner               scanner = new Scanner( stream );
		while (               scanner . hasNextLine()
			  )
		      { String line = scanner . nextLine();
		        System.out.println(line);
		      }
		stream.close();	
	}
}