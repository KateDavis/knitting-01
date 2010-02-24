package com.knitting.jamacoi;
import  java.io.*;
import  com.thoughtworks.xstream.XStream;

public class  Default_xml_string {
public        Default_xml_string ( String file_name_xml )
       throws java.io.IOException
{
Analysis_Parms       my_parms = new Analysis_Parms();
XStream              xstream  = new XStream();
String               xml      =     xstream.toXML(my_parms);   
try   {
       FileWriter file_xml    = new FileWriter(file_name_xml);
       file_xml.write( xml );
       file_xml.close();
      }
catch (java.io.FileNotFoundException e)
      {
       System.out.println("ERROR: could not write "
                         + file_name_xml
                         );
      }
}     
	

}
