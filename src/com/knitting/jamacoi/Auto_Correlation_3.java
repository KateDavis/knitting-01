package com.knitting.jamacoi;

import Jama.Matrix;

public   class   Auto_Correlation_3 extends Matrix {

private  static  final   long  serialVersionUID = 1L;

private          final   Matrix  residual;
private                  double  residual_ave     =  0;
//private                double  residual_sq_sum  =  0;

	
public           Auto_Correlation_3 ( final  Matrix  est_Y_residual
		                            )
                                                     
                                    { 
                                      super (      ( est_Y_residual.getRowDimension() / 4)
                                 		    ,      ( 7                                   )
                            		        );
                                                     residual  =  est_Y_residual;
                                    }
public   void    load_matrix        ()
{
	     int     col_0      =  0;
	     int     col_1      =  1;
	     int     col_2      =  2;
	     int     col_3      =  3;
	     int     col_4      =  4;
	     int     col_5      =  5;
	     int     col_6      =  6;
	     
                 set_residual_ave   ();
                 
// Notes on what the goal might be:
//  1) Treat the lagged variable as if it was some other variable and not lagged (i.e X)
//  2) Create the covariance between X and Y (i.e cov(X,Y) ).  Both should have the same number of terms.
//  3) Rescale the Cov(X,Y) to produce a value that ranges between -1.0 an 1.0.    
                 
// Implementation adjustments:
//  1) Assume that N is the total number of observations.  In our example N=200
//  2) Let L be the lag value ranging from 0 to (N/4).                 
//  3) Let U = (N - L) be the total number of usable observations for both X and Y.
//  4) Since the input values are already OLS residuals,  The average of the residuals is by definition 0.0.
//  5) Warning: the average of a subset of the residual will not be zero, but it should be very close to 0.0 especially when L is small compared to N.
//              As a result, the average of the subsets will not be calculated.  This might be a mistake.                 
                     
    for    ( int    row_ix  =  0
    	   ;        row_ix  <  super.getRowDimension()
    	   ;      ++row_ix
    	   )
           {
    	     int    lag                     =  row_ix;
    	     int    usable                  =  residual.getRowDimension()    //      N  = 200:   N  - lag
    	                                    -  lag;                          // usable  = 200 = 200 -  0
    	                                                                     //           199 = 200 -  1
    	                                                                     //           198 = 200 -  2
    	     
    	     double variance_y              =  get_variance          (   usable
    	    		                                                 ,   row_ix 
    	    		                                                 );
    	     
    	     double variance_x              =  get_variance          (   usable
    	    		                                                 , ( row_ix - lag )
    	    		                                                 );
    	     
    	     double covariance_x_y          =  get_covariance        (   usable
    	    		                                                 ,   lag
    	    		                                                 ,   row_ix
    	    		                                                 );
    	     
    	     double cor                     =  get_correlation       (   covariance_x_y 
    	    		                                                 ,     variance_x   
    	    		                                                 ,     variance_y
    	    		                                                 );
    	     
       	     double ac                      =  get_auto_correlation  (   covariance_x_y 
                                                                     ,     variance_x   
                                                                     ,     variance_y
                                                                     );

    	     double ac_variance             =  get_ac_variance       (   usable
    	    		                                                 ,   row_ix
    	    		                                                 ,   lag
    	    		                                                 ,   variance_y
    	    		                                                 );
    	     double ac_std_dev              =  Math.sqrt             (   ac_variance );
    	     double ac_95_percent           =  ac_std_dev * 2;
    	     
    	     super.set ( row_ix,  col_0,           ac                  );
    	     super.set ( row_ix,  col_1,           ac_95_percent       );
    	     
    	     super.set ( row_ix,  col_2,           covariance_x_y      ); 
    	     super.set ( row_ix,  col_3,           variance_x          );  
    	     super.set ( row_ix,  col_4,           variance_y          );  
    	     
    	     super.set ( row_ix,  col_5,           ac_variance         );
    	     super.set ( row_ix,  col_6,           cor                 );
  
           }
}
private  double  get_variance( final  int  usable
		                     , final  int  row
		                     )
{
	     int       col_1  =     1;
	     double      sum  =   0.0;
	     
	     for   ( int i    =   row
	    	   ;     i    < ( row + usable )
	    	   ;   ++i  		 
	    	   )
	           {
	    	         sum +=  (    residual.get( i , col_1 )
	    	        		 *	  residual.get( i , col_1 )
	    	        		 );
	           }
	     
return               sum  /  (double) usable;    
}
private  double  get_covariance( final  int  usable   
		                       , final  int  lag
		                       , final  int  row
		                       )
{
	     int       col_1  =   1;
         double      sum  = 0.0;
         
	     for   ( int i    =   row
		       ;     i    < ( row + usable )
		       ;   ++i  		 
		       )
		       {
		    	   sum +=  (    residual.get(  ( i - lag ), col_1 )
		    	           *	residual.get(  ( i       ), col_1 )
		    	           );
	           }
		     
return             sum     /    (double) usable;
}
private  double  get_correlation      ( final  double  covariance_x_y   // Note: this is the ordinary definition of correlation (i.e R squared).
		                              , final  double    variance_x
		                              , final  double    variance_y
		                              )
{
return    ( covariance_x_y   *   covariance_x_y )
        / (   variance_x     *     variance_y   );		
}
private  double  get_auto_correlation ( final  double  covariance_x_y   // Note: similar to Walter Ender's deiinition
                                      , final  double    variance_x
                                      , final  double    variance_y
                                      )
{
return    ( covariance_x_y   )
        / ( Math.sqrt(  variance_x     *     variance_y   ) );		
}
private  double  get_ac_variance ( final  int     usable
		                         , final  int     row
		                         , final  int     lag
		                         , final  double  y_subset_std_dev
		                         )
{	     
	     if ( lag == 0 )     { return ( y_subset_std_dev * y_subset_std_dev ); }
	     if ( lag == 1 )     { return (        1.0       / (double) usable  ); }
	     
return   get_lagged_variance ( usable
		                     , row
		                     , lag
		                     );
}
private  double  get_lagged_variance ( final  int  usable
		                             , final  int  row
		                             , final  int  lag
		                             )
         
{
final    int     col_0  =    0;
	     double  t      =  1.0 / (double) usable;
	     double  sum    =  1.0;
	     
	     for  ( int   i = 1
	    	  ;	      i < lag
	    	  ;	    ++i  
	    	  )
	          {
	    	    sum  += ( 2.0 * ( super.get(i, col_0)
	    	    		        * super.get(i, col_0)
	    	    		        )
	    	    		);
   	          }
return          sum * t;	
}

private  void    set_residual_ave()
{
         final   int      col_1  =  1;
                 residual_ave    =  0;
         for   ( int      row    =  0
        	   ;          row    <  residual.getRowDimension()
        	   ;        ++row
        	   )
               {
        	              residual_ave += residual.get( row, col_1 );
               }
                          residual_ave  = residual_ave / (double) residual.getRowDimension();
}
public  double  get_residual_ave    (){ return             residual_ave   ; }
public  String  get_significance( int  row )
{ 
	    int    col_0 = 0;
	    int    col_1 = 1;
	    if   ( Math.abs(super.get( row, col_0)) > super.get( row, col_1) )
	         {
	    	   return "Significant";
	         }
	    else
	         {
               return "not sig";	    	
	         }
}
}

