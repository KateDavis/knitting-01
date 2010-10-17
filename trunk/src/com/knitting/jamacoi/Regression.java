package com.knitting.jamacoi;
import java.util.ArrayList;

import Jama.Matrix;

/**
 * This class implements the standard least squares analysis
 * on the supplied rectangular data matrix. This class provides the algebraic
 * muscle to calculate:
 * <br>
 * <br>
 * 1) the estimated equation of coefficients.
 * <br>
 * 2) the analysis of errors.
 * <br>
 * 3) test of significance at different levels of confidence.
 * <br>
 * <br>
 * This class provides simple reporting capabilities via its
 * "get" and "print" methods.  More usable and more meaningful reporting is
 * provided by the Report_Regression_Results class.
 * @author Datamap, Inc
 * 
 */

public class Regression 
{
	private Integer   T_d_of_freedom; // degrees of freedom of the dependent   var    
	private Integer   X_d_of_freedom; // degrees of freedom of the independent vars
	private Integer   R_d_of_freedom; // degrees of freedom of the residual errors

	private Matrix    YX;
	private Matrix    row_of_ones;    // used to calc sum of cols
	private Matrix    YX_sum_of_cols; // sum of each col of YX
	private Matrix    YX_ave_of_cols; // sum/(num of rows) = ave of each col
	private Matrix    YX_dev;         // each cell of YX minus its associated
	                                  //      column ave from YX_ave_of_cols

	private Matrix     Y_dev;         // y deviations (a submatrix of YX_dev)
	private Matrix     X_dev;         // x deviations (a submatrix of YX_dev)
	private Matrix   t_X_dev;         // transpose of  X_dev
	private Matrix  p_XX_dev;         // product   of [t_X_dev][X_dev]
	private Matrix  p_XX_dev_adjusted;// product   of [t_X_dev][X_dev](1/obs-1)
	private Matrix  i_XX_dev;         // inverse   of [p_XX_dev]
	private Matrix  t_XY_dev;         // product   of [t_X_dev][Y_dev]
	private Matrix  est_Y_residual;   // a [N,2] matrix:
	                                  //         1st column: estimated Y
	                                  //         2nd column: residual = (Y - est_Y)
	private Matrix  auto_correlation; // a [N,1] matrix: needs est_Y_residual as input
	private Auto_Correlation_1  ac1;  //
	private Auto_Correlation_2  ac2;  //
	private Auto_Correlation_3  ac3;  //
	private Partial_Auto_Correlation_Detail_3    pac3;

	private Matrix  Estimated_Coefficients;   // a matrix [cols x 1] 
	private double  Estimated_Intercept;      // a scalar 

	private boolean has_enough_rows = false;  // set to true during?
	private boolean is_invertable   = false;  // set to true if estimate
	                                          // is called and if determinate
	                                          // is greater than user's
	                                          // error value?
	private boolean is_estimated    = false;  // set to true by the "estimate"
	                                          // method if it is successful.

	private boolean is_significant  = false;  // meets user's error criteria

	private double  det_XX_dev;               // determinate of [p_XX_dev]

	private Double  err_total;
	private Double  err_explained;
	private Double  err_residual;

	private Double  pct_err_total;
	private Double  pct_err_explained;
	private Double  pct_err_residual;

