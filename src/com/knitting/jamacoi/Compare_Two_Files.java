package com.knitting.jamacoi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public  class   Compare_Two_Files {
	    private String                   File_Name_Contents_Expected;
        private String                   File_Name_Contents_Actual;
        private String                   File_Name_Contents_Difference;
        private String                   Dir_Name_Actual = "actual";
	   
private Compare_Two_Files       (){};    // to prevent its use.
public  Compare_Two_Files       ( String File_Name_Contents_Expected
		                        , String File_Name_Contents_Actual
		                        , String File_Name_Contents_Difference
		                        ) {
	    this.File_Name_Contents_Expected   = File_Name_Contents_Expected;
	    this.File_Name_Contents_Actual     = File_Name_Contents_Actual;
	    this.File_Name_Contents_Difference = File_Name_Contents_Difference;
}
public  boolean exists_Expected(){	
	    return  exists_File    (             File_Name_Contents_Expected);
	
}
public  boolean exists_Actual  (){	
        return  exists_File    (             File_Name_Contents_Actual);

}
private boolean exists_File    ( String                    File_Name ){
	    InputStream   stream  =  this.getClass()
                                     .getResourceAsStream( File_Name );
	    return        stream ==  null;
}
public  boolean equal_Files(){
        ArrayList    <String> expected = load_List( File_Name_Contents_Expected );
        ArrayList    <String> actual   = load_List( File_Name_Contents_Actual   );
        
        Compare_Two_ArrayLists diff    = new Compare_Two_ArrayLists ( expected
                                                                    , actual
                                                                    );
        boolean d                      = diff.are_Equal();
        
        if  ( d )
            {
        	  delete_diff_file();
            }
        else
            {
        	  create_diff_file( diff );
            }
        return d;
}
private ArrayList<String>     load_List ( String                   File_Name){
	    ArrayList<String>          list = new ArrayList<String>();
try    {	    
	    InputStream              stream = this.getClass()
                                              .getResourceAsStream(File_Name);

        Scanner                 scanner = new Scanner( stream );
        while (                 scanner . hasNextLine()
              )
              { 
                list.add(       scanner . nextLine   () );
              }
        stream.close();
       }
catch  (Exception e)
       {System.out.println( "ERROR: Input file = >"
    		              +  File_Name
    		              + "< does not exist or cannot be found."
    		              );
       }
		return  list;
}
public String get_Dir_Actaul(){
	   URL    url_Name = this . getClass() . getResource(Dir_Name_Actual);
return      ( url_Name        . getPath () );	
}
protected void delete_diff_file(){
	      File diff = new File (File_Name_Contents_Difference);
	      if ( diff.exists() )
	         {
               diff.delete();
             }
}
protected void create_diff_file( ArrayList<String> diff)
          throws IOException
{
	      delete_diff_file();
try      {	      
	      FileWriter d = new FileWriter( File_Name_Contents_Difference);
         }
catch    (IOException e)
         { throw      e;
         }
         }
	      
}