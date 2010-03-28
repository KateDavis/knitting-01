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
	    int               entry_min          =     get_Min();
	    int               ix                 =     0;
	    while ( expected.get(ix) == actual.get(ix)
	    	  )  
	          {
	    	               ++ix;
	          }
	    
return  difference_entries;	    
	
}


}
