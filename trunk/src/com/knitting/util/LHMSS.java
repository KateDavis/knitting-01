package com.knitting.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
	    LHMSS                               new_lhm  =  new    LHMSS   ( lhm.size() );
//	    Iterator <Entry <String, String >>  iter     =  lhm  . entrySet()
//	                                                         . iterator();
//	    while ( iter.hasNext() )
	    for ( Iterator <Entry <String, String >>  iter     =  lhm  . entrySet()
                                                                   . iterator();
	                                              iter             . hasNext ();
	    	)
	    	
	          {
               Map.Entry<String, String>    me       =  iter . next();	
               
                                            new_lhm  .  put  ( me.getKey()
                                            		         , me.getValue()
                                            		         );
	          }
        return                              new_lhm;
}
public  String           put( final  String  Key
		                    , final  String  Value
		                    )
{
        return     ( lhm.put( Key, Value ) );
}
public  boolean          containsKey(   final  String  Key )
{
	    return     ( lhm.containsKey                 ( Key ) );
}
public  boolean          containsValue( final  String  Value )
{
	    return     ( lhm.containsValue               ( Value ) );
}

/****************************************************************************************
public  void             putAll( final  LHMSS  lhm_in )
{
	    LHMSS        lhm_new  = new LHMSS( lhm_in.size() ); 
	                 lhm.putAll( (Map<? extends String, ? extends String>) lhm_in );
	                 lhm.putAll( (LinkedHashMap<String, String>>)          lhm_in );
}
****************************************************************************************/

public  Set <String>     keySet()
{
	    return     ( lhm.keySet() );
}
public  Iterator< String> iterator_key_string()
{
	    return       lhm.keySet().iterator();
}
public   LinkedHashMap<String, String>  get()
{
return  (LinkedHashMap<String, String>) Collections.unmodifiableMap(lhm); 
}

public  Set     <Entry<String, String>>   entrySet()    
{
	    return   lhm                  .   entrySet();
}
public  Iterator<Entry<String, String>>   iterator()
{
	    return   lhm.entrySet()       .   iterator();
}

public  String    get( final  String  Key )
{
	    return    lhm.get           ( Key );
}
public  int       size()
{
	    return    lhm.size();
}
}
