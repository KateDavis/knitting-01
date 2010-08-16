package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public     class   Report_Covariance_Adjusted 
           extends Report_Abstract 
{
public             Report_Covariance_Adjusted( Regression  r
		                                     , Sub_Matrix  subMatrix
		                                     , FileWriter  Rpt_Detail
		                                     ) 
           throws  IOException {
		   super   ( r
				   , subMatrix
				   , Rpt_Detail
				   );
	}
@Override
public     void    write_details() 
           throws  IOException
                , not_estimated 
{
get_Rpt_Detail().write( fmt_line_01() );
loop_thru_rows();
}
protected  String  fmt_line_01(){
Formatter  line =  new Formatter();
	 
	       line .  format( "%n%n%s%n"
	                     , "6) Covariance Matrix Adjusted Report ==========================="
	                     );
return     line .  toString();	       
}
protected  void    loop_thru_rows()
           throws  java.io.IOException
{
for (int   ir    = 0
	;      ir    < get_Regression().get_p_XX_dev_adjusted_rows()
    ;    ++ir
	)
    {
Formatter  line  = new Formatter();

			   line.format("%s%n"
					      , loop_thru_cols(ir)
					      );
			   get_Rpt_Detail().write( line.toString() );
			 }	
}
protected  String  loop_thru_cols(int  ir)
{
Formatter  line =  new Formatter();
for (int   ic   =  0
	;      ic   <  get_Regression().get_p_XX_dev_adjusted_cols()
	;    ++ic
    )
	{
		   line .  format( "%15.5E"
		                 , get_Regression().get_p_XX_dev_adjusted_cell(ir, ic)
		                 );
    }
return     line .  toString();
}

}
