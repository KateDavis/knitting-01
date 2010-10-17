package com.knitting.jamacoi;
import java.util.Formatter;

import Jama.Matrix;

public class Partial_Auto_Correlation_Detail_3 extends Matrix {
	
private  static  final   long                serialVersionUID = 1L;

private          final   boolean  debug;
private          final   Matrix   ac;

public       Partial_Auto_Correlation_Detail_3( final  Matrix  ac)
{
	         super    ( ac.getRowDimension()
	        	      , ac.getRowDimension()
	        	      );
	         this.ac = ac;
	         debug   = false;
}
public       Partial_Auto_Correlation_Detail_3( final  Matrix  ac
		                                      , final  boolean debug
		                                      )
{
	         super    ( ac.getRowDimension()
	        	      , ac.getRowDimension()
	        	      );
	         this.ac     =  ac;
	         this.debug  =  debug;
}
public void load_matrix()
{
	 for  (  int   row  =  0
		  ;        row  <  super.getRowDimension() 
		  ;      ++row
		  )
	      {
		     for   (  int   col  =   row
		    	   ;	    col >=   0
		    	   ;	  --col
		    	   )
		           {
		    	      super.set(  row
		    	    		   ,  col
		    	    		   ,  calculate_partial_correlation( row, col)
		    	    		   );
		           }
	      }
}
private    boolean get_debug(){ return debug; }

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
        
