package com.knitting.jamacoi;

import java.io.FileWriter;
import java.util.Formatter;

public   class       Report_Row_Selection_Info
         extends     Report_Abstract
{         

public               Report_Row_Selection_Info( Regression  r
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
}
protected  String  fmt_line_01(){
Formatter  line =  new Formatter();
           line .  format( "%n%s%n"
                         , "-------------------------------------------------"
                         );
return     line .  toString();           
}
protected  String  fmt_line_02(){
Formatter  line =  new Formatter();
           line .  format( "%s%04d%s%s%04d%n"
                         , "matrix row = "
                         , 1                                
                         , "  "
                         , "source row = "
                         , get_Sub_Matrix().get_row_source_first()
                         );
return     line .  toString();           
}
protected  String  fmt_line_03(){
Formatter  line =  new Formatter();
           line .  format( "%s%04d%s%s%04d%n"
                         , "matrix row = "
                         ,  get_Sub_Matrix().get_rows_max()        
                         , "  "
                         , "source row = "
                         ,  get_Sub_Matrix().get_row_source_last()
                         );
return     line .  toString();           
}
}
