package com.knitting.jamacoi;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.knitting.util.K_Calendar;

public    class      Lagged_Matrix {
          private    int                      price_cols;
	      private    TreeMap<Date, Price_Row> tm;

private              Lagged_Matrix(){   // to prevent this constructor's use
	
}
public               Lagged_Matrix( final int price_cols ){
	      set_price_cols( price_cols );
	      tm = new   TreeMap<Date, Price_Row>();
}
protected void       set_price_cols(final int cols){
	                     price_cols =         cols;
}
public    int        get_price_cols(){
          return         price_cols;
}
public    void       put( final Date       date
		                , final Price_Row  pr
		                ) {
	      tm.put(date, pr);
}
public    void       print_ix_entries(final int ix_max){
	
	      Set     <Map.Entry<Date,Price_Row>> set  = tm .entrySet();
	      Iterator<Map.Entry<Date,Price_Row>> iter = set.iterator();
	      int                                 ix   = 0;
	      
	      while (
	    		   ( iter.hasNext()   )
	    		   &&
	    		   ( ix < ix_max      )
	    		)
	            {  System.out.println(fmt_entry_space_decimal( iter.next() 
	            		                                     )
	            		             );
	    	       ++ix;
	            }
}
protected String     fmt_entry_space_decimal(final Map.Entry<Date,Price_Row>  me ){
	      K_Calendar kcal = new K_Calendar();
	      String     date =     kcal.get_ccyy_mm_dd( (  me.getKey  () ) );
	      Price_Row  pr   =                             me.getValue();
	      String     row  =     pr.fmt_row_space_and_decimal();
	      return     (  date
	    		     + ","
	    		     +  row
	    		     ) ;
}
protected String     fmt_entry_comma_decimal(final Map.Entry<Date,Price_Row>  me ){
          K_Calendar kcal = new K_Calendar();
          String     date =     kcal.get_ccyy_mm_dd( (  me.getKey  () ) );
          Price_Row  pr   =                             me.getValue();
          String     row  =     pr.fmt_row_comma_and_decimal();
          return     (  date
  		             + ","
  		             +  row
  		             ) ;
}
protected String     fmt_entry_comma_scientific(final Map.Entry<Date,Price_Row>  me ){
          K_Calendar kcal = new K_Calendar();
          String     date =     kcal.get_ccyy_mm_dd( (  me.getKey  () ) );
          Price_Row  pr   =                             me.getValue();
          String     row  =     pr.fmt_row_comma_and_scientific();
          return     (  date
	                 + ","
	                 +  row
	                 ) ;
}
}
