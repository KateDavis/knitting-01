package com.knitting.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public  class    K_Calendar {

static  private           TimeZone tz          = TimeZone.getTimeZone("America/Chicago");
        private           Calendar cal         = Calendar.getInstance(tz);
                                       
public           K_Calendar(){
	
	
}
public Date      set_ccyy_mm_dd ( final  int     ccyy
		                        , final  int     mm
		                        , final  int     dd
		                        ) {
	             cal.set(Calendar.YEAR         , ccyy    );
	             cal.set(Calendar.MONTH        ,(mm - 1) );
	             cal.set(Calendar.DAY_OF_MONTH , dd      );
	             cal.set(Calendar.HOUR_OF_DAY  , 0       );
	             cal.set(Calendar.MINUTE       , 0       );
	             cal.set(Calendar.SECOND       , 0       );
	             cal.set(Calendar.MILLISECOND  , 0       );
	             
	   return    cal.getTime();

}
public String    get_ccyy_mm_dd(final   Date  d){
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
                                  sdf .     setTimeZone     (tz);
       return                     sdf .     format          (d);                           
                 		                                    
                 		                                   	
}
public String    get_ccyy_mm_dd_hh_mm_ss_mmm (final  Date  d){
	             SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss");
                                  sdf .     setTimeZone     (tz);
       return                     sdf .     format          (d); 
	
}
public String    toString       (final  Date  d ){
       return    get_ccyy_mm_dd_hh_mm_ss_mmm( d );	
}
}
