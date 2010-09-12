package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public      class    Report_Covariance_Matrix 
            extends  Report_Abstract 
{
public               Report_Covariance_Matrix( Regression r
		                                     , Sub_Matrix subMatrix
		                                     , FileWriter Rpt_Detail
		                                     ) 
            throws   IOException 
{
		             super( r 
		            	  , subMatrix
		            	  , Rpt_Detail
		            	  );
}

@Override
public      void     write_details() 
            throws   IOException
                 ,   not_estimated
{
            get_Rpt_Detail() .   write( fmt_line_01() );
            get_Rpt_Detail() .   write( fmt_line_02() );
            get_Rpt_Detail() .   write( fmt_line_03() );
            loop_thru_rows();

}
@Override
public     void    write_headers()
           throws  IOException
                ,  not_estimated
                {;}
public      String   fmt_line_01(){
Formatter   line =   new Formatter();
	 
	        line .   format( "%n%n%s%n"
	                       , "5) Covariance Matrix Report ===================================="
	                       );
return      line .   toString();	        
}
protected  String  fmt_line_02(){
Formatter  line = new Formatter();

	 for  (int   ic  =  1
		  ;      ic  < get_Regression().get_YX_max_cols()
		  ;    ++ic
		  )
		  {
		   line . format( "%15s"
		                , get_Sub_Matrix().get_name_security(ic)
		                );
		 }
		   line . format( "%n");	
return     line . toString();	
}
protected  String  fmt_line_03(){
	
Formatter  line = new Formatter();


	 for  (int   ic  = 1
	   	  ;      ic  < get_Regression().get_YX_max_cols()
		  ;    ++ic
		  )
		  {
		   line . format( "%15s"
		                , get_Sub_Matrix().get_name_lag(ic)
		                );
		  }
		   line . format( "%n");
return     line . toString();	  
}
protected   void    loop_thru_rows()
            throws  java.io.IOException
{
for ( int   ir    = 0
	;       ir    < get_Regression().get_p_XX_dev_rows()
	;     ++ir
	)
	{ 
Formatter 	line  = new Formatter();

            line  . format( "%s%n"
            		      ,  loop_thru_cols( ir ) 
            		      );

	        get_Rpt_Detail().write(line.toString() );
	 }
}
protected  String     loop_thru_cols( int  ir )
{
Formatter  line = new Formatter();	
for ( int  ic   = 0
    ;      ic   < get_Regression().get_p_XX_dev_cols()
    ;    ++ic
    )
	{
		   line . format( "%15.5E"
		                , get_Regression().get_p_XX_dev_cell(ir, ic)
		                );
    }
return     line . toString();
}
}
