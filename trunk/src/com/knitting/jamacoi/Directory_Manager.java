package com.knitting.jamacoi;

import java.io.File;
import java.net.URL;
import java.util.Map;

public class Directory_Manager {
	
private      LHMESURL  dirs;	
	
public       Directory_Manager ( Directory_Triples  dir_t )	
             throws    java.net.MalformedURLException
{
	         dirs     =    new  LHMESURL    ();
URL          url_ws   =    get_URL_Workspace();   
URL          url_new;

for  ( Map.Entry<String, String>    entry
     : dir_t.get_Map_Key_Subdir() . entrySet()
     )
     {
	   url_new =  getNewURL   (  dir_t,  url_ws,  entry );
       dirs.put(  entry.getKey(),        url_new        );
     }
}

private URL getNewURL ( final  Directory_Triples             dir_t
		              , final  URL                           url_ws
		              , final  Map.Entry < String, String >  entry
		              ) 
            throws      java.net.MalformedURLException 
{
	    URL      url_new;	           
	    
	    if    (  entry.getKey()     . equals     ( dir_t.get_Key_Rel_Base_Dir() )
              )	                           
              {
		                url_new     =  new   URL ( url_ws
                                                 , entry.getValue()
                                                 );
              }
	    else  {
		         String     parent  =  dir_t.get_Map_Key_Parent()     
		                                    .get ( entry.getKey() );
		         String     p_value =  dir_t.get_Map_Key_Subdir()
                                            .get ( parent );
		         String     value   =              entry.getValue();
		                          
		         URL    url_parent  =  dirs .get (     parent );
		         		       
		         String sub_dir     =  p_value
		                            + "/"
		                            +  value;
		         
		                sub_dir     =  get_Last_Subdirectory( p_value )
		                            + "/"
		                            +  value;
		            
		                url_new     =  new   URL ( url_parent
		         		                         , sub_dir    //  entry.getValue()
                                                 );
              }
return  url_new;
}
public   URL     get_URL_by_Key( final String Key )
         throws  IllegalArgumentException
{
if  ( dirs.containsKey( Key ) )
    {
	  return  dirs.get( Key );
    }
else
    {
	  throw   new IllegalArgumentException( "Does not contain key = >"
                                          +  Key
	                                      + "<"
	                                      );
    }
}
private  URL     get_URL_Workspace()
         throws  java.net.MalformedURLException 
{
return  (new  Workspace() ) . get_Workspace();
}
public   String  get_URL_Workspace_as_String()
         throws  java.net.MalformedURLException 
{
return   get_URL_Workspace().toExternalForm();	
}
public  LHMESURL  get_Map_URL()
{
return            dirs;	
}
public  String    get_Last_Subdirectory( final  String  url_str )
{
	    String    token[]  = url_str.split("/");
return            token[ token.length - 1 ]; 
}
public  void      check_urls()
{
	    for ( Map.Entry < String, URL >  entry
	        : dirs                    .  entrySet()
	        )
	        {
	    	  check_url ( entry.getValue() );
	        }
}
private void      check_url( URL u)
{
	final String s	      =     u.getFile();       
	final File   d        = new File ( s );
	                if   (  d.exists() )
	                     {
	                       System.out.println( "File does     exist   =>" + s + "<" ); 
	                       if   ( d.isDirectory() )
	                            {
	                    	      System.out.println( "File is    directory  =>" + s + "<" );
	                            }
	                       else
	                            {
	                    	      System.out.println( "File is NOT directory =>" + s + "<" );
	                            }
	                     }
	                else
	                     {
	                	   System.out.println( "File does NOT exist   =>" + s + "<" );
	                     }
}
public  void  create_Directories()
{
    for ( Map.Entry < String, URL >  entry
	    : dirs                    .  entrySet()
	    )
	    {
	      create_Directory ( entry.getValue() );
	    }	
}
private  void  create_Directory( URL  u )
{
	final String s	         =     u.getFile();       
	final File   d           = new File ( s );
		                if   (  d.exists() )
		                	 {
		                	    if ( d.isDirectory() )
		                	       {
		                	    	   System.out.println( "directory exists      =>" + s + "<" );
		                	       }
		                	    else
		                	         {
		                	    	   mkdir ( s, d );
		                	         }
		                     }
		                else
		                     {
		                	           mkdir ( s, d );
		                     }	
			
}
private  void      mkdir ( String  s
                         , File    d
                         )
{
  if    ( d.mkdir() )
        {
          System.out.println( "directory     created =>" + s + "<" );
        }
  else
        {
          System.out.println( "directory NOT created =>" + s + "<" );
        }
}
}
