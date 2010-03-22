package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class   Test_Report_Significant_Analysis {
	   private boolean     concatentate = true;
	   private FileWriter  Rpt_Detail;

	@Before
	public void   setUp     () 
	       throws Exception {
		   Rpt_Detail  = new FileWriter( "C:/Temp"
                                       + "/"
                                       + "Test_Report_Significant_Analysis.txt"
                                       , concatentate
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
