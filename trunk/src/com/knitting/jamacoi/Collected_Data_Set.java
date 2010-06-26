package com.knitting.jamacoi;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.knitting.util.K_Calendar;

public class      Collected_Data_Set {
	   private    LinkedHashSet<Collected_Data> set;
	   private    TreeSet      <Date          > date_intersection;
	   private    K_Calendar                    kcal;
private           Collected_Data_Set(){}  // to prevent this constructor's use
public            Collected_Data_Set( final  K_Calendar  k){
	              set               = new LinkedHashSet<Collected_Data>();
	              date_intersection = new TreeSet      <Date          >();
	              kcal              =     k;
}
public boolean    add_data( final  Collected_Data  d){
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
protected Lagged_Matrix      set_lagged_matrix(){
/*************************************************************************	
	      String_Row  name_security_row  =  build_name_security_row();
	      String_Row  name_lag_row       =  build_name_lag_row();
**************************************************************************/	      
	      
	      Lagged_Matrix lm = new Lagged_Matrix   ( get_cols()
	    		                                 , build_name_security_row()
	    		                                 , build_name_lag_row()
	    		                                 );
	      for ( Collected_Data cd: set )
              {
	    	    String security_name  = cd.get_human_name();
	    	           lm             . add_name_security( security_name );
	    	           lm             . add_name_lag     ("lag_0"        ); 

	    	           for ( int   ix = 0
	    	               ;       ix < cd.get_lag_size()
	    	        	   ;     ++ix
	    	        	   )
	    	        	   {
	    	        	           lm . add_name_security( security_name );
	    	        	           lm . add_name_lag     ("lag_"
	    	        	        		                 + ix
	    	        	        		                 );
	    	        	   }
              }
	      for ( Date date: date_intersection )
	          {
	  	        Price_Row pr    = new Price_Row  ( get_cols() );
	  	        for ( Collected_Data cd: set )
	  	            {
	  	    	      Double       price =     cd.get_price_on_date( date );
	  	    	      pr.add_price(price);
	  	    	      if ( cd.get_lag_size() > 0 )
	  	    	         {
	  	    		       cd.add_price_q ( price );
	  	    		       add_lag_prices ( pr
	  	    				              , cd
	  	    				              );
	  	    	         }
	  	            }
	  	        lm.put( date
	  	        	  , pr
	  	        	  );
	          }
	      return        lm;
}
protected String_Row build_name_security_row(){
	      String_Row row = new String_Row( get_cols() - 1 );
	      for ( Collected_Data cd: set )
          {
    	    String security_name  = cd.get_human_name();
    	           row            . add_string( security_name );            
    	           for ( int   ix = 0
    	               ;       ix < cd.get_lag_size()
    	        	   ;     ++ix
    	        	   )
    	        	   {
    	        	          row . add_string( security_name );
    	        	   }
          }
	      return   row;
}
protected  String_Row  build_name_lag_row(){
	       String_Row  row = new String_Row( get_cols() - 1 );
	       
   	       for ( Collected_Data cd: set )
               {
	             row.add_string( "lag_0" ); 
	             
	             TreeSet<Integer>  lags = cd.get_lags();
	             
	             for ( Integer ix: lags )
	                 {
	            	   row.add_string( "lag_"
	            			         +  ix.toString()
	            			         );
	                 }
              }
   	       return row;
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
protected  void  add_lag_prices( final  Price_Row       pr
		                       , final  Collected_Data  cd
		                       ) {
	       for  ( int     lag:   cd.get_lags()  )
	            {
	    	      Double        price = cd.get_price_q()[lag]; 	    		            
	    	      pr.add_price( price );
	            }
}
}
