package com.knitting.jamacoi;

import java.util.Date;
import java.util.TreeMap;

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
}
