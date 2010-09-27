package  com.knitting.jamacoi;

import Jama.Matrix;

public   class   Auto_Correlation_1 extends Matrix {

private  static  final   long  serialVersionUID = 1L;

private          final   Matrix  residual;
private                  double  residual_ave     =  0;
private                  double  residual_sq_sum  =  0;

	
public           Auto_Correlation_1 ( final  Matrix  est_Y_residual
		                            )
                                                     
                                    { 
                                      super (      ( est_Y_residual.getRowDimension() / 4)
                                 		    ,      ( 5                                   )
                            		        );
                                                     residual  =  est_Y_residual;
                                    }
public   void    load_matrix        ()
{

                 set_residual_ave   ();
                 set_residual_sq_sum();
                 

    int     row_0                =  0;
    int     col_0                =  0;
    int     col_1                =  1;
    int     col_2                =  2;
    int     col_3                =  3;
    int     col_4                =  4;
            super.set (  row_0,  col_0,  (double) 0                      );  
            super.set (  row_0,  col_1,           1.0                    );  // by definition 
            super.set (  row_0,  col_2,           get_residual_ave()     ); 
            super.set (  row_0,  col_3,           get_sample_variance()  );
            super.set (  row_0,  col_4,           get_residual_sq_sum()  );
            
    
    for    ( int    row_ix  =  1
    	   ;        row_ix  <  super.getRowDimension()
    	   ;      ++row_ix
    	   )
           {
	             
    	     super.set ( row_ix,  col_1,  set_sample_auto_correlation    ( row_ix ) );
    	     super.set ( row_ix,  col_0,  (double) row_ix                );
    	     super.set ( row_ix,  col_2,           get_residual_ave   () );
    	     super.set ( row_ix,  col_3,           get_sample_variance() );
    	     super.set ( row_ix,  col_4,           get_residual_sq_sum() );
  
           }
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
private  void    set_residual_sq_sum()
{
         final   int      col_1  =  1;
                 residual_sq_sum =  0;
         for   ( int      row    =  0
        	   ;          row    <  residual.getRowDimension()
        	   ;        ++row
        	   )
               {
        	              residual_sq_sum += ( residual.get( row, col_1 )
        	            		             * residual.get( row, col_1 )
        	            		             );
               }
}
private  double  set_sample_auto_correlation ( final  int  lag )
{
         int     col_1                    =  1;
         double  sample_auto_correlation  =  0.0;
    
         for  (  int   row =  ( lag + 1 )
           	  ;        row <    residual.getRowDimension()
           	  ;      ++row
           	  )
              {
           	     int    row_lagged         =       row - lag - 1;
           	     sample_auto_correlation  +=  (  
           	    		                         ( residual.get( row       ,  col_1 )  -  get_residual_ave()  )
           	    		                         *
           	    		                         ( residual.get( row_lagged,  col_1 )  -  get_residual_ave()  )
           	    		                      );   
              }
          
return           sample_auto_correlation;	
}
public   double  get_sample_variance (){ return  (          residual_sq_sum
		                                         / (double) residual.getRowDimension()
		                                         );
                                       }
public   double  get_residual_ave    (){ return             residual_ave   ; }
public   double  get_residual_sq_sum (){ return             residual_sq_sum; }
}
