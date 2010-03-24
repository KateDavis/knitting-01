package com.knitting.jamacoi;

import static org.junit.Assert.assertNotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class   Test_400_Report_Significant_Analysis {
static private boolean     concatentate_true    = true ;	
static private boolean     concatentate_false   = false;

static private String      file_name_expected   = "expected/";

static private String      file_name_actual     = "C:/Temp/actual"	
	                                            + "/"
	                                            + "Test_400_not_significant.txt";
static private FileWriter  Rpt       ;
	   private FileWriter  Rpt_Detail;
	   
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
	public void testScottWillChangeMethodName() throws Exception {
		String filename = file_name_expected + "expected_file01.txt";
		InputStream stream = this.getClass().getResourceAsStream(filename);
		assertNotNull(stream);
		
		StringBuilder sb = new StringBuilder();
		byte[] bytes = new byte[4096];
		int len;
		while ((len = stream.read(bytes)) > 0) {
			sb.append(new String(bytes, 0, len));
		}
		System.out.println(sb);
		
	}
}
