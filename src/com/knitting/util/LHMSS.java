package com.knitting.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class             LHMSS 
       implements        Cloneable
{
	
	   private  LinkedHashMap<String, String>  lhm;


public  LHMSS()
{
	    lhm  =  new  LinkedHashMap<String, String>();
}
public  LHMSS(  final  int  size )
{
	    lhm  =  new  LinkedHashMap<String, String>( size );
}
public  LHMSS   clone()
{
        return  (  (LHMSS) lhm.clone()  );	
}
public  String  put( final  String  Key
		           , final  String  Value
		           )
{
        return     ( lhm.put( Key, Value ) );
}
public  boolean  containsKey( final  String  Key )
{
	    return     ( lhm.containsKey       ( Key ) );
}
public  boolean  containsValue( final  String  Value )
{
	    return     ( lhm.containsValue       ( Value ) );
}
public  void     putAll( final  LHMSS  lhm_in )
{
	             lhm.putAll( (Map<? extends String, ? extends String>) lhm_in );
}
public  LinkedHashMap<String, String>    get()
{
	    return    ( LinkedHashMap <String, String> ) Collections.unmodifiableMap(lhm);
}
public  String    get( final  String  Key )
{
	    return    lhm.get           ( Key );
}
}
