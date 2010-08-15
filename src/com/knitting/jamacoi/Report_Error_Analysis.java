package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public   class   Report_Error_Analysis 
         extends Report_Abstract 
{     
static	 final   String detail_fmt_a   = "%17s%15.5E%8.2f%s%8d%n";
static   final   String detail_fmt_b   = "%17s%15s%8s%1s%8s%n";  
static   final   String detail_fmt_c   = "%17s%15.5E%n";


public           Report_Error_Analysis ( Regression r
		                               , Sub_Matrix subMatrix
		                               , FileWriter Rpt_Detail
		                               )
         throws  IOException 
{
		 super   ( r
				 , subMatrix
				 , Rpt_Detail
				 );
}

@Override
public     void    write_details() 
           throws  IOException
                ,  not_estimated
{
	       get_Rpt_Detail().write( fmt_line_01() );
	       get_Rpt_Detail().write( fmt_line_02() );
	       get_Rpt_Detail().write( fmt_line_03() );
	       get_Rpt_Detail().write( fmt_line_04() );
	       get_Rpt_Detail().write( fmt_line_05() );
	       get_Rpt_Detail().write( fmt_line_06() );
	       get_Rpt_Detail().write( fmt_line_07() );
	       get_Rpt_Detail().write( fmt_line_08() );
	       get_Rpt_Detail().write( fmt_line_09() );
}
protected  String fmt_line_01(){
Formatter  line = new Formatter();
	       line . format( "%n%n%s%n"
                        , "3) Error Analysis Report ==================================="
                        );
return     line . toString();	       
}
protected  String fmt_line_02(){
Formatter  line = new Formatter();
           line . format( detail_fmt_b
                        , ""
                        , "Sum of"
                        , ""
                        , ""
                        , "Degrees"
                        );
return     line . toString();  
}
protected  String fmt_line_03(){
Formatter  line = new Formatter();
	       line . format( detail_fmt_b
	                    , ""
	                    , "Squared"
	                    , ""
	                    , ""
	                    , "of"
	                    );
return     line . toString();  
}
protected  String fmt_line_04(){
Formatter  line = new Formatter();
           line . format( detail_fmt_b
                        , ""
                        , "Errors"
                        , ""
                        , ""
                        , "Freedom"
                        );
return     line.toString();
}
protected  String fmt_line_05()
           throws not_estimated
{
Formatter  line = new Formatter();
           line . format( detail_fmt_a 
                        , "Total     Error:"
                        , get_Regression().get_Error_Total()
                        , get_Regression().get_Pct_Error_Total()
                        , "%"
                        , get_Regression().get_T_d_of_freedom()
                        );
return     line . toString();           
}
protected  String fmt_line_06()
           throws not_estimated
{
Formatter  line = new Formatter();
           line . format(  detail_fmt_a 
                        , "Explained Error:"
                        ,  get_Regression().get_Error_Explained()
                        ,  get_Regression().get_Pct_Error_Explained()
                        , "%"
                        ,  get_Regression().get_X_d_of_freedom()
                        );
return     line . toString();           
}
protected  String fmt_line_07()
{
Formatter  line = new Formatter();
           line . format( detail_fmt_b 
                        , ""
                        , "  -------------"
                        , "  -------"
                        , ""
                        , "  ------"
                        );
return     line . toString();
}
protected  String fmt_line_08()
           throws not_estimated
{
Formatter  line = new Formatter();	
	       line . format(  detail_fmt_a 
                        , "Residual  Error:"
                        ,  get_Regression().get_Error_Residual()
                        ,  get_Regression().get_Pct_Error_Residual()
                        , "%"
                        ,  get_Regression().get_R_d_of_freedom()
                        );
return     line . toString();	       
}
protected  String fmt_line_09()
           throws not_estimated
{
Formatter  line = new Formatter();
           line . format(  detail_fmt_c 
                        , "F_value:"
                        ,  get_Regression().get_F_value()
                        );
return     line.toString();           
}
}
