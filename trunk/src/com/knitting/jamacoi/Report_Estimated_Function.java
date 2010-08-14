package com.knitting.jamacoi;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;

public   class       Report_Estimated_Function {

private  Regression  r;
private  Sub_Matrix  sub_matrix;
private  FileWriter  Rpt_Detail;
public               Report_Estimated_Function( Regression  r
                                              , Sub_Matrix  sub_matrix
                                              , FileWriter  Rpt_Detail
                                              )	
         throws      java.io.IOException
{
this.r            =  r;
this.sub_matrix   =  sub_matrix;
this.Rpt_Detail   =  Rpt_Detail;
}
public   void        write_details()
         throws      java.io.IOException
              ,      not_estimated
{
Rpt_Detail.write( fmt_line_01() );	
Rpt_Detail.write( fmt_line_02() );
loop_thru_rows  ();
}
protected  String       fmt_line_01(){
Formatter  line = new Formatter();
	 
	       line . format  ( "%n%n%s%n"
	                      , "2) Estimated Function Report ==============================="
	                      );
return     line . toString();	       
}
protected  String       fmt_line_02()
           throws       not_estimated
{
Formatter  line = new Formatter();	
	       line . format( "%5s%4s%s%15.5E%s%s  %s  (%s)%n"
                        , "Y"
                        , "="
                        , " "
                        , r.get_Estimated_Intercept()
                        , "   "
                        , "intercept"
                        , sub_matrix.get_name_security(0)
                        , sub_matrix.get_name_lag     (0)
                        );
return     line . toString();	       
}
protected  void            loop_thru_rows()
           throws          not_estimated
                ,          java.io.IOException
{
ArrayList<Double> c        = r.get_Estimated_Coefficients();
int                 ix_max = c.size();
for (int   ix     = 0
	;      ix     < ix_max
	;    ++ix
	)
	{
	 Formatter line = new Formatter();
	           line . format ( "%5s%4s%s%15.5E%s%s%d%s  %s  (%s)%n"
	                         , ""
	                         , "+"
	                         , " "
	                         ,  c.get(ix)
	                         , " * "
	                         , "X"
	                         , (ix + 1)
	                         , "       "
	                         , sub_matrix.get_name_security(ix + 1)
	                         , sub_matrix.get_name_lag     (ix + 1)                               
	                         );
	  Rpt_Detail.write( line.toString() );
	}           
}
}
