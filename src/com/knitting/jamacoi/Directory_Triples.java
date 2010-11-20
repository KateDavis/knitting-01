package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Map;

import com.knitting.util.LHMESS;

public   class  Directory_Triples 
                implements         Cloneable
{
private  final  static  String     Rel_Base_Dir    =  "Rel_Base_Dir";	
private  final  static  String     Parent_default  =  "-1";
	
private                 String     Key_Rel_Base_Dir;
private                 LHMESS     Key_Parent;
private                 LHMESS     Key_Subdir;

private       Directory_Triples    (){;}        //   to prevent this constructor's use.
public        Directory_Triples    ( final           String  Subdir
		                           )
{
              Key_Parent = new     LHMESS();
	          Key_Subdir = new     LHMESS();
	         
	          Key_Parent . put     ( Rel_Base_Dir,   Parent_default);
	          Key_Subdir . put     ( Rel_Base_Dir,   Subdir        );
	          set_Key_Rel_Base_Dir ( Rel_Base_Dir                  );
}
public        Directory_Triples    ( final           String  Key
		                           , final           String  Subdir
                                   )
{
	          Key_Parent = new     LHMESS();
              Key_Subdir = new     LHMESS();
              
              Key_Parent . put     ( Key,            Parent_default);
              Key_Subdir . put     ( Key,            Subdir        );
              set_Key_Rel_Base_Dir (                 Key           );
}
  private     Directory_Triples    ( LHMESS          Key_Parent_Old 
		                           , LHMESS          Key_Subdir_Old
		                           , String          Key_Rel_Base_Dir
		                           )
{	         
              Key_Parent  =        ( LHMESS )        Key_Parent_Old.clone();
	          Key_Subdir  =        ( LHMESS )        Key_Subdir_Old.clone();
}
public        Directory_Triples    clone()
{
	          Directory_Triples    clone  =  new Directory_Triples(  this.Key_Parent
	        	  	                                              ,  this.Key_Subdir
	        		                                              , "test"
	        		                                              );
	          return               clone;
}
protected     void   set_Key_Rel_Base_Dir ( final  String  Key )
{
 	                     Key_Rel_Base_Dir = Key;
}
protected     String get_Key_Rel_Base_Dir () // final  String  Key )
{
return	                 Key_Rel_Base_Dir;
}
public        void    put         ( final  String  Key
		                          , final  String  Parent
		                          , final  String  Subdir
		                          )
              throws  IllegalArgumentException
{
if  (        Key_Subdir . containsKey      ( Parent ) )
    {
	  if   ( Key_Subdir . containsValue    ( Subdir ) )
	       {
		     check_for_duplicate_directory ( Key,  Parent,  Subdir );
	       }
	  addEntry  ( Key, Parent, Subdir );
    }
else
    {
	  throw  new  IllegalArgumentException( "Parent:("
			                              +  Parent
			                              + ") does NOT exist"
			                              );
    }
}
private  void  addEntry  ( final  String  Key
		                 , final  String  Parent
		                 , final  String  Subdir
		                 )
{
              Key_Parent . put  ( Key,    Parent  );
              Key_Subdir . put  ( Key,    Subdir  );
}
private  void    check_for_duplicate_directory ( final  String  Key
                                               , final  String  Parent
                                               , final  String  Subdir
		                                       )
         throws  IllegalArgumentException
{
         for ( Map.Entry <String, String>  entry
             : Key_Subdir.entrySet()
             )
             {
        	   if ( entry.getValue()  ==   Subdir )
        	      {
        		    matchingParent(Parent, entry);
        	      }
             }
}
private  void    matchingParent( final            String          Parent
		                       , final  Map.Entry<String, String> entry
		                       ) 
         throws  IllegalArgumentException
{
         String               existing_key   =  entry.getKey();
	
         if ( Key_Parent.get( existing_key ) == Parent )
            {
              throw  new  IllegalArgumentException( "Duplicate Sub-directory:("
            		                              +  entry.getValue()
            		                              + ") for Parent:("
            		                              +  Parent
            		                              + ")"
            		                              );
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
protected  LHMESS get_Key_Subdir()
{
return                Key_Subdir;
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
	    for (   String       key
	    	:   Key_Subdir . keySet  () 	
	    	)
	        {
	    	    al.add     ( key );
	        }
	    return  al;
}
public            LHMESS  get_Map_Key_Subdir()
{
	    return    Key_Subdir;              
}
public            LHMESS  get_Map_Key_Parent()
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
            LHMESS                          Key_Parent_New  =  new  LHMESS       (); // ( Key_Parent.size() );
	        LHMESS                          Key_Subdir_New  =  new  LHMESS       (); // ( Key_Subdir.size() );
	        LHMESS                          Excluded_List   =  new  LHMESS       (); // ( Key_Subdir.size() );
	        
	        Excluded_List.put  ( Key_In, "exclude");
	        for (  Map.Entry   < String, String>  entry
	        	:  Key_Subdir  . entrySet()	
	        	)
	            {
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
	        	    	           String  Value   =  entry.getValue();
	        	    	           Key_Subdir_New  .  put ( Key, Value  );
	        	    	           String  Parent1 =  Key_Parent.get(Key);
	        	    	           Key_Parent_New  .  put ( Key, Parent1);
	        	    	         }
	        	         }
	             }
	        Key_Parent = Key_Parent_New;
	        Key_Subdir = Key_Subdir_New;
}
}
