package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.knitting.util.LHMSS;

public class Directory_Triples 
             implements        Cloneable
{
final static String Rel_Base_Dir = "Rel_Base_Dir";	
	
  private String                          Key_Rel_Base_Dir;
//private LinkedHashMap<String, String>   Key_Parent;
  private LHMSS                           Key_Parent;
//private LinkedHashMap<String, String>   Key_Subdir;
  private LHMSS                           Key_Subdir;

private      Directory_Triples(){;}    //      to prevent this constructor's use.
public       Directory_Triples( final  String  Subdir
		                      )
{
final String     Base_Dir   =        "Base_Dir";

//	         Key_Parent = new     LinkedHashMap<String, String>();
             Key_Parent = new     LHMSS();
//	         Key_Subdir = new     LinkedHashMap<String, String>();
	         Key_Subdir = new     LHMSS();
	         
	         Key_Parent . put     ( Base_Dir,   Rel_Base_Dir  );
	         Key_Subdir . put     ( Base_Dir,   Subdir        );
	         set_Key_Rel_Base_Dir ( Base_Dir                  );
}
//private    Directory_Triples    ( LinkedHashMap<String,  String>  Key_Parent_Old 
//		                          , LinkedHashMap<String,  String>  Key_Subdir_Old
  private    Directory_Triples    ( LHMSS                           Key_Parent_Old 
		                          , LHMSS                           Key_Subdir_Old
		                          , String                          Key_Rel_Base_Dir
		                          )
{	         
//	         Key_Parent  =         (LinkedHashMap<String,  String>) Key_Parent_Old.clone();
             Key_Parent  =         (LHMSS                         ) Key_Parent_Old.clone();
//	         Key_Subdir  =         (LinkedHashMap<String,  String>) Key_Subdir_Old.clone();
	         Key_Subdir  =         (LHMSS                         ) Key_Subdir_Old.clone();
}
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
//protected  LinkedHashMap< String,  String > get_Key_Subdir()
  protected  LHMSS get_Key_Subdir()
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
//public       LinkedHashMap<String, String>  get_Map_Key_Subdir()
//{
//	    final  LinkedHashMap<String, String>  ks  =  new  LinkedHashMap<String, String> ( Key_Subdir );
//	    return                                ks;
//}
public            LHMSS  get_Map_Key_Subdir()
{
	    return    Key_Subdir;              
}

//public       LinkedHashMap<String, String>  get_Map_Key_Parent()
//{
// 	    final  LinkedHashMap<String, String>  kp  =  new  LinkedHashMap<String, String> ( Key_Parent );
//	    return                                kp;
//}


public            LHMSS  get_Map_Key_Parent()
{
	    return    Key_Parent;              
}
public  boolean  remove_Subdir ( final String  Key )
{
	    if    ( Key_Subdir.containsKey( Key ) )
	          { 
	    	    rebuild_without  ( Key );
	    	    return true;
	          }
	    else  {
	    	    return false;
	          }
}
protected  void  rebuild_without ( final  String  Key_In )
{
//	        LinkedHashMap <String, String>  Key_Parent_New  =  new  LinkedHashMap <String, String>( Key_Parent.size() );
            LHMSS                           Key_Parent_New  =  new  LHMSS                         ( Key_Parent.size() );
//	        LinkedHashMap <String, String>  Key_Subdir_New  =  new  LinkedHashMap <String, String>( Key_Subdir.size() );
	        LHMSS                           Key_Subdir_New  =  new  LHMSS                         ( Key_Subdir.size() );
//	        LinkedHashMap <String, String>  Excluded_List   =  new  LinkedHashMap <String, String>( Key_Subdir.size() );
	        LHMSS                           Excluded_List   =  new  LHMSS                         ( Key_Subdir.size() );
	        
	        Excluded_List.put( Key_In, "exclude");
	        
	        Iterator < Map.Entry < String, String >> e_iter = Key_Subdir . entrySet() 
	                                                                     . iterator();
	        
	        while  ( e_iter . hasNext() )
	               {
	        	     Map.Entry <String,String>  entry  =  ( Map.Entry <String,String> ) e_iter     . next  ();
	        	     String                     Key    =  ( String                    ) entry      . getKey();
	        	     String                     Parent =  ( String                    ) Key_Parent . get   (Key);
	        	     
	        	     if   ( Key_In.equals( Key ) )
	        	          {
                          // do nothing, skip it	        	    	 
	        	          }
	        	     else
	        	          {
	        	    	     if   ( Excluded_List.containsKey  (Parent)  )
	        	    	          {
	        	    	    	    Excluded_List.put( Parent, "exclude" );
	        	    	          }
	        	    	     else
	        	    	          {
	        	    	            String  Value   =  (String ) entry.getValue();
	        	    	            Key_Subdir_New  .  put ( Key, Value );
	        	    	            String  Parent1 =  Key_Parent.get(Key);
	        	    	            Key_Parent_New.put(Key, Parent1);
	        	    	          }
	        	          }
	               }
	        Key_Parent = Key_Parent_New;
	        Key_Subdir = Key_Subdir_New;
}
}
