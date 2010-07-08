package com.knitting.jamacoi;
import java.io.BufferedReader;
import java.io.FileReader;
public class Build_xml_string {
	private String xml_trimmed;
    
	public         Build_xml_string ( String file_name_xml )
	        throws java.io.IOException
	{
	 try   {
	        FileReader     file_xml = new FileReader    ( file_name_xml);
	        BufferedReader br       = new BufferedReader( file_xml     );
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
	 catch (java.io.FileNotFoundException e)
	       {
	        System.out.println("ERROR: could not read "
	                          + file_name_xml
	                          );
	       }   
	}      
	public String get_xml_string()
	{
	       return xml_trimmed;
	}
//	public void    write_to_disk      ( String file_name_xml )
//	       throws  java.io.IOException
//	{
//		   try    {
//			   
//		          }
//		   catch  ( java.io.FileNotFoundException e)
//	              {
//	                System.out.println("ERROR: could not read "
//	                                  + file_name_xml
//	                                  );
//	              }  
//	}
}
