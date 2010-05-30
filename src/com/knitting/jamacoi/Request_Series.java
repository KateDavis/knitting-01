package com.knitting.jamacoi;

import java.net.URI;
import java.util.SortedSet;

public  class      Request_Series{ 

		private    URI                     data_location;
	    private    String                  human_name;
	    protected  SortedSet<Integer>      lags;
private            Request_Series(){}; //  prevent this constructor
public             Request_Series( URI     data_location
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
public  SortedSet<Integer>  get_lags(){
	    return                  lags;
}
public  void     set_lags(SortedSet<Integer>  lags){
        this .       lags           =         lags;
}
}