	private Double  F_value;
	/**
	 * 
	 * This method builds most of the needed interminate results for the
	 * regression object.  These results can be very time consuming to 
	 * calculate as the amount of data grows.  This method requires a rectangular
	 * matrix of double values.  The most common method of supplying this
	 * rectangular matrix is to use the Rectangular_CVS_Matrix class.  The
	 * rectangular input matrix consists of two logical parts:
	 * <br>
	 * <br>
	 * 1) the first column must be the dependent variable referred traditionally to
	 * as Y;
	 * <br>
	 * 2) multiple other columns which represent the independent variables referred
	 * traditionally,in whole, to as X.  
	 * <br>
	 * <br>
	 * Symbolically the rectangular input matrix is: YX
	 * 
	 */ 
	public Regression  ( Sub_Matrix sub_matrix )                      
	       throws        not_enough_rows        
	{
	    YX             = new Matrix          ( sub_matrix.get_Data()
	                                         );
	    
	    row_of_ones    = new Matrix          (1     // # of rows
	                                         ,YX.getRowDimension()
	                                         ,1.0   // # the value
	                                         );
	    YX_sum_of_cols = row_of_ones   .times(YX);
	    
	    YX_ave_of_cols = YX_sum_of_cols.times( 1.0
	                                         / (double) YX.getRowDimension()
	                                         );
	    
	    YX_dev =   calc_deviations ( YX
	                               , YX_ave_of_cols
	                               );
	  
	     Y_dev =   YX_dev.getMatrix( 0                           //start row offset
	                               , YX.getRowDimension()    - 1 //end   row offset
	                               , 0                           //start col offset
	                               , 0                           //end   col offset
	                               );
	     
	     X_dev =   YX_dev.getMatrix( 0                           //start row offset
	                               , YX.getRowDimension()    - 1 //end   row offset
	                               , 1                           //start col offset
	                               , YX.getColumnDimension() - 1 //end   col offset
	                               );     
	     
	   t_X_dev =    X_dev.transpose();
	   
	  p_XX_dev =  t_X_dev.times(X_dev); // Matrix product of [t_X_dev] and [X_dev]
	  
	  p_XX_dev_adjusted = p_XX_dev.times( 1.0/( (double) YX.getRowDimension() ) );
	  
	  enough_rows    ( YX.getRowDimension()
	                 , YX.getColumnDimension()
	                 );
	  
	  det_XX_dev     = p_XX_dev.det();  // very, very expensive calculation!!!!

	    t_XY_dev     =  t_X_dev.times(Y_dev);  
	  
	  T_d_of_freedom = YX.getRowDimension()
	                 - 1;
	    
	  R_d_of_freedom = YX.getRowDimension()
	                 - YX.getColumnDimension();
	  
	  X_d_of_freedom = YX.getColumnDimension()
	                 - 1;
	  
	  try   {
	          estimate_coefficients(1.0E-05);
	        }
	  catch ( not_enough_rows e ) {}
	  catch ( not_significant e ) {}
	  catch ( not_invertable  e ) {} ;

	  est_Y_residual   = calc_estimated_y_and_residuals();
	  auto_correlation = calc_auto_correlations        ();
	  
	  ac1              = new Auto_Correlation_1( est_Y_residual );
	  ac1.load_matrix();
	  ac2              = new Auto_Correlation_2( est_Y_residual );
	  ac2.load_matrix();
	  ac3              = new Auto_Correlation_3( est_Y_residual );
	  ac3.load_matrix();
	  
final int row_initial  =   0;
final int row_final    = ( ac3.getRowDimension() -1 );
final int col_initial  =   0;
final int col_final    =   0;
	  
	  pac3             = new Partial_Auto_Correlation_Detail_3 ( ac3.getMatrix( row_initial
			                                                                  , row_final
			                                                                  , col_initial
			                                                                  , col_final
			                                                                  )
			                                                   );
	  pac3.load_matrix();
	  
	}
	private void       enough_rows ( final int rows
	                               , final int cols
	                               )
	        throws not_enough_rows                  
	{
	 final int   rows_min = cols + 1;
	 
	 if ( rows < rows_min )
	    {
	     throw new not_enough_rows( rows
	                              , cols
	                              , rows_min
	                              );
	    }
	 else
	    {
	     set_has_enough_rows(); 
	    }
	}                          
	private void    set_has_enough_rows(){       has_enough_rows = true; }
	public  boolean get_has_enough_rows(){return has_enough_rows;        }

