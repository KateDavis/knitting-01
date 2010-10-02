package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public   class    Report_Auto_Correlations_1 
         extends  Report_Abstract {
	
public            Report_Auto_Correlations_1( Regression  r
                                            , Sub_Matrix  sub_matrix
                                            , FileWriter  Rpt_Detail
                                            )	
                  throws                      java.io.IOException{
         super  ( r
                , sub_matrix
                , Rpt_Detail
                );
}	

@Override
public     void     write_headers()
           throws   IOException
                ,   not_estimated
           {;}
	
@Override
public     void     write_details() 
           throws   IOException
                ,   not_estimated 
{ 
           get_Rpt_Detail().write( fmt_line_01() ); 
           loop_thru_rows();
}
protected  String   fmt_line_01(){
Formatter  line =   new Formatter();
		   line .   format("%n%n%s%n"
		                  ,"7_1) Sample Auto-Correlations values ==========================="
		                  ); 
return     line .   toString();	
}
protected  void   loop_thru_rows()
           throws java.io.IOException
{	
//           for  (int  ir   = 0
//                ;     ir   < get_Regression()
//                            .get_Auto_Correlation_1()
//                            .getRowDimension() 
//                ;   ++ir
//                )
//                {
//                  Formatter line = new Formatter();
//                            line .  format("%4d"
//         		                          , ir
//         		                          );
//	                        line . format("%s%n" 
//	     		                         , fmt_line_06_cells(ir)
//	     		                         );
//	                        get_Rpt_Detail().write( line.toString() );
//	     
//	                        line = null;
//                }
}
protected  String  fmt_line_06_cells(int  ir){
Formatter  line =  new Formatter();

//           for (int   ic   =    1
//               ;      ic   <    get_Regression()
//                               .get_Auto_Correlation_1()
//                               .getColumnDimension()
//               ;    ++ic
//               )
//               {
//                 line . format( "%15.5E"
//	                          ,  get_Regression()
//	                            .get_Auto_Correlation_1()
//	                            .get(ir, ic)
//	                          );
//               }
return           line . toString();	
}

}
