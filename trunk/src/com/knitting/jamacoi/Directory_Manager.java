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
//	   print_Intial_Data      (  url_ws, entry          );
	   url_new =  getNewURL   (  dir_t,  url_ws,  entry );
//	   print_New_URL          (  url_new                );
       dirs.put(  entry.getKey(),      url_new          );
     }
}
/*****************************************************************************
private void print_Intial_Data( final  URL                        url_ws
		                      , final  Map.Entry<String, String>  entry
		                      ) 
{
	   System.out.println     ( "Key ........ = >"
			                  +  entry.getKey()
			                  + "<"
			                  );
	   System.out.println     ( "Value ...... = >"
	                          +  entry.getValue()
	                          + "<"
	                          );
	   System.out.println     ( "url_ws ..... = >"
                              +  url_ws       . toExternalForm()
                              + "<"
                              );
}
*****************************************************************************/
private URL getNewURL ( final  Directory_Triples             dir_t
		              , final  URL                           url_ws
		              , final  Map.Entry < String, String >  entry
		              ) 
            throws      java.net.MalformedURLException 
{
	    URL      url_new;
	    
	    /************************************************************************	    
	    String   Rel_Base_Dir       =       dir_t.get_Key_Rel_Base_Dir() ;
	    System.out.println ( "Rel_Base_Dir = >"
	    		           +  Rel_Base_Dir
	    		           + "<"
	    		           );
	    ************************************************************************/		           
	    
	    if    (  entry.getKey()     . equals     ( dir_t.get_Key_Rel_Base_Dir() )
              )	                           
              {
		                url_new     =  new   URL ( url_ws
                                                 , entry.getValue()
                                                 );
              }
	    else  {
		         String     parent  =  dir_t.get_Map_Key_Parent()      //
		                                    .get ( entry.getKey() );
		         String     p_value =  dir_t.get_Map_Key_Subdir()
                                            .get(parent);
		         String     value   =              entry.getValue();
		        
		 	    /************************************************************************
		         System.out.println ( "    p_value  = >"
     		                        +      p_value
     		                        + "<"
     		                        );
		         System.out.println ( "    value    = >"
                                    +      value
                                    + "<"
                                    );
                ************************************************************************/                    
		         URL    url_parent  =  dirs .get (     parent );
		         
//		         String url_p       =              url_parent.toExternalForm();
		       
		         String sub_dir     =  p_value
		                            + "/"
		                            +  value;
		         
		                sub_dir     =  get_Last_Subdirectory( p_value )
		                            + "/"
		                            +  value;
		         /************************************************************************
		         System.out.println ( "url_parent   = >"
		        		            +  url_p
		        		            + "<"
		        		            );
		        ************************************************************************/ 		            
		                url_new     =  new   URL ( url_parent
		         		                         , sub_dir    //  entry.getValue()
                                                 );
              }
return  url_new;
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
private  void  print_New_URL    ( final  URL   url_new ) 
{
	     System.out.println     ( "url_new      = >"
                                +  url_new      . toExternalForm()
                                + "<"
                                );
	     System.out.println     ( "---------------------------------------------------------" );
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
