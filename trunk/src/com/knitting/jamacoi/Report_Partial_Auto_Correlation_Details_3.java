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
final  int values_per_line_max = 10;
final  int row_max             =  get_Regression()
                                 .get_Partial_Auto_Correlation_Detail_3()
                                 .getRowDimension();
           get_Rpt_Detail().write( fmt_line_01() );
           get_Rpt_Detail().write( fmt_line_02() );
/*** 
           get_Rpt_Detail().write( fmt_line_03() ); 
           get_Rpt_Detail().write( fmt_line_04() );
           get_Rpt_Detail().write( fmt_line_05() );
***/
           loop_thru_headers(                     values_per_line_max   
        		            ,                     row_max
        		            );
           get_Rpt_Detail().write( fmt_line_06( values_per_line_max ) );
           loop_thru_rows   (                     values_per_line_max  
        		            ,                     row_max
        		            );
}
protected  String   fmt_line_01()
{
Formatter  line =   new Formatter();
		   line .   format("%n%n%s%n"
			              ,"8) Sample Partial Auto-Correlations values ==========================="
			              ); 
return     line .   toString();	
}
protected  String   fmt_line_02()
{
Formatter  line =   new Formatter();
	       line .   format( "%nRows = >%d<%nCols = >%d<%n%n"
	    		   
		                  ,  get_Regression()
                            .get_Partial_Auto_Correlation_Detail_3()
                            .getRowDimension()
                            
                          ,  get_Regression()
                            .get_Partial_Auto_Correlation_Detail_3()
                            .getColumnDimension()
		                  );
	       
return     line .   toString();		
}
protected  void     loop_thru_headers( final  int  values_per_line_max 
		                             , final  int  row_max
		                              )
           throws   java.io.IOException
{
	   int    col;
	   final  int    col_max = ( row_max + 1 );
	          for  ( col     =   0
	   	           ; col     <   col_max
	   	           ; col    +=   values_per_line_max
	   	           )
	               {
	       	         int col_max_2 = Math.min( ( col + values_per_line_max )
	       	    	   	                     ,   col_max
	       	    		                     );
	       	      
	       	         fmt_line_03   ( row_max
	                               , col
	                               , col_max_2
	                               );
	               }
	          if   ( col < col_max )
	               {
	       	         fmt_line_03( row_max
	                            , col
	                            , col_max
	                            );
	               }	
}
protected  void     fmt_line_03    ( final  int  row_max
		                           , final  int  col_start
		                           , final  int  col_max
		                           )
           throws   java.io.IOException
{
Formatter  line =   new Formatter();
           line .   format("%4s"
                          ,"Lag"
                          );
    
           for ( int   col = col_start
 	           ;       col < col_max
 	           ;     ++col
 	           )
               {
                 line .   format("%15d" 
                                , ( col + 1 )
                                );
               };
                 line .   format("%n");

          get_Rpt_Detail().write ( line.toString() );
}
protected  String   fmt_line_06    ( final  int  values_per_line_max )
{
Formatter  line =   new Formatter();
           line .   format("%4s"
                          ,"===="
                          );
           
           for ( int   col = 0
        	   ;       col < values_per_line_max
        	   ;     ++col
        	   )
               {
                 line .   format("%15s" 
                                ,"==========="
                                );
               };
           line .   format("%n");
return     line .   toString();
}
protected  void   loop_thru_rows( final  int  values_per_line_max 
		                        , final  int  row_max
		                        )
           throws java.io.IOException
{
/*****
final int  row_max             =  get_Regression()
                                 .get_Partial_Auto_Correlation_Detail_3()
                                 .getRowDimension();
*****/
                                
for  (int  row  =  0
	 ;     row  <  row_max
     ;   ++row
	 )
     { 
	   /*****
	   fmt_line_of_values  ( values_per_line_max
			               , row_max
			               , row 
			               );
	   ******/
	   fmt_line_of_values_2( values_per_line_max
                           , row 
                           );
	   if ( values_per_line_max <  row_max )
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
protected  void   fmt_line_of_values_2( final  int  values_per_line_max
		                              , final  int  row
		                              )
           throws java.io.IOException
{
	   int    col;
final  int    col_max = ( row + 1 );
       for  ( col     =   0
	        ; col     <   col_max
	        ; col    +=   values_per_line_max
	        )
            {
    	      int col_max_2 = Math.min( ( col + values_per_line_max )
    	    		                  ,   col_max
    	    		                  );
    	      
    	      fmt_line_02( row
                         , col
                         , col_max_2
                         );
            }
       if   ( col < col_max )
            {
    	      fmt_line_02( row
                         , col
                         , col_max
                         );
            }
}
protected  void   fmt_line_02( final  int  row
		                     , final  int  col_start
		                     , final  int  col_max
		                     )
           throws java.io.IOException
{
Formatter  line =   new Formatter();
           line .   format("%4d"
                          , ( row + 1 )
                          );
           line .   format("%s%n" 
                          , fmt_line_07_cells( row
	                                         , col_start
	                                         , col_max
	                                         )
                          );
           get_Rpt_Detail().write( line.toString() );	
}
/******************************************
protected  void   fmt_line_of_values( final  int  values_per_line_max 
		                            , final  int  row_max
		                            , final  int  row 
		                            )
           throws java.io.IOException
{	
      int  col;             
      int  col_max = Math.min(row_max, row);
           
if   ( col_max < values_per_line_max )
     {
	   fmt_line_full ( ( row + 1 )
  	                 ,   row
	                 ,   0
	                 );
	   return;
     }
    		                 
for  (     col  =  0
     ;     col  <  col_max
     ;     col +=  values_per_line_max
     )
     {	   
	   fmt_line_full ( values_per_line_max
		             , row
		             , col
		             );                
     }
if   ( col  <=  col_max )
     {
	  fmt_line_short( values_per_line_max
			        , col_max
		  	        , row
			        , col   // (col - 1)
			        );
     }
}
protected  void    fmt_line_full ( final  int  values_per_line_max 
                                 , final  int  row 
                                 , final  int  col
                                 )
           throws  java.io.IOException
{
int   col_max  =   Math.min( ( col + values_per_line_max)
		                   , ( row + 1                  )
		                   );

Formatter line =   new Formatter();
          line .   format("%4d"
                         , ( row + 1 ) 
                         );
          line .   format("%s%n" 
                         , fmt_line_07_cells(   row
               	  	                        ,   col
               		                        ,   col_max  //( col + values_per_line_max )
               		                        )
                         );
          get_Rpt_Detail().write( line.toString() );
}
protected  void     fmt_line_short( final  int  values_per_line_max 
		                          , final  int  col_max
                                  , final  int  row 
                                  , final  int  col
                                  )
           throws   java.io.IOException
{
Formatter  line =   new Formatter();
           line .   format("%4d"
                          , ( row + 1 )
                          );
           line .   format("%s%n" 
                          , fmt_line_07_cells( row
 		                                     , col
 		                                     ,(row + 1)
 		                                     )
                          );
           get_Rpt_Detail().write( line.toString() );
}
*********************************************************/

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
	    	    /******************
	    	      if (  (row < 49)
	    	    	    &&
	    	    		(ic  < 49)
	    	    	 )
	    	    ******************/
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
