package com.knitting.jamacoi;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;

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
    private FileWriter      Rpt_Summary; 
    private FileWriter      Rpt_Detail;
    private Analysis_Parms  xml_parms;
    
    private Report_YX       rpt_yx;
    
    private URL             reports;
    private URL             request_series;
    private URL             request_set;
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
        
    URL  s            = new URL       ( xml_parms.getURL_REL_RPT_SUMMARY() );
    File fs           = new File      ( s.getFile() );
         Rpt_Summary  = new FileWriter( fs
    		                          , true
                                      );
         rpt_yx       = new Report_YX ( r
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
           report_row_selection_info         ();
       //  report_YX                         ();
           rpt_yx.write_details              ();        
           report_Y_est_Y_residual_X         ();
           report_Estimated_Function         ();
           report_Error_Analysis             ();
           report_Significant_Analysis       ();
           report_Covariance_Matrix          ();
           report_Covariance_Matrix_Adjusted ();
           report_CVS_summary                ();
           Rpt_Summary.close();
           Rpt_Detail .close();
}
public  void   report_row_selection_info()
    throws java.io.IOException
{
 
 Formatter line_01 = new Formatter();
           line_01.format("%n%s%n"
                         ,"-------------------------------------------------"
                         ); 
 Rpt_Detail.write(line_01.toString());
 
 Formatter line_02 = new Formatter();
           line_02.format("%s%02d%s%s%04d%n"
                         ,"matrix row = "
                         , 1                                
                         ,"  "
                         ,"source row = "
                         , sub_matrix.get_row_source_first()
                         );
 Rpt_Detail.write(line_02.toString());   

 Formatter line_03 = new Formatter();
           line_03.format("%s%02d%s%s%04d%n"
                         ,"matrix row = "
                         , sub_matrix.get_rows_max()        
                         ,"  "
                         ,"source row = "
                         , sub_matrix.get_row_source_last() 
                         );
 Rpt_Detail.write(line_03.toString());     
}
public  void   report_YX()
    throws java.io.IOException
{
 Formatter line_01 = new Formatter();
           line_01.format("%n%n%s%n"
                         ,"0) YX matrix contents ==========================="
                         ); 
 Rpt_Detail.write(line_01.toString());          
 
 int ir;
 int ic;
 
 Formatter line_02 = new Formatter();
 line_02.format( "    %10s  %4s"
               , ""
               , ""
               );

 for  (   ic  = 0
      ;   ic  < r.get_YX_max_cols()
      ; ++ic
      )
      {
          line_02.format( "%15s"
                        , sub_matrix.get_name_security(ic)
                        );
      }
 line_02.format( "%n");
 Rpt_Detail.write(line_02.toString());
 
 Formatter line_03 = new Formatter();
 line_03.format( "    %10s  %4s"
               , ""
               , ""
               );

 for  (   ic  = 0
      ;   ic  < r.get_YX_max_cols()
      ; ++ic
      )
      {
          line_03.format( "%15s"
                        , sub_matrix.get_name_lag(ic)
                        );
      }
 line_03.format( "%n");
 Rpt_Detail.write(line_03.toString());
 
 Formatter line_04 = new Formatter();
        
 line_04.format( "    %10s  %4s"
               , "Row-ID"
               , "Time"
               );
 line_04.format( "%15s"
               , "Y"
               );
 for  (   ic  = 0
      ;   ic  < ( r.get_YX_max_cols() - 1 )
      ; ++ic
      )
      {
          line_04.format( "%13s%02d"
                        , "X"
                        , (ic + 1)
                        );
      }
 line_04.format( "%n");
 Rpt_Detail.write(line_04.toString());
  
 Formatter line_05 = new Formatter();
        
 line_05.format( "    %10s  %4s"
               , "----------"
               , "----"
               );
 for  (   ic  = 0
      ;   ic  < r.get_YX_max_cols()
      ; ++ic
      )
      {
          line_05.format( "%15s"
                        , "------------"
                        );
      }
 line_05.format( "%n");
 Rpt_Detail.write(line_05.toString());
   
 for  (   ir  = 0
      ;   ir  < r.get_YX_max_rows()
      ;   ir++
      )
      {
        Formatter line_06 = new Formatter();
        
        line_06.format( "    %s   %03d"
                      , sub_matrix.get_row_id(ir)
                      , ( ir + 1 )
                      );
        
        for (   ic  = 0
            ;   ic  < r.get_YX_max_cols()
            ;   ic++
            )
            {
              line_06.format( "%15.5E"
                            , r.get_YX_cell(ir, ic)
                            );
            }
        line_06.format( "%n");
        Rpt_Detail.write(line_06.toString()); 
        line_06 = null;
      }
}     

