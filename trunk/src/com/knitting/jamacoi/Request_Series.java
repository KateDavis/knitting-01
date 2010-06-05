package com.knitting.jamacoi;

import java.net.URI;
import java.util.Iterator;
import java.util.TreeSet;

import com.knitting.util.K_String;
public  class      Request_Series{ 

    	private    URI                     data_location;
	    private    String                  human_name;
	    protected  TreeSet<Integer>        lags;
private            Request_Series(){}; //  prevent this constructor
public             Request_Series( URI     data_location
                                 ) {
        this.data_location  =              data_location;
        this.human_name     =              K_String.remove_file_extention(
                                          (K_String.get_file_name_short  (
                                          (data_location.toString        ()
                                          ) 
                                          )
                                          )
                                          );
        this.lags           =          new TreeSet<Integer>();
}
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
public  boolean  add_lag     (Integer i){
	    return   lags.add            (i);
}
public  boolean  remove_lag  (Integer i){
        return   lags.remove         (i);
}
public  boolean  contains_lag(Integer i){
        return   lags.contains       (i);
}
public  TreeSet<Integer>  get_lags(){
	    return                lags;
}
//public              SortedSet<TreeSet<Integer>> getlags(){
//	                  SortedSet<TreeSet<Integer>> s = unmodifiableSortedSet.lags;    
//return  unmodifiableSortedSet<TreeSet<Integer>>( lags);
//}
public  void          set_lags(final TreeSet<Integer>  ts){
	    lags                   = new TreeSet<Integer>();
	    Iterator<Integer> iter = ts.iterator();
	    while ( iter.hasNext() )
	          {
	    	    lags.add(iter.next());
	          }
}
final   public   boolean  equals (Object obj){
	    if (     this    ==     obj           )   return true ;
	    if (  !( obj instanceof Request_Series) ) return false;
	    String   s0 =    this                 .get_data_location().toString();
	    String   s1 = ( (Request_Series)obj ) .get_data_location().toString();
	    return ( s0.equals(s1) );
}
final   public   int      hashCode(){
	    String   s0 = this.get_data_location().toString();
	    return   s0.hashCode();
}
}


