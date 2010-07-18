package com.knitting.jamacoi;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.thoughtworks.xstream.XStream;

public class Main 
{
	static String  Dir__Config           = "knitting-01/src_resources/com/knitting/resources/configuration";
	static String          xml           =  Dir__Config    + "/test_xml_02.xml";
	
	public static  void  main(String[] args)
    throws         IOException
         ,         not_estimated
         ,         not_invertable
         ,         not_rectangular
         ,         not_significant
{
Workspace          ws            = new Workspace();	
URL                url_workspace = ws.get_Workspace();
assertNotNull    ( url_workspace  ) ;

URL                url_xml       = new URL( url_workspace, xml  );
assertNotNull    ( url_xml        ) ;
    
Build_xml_string   xml_in      = new Build_xml_string   ( url_xml );
XStream            xstream     = new XStream();
Analysis_Parms     my_parms_02 = (Analysis_Parms)
                                  xstream.fromXML( xml_in.get_xml_string() );

                   my_parms_02 . report_values();
     
File               Delete_Detail = new File ( my_parms_02.getNAME_OUT_DIR()
                                            , my_parms_02.getNAME_OUT_DETAILS()
                                            );
                 if   ( Delete_Detail.isFile() )
                      {
                        Delete_Detail.delete();
                      }             
                 Delete_Detail = null;
     
File             Delete_Summary = new File ( my_parms_02.getNAME_OUT_DIR()
                                           , my_parms_02.getNAME_OUT_SUMMARY()
                                           );
                 if   ( Delete_Summary.isFile() )
                      {
                        Delete_Summary.delete();
                      }             
                 Delete_Summary = null;        
Rectangular_CVS_Matrix m = new Rectangular_CVS_Matrix ( my_parms_02 );
                       m . show_input_names();
  
Sub_Matrix  sub_matrix   =  new Sub_Matrix ( my_parms_02.getCOUNT_MAX_MATRIX_ROWS()
                                           , my_parms_02.getCOUNT_MAX_COLUMNS()
                                           );
      
for ( int ir_base  =   my_parms_02.getROW_BASE()
    ;     ir_base  < ( my_parms_02.getROW_BASE()
                     + my_parms_02.getCOUNT_MAX_REGRESSION_ANALYSIS()
                     )
    ;     ir_base++
    )   
{

   sub_matrix.Load_Data_Backwards( ir_base
                                 , m
                                 );
   try
      {                            
       Regression        r = new Regression ( sub_matrix ); 

                 Report_Regression_Results 
       rrr = new Report_Regression_Results  (r
                                            ,sub_matrix
                                            ,my_parms_02
                                            );
       rrr .     report_All                 ();
      }
   catch (not_enough_rows e)
         {}                  
   catch (not_invertable  e)
         {}        
   catch (not_significant e)
         {}
   catch (java.io.FileNotFoundException e)
         {}
   }

}    


}