public  void   report_Y_est_Y_residual_X()
        throws not_estimated
             , not_invertable
             , not_significant 
             , java.io.IOException
{ 
 Formatter line_01 = new Formatter();
           line_01.format("%n%n%s%n"
                         ,"1) Y, est_Y, residual, X matrix contents ========"
                         ); 
 Rpt_Detail.write(line_01.toString());          
 
 int ir;
 int ic;
 
 Formatter line_02 = new Formatter();
 line_02.format( "    %10s  %4s"
               , "Row-ID"
               , "Time"
               );           
 line_02.format( "%15s"
               , "Y"
               );
 line_02.format( "%15s"
               , "Estimated Y"
               );
 line_02.format( "%15s"
               , "Residual"
               );
 for  (   ic  = 0
      ;   ic  < ( r.get_YX_max_cols() - 1 )
      ; ++ic
      )
      {
          line_02.format( "%13s%02d"
                        , "X"
                        , (ic + 1)
                        );
      }
 line_02.format( "%n");
 Rpt_Detail.write(line_02.toString());
  
 Formatter line_03 = new Formatter();
        
 line_03.format( "    %10s  %4s"
               , "----------"
               , "----"
               );
 for  (   ic  = 0
      ;   ic  < ( 2+ r.get_YX_max_cols() )
      ; ++ic
      )
      {
          line_03.format( "%15s"
                        , "------------"
                        );
      }
 line_03.format( "%n");
 Rpt_Detail.write(line_03.toString());

 for  (   ir  = 0
      ;   ir  < r.get_YX_max_rows()
      ;   ir++
      )
      {
        Formatter line_04 = new Formatter();
        
        line_04.format( "    %s   %03d"
                      , sub_matrix.get_row_id(ir)
                      , ( ir + 1 )
                      );       
        line_04.format( "%15.5E"
                      , r.get_YX_cell(ir, 0)
                      );
        line_04.format( "%15.5E"
                      , r.get_est_Y_residual(ir, 0)
                      );
        line_04.format( "%15.5E"
                      , r.get_est_Y_residual(ir, 1)
                      );
        
        for (   ic  = 1
            ;   ic  < r.get_YX_max_cols()
            ;   ic++
            )
            {
              line_04.format( "%15.5E"
                            , r.get_YX_cell(ir, ic)
                            );
            }
        line_04.format( "%n");
        Rpt_Detail.write(line_04.toString()); 
        line_04 = null;
      }   
}
public  void   report_Estimated_Function()
    throws not_estimated
         , not_invertable
         , not_significant 
         , java.io.IOException
{ 
 Formatter line_1 = new Formatter();
 Formatter line_2 = new Formatter();
 
 line_1.format("%n%n%s%n"
              ,"2) Estimated Function Report ==============================="
              );
 Rpt_Detail.write(line_1.toString());

 ArrayList<Double> c =   r.get_Estimated_Coefficients();    
         
 line_2.format("%5s%4s%s%15.5E%s%s  %s  (%s)%n"
              ,"Y"
              ,"="
              ," "
              , r.get_Estimated_Intercept()
              ,"   "
              ,"intercept"
              ,sub_matrix.get_name_security(0)
              ,sub_matrix.get_name_lag     (0)
              );
 Rpt_Detail.write(line_2.toString());
       
 int  ix;
 int  ix_max = c.size();
 for (ix     = 0
     ;ix     < ix_max
     ;ix++
     )
     {
       Formatter line_3 = new Formatter();
                 line_3.format("%5s%4s%s%15.5E%s%s%d%s  %s  (%s)%n"
                              ,""
                              ,"+"
                              ," "
                              ,c.get(ix)
                              ," * "
                              ,"X"
                              ,(ix + 1)
                              ,"       "
                              , sub_matrix.get_name_security(ix + 1)
                              , sub_matrix.get_name_lag     (ix + 1)                               
                              );
       Rpt_Detail.write(line_3.toString());             
     }      
}
public void   report_Error_Analysis()
   throws not_estimated
        , not_invertable
        , not_significant 
        , java.io.IOException
{
 final String detail_fmt_a = "%17s%15.5E%8.2f%s%8d%n";
 final String detail_fmt_b = "%17s%15s%8s%1s%8s%n";
 final String detail_fmt_c = "%17s%15.5E%n";
 
 Formatter line_1 = new Formatter();
 Formatter line_2 = new Formatter();   
 Formatter line_3 = new Formatter(); 
 Formatter line_4 = new Formatter(); 
 Formatter line_5 = new Formatter(); 
 Formatter line_6 = new Formatter(); 
 Formatter line_7 = new Formatter(); 
 Formatter line_8 = new Formatter(); 
 Formatter line_9 = new Formatter(); 
     
 line_1.format("%n%n%s%n"
              ,"3) Error Analysis Report ==================================="
              );
 Rpt_Detail.write(line_1.toString());
      
 line_2.format( detail_fmt_b
              ,""
              ,"Sum of"
              ,""
              ,""
              ,"Degrees"
              );
 Rpt_Detail.write(line_2.toString());
       
 line_3.format( detail_fmt_b
              ,""
              ,"Squared"
              ,""
              ,""
              ,"of"
              );
 Rpt_Detail.write(line_3.toString());
      
 line_4.format( detail_fmt_b
              ,""
              ,"Errors"
              ,""
              ,""
              ,"Freedom"
              );
 Rpt_Detail.write(line_4.toString());
      
 line_5.format( detail_fmt_a 
              ,"Total     Error:"
              , r.get_Error_Total()
              , r.get_Pct_Error_Total()
              ,"%"
              , r.get_T_d_of_freedom()
              );
 Rpt_Detail.write(line_5.toString());
                 
 line_6.format( detail_fmt_a 
              ,"Explained Error:"
              , r.get_Error_Explained()
              , r.get_Pct_Error_Explained()
              ,"%"
              , r.get_X_d_of_freedom()
              );
 Rpt_Detail.write(line_6.toString());

 line_7.format( detail_fmt_b 
              ,""
              ,"  -------------"
              ,"  -------"
              ,""
              ,"  ------"
              );
 Rpt_Detail.write(line_7.toString());    
        
 line_8.format( detail_fmt_a 
              ,"Residual  Error:"
              , r.get_Error_Residual()
              , r.get_Pct_Error_Residual()
              ,"%"
              , r.get_R_d_of_freedom()
              );
 Rpt_Detail.write(line_8.toString());

 line_9.format( detail_fmt_c 
              ,"F_value:"
              , r.get_F_value()
              );
 Rpt_Detail.write(line_9.toString());   
} 
public void   report_Significant_Analysis()
   throws not_estimated
        , not_invertable
        , not_significant 
        , java.io.IOException
{
   Formatter line_1  = new Formatter();
   try   {
          line_1.format("%n%n%s"
                       ,"4) Significant Analysis Report  ========================"
                       );
          Rpt_Detail.write(line_1.toString());

          Table_of_F_Tables  fdt = new Table_of_F_Tables();

          Result_Tree rt = fdt.build_Result_Tree( r.get_R_d_of_freedom()
                                                , r.get_X_d_of_freedom()
                                                );
          
                      rt.compare_reg_with_data  ( Rpt_Detail
                                                , r.get_R_d_of_freedom()
                                                , r.get_X_d_of_freedom()
                                                , r.get_F_value()
                                                );  
         } 
   catch (Exception e)
         { 
          System.out.println ( "Exception was caught:");
         }  
   Report_Significant_Analysis rsa = new
   Report_Significant_Analysis     ( Rpt_Detail
		                           , r.get_R_d_of_freedom()
		                           , r.get_X_d_of_freedom()
		                           , r.get_F_value()
		                           ) ;
                               rsa . get();
}
public  void   report_Covariance_Matrix()
    throws not_estimated
         , not_invertable
         , not_significant 
         , java.io.IOException

