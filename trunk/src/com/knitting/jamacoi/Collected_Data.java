package com.knitting.jamacoi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class      Collected_Data {
	   private    Calendar cal;
	   private    Date     shared_start__earliest; 
	   private    Date     shared_ending_lastest;
	   private    Integer  lag_max;
public            Collected_Data(){
	              cal                    = Calendar.getInstance();
	              
	              cal                    . set(1900, Calendar.JANUARY,   1);//set(3000, Calendar.DECEMBER, 31);
	              shared_start__earliest = cal.getTime();
	              
	              cal                    . set(3000, Calendar.DECEMBER, 31);//set(1900, Calendar.JANUARY,   1);
	              shared_ending_lastest  = cal.getTime();
	              
	              lag_max                = 0;
}
public String     get_fmt_shared_start__earliest(){
	   DateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
	   return     sdf.format(shared_start__earliest);
}
public Date       get_shared_start__earliest(){
	   return         shared_start__earliest;
}
public String     get_fmt_shared_ending_lastest(){
	   DateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
	   return     sdf.format(shared_ending_lastest);
}
public Date       get_shared_ending_lastest(){
	   return         shared_ending_lastest;
}
public Integer    get_lag_max(){
	   return         lag_max;
}
}
