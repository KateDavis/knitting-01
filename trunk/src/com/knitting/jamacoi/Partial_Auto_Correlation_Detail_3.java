package com.knitting.jamacoi;
//        Read_Me to understand calculations:
//
//        Partial
//        Auto                           Auto
//        Correlation                    Correlation
//        (p)                            (a)
//
//         1  2  3  4  (index)            1   (index)
// i  o    0  1  2  3  (offset)   i  o    0   (offset)
// -  - +  -  -  -  -             -  - +  -
// 1  0 |  1  x  x  x             1  0 |  a(0,0)
// 2  1 |  3  2  x  x             2  1 |  a(1,0)
// 3  2 |  6  5  4  x             3  2 |  a(2,0)    
// 4  3 | 10  9  8  7             4  3 |  a(3,0)
//
//
//   The numbers within the p matrix indicate the order in which the entries must be calculated.  The x's
//   have the value 0 so they do not need to be calculated.
//
//   Note: the calculations listed below all use offsets NOT index values!
//
//   p(0,0)   =    a(0,0)
//
//   p(1,1)   =  [ a(1,0)  - B1    ]       /    [ 1.0    -  C1    ]
//
//   where B1 =  [ p(0,0) * a(0,0) ]       C1 = [ p(0,0) * a(0,0) ]
//                     ^      ^                       ^      ^
//                     |      |                       |      |
//
//   p(1,0)   =  [ a(0,0)  - (p(1,1) * p(0,0)) ]
//
//   p(2,2)   =  [ a(2,0) - B2     ]       /    [ 1.0    -  C2    ]     
//
//   where B2 =  [ p(1,0) * a(1,0) ]       C2 = [ p(1,0) * a(0,0) ]
//            +  [ p(1,1) * a(0,0) ]          + [ p(1,1) * a(1,0) ]
//                     ^      ^                       ^      ^
//                     |      |                       |      |
//
//
//   p(2,1)   =  [ p(1,1) - ( p(2,2) * p(1,0) ) ]
//   p(2,0)   =  [ p(1,0) - ( p(2,2) * p(1,1) ) ]
//                     ^                   ^
//                     |                   |
//
//   p(3,3)   =  [ a(3,0) - B3     ]       /    [ 1.0    -  C3    ]     
//
//   where B3 =  [ p(2,0) * a(2,0) ]       C3 = [ p(2,0) * a(0,0) ]
//            +  [ p(2,1) * a(1,0) ]          + [ p(2,1) * a(1,0) ]
//            +  [ p(2,2) * a(0,0) ]          + [ p(2,2) * a(2,0) ]
//                     ^      ^                       ^      ^
//                     |      |                       |      |
//
//   p(3,2)   =  [ p(2,2) - ( p(3,3) * p(2,0) ) ]
//   p(3,1)   =  [ p(2,1) - ( p(3,3) * p(2,1) ) ]
//   p(3,0)   =  [ p(2,0) - ( p(3,3) * p(2,2) ) ]
//                     ^                   ^
//                     |                   |

import Jama.Matrix;

public class Partial_Auto_Correlation_Detail_3 extends Matrix {
	
private  static  final   long                serialVersionUID = 1L;

private          final   Matrix   ac;

public       Partial_Auto_Correlation_Detail_3( final  Matrix  ac)
{
	         super    ( ac.getRowDimension()
	        	      , ac.getRowDimension()
	        	      );
	         this.ac = ac;
}
public void load_matrix()
{
	 for  (  int   row  =  0
		  ;        row  <  super.getRowDimension() 
		  ;      ++row
		  )
	      {
		     for   (  int   col  =   0
		    	   ;	    col  <  super.getColumnDimension()
		    	   ;	  ++col
		    	   )
		           {
		    	      super.set(  row
		    	    		   ,  col
		    	    		   ,  calculate_partial_correlation( row, col)
		    	    		   );
		           }
	      }
}
protected  double  calculate_partial_correlation( final  int  row
		                                        , final  int  col
  		                                        )
{
double               pac =  0.0;

if ( row  <  col ) { pac =  0.0                             ; }
if ( row ==  col ) { pac =  set_partial_diagonal( row     ) ; }
if ( row  >  col ) { pac =  set_partial_off_diag( row, col) ; }

return               pac;
}
protected  double  set_partial_diagonal( final  int  row )
{
final  int        col_0  =  0;
       double     pac    =  0.0;

if ( row == 0 ) { pac    =  ac.get      ( row, col_0 ); }
if ( row  > 0 ) { pac    =  set_diagonal( row        ); } 
return  pac;	
}
protected  double  set_diagonal( final  int  row )                   
{
final   int     col_0  =  0;
        double  b      =  set_b(row);
        double  c      =  set_c(row);
        double  pac    =  ( ac.get(row, col_0 )  -  b )
                       /  ( 1.0                  -  c );
return  pac;
}
protected  double  set_b( final  int  row )
{
final  int     col_0   =  0;	
final  int     max     =  row - 1;
       double  b       =  0.0;
       
       for   ( int   j =  0
    		 ;       j <  max
    		 ;     ++j
    		 )
             {
    	             b +=  ( super.get (  max   , j    ) )
    	                *  ( ac   .get ( (row-j), col_0) );
             }
return               b;
}
protected  double  set_c( final  int  row )
{
final  int     col_0   =  0;	
final  int     max     =  row - 1;
       double  c       =  0.0;
       
       for   ( int   j =  0
    		 ;       j <  max
    		 ;     ++j
    		 )
             {
    	             c +=  ( super.get ( max, j    ) )
    	                *  ( ac   .get ( row, col_0) );
             }
return               c;
}
protected  double  set_partial_off_diag( final  int  row
                                       , final  int  col
                                       )
{
final   int     max  =    row - 1;	
        double  pac  =  ( super.get(max, col) )
                     /  ( super.get(max ,max) * super.get(max,(row-col)) );  
return          pac;
}
}
