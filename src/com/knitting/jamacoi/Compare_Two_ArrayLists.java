package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Iterator;

public  class   Compare_Two_ArrayLists {
        private                 ArrayList<String> expected;
        private                 ArrayList<String> actual;
       
private Compare_Two_ArrayLists(){}; // to prevent this use.
public  Compare_Two_ArrayLists( ArrayList<String> expected
		                      , ArrayList<String> actual
		                      ) {
	    this.expected         =                   expected;
	    this.actual           =                   actual;
}
public  boolean are_Equal(){
        ArrayList<String> difference_report = report_First_Difference();
        return          ( difference_report . size() == 0 );
}
public  ArrayList<String> report_First_Difference(){
        ArrayList<String> difference_report  = new ArrayList<String>();
return  difference_report;
}
public  int              get_Min (){
return  Math.min( expected . size() 
		        , actual   . size()
		        ) ;	
}
public  ArrayList<String> find_First_Difference(){
	    ArrayList<String> difference_entries = new ArrayList<String>();
	    
	    int     ix = 0;
	    
	    if      (
	    		  ( expected.size() == 0 )
	    		  &&
	    	      ( actual  .size() == 0 )
	    	    )
	            {
                    System.out.println("Both lists are empty.  Hence they are equal.");
	            }
	    else if (   expected.size() == 0 )
                {
    	            System.out.println   ( "About to execute: get_extra_line.");
    	            get_extra_line       ( ix
    	            		             , difference_entries
    	            		             );
                }
	    else if (   actual  .size() == 0 )
                {
                    System.out.println   ( "About to execute: get_unmatched_line-1.");
                    get_unmatched_line   ( ix
                    		             , difference_entries
                    		             );
                }
	    else 
	            {
	    	        compare_lines        ( ix
	    	        		             , difference_entries
	    	        		             );
	            }
	    	        
        return                             difference_entries;	
}

private void   get_non_matching_lines( int                ix
		                             , ArrayList<String>  difference_entries
		                             ) {
        difference_entries.add( get_row_expected(ix) );
        difference_entries.add( get_row_actual  (ix) );
        difference_entries.add( get_char_difference  ( get_row_expected(ix)
        		                                     , get_row_actual  (ix)
        		                                     )
        		              ) ;
}
private void   get_unmatched_line    ( int                ix
		                             , ArrayList<String>  difference_entries
		                             ) {
        difference_entries.add( get_row_expected(ix) );
        difference_entries.add( get_row_missing (ix) );	
}
private void   get_extra_line        ( int                ix
                                     , ArrayList<String>  difference_entries
                                     ) {
	    difference_entries.add( get_row_actual  (ix) );
	    difference_entries.add( get_row_extra   (ix) );
}

private void   compare_lines         ( int                ix
		                             , ArrayList<String>  difference_entries
		                             ){
        while ( ix < get_Min() )
              {
	            String exp = expected.get(ix);
	            String act = actual  .get(ix);
	    
	            if   ( exp.equals(act) )
	                 {
	    	           //  do nothing
	                 }
	            else 
	                 {
	    	           System.out.println( "About to execute: get_non_matching_lines-2.");
  	                   System.out.println( "      expected line is not equal to actual line");
  	                   System.out.println( "      expected line length =>"
  	    	  	                         +        exp.length()
  	    		                         +       "<"
  	    		                         );
  	                   System.out.println( "      actual   line length =>"
  		                                 +        act.length()
  		                                 +       "<"
  		                                 );
  	                   get_non_matching_lines( ix, difference_entries) ;
  	                   return;
	                 }
	           ++ix;
              }
        if   ( get_Min() < expected.size() )
             {
	           ix = get_Min();
	           System.out.println( "About to execute: get_unmatched_line"    );
	           get_unmatched_line            ( ix, difference_entries) ;
	           return;
             }
        if   ( get_Min() < actual  .size() )
             {
               ix = get_Min();
               System.out.println( "About to execute: get_extra_line"        );
               get_extra_line                ( ix, difference_entries );
               return;
             }
}

private String get_row_expected ( int ix ){
return         (  "row "
               +  ix
               +  ": expected =>"
               +     expected.get(ix)
               +  "<"
               )  ;
}
private String get_row_actual   ( int ix ){
return         (  "row "
               +  ix
               +  ": actual   =>"
               +     actual  .get(ix)
               +  "<"
               )  ;
}
private String get_row_missing  ( int ix ){
return         (  "row "
               +  ix
               +  ": actual   =>"
               +  "Error: there is no corresponding line here"
               +  "<"
               )  ;
}
private String get_row_extra    ( int ix ){
return         (  "row "
               +  ix
               +  ": actual   =>"
               +  "Error: this is an extra line that should not be here"
               +  "<"
               )  ;
}
private String get_char_difference ( String exp
		                           , String act
		                           ) {
	StringBuffer b       = new  StringBuffer();
	int          len_min = Math.min( exp.length()
			                       , act.length()
			                       ) ;
	int      ix = 0;
	while ( (ix             <  len_min        )
			&&
			(exp.charAt(ix) != '>'            )
          )
          {
  		    b.append  ( '-' );
            ++ix;     	  
          }
		    b.append  ( '-' );
            ++ix;     	  	
	while (
			(ix             <  len_min        )
			&&
			(exp.charAt(ix) == act.charAt(ix) )
		  )
          {
		    b.append  ( '-' );
          ++ix;
          }
	        b.append  ( '^' );
	return  b.toString();	
}
public  void   print_ArrayList( ArrayList<String> list){
	    Iterator<String> iter = list.iterator();
	    
	    while ( iter.hasNext() )
	          {
	    	    System.out.println( iter.next() );
	          }
}

}