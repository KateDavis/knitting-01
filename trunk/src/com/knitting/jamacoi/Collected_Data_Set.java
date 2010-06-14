package com.knitting.jamacoi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class      Collected_Data_Set {
	   private    LinkedHashSet<Collected_Data> set;
	   private    TreeSet      <Date          > date_intersection;
	   private    DateFormat                    ccyy_mm_dd;
//	   private    Calendar cal;
public            Collected_Data_Set(){
	              set               = new LinkedHashSet<Collected_Data>();
	              date_intersection = new TreeSet      <Date          >();
	              ccyy_mm_dd        = new SimpleDateFormat("yyyy_MM_dd");
}
public boolean    add_data(Collected_Data d){
	   return     set.add(d);
}
public int        get_data_size(){
	   return     set.size();
}
public int        get_date_intersection_size(){
	   return         date_intersection.size();
}
public String     get_first_ccyy_mm_dd(){
	              SimpleDateFormat sdf = new SimpleDateFormat( "yyyy_MM_dd" );
	   return     sdf.format ( date_intersection.first() );
}
public String     get_last__ccyy_mm_dd(){
                  SimpleDateFormat sdf = new SimpleDateFormat( "yyyy_MM_dd" );
       return     sdf.format ( date_intersection.last () );
}
protected void    set_date_intersection(){
	      TreeSet<Date>  intersection  =  new TreeSet<Date>();
	      for    (Collected_Data ix: set )
	             {
	    	        if   ( intersection.isEmpty() )
	    	             {
	    	    	       intersection.addAll   ( ix.get_keys() );
	    	             }
	    	        else 
	    	             {
	    	    	       intersection.retainAll( ix.get_keys() );
	    	             }
	             }
     date_intersection   = intersection;      
}
protected TreeMap  <Date, ArrayList<Double> >  set_initial_matrix(){
	      TreeMap  <Date, ArrayList<Double> >  matrix  = new TreeMap  <Date, ArrayList<Double> >  ()  ;
	      int   ix = 0;
	      for ( Date date: date_intersection )
	          {
	    	    ArrayList<Double>              one_row = new ArrayList<Double>( this.get_data_size() );
	    	    
	    	    for ( Collected_Data cd: set )
	    	        {
	    	    	  if ( ix == 0 )
	    	    	     {
	    	    		   System.out.println(  cd.get_human_name()
	    	    				             + " "
	    	    				             + "price = >"
	    	    				             +  cd.get_price_on_date( date )
	    	    				             + "<"
	    	    				             );
	    	    	     }
	    	    	  one_row.add ( cd.get_price_on_date( date ) );
	    	        }
	    	    ++ix;
	    	    matrix.put( date, one_row );
	          }
	      return matrix;
}

}
