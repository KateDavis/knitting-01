package com.knitting.jamacoi;

import java.io.FileWriter;
import java.util.Formatter;

public class    Report_Significant_Analysis {
	   private  FileWriter  Rpt_Detail;
	   private  int         R_d_of_freedom;
	   private  int         X_d_of_freedom;
	   private  double      f_value;
	

public Report_Significant_Analysis( FileWriter  Rpt_Detail
		                          , int         R_d_of_freedom
		                          , int         X_d_of_freedom
		                          , double      f_value
		                          ) 
       {
	   this.Rpt_Detail     = Rpt_Detail;
	   this.R_d_of_freedom = R_d_of_freedom;
	   this.X_d_of_freedom = X_d_of_freedom;
	   this.f_value        = f_value;
	   }
	
public void   get() 
       throws not_estimated
            , not_invertable
            , not_significant 
            , java.io.IOException
{
  Formatter line_1  = new Formatter();
  try   {
         line_1.format("%n%n%s"
                      ,"4) Significant Analysis Report  =(New Class/method)===="
                      );
         Rpt_Detail.write(line_1.toString());

         Table_of_F_Tables  fdt = new Table_of_F_Tables();

         Result_Tree rt = fdt.build_Result_Tree( R_d_of_freedom
                                               , X_d_of_freedom
                                               ) ;
         
                     rt . compare_reg_with_data( Rpt_Detail
                                               , R_d_of_freedom
                                               , X_d_of_freedom
                                               , f_value
                                               ) ;  
        } 
  catch (Exception e)
        { 
         System.out.println ( "Exception was caught:");
        }  
	
		
	}
}