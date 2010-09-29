package com.knitting.jamacoi;
import Jama.Matrix;

public   class   Auto_Correlation_2 extends Matrix {

private  static  final   long  serialVersionUID = 1L;

private          final   Matrix  residual;
private                  double  residual_ave     =  0;
//private                  double  residual_sq_sum  =  0;

	
public           Auto_Correlation_2 ( final  Matrix  est_Y_residual
		                            )
                                                     
                                    { 
                                      super (      ( est_Y_residual.getRowDimension() / 4)
                                 		    ,      ( 5                                   )
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
	     
                 set_residual_ave   ();
                     
    for    ( int    row_ix  =  0
    	   ;        row_ix  <  super.getRowDimension()
    	   ;      ++row_ix
    	   )
           {
  	         double residual_sq_sum         =  get_residual_sq_sum            ( row_ix )  ;
	         double sample_variance         =      residual_sq_sum / (double) ( super.getRowDimension() - row_ix );
	         double correlation             =  get_sample_auto_correlation    ( row_ix )  ;
	         double auto_correlation        =  correlation
	                                        /  residual_sq_sum ;
	     
    	     super.set ( row_ix,  col_0,  (double) row_ix           );	             
    	     super.set ( row_ix,  col_1,           correlation      );
    	     super.set ( row_ix,  col_2,           auto_correlation );
    	     super.set ( row_ix,  col_3,           residual_sq_sum  );
    	     super.set ( row_ix,  col_4,           sample_variance  );
  
           }
}
private  double  get_sample_auto_correlation ( final  int  lag )
{
         int     col_1                    =  1;
         double  sample_auto_correlation  =  0.0;
    
         for  (  int   row =    lag 
           	  ;        row <    residual.getRowDimension()
           	  ;      ++row
           	  )
              {
           	     int    row_lagged         =       row - lag;
           	     sample_auto_correlation  +=  (  
           	    		                         ( residual.get( row       ,  col_1 ) )  // -  get_residual_ave()  )
           	    		                         *
           	    		                         ( residual.get( row_lagged,  col_1 ) )  // -  get_residual_ave()  )
           	    		                      );   
              }
          
return           sample_auto_correlation;	
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
private  double  get_residual_sq_sum( int  lag )
{
         final   int      col_1           =  1;
                 double   residual_sq_sum =  0;
         for   ( int      row    =  lag
        	   ;          row    <  residual.getRowDimension()
        	   ;        ++row
        	   )
               {
        	              residual_sq_sum += ( residual.get( row, col_1 )
        	            		             * residual.get( row, col_1 )
        	            		             );
               }
return                    residual_sq_sum;
}

//public   double  get_sample_variance (int lag )  { return  (            residual_sq_sum
//		                                                   / (double) ( residual.getRowDimension() - lag )
//		                                                   );
//                                       }
public   double  get_residual_ave    (){ return             residual_ave   ; }
//public   double  get_residual_sq_sum (){ return             residual_sq_sum; }
}
