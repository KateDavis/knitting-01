package com.knitting.jamacoi;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.URL;

import com.thoughtworks.xstream.XStream;
public class Build_xml_string {
	private String xml_trimmed;
    
	public         Build_xml_string ( URL u )
	       throws  java.io.IOException
	{
		   assertNotNull       ( u ) ;
		   
		   File  f    = new File   ( u.getFile() );

		   assertTrue ( f.exists() );
		   assertTrue ( f.isFile() );
		
		   try   {
			        FileReader     file_xml = new FileReader    ( f        );
			        BufferedReader br       = new BufferedReader( file_xml );
			        String         a_line;
			        String         a_xml    = "";
			        while (
			                 null  != ( a_line = br.readLine() )
			              )
			              {
			                 a_xml  = a_xml
			                        + a_line
			                        + "\n";
			              }
			        file_xml.close();
			        xml_trimmed = a_xml.substring(  0
			                                     , (a_xml.length() -1 )
			                                     );
			       } 
		   catch   (java.io.FileNotFoundException e)
			       {
			        System.out.println("ERROR: could not read file refereced in URL "
			                          + u.toString()
			                          );
			       }   
	}
	       
	public String get_xml_string()
	{
	       return xml_trimmed;
	}
  	public void    write_to_disk      ( URL             u
  			                          , XStream         x
  			                          , Analysis_Parms  p
  			                          )
  	       throws  java.io.IOException
   {
  		   try    {
  			        File              f = new File ( u.getFile() );
  			        FileOutputStream os = new FileOutputStream( f );
  			        x.toXML(p, os);
  		          }
  		   catch  ( java.io.FileNotFoundException e)
  	              {
  	                System.out.println("ERROR: could not read "
  	                                  + u.toExternalForm()
  	                                  );
  	              }  
  	}
}