	private Matrix  calc_estimated_y_and_residuals(){
	    
	 Matrix est_Y_and_residuals = new Matrix ( YX.getRowDimension() // # of rows
	                                         , 2                    // # of columns
	                                         );
	 double  estimated_y;
	 double  residual;

	 int     ic;
	 int     ir;
	 for  (  ir = 0
	      ;  ir < est_Y_and_residuals.getRowDimension()
	      ;++ir
	      )
	      {
	         estimated_y = Estimated_Intercept;
	         for  (  ic  = 1
	              ;  ic  < YX.getColumnDimension()
	              ;++ic
	              )
	              {
	              // Note: Estimated_Coefficients is a column vector, or
	              //       a [row, 1] matrix.
	                 estimated_y += (YX                    .get(ir  ,ic  )
	                                 *
	                                 Estimated_Coefficients.get(ic-1, 0  )
	                                );
	              }
	         residual = YX.get(ir , 0)   -  estimated_y ;
	         
	         est_Y_and_residuals.set(ir, 0, estimated_y);
	         est_Y_and_residuals.set(ir, 1, residual   );
	      }
	 return est_Y_and_residuals;
	}
	private Matrix  calc_auto_correlations(){
            int     max_count            =  est_Y_residual.getRowDimension() / 4;
	        Matrix  auto_correlation     =  new Matrix ( max_count  // # of rows
			                                           , 5          // # of cols
			                                           );
	
	        double  ave_residual         =  get_ave_residual();
	        double  sum_sqt_residuals    =  get_sum_sqt_residuals            ( ave_residual );
	        double  sample_variance      =  sum_sqt_residuals                / est_Y_residual.getRowDimension();

	        int     row_0                =  0;
	        int     col_0                =  0;
	        int     col_1                =  1;
	        int     col_2                =  2;
	        int     col_3                =  3;
	        int     col_4                =  4;
	                auto_correlation.set (  row_0,  col_0,  (double) 0                 );  
	                auto_correlation.set (  row_0,  col_1,           1.0               );  // by definition 
	                auto_correlation.set (  row_0,  col_2,           ave_residual      ); 
	                auto_correlation.set (  row_0,  col_3,           sample_variance   );
	                auto_correlation.set (  row_0,  col_4,           sum_sqt_residuals );
	                
	        
	        for    ( int    row_ix  =  1
	        	   ;        row_ix  <  max_count
	        	   ;      ++row_ix
	        	   )
	               {
  		             
	        	     auto_correlation.set ( row_ix,  col_1,  get_sample_auto_correlation( row_ix
	        	    		            		                                        , ave_residual
	        	    		            		                                        , sum_sqt_residuals
	        	    		            		                                        )
	        	    		              );       
	        	     auto_correlation.set ( row_ix,  col_0,  (double) row_ix            );
	        	     auto_correlation.set ( row_ix,  col_2,           ave_residual      );
	        	     auto_correlation.set ( row_ix,  col_3,           sample_variance   );
	        	     auto_correlation.set ( row_ix,  col_4,           sum_sqt_residuals );
          
	               }
	return          auto_correlation;
	}
	private  double  get_ave_residual() {
		     int     col_residual = 1;
		     double  ave_residual = 0;
		             for  ( int   row_ix  = 0
			   	          ;       row_ix  < est_Y_residual.getRowDimension()
				          ;     ++row_ix
		                  )
		                  {
		    	            ave_residual += est_Y_residual.get( row_ix,  col_residual );
		                  }
    return                  ave_residual  / (double)est_Y_residual.getRowDimension();		             
	}
	private  double  get_sum_sqt_residuals( double  ave_residual ) {
	         int     col_residual         = 1;
	         double  sum_sqt_residuals    = 0;
	                 for  ( int   row_ix  = 0
		   	              ;       row_ix  < est_Y_residual.getRowDimension()
			              ;     ++row_ix
	                      )
	                      {
	    	                sum_sqt_residuals  += (  est_Y_residual.get( row_ix,  col_residual )
	    	            	  	                  *  est_Y_residual.get( row_ix,  col_residual )
	    	            		                  );
	                      }
    return                  sum_sqt_residuals;		             
    }
	private  double  get_sample_auto_correlation ( int     lag
			                                     , double  ave_residual
			                                     , double  sum_sqt_residual
			                                     )
	{
		     int     col_residual             =  1;
		     double  sample_auto_correlation  =  0.0;
		     
		             for  (  int   row_ix =  ( lag + 1 )
		            	  ;        row_ix <  est_Y_residual.getRowDimension()
		            	  ;      ++row_ix
		            	  )
		                  {
		            	     int    row_lagged         =       row_ix - lag - 1;
		            	     sample_auto_correlation  +=  (  
		            	    		                         ( est_Y_residual.get( row_ix,      col_residual )  -  ave_residual  )
		            	    		                         *
		            	    		                         ( est_Y_residual.get( row_lagged,  col_residual )  -  ave_residual  )
		            	    		                      );   
		                  }
		           
	return                   sample_auto_correlation;
	}
	public double get_est_Y_residual ( int ir
	                                 , int ic
	                                 )
	{
	       return est_Y_residual.get(ir, ic);
	}
	private double  estimate_intercept (){
	    //    [ 1 x (col - 1)]
	    Matrix X_ave      = YX_ave_of_cols.getMatrix( 0     // row at offset 0
	                                                , 0     // row at offset 0
	                                                , 1     // col at offset 1
	                                                , YX.getColumnDimension() - 1
	                                                );
	    double Y_ave      = YX_ave_of_cols.get      (0, 0);
	    
	    //     [ 1 x 1 ]  = [ 1 x (cols -1)]        [ (cols - 1) x 1 ]
	    Matrix one_by_one = X_ave         .times    (Estimated_Coefficients);
	    
	    double scalar     = one_by_one    .get      (0, 0);
	    
	    double intercept  = Y_ave
	                      - scalar;
	    
	    return intercept;
	}/**
	 * This method attempts to calculate all of the regression results, if possible.
	 * The supplied data may prevent the results from being calculated.  The 
	 * supplied data must have specific properties to allow the results to be
	 * calculated.  If the supplied data does not have these required properties,
	 * this method will throw appropriate exceptions to alert the caller of any
	 * problem.  This method calculates the following results:
	 * <br>
	 * <br>
	 * 1) the inverse matrix to the variance-covariance matrix.
	 * <br>
	 * 2) the vector of estimated coefficients for the independent variables.  
	 * <br>
	 * 3) the estimated regression intercept. 
	 * <br>
	 * 4) the amount of total sum squared error deviations explained by the
	 * the independent variables.
	 * <br>
	 * 5) the F-value result of the regression which is a measure of the
	 * significance of the regression.     
	 * <br>
	 * @param min_determinate is a double field.  The purpose of this field
	 * is to prevent the degeneration of the analysis because the analysis
	 * produced a determinate value that was smaller than this parameter.
	 * When the determinate is too small, the results cannot
	 * be relied upon.  A small determinate will produce results similar to
	 * dividing by a number close to zero.  A reasonable starting value for
	 * this parameter is 1.0E-05      
	 */    
	public  void    estimate_coefficients( double min_determinate )
	        throws  not_enough_rows
	             ,  not_invertable 
	             ,  not_significant
	{   if  (!has_enough_rows   ) {throw new not_enough_rows()    ;}
	    if  ( det_XX_dev == 0.0 ) {throw new not_invertable ()    ;}
	    else                      {           is_invertable = true;}
	    
	    if   ( Math.abs(det_XX_dev) < Math.abs(min_determinate) )
	         {
	           throw new not_significant( min_determinate
	                                    , this
	                                    );
	         }
	    else {            is_significant = true; }
	    
	    i_XX_dev               = p_XX_dev.inverse  (); // very, very expensive!!
	    Estimated_Coefficients = i_XX_dev.times    (t_XY_dev);
	    Estimated_Intercept    = estimate_intercept();
	    do_error_analysis();
	    
	    is_estimated = true;
	}
	private void   do_error_analysis()
	{
	    Matrix t_Est_Coeff   = Estimated_Coefficients.transpose();
	    Matrix t_Y_dev       =   Y_dev.transpose();
	    
	           err_total     = t_Y_dev.times(Y_dev).get(0,0);
	       pct_err_total     = 100.00;    
	          
	           err_explained = t_Est_Coeff.times(t_X_dev.times(Y_dev)).get(0,0);
	       pct_err_explained = (err_explained * 100.0)
	                         /  err_total;
	           
	           err_residual  =     err_total                      
	                         -     err_explained;
	           
	       pct_err_residual  = pct_err_total
	                         - pct_err_explained;
	           
	    
	           F_value       = (err_explained * R_d_of_freedom)
	                         / (err_residual  * X_d_of_freedom);
	    return;
	}
	/**
	 * This method returns the total sum of squared errors of deviations.
	 */   
	public Double  get_Error_Total()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }
	       return      err_total;
	}
	public Double  get_Pct_Error_Total()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }        
	       return      pct_err_total;
	}
	/**
	 * This method returns the total sum of squared errors of deviations explained 
	 * by the independent variables.
	 */ 
	public Double  get_Error_Explained()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }          
	       return      err_explained;
	}
	public Double  get_Pct_Error_Explained()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }          
	       return      pct_err_explained;
	}
	/**
	 * This method returns the total sum of squared errors of deviations UNEXPLAINED 
	 * by the independent variables.
	 */ 
	public Double  get_Error_Residual()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }          
	       return      err_residual;
	}  
	public Double  get_Pct_Error_Residual()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }          
	       return      pct_err_residual;
	} 
	/**
	 * This method returns the total degrees of freedom of the data.
	 */ 
	public Integer get_T_d_of_freedom()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }          
	       return      T_d_of_freedom;
	}
	/**
	 * This method returns the degrees of freedom of the independent variables.
	 */
	public Integer get_X_d_of_freedom()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }          
	       return      X_d_of_freedom;
	}
	/**
	 * This method returns the degrees of freedom of the residual errors.
	 */
	public Integer get_R_d_of_freedom()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }          
	       return      R_d_of_freedom;
	}
	public Double  get_F_value()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }          
	       return      F_value;
	}
	public Double  get_Estimated_Intercept()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }         
	       return      Estimated_Intercept;
	}
	public ArrayList<Double> get_Estimated_Coefficients()
	       throws  not_estimated
	{      if     (!is_estimated() )  {throw new not_estimated(); }         
	       ArrayList<Double> c = new ArrayList<Double>();
	       int ix;
	       int ix_max          = Estimated_Coefficients.getRowDimension();
	       
	       for (ix   = 0
	           ;ix   < ix_max
	           ;ix++
	           )
	           {
	            c.add(Estimated_Coefficients.get(ix, 0));          
	           }
	       
	       return  c;
	}
	public boolean is_estimated  (){return is_estimated  ;}
	public boolean is_significant(){return is_significant;}
	public boolean is_invertable (){return is_invertable ;}

	/**
	 * This method prints the Y deviation matrix: Y_dev.  The Y_dev
	 * matrix is related to the rectangular input matrix, YX, as follows:
	 * <br>
	 * <br>
	 * <TT>Let:</TT>
	 * <br>
	 * <TT><pre>       Y_ave = (sum_of_all Y's)/(number_of_rows in YX), then</pre></TT>
	 * <br>
	 * <TT><pre>Y_dev(row,1) = [ Y(row,1) - Y_ave ]</pre></TT>
	 */
	public  void   print_Y_dev()    {
	                     Y_dev    . print (10, 5);
	}
	/**
	 * This method prints the X deviation matrix: X_dev.  The X_dev
	 * matrix is related to the rectangular input matrix, YX, as follows:
	 * <br>
	 * <br>
	 * <TT>Let:</TT>
	 * <br>
	 * <TT><pre>    X_ave(col) = (sum_of_all X's in column = col)/(number_of_rows in YX), then</pre></TT>
	 * <br>
	 * <TT><pre>X_dev(row,col) = [ X(row,col) - X_ave(col) ]</pre></TT>
	 */
	public  void   print_X_dev()    {
	                     X_dev    . print (10, 5);
	}
	/**
	 * This method prints the tranpose of the X deviation matrix: t_X_dev.  The t_X_dev
	 * matrix is related to the rectangular input matrix, YX, as follows:
	 * <SMALL>
	 * <br>
	 * <br>
	 * <TT>Let:</TT>
	 * <br>
	 * <TT><pre>1)      X_ave(col) = (sum_of_all X's in column = col)/(number_of_rows in YX) and</pre></TT>
	 * <TT><pre>2)  X_dev(row,col) = [ X(row,col) - X_ave(col) ], then </pre></TT>
	 * <br>
	 * <TT><pre>t_X_dev(row,col) = X_dev(col,row)</pre></TT>
	 * </SMALL>
	 */
	public  void   print_t_X_dev()  {
	                     t_X_dev  . print (10, 5);
	}
	/**
	 * This method prints the product of two matrixs: the tranpose of the X 
	 * deviation matrix and the X deviation matrix: p_XX_dev.  The p_XX_dev
	 * matrix is related to the rectangular input matrix, YX, as follows:
	 * <SMALL>
	 * <br>
	 * <br>
	 * <TT>Let:</TT>
	 * <br>
	 * <TT><pre>1)      X_ave(col) = (sum_of_all X's in column = col)/(number_of_rows in YX) and</pre></TT>
	 * <TT><pre>2)  X_dev(row,col) = [ X(row,col) - X_ave(col) ], then </pre></TT>
	 * <TT><pre>3)t_X_dev(row,col) = X_dev(col,row)</pre></TT>
	 * <br>
	 * <TT><pre>          p_XX_dev = [t_X_dev][X_dev] </pre></TT>
	 * </SMALL>
	 */
	public  void   print_p_XX_dev() {
	                     p_XX_dev . print (10, 5);
	}
	/**
	 * This method prints the product of two matrixs: the tranpose of the X 
	 * deviation matrix and the Y deviation matrix: t_XY_dev.  The t_XY_dev
	 * matrix is related to the rectangular input matrix, YX, as follows:
	 * <SMALL>
	 * <br>
	 * <br>
	 * <TT>Let:</TT>
	 * <br>
	 * <TT><pre>1)      X_ave(col) = (sum_of_all X's in column = col)/(number_of_rows in YX) and</pre></TT>
	 * <TT><pre>2)  X_dev(row,col) = [ X(row,col) - X_ave(col) ]</pre></TT>
	 * <TT><pre>3)t_X_dev(row,col) = X_dev(col,row)</pre></TT>
	 * <br>
	 * <TT><pre>4)           Y_ave = (sum_of_all Y's)/(number_of_rows in YX)</pre></TT>
	 * <TT><pre>5)    Y_dev(row,1) = [ Y(row,1) - Y_ave ], then</pre></TT>
	 * <br>
	 * <TT><pre>          t_XY_dev = [t_X_dev][Y_dev] </pre></TT>
	 * </SMALL>
	 */
	public  void   print_t_XY_dev() {
	                     t_XY_dev . print (10, 5);
	}
	/**
	 * This method prints the deteminate of the product of two matrixs: 
	 * <br>
	 * <br>
	 * the 
	 * 1) transpose of the X deviation matrix, and
	 * <br>
	 * 2) the X deviation matrix:
	 * <br>
	 * <br>
	 * det_XX_dev.
	 * The t_X_dev matrix and the X_dev matrix are related to the rectangular input
	 * matrix, YX, as follows:
	 * <SMALL>
	 * <br>
	 * <br>
	 * <TT>Let:</TT>
	 * <br>
	 * <TT><pre>1)      X_ave(col) = (sum_of_all X's in column = col)/(number_of_rows in YX) and</pre></TT>
	 * <TT><pre>2)  X_dev(row,col) = [ X(row,col) - X_ave(col) ]</pre></TT>
	 * <TT><pre>3)t_X_dev(row,col) = X_dev(col,row)</pre></TT>
	 * <br>
	 * <TT><pre>        det_XX_dev = det | [t_X_dev][Y_dev] | </pre></TT>
	 * <br>
	 * <TT><pre>where   dey_XX_dev is a scalar value and NOT a matrix.</pre></TT>
	 * </SMALL>
	 */
	public double  get_det_XX_dev() {
	       return  det_XX_dev;
	}
	public double  get_p_XX_dev_cell(int row, int col){
	       return  p_XX_dev.get(row, col);
	}
	public int     get_p_XX_dev_cols(){
	       return  p_XX_dev.getColumnDimension();
	}
	public int     get_p_XX_dev_rows(){
	       return  p_XX_dev.getRowDimension();
	}

	public double  get_p_XX_dev_adjusted_cell(int row, int col){
	       return  p_XX_dev_adjusted.get(row, col);
	}
	public int     get_p_XX_dev_adjusted_cols(){
	       return  p_XX_dev_adjusted.getColumnDimension();
	}
	public int     get_p_XX_dev_adjusted_rows(){
	       return  p_XX_dev_adjusted.getRowDimension();
	}
	public double  get_YX_cell(int row, int col){
	       double  d=YX.get(row, col);
	       return  d;
	}
	public int      get_YX_max_cols        (){ return  YX              .getColumnDimension();  }
	public int      get_YX_max_rows        (){ return  YX              .getRowDimension   ();  }       
	
	public int      get_Auto_Corr_max_cols (){ return  auto_correlation.getColumnDimension();  }
	public int      get_Auto_Corr_max_rows (){ return  auto_correlation.getRowDimension   ();  }       
