package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public   class   Report_Significant_Analysis_2 
         extends Report_Abstract 
{
public           Report_Significant_Analysis_2 ( Regression r
                                               , Sub_Matrix subMatrix
                                               , FileWriter Rpt_Detail
                                               ) 
         throws  java.io.IOException
{
         super ( r 
      	       , subMatrix
      	       , Rpt_Detail
      	       );	
}
@Override
public     void    write_headers()
           throws  IOException
                ,  not_estimated
                {;}
@Override
public    void     write_details() 
          throws   IOException
{
Formatter    line_1  = new Formatter();
	  try   {
	         line_1.format("%n%n%s"
	                      ,"4) Significant Analysis Report  =(New Class 2/method)===="
	                      );
	         get_Rpt_Detail().write(line_1.toString());

	         Table_of_F_Tables  fdt = new Table_of_F_Tables();

	         Result_Tree rt = fdt.build_Result_Tree( get_Regression().get_R_d_of_freedom()
	                                               , get_Regression().get_X_d_of_freedom()
	                                               ) ;
	         
	                     rt . compare_reg_with_data( get_Rpt_Detail()
	                                               , get_Regression().get_R_d_of_freedom()
	                                               , get_Regression().get_X_d_of_freedom()
	                                               , get_Regression().get_F_value()
	                                               ) ;  
	        } 
	  catch (Exception e)
	        { 
	         System.out.println ( "Exception was caught:");
	        }  			
}	

}
