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
public   void        print_ix_entries ( final  int               ix_max
		                              , final  Price_Row_Format  prf
		                              ){
         Set     <Map.Entry<Date,Price_Row>> set  = tm .entrySet();
         Iterator<Map.Entry<Date,Price_Row>> iter = set.iterator();
         int                                 ix   = 0;
    
         while (
  		          ( iter.hasNext()   )
  		          &&
  		          ( ix < ix_max      )
  		       )
               {
        	        System.out.println(fmt_entry( iter.next() 
        	        		                    , prf
        	        		                    ) 
        	        		          );
  	              ++ix;
               }
}
protected String     fmt_entry(final  Map.Entry<Date,Price_Row>  me 
		                      ,final  Price_Row_Format           prf
		                      ){
          K_Calendar kcal = new K_Calendar();
          String     date =     kcal.get_ccyy_mm_dd( (  me.getKey  () ) );
          Price_Row  pr   =                             me.getValue()    ;
          String     row  =     pr.fmt_row(prf.get_price_row_format() )  ;
          return     (  date
  		             +  row
  		             ) ;
}
}