{int ir;
int ic;
Formatter line_1 = new Formatter();
 
line_1.format("%n%n%s%n"
          ,"5) Covariance Matrix Report ===================================="
          );
Rpt_Detail.write(line_1.toString());
  
Formatter line_2;

for ( ir    = 0
 ; ir    < r.get_p_XX_dev_rows()
 ; ir++
 )
 { 
   line_2     = new Formatter();
   for ( ic   = 0
       ; ic   < r.get_p_XX_dev_cols()
       ; ic++
       )
       {
        line_2.format( "%15.5E"
                     , r.get_p_XX_dev_cell(ir, ic)
                     );
       }
   line_2.format("%n");
   Rpt_Detail.write(line_2.toString());
   line_2 = null;
 }
}
public  void   report_Covariance_Matrix_Adjusted()
    throws not_estimated
         , not_invertable
         , not_significant   
         , java.io.IOException

{int ir;
int ic;
Formatter line_1 = new Formatter();
 
line_1.format("%n%n%s%n"
          ,"6) Covariance Matrix Adjusted Report ==========================="
          );
Rpt_Detail.write(line_1.toString());
  
Formatter line_2;

for ( ir    = 0
 ; ir    < r.get_p_XX_dev_adjusted_rows()
 ; ir++
 )
 { 
   line_2     = new Formatter();
   for ( ic   = 0
       ; ic   < r.get_p_XX_dev_adjusted_cols()
       ; ic++
       )
       {
        line_2.format( "%15.5E"
                     , r.get_p_XX_dev_adjusted_cell(ir, ic)
                     );
       }
   line_2.format("%n");
   Rpt_Detail.write(line_2.toString());
   line_2 = null;
 }
}
public void   report_CVS_summary()
   throws not_estimated
        , not_invertable
        , not_significant  
        , java.io.IOException
{
 Formatter line_2    = new Formatter();
      
 ArrayList<Double> c =   r.get_Estimated_Coefficients();  
 line_2.format("%4d,%4d,"
              , sub_matrix.get_row_source_first()
              , sub_matrix.get_row_source_last ()
              );       
   
 line_2.format("%12.5E,"
              , r.get_Estimated_Intercept()
              );       
 int  ix;
 int  ix_max = c.size();
 for (ix     = 0
     ;ix     < ix_max
     ;ix++
     )
     {
                 line_2.format("%12.5E,"
                              ,c.get(ix)
                              );   
     }  
 line_2.format("%5.2f,"
              , r.get_Pct_Error_Explained()
              );
 int   ir;
 int   ic;
 
 for ( ir    = 0
     ; ir    < r.get_p_XX_dev_adjusted_rows()
     ; ir++
     )
     {
       for ( ic   = ir
           ; ic   < r.get_p_XX_dev_adjusted_cols()
           ; ic++
           )
           {
             line_2.format( "%12.5E,"
                          , r.get_p_XX_dev_adjusted_cell(ir, ic)
                          );
           }
      }  
 line_2.format ( "%n" );
 Rpt_Summary.write(line_2.toString());
}

}
