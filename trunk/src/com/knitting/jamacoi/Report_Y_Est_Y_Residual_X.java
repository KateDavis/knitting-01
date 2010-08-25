package com.knitting.jamacoi;

import java.io.FileWriter;
import java.util.Formatter;

public   class       Report_Y_Est_Y_Residual_X
         extends     Report_Abstract
{
public               Report_Y_Est_Y_Residual_X( Regression  r
                                              , Sub_Matrix  sub_matrix
                                              , FileWriter  Rpt_Detail
                                              )	
         throws      java.io.IOException{
         super     ( r
		           , sub_matrix
		           , Rpt_Detail
		           );
}
public   void        write_details()
         throws      java.io.IOException
{

get_Rpt_Detail().write( fmt_line_01() ); 
get_Rpt_Detail().write( fmt_line_02() ); 
get_Rpt_Detail().write( fmt_line_03() );
loop_thru_rows  ();
}
protected  String      fmt_line_01(){
Formatter  line =  new Formatter();
           line .  format("%n%n%s%n"
                         ,"1) Y, est_Y, residual, X matrix contents ========"
                         ); 
return     line .  toString();
}
protected  String     fmt_line_02(){
Formatter  line = new Formatter();
  	       line . format( "    %10s  %4s"
	                    , "Row-ID"
	                    , "Time"
	                    );           
	       line . format( "%15s", "Y"           );
	       line . format( "%15s", "Estimated Y" );
	       line . format( "%15s", "Residual"    );
	 for  (int    ic  = 0
	      ;       ic  < ( get_Regression().get_YX_max_cols() - 1 )
	      ;     ++ic
	      )
	      {
	       line . format( "%13s%02d"
	                    , "X"
	                    , (ic + 1)
	                    );
	      }
	       line . format( "%n");
return     line . toString();	 
}
protected  String     fmt_line_03(){
Formatter  line = new Formatter();
    
	       line . format( "    %10s  %4s"
	                    , "----------"
	                    , "----"
	                    );
	 for  (int  ic  = 0
	      ;     ic  < ( 2 + get_Regression().get_YX_max_cols() )
	      ;   ++ic
	      )
	      {
	       line . format( "%15s"
	                    , "------------"
	                    );
	      }
	       line . format( "%n");
return     line . toString();	 
}
protected  void      loop_thru_rows()
           throws    java.io.IOException
{
	 for  (int   ir  = 0
	      ;      ir  < get_Regression().get_YX_max_rows()
	      ;    ++ir
	      )
	      {
Formatter  line = new Formatter();
	        
	       line . format( "    %s   %03d"
	                    , get_Sub_Matrix().get_row_id(ir)
	                    , ( ir + 1 )
	                    );       
	       line . format( "%15.5E", get_Regression().get_YX_cell       (ir, 0) );
	       line . format( "%15.5E", get_Regression().get_est_Y_residual(ir, 0) );
	       line . format( "%15.5E", get_Regression().get_est_Y_residual(ir, 1) );
	       line . format( "%s%n", fmt_cells(ir) );
           get_Rpt_Detail().write( line.toString() );
	      }
}
protected  String  fmt_cells(int ir){
Formatter  line =  new Formatter();	
      for (int   ic  = 1
          ;      ic  < get_Regression().get_YX_max_cols()
          ;    ++ic
          )
          {
           line . format( "%15.5E"
                        ,  get_Regression().get_YX_cell(ir, ic)
                        );
          }
return     line . toString();    
}
}
