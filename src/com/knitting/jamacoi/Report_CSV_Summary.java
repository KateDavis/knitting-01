package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

public   class    Report_CSV_Summary 
         extends  Report_Abstract 
{
public            Report_CSV_Summary ( Regression  r
                                     , Sub_Matrix  subMatrix
                                     , FileWriter  Rpt_Summary
		                             )
         throws   IOException
{
         super  ( r 
      	        , subMatrix
      	        , Rpt_Summary
      	        );	
}

@Override
public     void     write_details() 
           throws   IOException
           ,        not_estimated 
{
	       get_Rpt() . write( fmt_line_01() );
}
protected  String   fmt_line_01()
           throws   not_estimated
{
	 Formatter line      = new Formatter();
     
	 ArrayList<Double> c =     get_Regression().get_Estimated_Coefficients();  
	 line . format("%4d,%4d,"
	              , get_Sub_Matrix().get_row_source_first()
	              , get_Sub_Matrix().get_row_source_last ()
	              );       
	   
	 line . format("%12.5E,"
	              , get_Regression().get_Estimated_Intercept()
	              );       
	 int  ix;
	 int  ix_max = c.size();
	 for (ix     = 0
	     ;ix     < ix_max
	     ;ix++
	     )
	     {
	                 line . format("%12.5E,"
	                              ,c.get(ix)
	                              );   
	     }  
	 line . format("%5.2f,"
	              , get_Regression().get_Pct_Error_Explained()
	              );
	 int   ir;
	 int   ic;
	 
	 for ( ir    = 0
	     ; ir    < get_Regression().get_p_XX_dev_adjusted_rows()
	     ; ir++
	     )
	     {
	       for ( ic   = ir
	           ; ic   < get_Regression().get_p_XX_dev_adjusted_cols()
	           ; ic++
	           )
	           {
	             line . format( "%12.5E,"
	                          , get_Regression().get_p_XX_dev_adjusted_cell(ir, ic)
	                          );
	           }
	      }  
	 line . format ( "%n" );	
return     line . toString();	 
}

}
