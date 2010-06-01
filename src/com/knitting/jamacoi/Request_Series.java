package com.knitting.jamacoi;

import java.net.URI;
import java.util.StringTokenizer;
import java.util.TreeSet;

final   public     class      Request_Series{
//        implements Comparable<Request_Series>{ 

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
public  String   get_short_file_name(String s){
        StringTokenizer st            = new StringTokenizer (  s 
                                                            , "/"
                                                            );

        StringBuffer    sb            = new StringBuffer    ( "" );

        while ( st . hasMoreTokens() )
              {
                sb = new StringBuffer( st.nextToken() );
              }
        return  sb . toString();
}
public  String   remove_file_type(String s){
	    int      ix  = s.lastIndexOf(".");
	    return         s.substring  ( 0
	    		                    , ix
	    		                    );
	
}
public  boolean  equals (Object obj){
	    if (     this    ==     obj           )   return true ;
	    if (  !( obj instanceof Request_Series) ) return false;
	    String   s0 =    this                 .get_data_location().toString();
	    String   s1 = ( (Request_Series)obj ) .get_data_location().toString();
	    return ( s0.equals(s1) );
}
public  int      hashCode(){
	    String   s0 = this.get_data_location().toString();
	    return   s0.hashCode();
}
}


