package com.knitting.jamacoi;

import java.net.URI;
import java.util.Comparator;
import java.util.TreeSet;

public  class      Request_Series
        implements Comparator<Request_Series>{ 

		private    URI                     data_location;
	    private    String                  human_name;
	    protected  TreeSet<Integer>        lags;
private            Request_Series(){}; //  prevent this constructor
public             Request_Series( URI     data_location
		                         , String  human_name
		                         ) {
	    this.data_location  =              data_location;
	    this.human_name     =              human_name;
	    this.lags           =          new TreeSet<Integer>();
}
public  URI      get_data_location() {
	    return       data_location;
}
public  String   get_human_name() {
	    return       human_name;
}
public  void     set_human_name(String     human_name) {
	    this .       human_name     =      human_name;
}
public  TreeSet<Integer>  get_lags(){
	    return                lags;
}
public  void     set_lags(TreeSet<Integer> lags){
        this .       lags           =      lags;
}
public  int      compare(Request_Series rs_0
		                ,Request_Series rs_1
		                ){
	    String   s0 = rs_0.get_data_location().toString();
	    String   s1 = rs_1.get_data_location().toString();
	    return   s0 . compareTo(s1);	
}
public  boolean  equals (Request_Series rs){
        String   s0 =        data_location  .toString();
        String   s1 = rs.get_data_location().toString();
        return   s0 == s1;
}
}


