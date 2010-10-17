package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public   class    Report_Partial_Auto_Correlation_Details_3 
         extends  Report_Abstract {
	
public            Report_Partial_Auto_Correlation_Details_3(  Regression  r
                                                            , Sub_Matrix  sub_matrix
                                                            , FileWriter  Rpt_Detail
                                                            )	
                  throws                                      java.io.IOException
{
         super  ( r
                , sub_matrix
                , Rpt_Detail
                );
}	


@Override
public void write_headers() throws IOException, not_estimated
{;}
@Override
public     void     write_details() 
           throws   IOException
                ,   not_estimated 
{ 
           get_Rpt_Detail().write( fmt_line_01() );
/*** 
           get_Rpt_Detail().write( fmt_line_03() ); 
           get_Rpt_Detail().write( fmt_line_04() );
           get_Rpt_Detail().write( fmt_line_05() );
           get_Rpt_Detail().write( fmt_line_06() );
***/
           loop_thru_rows();
}
protected  String   fmt_line_01()
{
Formatter  line =   new Formatter();
		   line .   format("%n%n%s%n"
			              ,"8) Sample Partial Auto-Correlations values ==========================="
			              ); 
return     line .   toString();	
}
protected  void   loop_thru_rows()
           throws java.io.IOException
{
final int  values_per_line_max = 10;	
for  (int  ir   = 0
	 ;     ir   < (  get_Regression()
                    .get_Partial_Auto_Correlation_Detail_3()
                    .getRowDimension()
                  -  1
                  )
     ;   ++ir
	 )
     { 
	   fmt_line_of_values( values_per_line_max
			             , ir 
			             );
	   if ( values_per_line_max <  get_Regression()
                                  .get_Partial_Auto_Correlation_Detail_3()
                                  .getRowDimension()
          )
	      {
		    blank_line();
	      }
	   
     }
}
protected  void   blank_line()
           throws java.io.IOException
{
    Formatter line   = new Formatter();
              line   . format("%n");
    get_Rpt_Detail() . write( line.toString() );

    line = null;	
}
protected  void   fmt_line_of_values( final  int  values_per_line_max 
		                            , final  int  row 
		                            )
           throws java.io.IOException
{	
      int  col;
      int  col_max = Math.min(  row
    		                 ,  (  get_Regression()
    		                      .get_Partial_Auto_Correlation_Detail_3()
    		                      .getRowDimension()
    		                    - 1
    		                    )
    		                 );
for  (     col  =  0
     ;     col  <  col_max
     ;     col +=  values_per_line_max
     )
     {
	   int       col_line_max   =  Math.min(  col_max
			                               ,  values_per_line_max
			                               );
       Formatter line =  new Formatter();
                 line .  format("%4d"
		                       , ( row )
		                       );
                 line .  format("%s%n" 
		                       , fmt_line_07_cells(   row
		                    		              ,   col
		                    		              , ( col_line_max )
		                    		              )
		                       );
                 get_Rpt_Detail().write( line.toString() );

                 line = null;
     }
if ( col  < (  get_Regression()
              .get_Partial_Auto_Correlation_Detail_3()
              .getRowDimension()
            -  1
            )
   )
   {
    Formatter line =  new Formatter();
              line .  format("%4d"
                            , ( row )
                            );
              line .  format("%s%n" 
                            , fmt_line_07_cells(   row
               		                           ,   col
               		                           ,  (get_Regression()
               		                              .get_Partial_Auto_Correlation_Detail_3()
               		                              .getRowDimension()
               		                              - 1
               		                              )
               		                           )
                            );
              get_Rpt_Detail().write( line.toString() );

              line = null;
   }
}
protected  String  fmt_line_07_cells( final  int  row
		                            , final  int  col_start
		                            , final  int  col_max
		                            )
{
Formatter  line =  new Formatter();

	       for  ( int  ic   =    col_start
	            ;      ic   <    col_max
	            ;    ++ic
	            )
	            {
	    	      if (  (row < 49)
	    	    	    &&
	    	    		(ic  < 49)
	    	    	 )
	    	         {
	                    line . format( "%15.5E"
		                             ,  get_Regression()
		                               .get_Partial_Auto_Correlation_Detail_3()
		                               .get(row, ic)
		                             );
	    	         }

	            }
return            line . toString();	
}
}
