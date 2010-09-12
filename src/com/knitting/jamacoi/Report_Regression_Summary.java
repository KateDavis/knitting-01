package com.knitting.jamacoi;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;

public class Report_Regression_Summary {
	
    private Regression      r;
    private Sub_Matrix      sub_matrix;
    private FileWriter      Rpt_Summary; 
    private Analysis_Parms  xml_parms;
    
    private Report_Abstract rpt_csv_summary;
    
    /**
    * @param r is an "estimated" Regression instance.  Because this reference
    * is passed into this constructor, the Report_Regression_Result instance
    * is able to gain access to all of the Regression instance's results.
    */    
    public Report_Regression_Summary (final Regression     r
                                     ,final Sub_Matrix     sub_matrix
                                     ,final Analysis_Parms xml_parms
                                     )
           throws                     java.io.IOException
    {        
        this.r                = r;
        this.sub_matrix       = sub_matrix;
        
        URL  s                = new URL   ( xml_parms.getURL_REL_RPT_SUMMARY() );
        File fs               = new File  ( s.getFile() );
             Rpt_Summary      = new FileWriter                     ( fs
        		                                                   , true
                                                                   );
               
             rpt_csv_summary  = new Report_CSV_Summary             ( r
                                                                   , sub_matrix
                                                                   , Rpt_Summary
                                                                   );  
    }     
    public  void   report_All()
            throws not_estimated
                 , not_invertable
                 , not_significant
                 , java.io.IOException
{ 
    rpt_csv_summary  . write_details  ();
    Rpt_Summary.close();
}

}
