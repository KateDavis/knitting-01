package com.knitting.jamacoi;

import java.util.ArrayList;

public  class   Compare_Two_ArrayLists {
        private                 ArrayList<String> expected;
        private                 ArrayList<String> actual;
       
private Compare_Two_ArrayLists(){};  // to prevent this use.
public  Compare_Two_ArrayLists( ArrayList<String> expected
		                      , ArrayList<String> actual
		                      ) {
	    this.expected         =                   expected;
	    this.actual           =                   actual;
}
public  boolean are_Equal(){
	    return  false;
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
private ArrayList<String> find_First_Difference(){
	    ArrayList<String> difference_entries = new ArrayList<String>();
	    int                    ix            =     0;
	    while ( (              ix   < get_Min()      )
	    		&&
	    		( expected.get(ix) == actual.get(ix) )
	    	  )  
	          {
	    	                 ++ix;
	          }
	    if    ( ix < get_Min() )
	          {
	    	    get_non_matching_lines( ix
	    	    		              , difference_entries
	    	    		              );
	          }
	    if    ( get_Min() < expected.size() )
              {
                get_unmatched_line    ( ix
                		              , difference_entries
                		              );
              }
	    if    ( get_Min() < actual  .size() )
              {
                get_extra_line        ( ix
                		              , difference_entries
                		              );
              }
	    
return  difference_entries;	
}

private void   get_non_matching_lines( int                ix
		                             , ArrayList<String>  difference_entries
		                             ) {
        difference_entries.add( get_row_expected(ix) );
        difference_entries.add( get_row_actual  (ix) );
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
private String get_row_expected ( int ix ){
        String e = "row "
                 +  ix
                 + ": expected =>"
                 +    expected.get(ix)
                 + "<";
return         e;
}
private String get_row_actual   ( int ix ){
        String a = "row "
                 +  ix
                 + ": actual   =>"
                 +    actual.get(ix)
                 + "<";
return         a;
}
private String get_row_missing  ( int ix ){
        String a = "row "
                 +  ix
                 + ": actual   =>"
                 + "Error: there is no corresponding line here"
                 + "<";
return         a;
}
private String get_row_extra    ( int ix ){
        String a = "row "
                 +  ix
                 + ": actual   =>"
                 + "Error: this is an extra line that should not be here"
                 + "<";
return         a;
}

}
