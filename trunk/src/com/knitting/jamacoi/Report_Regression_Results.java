package com.knitting.jamacoi;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;

/**
 * This class implements usable and more meaningful reports that the 
 * Regression class has calculated.  These reports have standard
 * formating with every field labeled.  The class can be replaced or
 * overridden to provide custom reporting.  This class provides the
 * important function of separating the calculation of regression results
 * from the reporting of these results.  This keeps the Regression class
 * smaller and more understandable. 
 * @author Datamap, Inc
 */

public class Report_Regression_Results 
{
  	private int             residual_rpt_count  =  0;
    private Regression      r;
    private Sub_Matrix      sub_matrix;
    private FileWriter      Rpt_Detail;
    private Analysis_Parms  xml_parms;
    
    private Report_Abstract rpt_row_info;
    private Report_Abstract rpt_yx;
    private Report_Abstract rpt_YYX;
    private Report_Abstract rpt_est_func;
    private Report_Abstract rpt_err_analysis;
    private Report_Abstract rpt_sig_analysis;    
    private Report_Abstract rpt_cov_matrix;
    private Report_Abstract rpt_cov_adjusted;
//  private Report_Abstract rpt_auto_correlations;
//  private Report_Abstract rpt_auto_correlation_1;
    private Report_Abstract rpt_auto_correlation_2;
    private Report_Abstract rpt_auto_correlation_3;
    
    private URL             residuals;
/**
* @param r is an "estimated" Regression instance.  Because this reference
* is passed into this constructor, the Report_Regression_Result instance
* is able to gain access to all of the Regression instance's results.
*/    
public Report_Regression_Results (final Regression     r
                                 ,final Sub_Matrix     sub_matrix
                                 ,final Analysis_Parms xml_parms
                                 )
    throws java.io.IOException
{        
    this.r            = r;
    this.sub_matrix   = sub_matrix;
         residuals    = new URL       ( xml_parms.getURL_REL_RESIDUALS  () );

    URL  d            = new URL       ( xml_parms.getURL_REL_RPT_DETAILS() );
    File fd           = new File      ( d.getFile() );
         Rpt_Detail   = new FileWriter( fd
                                      , true
                                      );
                                                                      
         rpt_row_info     = new Report_Row_Selection_Info      ( r
        		                                               , sub_matrix
        		                                               , Rpt_Detail
        		                                               );
         
         rpt_yx           = new Report_YX                      ( r
        		                                               , sub_matrix
        		                                               , Rpt_Detail
        		                                               );
         
         rpt_YYX          = new Report_Y_Est_Y_Residual_X      ( r
        		                                               , sub_matrix
        		                                               , Rpt_Detail
        		                                               );
         
         rpt_est_func     = new Report_Estimated_Function      ( r
                                                               , sub_matrix
                                                               , Rpt_Detail
                                                               );   
         
         rpt_err_analysis = new Report_Error_Analysis          ( r
                                                               , sub_matrix
                                                               , Rpt_Detail
        		                                               );
         
         rpt_sig_analysis = new Report_Significant_Analysis_2  ( r
                                                               , sub_matrix
                                                               , Rpt_Detail
                                                               );
         
         rpt_cov_matrix   = new Report_Covariance_Matrix       ( r
        		                                               , sub_matrix
        		                                               , Rpt_Detail
        		                                               );
         
         rpt_cov_adjusted = new Report_Covariance_Adjusted     ( r
                                                               , sub_matrix
                                                               , Rpt_Detail
                                                               );    
//       rpt_auto_correlations  = new Report_Auto_Correlations   ( r
//                                                               , sub_matrix
//                                                               , Rpt_Detail
//                                                               );    
//       rpt_auto_correlation_1 = new Report_Auto_Correlations_1 ( r
//                                                               , sub_matrix
//                                                               , Rpt_Detail
//                                                               );    
         rpt_auto_correlation_2 = new Report_Auto_Correlations_2 ( r
                                                                 , sub_matrix
                                                                 , Rpt_Detail
                                                                 );    
         rpt_auto_correlation_3 = new Report_Auto_Correlations_3 ( r
                                                                 , sub_matrix
                                                                 , Rpt_Detail
                                                                 );   
} 
public  void   report_All()
        throws not_estimated
             , not_invertable
             , not_significant
             , java.io.IOException
{ 
	    rpt_row_info          . write_details  ();
        rpt_yx                . write_details  ();  
        rpt_YYX               . write_details  ();
        rpt_est_func          . write_details  ();
        rpt_err_analysis      . write_details  ();
        rpt_sig_analysis      . write_details  ();
        rpt_cov_matrix        . write_details  ();
        rpt_cov_adjusted      . write_details  ();
//      rpt_auto_correlations . write_details  ();
//      rpt_auto_correlation_1. write_details  ();
        rpt_auto_correlation_2. write_details  ();
        rpt_auto_correlation_3. write_details  ();
       
        Rpt_Detail .close();
}

}
