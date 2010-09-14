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
@Override
public     void     write_headers() 
           throws   IOException
{
           get_Rpt() . write( fmt_headers_01() );
           get_Rpt() . write( fmt_headers_02() );
           get_Rpt() . write( fmt_headers_03() );
           get_Rpt() . write( fmt_headers_04() );
           get_Rpt() . write( fmt_headers_05() );
}
protected  String   fmt_headers_01()
{
           Formatter  line  = new Formatter();
                      line  . format( "%13s%10s %13s"
                                    , ""
                                    , ""
                                    , ""
                                    );
           for  ( int   ic  = 1
                ;       ic  < get_Regression().get_YX_max_cols()
                ;     ++ic
                )
                {
                  line . format( "%13s"
                               , get_Sub_Matrix().get_name_security(ic)
                               );
                }
                  line . format( "%n");
              
return            line . toString();	
	
}
protected  String   fmt_headers_02()
{
           Formatter  line  = new Formatter();
                      line  . format( "%13s%10s %13s"
                                    , ""
                                    , ""
                                    , ""
                                    );
           for  ( int   ic  = 1
                ;       ic  < get_Regression().get_YX_max_cols()
                ;     ++ic
                )
                {
                  line . format( "%13s"
                               , get_Sub_Matrix().get_name_lag(ic)
                               );
                }
                  line . format( "%n");
              
return            line . toString();	
	
}
protected  String   fmt_headers_03()
{
           Formatter  line  = new Formatter();
                      line  . format( "%13s%10s %13s"
                                    , ""
                                    , ""
                                    , ""
                                    );
           for  ( int   ic  = 1
                ;       ic  < get_Regression().get_YX_max_cols()
                ;     ++ic
                )
                {
                  line . format( "%13s"
                               , "Coefficient"
                               );
                }
                  line . format( "%n");
              
return            line . toString();	
	
}
protected  String   fmt_headers_04()
{
           Formatter  line  = new Formatter();
                      line  . format( "%6s %6s %10s%13s"
                                    , "Start"
                                    , "End"
                                    , "Percent"
                                    , ""
                                    );
           for  ( int   ic  = 1
                ;       ic  < get_Regression().get_YX_max_cols()
                ;     ++ic
                )
                {
                  line . format( "%13s"
                               , "for"
                               );
                }
                  line . format( "%n");
              
return            line . toString();	
	
}
protected  String  fmt_headers_05(){
	Formatter  line = new Formatter();

		       line . format( "%6s %6s %10s%13s"
		    		        , "row"
		    		        , "row"
		                    , "Explained"
		                    , "Intercept"
		                    );

	for  (int   ic  = 0
		 ;      ic  < ( get_Regression().get_YX_max_cols() - 1 )
		 ;    ++ic
		 )
		 {
		    line . format( "%11s%02d"
		                 , "X"
		                 , (ic + 1)
		                 );
		 }
		    line . format( "%n");
	return  line . toString();	
	}
protected  String   fmt_line_01()
           throws   not_estimated
{
	 Formatter line      = new Formatter();
     
	 ArrayList<Double> c =     get_Regression().get_Estimated_Coefficients();  
	 line . format("%6d,%6d,%10.2f"
	              , get_Sub_Matrix().get_row_source_first()
	              , get_Sub_Matrix().get_row_source_last ()
	              , get_Regression().get_Pct_Error_Explained()
	              );       
	   
	 line . format(",%12.5E"
	              , get_Regression().get_Estimated_Intercept()
	              );       
	 int  ix;
	 int  ix_max = c.size();
	 for (ix     = 0
	     ;ix     < ix_max
	     ;ix++
	     )
	     {
	                 line . format(",%12.5E"
	                              ,c.get(ix)
	                              );   
	     }  

	           
      
	                 line . format ( "%n" );	
return               line . toString();	 
}

}
