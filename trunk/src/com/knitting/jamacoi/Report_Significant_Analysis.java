package com.knitting.jamacoi;

import java.io.FileWriter;
import java.util.Formatter;

public class    Report_Significant_Analysis {
	   private  Regression  r;
	   private  FileWriter  Rpt_Detail;

public Report_Significant_Analysis( Regression  r
		                          , FileWriter  Rpt_Detail
		                          ) 
       {
	   this.r           = r;
	   this.Rpt_Detail  = Rpt_Detail;
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

         Result_Tree rt = fdt.build_Result_Tree( r.get_R_d_of_freedom()
                                               , r.get_X_d_of_freedom()
                                               );
         
                     rt.compare_reg_with_data  ( Rpt_Detail
                                               , r.get_R_d_of_freedom()
                                               , r.get_X_d_of_freedom()
                                               , r.get_F_value()
                                               );  
        } 
  catch (Exception e)
        { 
         System.out.println ( "Exception was caught:");
        }  
	
		
	}
}