package com.knitting.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.knitting.jamacoi.Collected_Data;

public  class   Print_Dates_Prices {
final	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
	 
public          Print_Dates_Prices(){}

public  void    print_data( final Collected_Data  cd
                          , final int             count
                          ) {
	               TreeMap<Date,Double>  tm  = cd .get_prices();
	         Set<Map.Entry<Date,Double>> set = tm .entrySet();
	    Iterator<Map.Entry<Date,Double>> it  = set.iterator(); 
	    int                              ix  = 0;
	    while (
	    		( it.hasNext() )
	    		&&
	    		( ix < count   )
	    	  )
	          {
	    	     Map.Entry<Date,Double> entry = it   .next    ();
	    	     Date                   date  = entry.getKey  ();
	    	     Double                 price = entry.getValue();
	    	     System.out.println("date="
	    	    		           + sdf.format(date)
	    	    		           +"  "
	    	    		           +"price="
	    	    		           + price
	    	    		           );
	    	   ++ix;  
	          }
	    	

	
}
}