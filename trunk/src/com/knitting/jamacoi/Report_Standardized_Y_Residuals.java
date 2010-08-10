package com.knitting.jamacoi;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Formatter;

public   class     Report_Standardized_Y_Residuals {
private  int              residual_rpt_count  =  0;
private  Regression       r;
private  Sub_Matrix       sub_matrix;
private  Analysis_Parms   xml_parms;
private  URL              residuals;
private  FileWriter       rpt_writer;


public             Report_Standardized_Y_Residuals( int             residual_rpt_count
		                                          , Regression      r
		                                          , Sub_Matrix      sub_matrix
		                                          , Analysis_Parms  xml_parms
		                                          )
         throws    not_estimated
              ,    not_invertable
              ,    not_significant
              ,    java.io.IOException
{
 this.residual_rpt_count = residual_rpt_count;
 this.r                  = r;
 this.sub_matrix         = sub_matrix;
 this.xml_parms          = xml_parms;
}
public      void     create_rpt()
            throws   java.io.IOException
{
            residuals      = new URL       ( xml_parms.getURL_REL_RESIDUALS() );            
URL         rpt_residuals  = new URL       ( residuals,  fmt_file_name     () );
File        file_residual  = new File      ( rpt_residuals.getFile         () );
            rpt_writer     = new FileWriter( file_residual
                                           , false
                                           );
            rpt_details();
            rpt_writer.close();
}
protected   String  fmt_file_name(){
Formatter   fmt_file_name = new Formatter ();
            fmt_file_name . format   ("residuals_%04d__%s__%s.txt"
  	                                 , residual_rpt_count
  	                                 , sub_matrix.get_row_id(0)
  	                                 , sub_matrix.get_row_id( r.get_YX_max_rows() -1 )
	                                 );
return      fmt_file_name . toString();            
}
protected   void    rpt_details()
            throws  java.io.IOException
{
double      residual_ave      = calc_residual_ave();
double      sqt_deviation_sum = calc_sqt_deviation_sum ( residual_ave      );
double      std_deviation     = calc_std_deviation     ( sqt_deviation_sum );
            rpt_writer.write  ( fmt_residual_ave       ( residual_ave      ) );
            rpt_writer.write  ( fmt_sqt_dev_sum        ( sqt_deviation_sum ) );
            rpt_writer.write  ( fmt_std_dev            ( std_deviation     ) );
        	for   (int   ir  = 0
      		      ;      ir  < r.get_YX_max_rows()
      		      ;    ++ir
      		      )
      		      {
      		        rpt_writer.write( fmt_detail_line( ir 
      		        		                         , residual_ave
      		        		                         , std_deviation
      		        		                         )
      		        		        ); 
      		      }  
           
}
protected   double calc_residual_ave(){
double      residual_sum = 0;	

for     (int   ir  = 0
	    ;      ir  < r.get_YX_max_rows()
	    ;    ++ir
	    )
        {
                     residual_sum =+ r.get_est_Y_residual(ir, 1);
        };
return               residual_sum /  r.get_YX_max_rows();
}
protected   double  calc_sqt_deviation_sum( double residual_ave )
{
double      sqt_deviation_sum = 0;	
for        (int   ir  = 0
	       ;      ir  < r.get_YX_max_rows()
	       ;    ++ir
	       )
	       {
	          	  double           deviation         =    r.get_est_Y_residual(ir, 1)
	          	                                     -    residual_ave;
	          	  
	          	                   sqt_deviation_sum =+ ( deviation
	          	        		                        * deviation
	          	        		                        );
	       }	
return                             sqt_deviation_sum;
}
protected   double   calc_std_deviation( double sqt_deviation_sum ){
	        return   Math.sqrt(                 sqt_deviation_sum 
                              / ( r.get_YX_max_rows() - 1 )
                              );
}
protected   String  fmt_residual_ave( double  residual_ave )
            throws  java.io.IOException
{
Formatter   fmt_ave = new Formatter();
            fmt_ave . format( "residual_ave ..... = >%5.5E<%n"
  		                    ,  residual_ave
  		                    );
return      fmt_ave.toString();
}
protected   String  fmt_sqt_dev_sum ( double sqt_deviation_sum ){
Formatter   fmt_sqt_sum = new Formatter();
            fmt_sqt_sum . format( "sqt_deviation_sum  = >%5.5E<%n"
  		                        ,  sqt_deviation_sum
  		                        );
return      fmt_sqt_sum . toString();	
}
protected   String  fmt_std_dev( double std_deviation ){
Formatter   fmt_std_dev = new Formatter();
            fmt_std_dev . format( "std_deviation .... = >%5.5E<%n"
            		            ,  std_deviation
            		            );
return      fmt_std_dev . toString();	
}
protected   String  fmt_detail_line( int     ir
		                           , double  residual_ave
		                           , double  std_deviation
		                           ){
Formatter   line_01 = new Formatter();
		    line_01 . format( "%s,"
	                        , sub_matrix.get_row_id(ir)
	                        );    
             
		    line_01 . format( "%5.5E,%5.5E"
		        	        ,       r.get_est_Y_residual(ir, 1)
		                    , ( 
		                    	 (  r.get_est_Y_residual(ir, 1)
		                    	 -  residual_ave
		                    	 )
		                         /  std_deviation		  
		                      )		  
		                    );   
		    
		    line_01 . format( "%n" );
return      line_01 . toString();		        
}
}