        if ( get_debug() )
           {
            Formatter line = new Formatter();
                      line . format( "%s%d%s%d%s%7.4f%s%7.4f%s%n"
                     		       , "p("
                	    	       ,  row
                		           , ","
                		           ,  row
                		           , ") = ("
                		           ,   ac.get(row, col_0 )
                		           , " - "
                		           ,  b
                		           , " )"
                		           );
                      line . format( "%s%7.4f%s%n"
                		           , "       / ( 1.0    - "
                		           ,  c
                		           , " )"
                		           );
                      line . format( "%s%d%s%d%s%7.4f%s%n"
                		           , "p("
           	    	               ,  row
           		                   , ","
           		                   ,  row
           		                   , ") = >"
           		                   ,  pac
           		                   , "<"
           		                   );
                      System.out.println( line );
           }           
return  pac;
}
//
// p(1,1);
//
// where B1 =  [ p(0,0) * a(0,0) ]       C1 = [ p(0,0) * a(0,0) ]
//                   ^      ^                       ^      ^
//                   |      |                       |      |
//
//        ? =[(-0.8445) * (-0.8445)]      ?=[(-0.8445) * (-0.8445)]
//
//
// p(2,2):
//
// where B2 =  [ p(1,0) * a(1,0) ]       C2 = [ p(1,0) * a(0,0) ]
//          +  [ p(1,1) * a(0,0) ]          + [ p(1,1) * a(1,0) ]
//                   ^      ^                       ^      ^
//                   |      |                       |      |
//
//       ?  =  [(-1.204) * ( 0.591 )]     ? = [(-1.204) * (-0.8445)]
//          +  [(-0.426) * (-0.8445)]       + [(-0.426) * ( 0.591 )]
//
// p(3,3):
// 
// where B3 =  [ p(2,0) * a(2,0) ]       C3 = [ p(2,0) * a(0,0) ]
//          +  [ p(2,1) * a(1,0) ]          + [ p(2,1) * a(1,0) ]
//          +  [ p(2,2) * a(0,0) ]          + [ p(2,2) * a(2,0) ]
//                   ^      ^                       ^      ^
//                   |      |                       |      |
//
protected  double  set_b( final  int  row )              // row = 1
{
final  int     col_0   =  0;	
       double  b       =  0.0;
       
       for   ( int   j = (row-1)                           // j   = 0
    		 ;       j>=  0
    		 ;     --j
    		 )
             {
	           double p =    super.get ( (row-1)  , (row-j-1) )
	                    *    ac   .get ( (j    )  , (col_0  ) );
               //       *    ac   .get ( (row-j-1), (col_0  ) );
	           
	           if ( get_debug() )
	              {
    	            Formatter line = new Formatter();
    	                      line . format ( "%s%d%s%d%s%d%s%7.4f%s%s%d%s%d%s%7.4f%s%7.4f%s"
    	                  		            , "for B row("
    	                		            , row
    	                		            , "): super("
    	                		            ,  (row-1)
    	                		            , ","
    	                		            ,  (row-j-1)
    	                		            , ") = >"
    	                		            , super.get ( (row-1), (row-j-1) )
    	                		            , "<   "
    	                		            , "ac("
    	                		            ,  j
    	                		            , ","
    	                		            , col_0
    	                		            , ") = >"
    	                		            , ac   .get (  j     , (col_0) )
    	                		            , "<  product = >"
    	                		            ,  p
    	                		            , "<"
    	                		            );
    	            System.out.println( line );  
	              }

    	        b  += p;
             }
return          b;
}
//
// p(1,1);
//
// where B1 =  [ p(0,0) * a(0,0) ]       C1 = [ p(0,0) * a(0,0) ]
//                   ^      ^                       ^      ^
//                   |      |                       |      |
//
//
// p(2,2):
//
// where B2 =  [ p(1,0) * a(1,0) ]       C2 = [ p(1,0) * a(0,0) ]
//          +  [ p(1,1) * a(0,0) ]          + [ p(1,1) * a(1,0) ]
//                   ^      ^                       ^      ^
//                   |      |                       |      |
//
//
// p(3,3):
//
// where B3 =  [ p(2,0) * a(2,0) ]       C3 = [ p(2,0) * a(0,0) ]
//          +  [ p(2,1) * a(1,0) ]          + [ p(2,1) * a(1,0) ]
//          +  [ p(2,2) * a(0,0) ]          + [ p(2,2) * a(2,0) ]
//                   ^      ^                       ^      ^
//                   |      |                       |      |
//
protected  double  set_c( final  int  row )
{
final  int     col_0   =  0;	
       double  c       =  0.0;
       
       for   ( int   j =  0
    		 ;       j <  row
    		 ;     ++j
    		 )
             {
 	           double p  =  ( super.get ( (row-1), j    ) )
                         *  ( ac   .get (  j     , col_0) );

 	           if ( get_debug() )
 	              {
 	                Formatter line = new Formatter();
                              line . format ( "%s%d%s%d%s%d%s%7.4f%s%s%d%s%d%s%7.4f%s%7.4f%s"
          		                            , "for C row("
          		                            ,  row
          		                            , "): super("
          		                            ,  (row-1)
          		                            , ","
          		                            ,  j
          		                            , ") = >"
          		                            , super.get ( (row-1), j )
          		                            , "<   "
          		                            , "ac("
          		                            , j
          		                            , ","
          		                            , col_0
          		                            , ") = >"
          		                            , ac   .get ( j, (col_0) )
          		                            , "<  product = >"
          		                            , p
          		                            , "<"
          		                            );
                    System.out.println( line );
 	              }

    	      c += p;
             }
return               c;
}
protected  double  set_partial_off_diag( final  int  row
                                       , final  int  col
                                       )
{
final   int     max  =    row - 1;	
if ( row==1 && col==0 )
   {
	 if ( get_debug() )
	    {
	      System.out.println( "partial auto_correlation row="
                            +  row
                            + ", col="
                            +  col
                            );
	      System.out.println( "partial auto_correlation p("
                            +  max
                            + ","
                            +  col
                            + ") = >"
                            +  super.get(max, col)
                            + "<"
                            );
	      System.out.println( "partial auto_correlation p("
                            +  row
                            + ","
                            +  row
                            + ") = >"
                            +  super.get(row, row)
                            + "<"
                            ); 
	      System.out.println( "partial auto_correlation p("
                            +  max
                            + ","
                            + (row-col-1)
                            + ") = >"
                            +  super.get(max, (row-col-1))
                            + "<"
                            ); 
	      System.out.println( " ");
	    }
   }
//      p(1,0)   =  [ p(0,0) - ( p(1,1) * p(0,0) ) ]
//
//      p(2,1)   =  [ p(1,1) - ( p(2,2) * p(1,0) ) ]
//      p(2,0)   =  [ p(1,0) - ( p(2,2) * p(1,1) ) ]
//                        ^                   ^
//                        |                   |
//
//      p(3,2)   =  [ p(2,2) - ( p(3,3) * p(2,0) ) ]
//      p(3,1)   =  [ p(2,1) - ( p(3,3) * p(2,1) ) ]
//      p(3,0)   =  [ p(2,0) - ( p(3,3) * p(2,2) ) ]
//                        ^                   ^
//                        |                   |
        double  pac  =  ( super.get(max, col) )
                     -  ( super.get(row ,row) * super.get(max,(row-col-1)) );  
        
        if ( get_debug() )
           {
             System.out.println( "partial auto_correlation p("
 		                       +  row
 		                       + ","
 		                       +  col
 		                       + ") = >"
 		                       +  pac
 		                       + "<"
 		                       );
           }
return          pac;
}
}
