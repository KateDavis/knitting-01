package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.knitting.util.K_Calendar;

public class      Collected_Data_Set {
	   private    LinkedHashSet<Collected_Data> set;
	   private    TreeSet      <Date          > date_intersection;
	   private    K_Calendar                    kcal;
public            Collected_Data_Set( final  K_Calendar  k){
	              set               = new LinkedHashSet<Collected_Data>();
	              date_intersection = new TreeSet      <Date          >();
	              kcal              =     k;
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
	   return     kcal .get_ccyy_mm_dd( date_intersection.first() );
}
public String     get_last__ccyy_mm_dd(){
	   return     kcal .get_ccyy_mm_dd( date_intersection.last () );
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
/****************************************************
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
***********************************************************/
protected TreeMap  <Date, ArrayList<Double> >  set_lagged_matrix(){
    TreeMap  <Date, ArrayList<Double> >  matrix  = new TreeMap  <Date, ArrayList<Double> >  ()  ;
    int   cols =     get_cols();
    System.out.println( "cols       = >"
    		          +  cols
    		          + "<"
    		          );
    int   ix = 0;
    for ( Date date: date_intersection )
        {
  	    ArrayList<Double>              one_row = new ArrayList<Double>( cols );
  	    
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
  	    	  Double        price = cd.get_price_on_date( date );
  	    	  one_row.add ( price );
  	    	  if ( cd.get_lag_size() > 0 )
  	    	     {
  	    		   cd.add_price_q ( price );
  	    		   add_lag_prices ( one_row
  	    				          , cd
  	    				          );
  	    	     }
  	        }
  	    ++ix;
  	    matrix.put( date, one_row );
        }
    return matrix;
}
public int    get_cols(){
	   int    ix  = 0;
              for ( Collected_Data cd: set )
	              {
            	      ix += cd.get_lag_size();
		            ++ix;
	              }
       return ix;
}
protected  void  add_lag_prices( ArrayList<Double>  one_row
		                       , Collected_Data     cd
		                       ) {
	       if ( one_row == null )
	          {
	    	    System.out.println("one_row == null" );
	          }
	       if ( cd      == null )
	          {
	    	    System.out.println("cd      == null" );
	          }
	       if ( cd.get_price_q() == null )
	          {
	    	    System.out.println("price_q == null" );
	          }
	       for  ( int     lag:   cd.get_lags()  )
	            {
	    	      Double       price = cd.get_price_q()[lag];
/**********************************************************************	    	      
	    	      System.out.println( "lag=>"
	    	    		            +  lag
	    	    		            + "<"
	    	    		            + "  "
	    	    		            + "price=>"
	    	    		            +  price
	    	    		            + "<"
	    	    		            );
**********************************************************************/	    	    		            
	    	      one_row.add( price );
	            }
	
}
}
