package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class   Test_Report_Significant_Analysis {
static private boolean     concatentate_true    = true ;	
static private boolean     concatentate_false   = false;	
static private String      file_name            = "C:/Temp"	
	                                            + "/"
	                                            + "Test_Report_Significant_Analysis.txt";
static private FileWriter  Rpt       ;
	   private FileWriter  Rpt_Detail;
	   
    @BeforeClass
    public static void setUpBeforeClass() 
           throws Exception            {
    	   Rpt  = new FileWriter       ( file_name
                                       , concatentate_false
                                       );
		}

	@Before
	public void   setUp     () 
	       throws Exception {
		   Rpt_Detail  = new FileWriter( file_name
                                       , concatentate_true
                                       );
	}

	@After
	public void   tearDown   () 
	       throws Exception  {
		   Rpt_Detail . close();
	}

	@Test
	public void   test_not_significant_Get() {
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
	public void   test_significant_Get()     {
		   int    r_d_of_freedom             =  3  ;
		   int    y_d_of_freedom             = 10  ;
		   double f_value                    = 15.0;
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


}
