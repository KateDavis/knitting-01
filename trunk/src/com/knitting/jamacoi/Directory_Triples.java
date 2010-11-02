package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Directory_Triples 
             implements        Cloneable
{
final static String Rel_Base_Dir = "Rel_Base_Dir";	
	
private String                        Key_Rel_Base_Dir;
private LinkedHashMap<String, String> Key_Parent;

private LinkedHashMap<String, String> Key_Subdir;

private      Directory_Triples(){;}    //      to prevent this constructor's use.
public       Directory_Triples( final  String  Subdir
		                      )
{
final String     Base_Dir   =        "Base_Dir";

	         Key_Parent = new     LinkedHashMap<String, String>();
	         Key_Subdir = new     LinkedHashMap<String, String>();
	         
	         Key_Parent . put     ( Base_Dir,   Rel_Base_Dir  );
	         Key_Subdir . put     ( Base_Dir,   Subdir        );
	         set_Key_Rel_Base_Dir ( Base_Dir                  );
}
private      Directory_Triples    ( LinkedHashMap<String,  String>  Key_Parent_Old 
		                          , LinkedHashMap<String,  String>  Key_Subdir_Old
		                          , String                          Key_Rel_Base_Dir
		                          )
{
	         Key_Parent  =  new     LinkedHashMap<String,  String>( Key_Parent_Old.size() );
	         Key_Subdir  =  new     LinkedHashMap<String,  String>( Key_Subdir_Old.size() );
	         
	         Key_Parent.putAll( Key_Parent_Old );
	         Key_Subdir.putAll( Key_Subdir_Old );
	         
//	         deep_copy ( Key_Parent, Key_Parent_Old );
//	         deep_copy ( Key_Subdir, Key_Subdir_Old );
	
}
/*****************************************************************************************
protected    void  deep_copy( LinkedHashMap < String, String >  Key_Parent_New
		                    , LinkedHashMap < String, String >  Key_Parent_Old
		                    )
{
	         
	         Set       <Entry<String, String>> es   = Key_Parent_Old.entrySet();
	         Map.Entry       <String, String>  me;
	         Iterator  <Entry<String, String>> iter = es.iterator();
	         
	         while ( iter.hasNext() )
	               {
	        	             me     =  iter . next    ();
	        	     String  Key    =  me   . getKey  ();
	        	     String  Value  =  me   . getValue();
	        	     Key_Parent_New.put( Key, Value);
	               }
	
}
******************************************************************************************/
public       Directory_Triples    clone( )
{
	         Directory_Triples    clone  =  new Directory_Triples( this.Key_Parent
	        		                                             , this.Key_Subdir
	        		                                             , "test"
	        		                                             );
	         return               clone;
}

protected    void   set_Key_Rel_Base_Dir ( final  String  Key )
{
	                    Key_Rel_Base_Dir = Key;
}
protected    String get_Key_Rel_Base_Dir ( final  String  Key )
{
return	                Key_Rel_Base_Dir;
}
public       boolean  put        ( final  String  Key
		                         , final  String  Parent
		                         , final  String  Subdir
		                         )
{
if  (   
	  (	Key_Subdir.containsKey( Key ) )
	  ||
	  ( Key == Rel_Base_Dir           )
	)
    {
	  return false;
    }
else
    {
	  Key_Parent . put ( Key,  Parent );
	  Key_Subdir . put ( Key,  Subdir );
	
      return true;
    }
}
public boolean  set_Subdir( final  String  Key
		                  , final  String  Value
		                  )
{
	   if   ( get_Key_Subdir().containsKey( Key ) )
	        {
		      Key_Subdir.put( Key, Value);
		      return true;
	        }
	   else
	        {
		      return false;
	        }
}
public  boolean contains_Key( final  String  Key)
{
	    if   ( get_Key_Subdir().containsKey( Key ) )
	         {
	    	   return true;
	         }
	    else
	         {
	    	   return false;
	         }
}
protected  LinkedHashMap< String,  String > get_Key_Subdir()
{
return                                          Key_Subdir;
}
public boolean  containsKey( final  String  Key )
{
	   return   Key_Subdir . containsKey (  Key );
}
public boolean  containsParent ( final  String  Parent )
{
	   return   (
			       (Key_Subdir . containsKey    ( Parent ) )
			       &&
			       (Key_Parent . containsValue  ( Parent ) )
	            );
}
public ArrayList<String> list_Keys()
{
	   ArrayList<String>  al   = new ArrayList<String>  ( Key_Subdir.size() );
	   Set      <String>  es   =     Key_Subdir.keySet  (); 
	   Iterator <String>  iter =     es        .iterator();
	   
	   while ( iter.hasNext() )
	         {
		       al.add( (String) iter.next() );
	         }
	   
	   return            al;
}
public         LinkedHashMap<String, String>  get_Map_Key_Subdir()
{
	    final  LinkedHashMap<String, String>  ks  =  new  LinkedHashMap<String, String> ( Key_Subdir );
	    return                                ks;
}
public         LinkedHashMap<String, String>  get_Map_Key_Parent()
{
	    final  LinkedHashMap<String, String>  kp  =  new  LinkedHashMap<String, String> ( Key_Parent );
	    return                                kp;
}


}
