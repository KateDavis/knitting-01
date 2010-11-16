package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.knitting.util.LHMSS;

public   class  Directory_Triples 
                implements         Cloneable
{
private  final  static  String     Rel_Base_Dir    =  "Rel_Base_Dir";	
private  final  static  String     Parent_default  =  "-1";
	
private  String                    Key_Rel_Base_Dir;
private  LHMSS                     Key_Parent;
private  LHMSS                     Key_Subdir;

private       Directory_Triples    (){;}    //   to prevent this constructor's use.
public        Directory_Triples    ( final       String  Subdir
		                           )
{
              Key_Parent = new     LHMSS();
	          Key_Subdir = new     LHMSS();
	         
	          Key_Parent . put     ( Rel_Base_Dir,   Parent_default);
	          Key_Subdir . put     ( Rel_Base_Dir,   Subdir        );
	          set_Key_Rel_Base_Dir ( Rel_Base_Dir                  );
}
public        Directory_Triples    ( final           String  Key
		                           , final           String  Subdir
                                   )
{
	          Key_Parent = new     LHMSS();
              Key_Subdir = new     LHMSS();
              
              Key_Parent . put     ( Key,            Parent_default);
              Key_Subdir . put     ( Key,            Subdir        );
              set_Key_Rel_Base_Dir (                 Key           );
}
  private     Directory_Triples    ( LHMSS                       Key_Parent_Old 
		                           , LHMSS                       Key_Subdir_Old
		                           , String                      Key_Rel_Base_Dir
		                           )
{	         
              Key_Parent  =         (LHMSS                     ) Key_Parent_Old.clone();
	          Key_Subdir  =         (LHMSS                     ) Key_Subdir_Old.clone();
}
public        Directory_Triples    clone( )
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
/***********************************************
public  boolean x( final  String  Key)
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
************************************************/
protected  LHMSS get_Key_Subdir()
{
return               Key_Subdir;
}
public boolean  containsKey    ( final  String  Key )
{
	   return   Key_Subdir     . containsKey (  Key );
}
public boolean  containsParent ( final  String  Parent )
{
	   return   (
			       (Key_Subdir . containsKey    ( Parent ) )
			       &&
			       (Key_Parent . containsValue  ( Parent ) )
	            );
}
public  ArrayList<String> list_Keys()
{
	    ArrayList        <String>  al   = new ArrayList<String> ( Key_Subdir . size    () );
	    for (   Iterator <String>  iter =                         Key_Subdir . keySet  () 
	    		                                                             . iterator();
	                               iter . hasNext();
	    	)
	        {
		        al.add( (String)   iter . next   () );
	        }
	    return  al;
}
public            LHMSS  get_Map_Key_Subdir()
{
	    return    Key_Subdir;              
}
public            LHMSS  get_Map_Key_Parent()
{
	    return    Key_Parent;              
}
public  boolean  remove_Subdir ( final String  Key )
{
	    if     ( Key_Subdir.containsKey      ( Key ) )
	           { 
	    	     rebuild_without             ( Key );
	    	     return true;
	           }
	    else   {
	    	     return false;
	           }
}
protected  void  rebuild_without ( final  String  Key_In )
{
            LHMSS                           Key_Parent_New  =  new  LHMSS        ( Key_Parent.size() );
	        LHMSS                           Key_Subdir_New  =  new  LHMSS        ( Key_Subdir.size() );
	        LHMSS                           Excluded_List   =  new  LHMSS        ( Key_Subdir.size() );
	        
	        Excluded_List.put( Key_In, "exclude");

	        for (  Iterator < Map.Entry < String, String >> e_iter = Key_Subdir  . entrySet() 
                                                                                 . iterator();
	                                                        e_iter               . hasNext ();
	        	)
	            {
	        	    Map.Entry           < String, String >  entry  =  e_iter     . next  ();
	        	    String                                  Key    =  entry      . getKey();
	        	    String                                  Parent =  Key_Parent . get   (Key);
	        	     
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
