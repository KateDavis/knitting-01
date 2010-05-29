package com.knitting.jamacoi;

import java.net.URI;
import java.util.SortedSet;

public  class      request_series{ 

		private    URI                     data_location;
	    private    String                  human_name;
	    protected  SortedSet<Integer>      lags;
private            request_series(){}; //  prevent this constructor
public             request_series( URI     data_location
		                         , String  human_name
		                         ) {
	    this.data_location  =              data_location;
	    this.human_name     =              human_name;
}
public  URI      get_data_location() {
	    return       data_location;
}
public  void     set_data_location(URI     data_location) {
	    this .       data_location  =      data_location;
}
public  String   get_human_name() {
	    return       human_name;
}
public  void     set_human_name(String     human_name) {
	    this .       human_name     =      human_name;
}
}

