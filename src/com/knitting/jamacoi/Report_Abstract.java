package com.knitting.jamacoi;

import java.io.FileWriter;

public   abstract    class            Report_Abstract {
	
private  Regression  r;
private  Sub_Matrix  sub_matrix;
private  FileWriter  Rpt_Detail;

public               Report_Abstract( Regression  r
                                    , Sub_Matrix  sub_matrix
                                    , FileWriter  Rpt_Detail
                                    )	
         throws      java.io.IOException
{
this.r            =  r;
this.sub_matrix   =  sub_matrix;
this.Rpt_Detail   =  Rpt_Detail;
}
public   abstract    void             write_details()
         throws      java.io.IOException
              ,      not_estimated;

public   abstract    void             write_headers()
         throws      java.io.IOException
              ,      not_estimated;

public   FileWriter  get_Rpt_Detail(){
return                   Rpt_Detail;
}
public   FileWriter  get_Rpt(){
return                   Rpt_Detail;
}
public   Sub_Matrix  get_Sub_Matrix(){
return                   sub_matrix;	
}
public   Regression  get_Regression(){
return                   r;	
}
}
