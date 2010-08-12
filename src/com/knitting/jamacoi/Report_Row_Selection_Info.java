package com.knitting.jamacoi;

import java.io.FileWriter;
import java.util.Formatter;

public   class       Report_Row_Selection_Info {

private  Sub_Matrix  sub_matrix;
private  FileWriter  Rpt_Detail;

public               Report_Row_Selection_Info( Sub_Matrix  sub_matrix
                                              , FileWriter  Rpt_Detail
                                              )	
         throws      java.io.IOException{

this.sub_matrix   =  sub_matrix;
this.Rpt_Detail   =  Rpt_Detail;
}
public   void        write_details()
         throws      java.io.IOException
{
	     Rpt_Detail.write( fmt_line_01() );
	     Rpt_Detail.write( fmt_line_02() );
	     Rpt_Detail.write( fmt_line_03() );
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
                         , sub_matrix.get_row_source_first()
                         );
return     line .  toString();           
}
protected  String  fmt_line_03(){
Formatter  line =  new Formatter();
           line .  format( "%s%04d%s%s%04d%n"
                         , "matrix row = "
                         ,  sub_matrix.get_rows_max()        
                         , "  "
                         , "source row = "
                         ,  sub_matrix.get_row_source_last()
                         );
return     line .  toString();           
}
}