//	public double   get_Auto_Corr_cell     ( int  row
//			                               , int  col
//			                               ) { return  auto_correlation.get(row,col)        ;  }    
	
//	public Auto_Correlation_1  get_Auto_Correlation_1() { return  ac1;}
	public Auto_Correlation_2  get_Auto_Correlation_2() { return  ac2;}
	public Auto_Correlation_3  get_Auto_Correlation_3() { return  ac3;}
	 

	public  void   print_est_coefficients()
	        throws not_estimated
	{
	if   ( is_estimated ) {}
	else                  {throw new not_estimated(this);}

	Estimated_Coefficients . print (10, 5);
	}
	public  void   print_est_intercept()
	        throws not_estimated
	{
	if   ( is_estimated ) {}
	else                  {throw new not_estimated(this);}

	System.out.println ( "Estimate Intercept = >"
	                   + get_intercept()
	                   + "<"
	                   );
	}
	private double get_intercept(){return Estimated_Intercept;}

	private Matrix calc_deviations  ( Matrix YX
	                                , Matrix YX_ave_of_cols
	                                ){
	    Matrix yx_dev  = new Matrix ( YX.getRowDimension()
	                                , YX.getColumnDimension()
	                                );
	    int ix_row;
	    int jx_col;
	    
	    for ( ix_row = 0
	        ; ix_row < YX.getRowDimension()
	        ; ix_row++
	        )
	        {
	          for ( jx_col = 0
	              ; jx_col < YX.getColumnDimension()
	              ; jx_col++
	              )
	              {
	                yx_dev.set( ix_row
	                          , jx_col
	                          , ( YX             . get (ix_row, jx_col)
	                            - YX_ave_of_cols . get (0     , jx_col)
	                            )            
	                          );
	              }
	        }
	    return yx_dev; 
	}
}
