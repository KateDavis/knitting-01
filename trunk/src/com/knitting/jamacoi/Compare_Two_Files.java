package com.knitting.jamacoi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
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
public  boolean exists_Expected   (){	
	    return  exists_File       (          File_Name_Contents_Expected   );
}
public  boolean exists_Actual     (){	
        return  exists_File       (          File_Name_Contents_Actual     );
}
public  boolean exists_Difference (){	
        return  exists_File       (          File_Name_Contents_Difference );
}
private boolean exists_File       ( String   File_Name ){

	    File    f              =  new File ( File_Name );
	    return  f.exists();              
}
public  boolean equal_Files(){
        ArrayList    <String>  expected = load_List( File_Name_Contents_Expected );
        ArrayList    <String>  actual   = load_List( File_Name_Contents_Actual   );
        
        Compare_Two_ArrayLists c        = new Compare_Two_ArrayLists ( expected
                                                                     , actual
                                                                     );
                           
        ArrayList<String>      diff     = c.find_First_Difference();
        assert                (diff.size() > 0 );
                                          c.print_ArrayList(diff);
        System.out.println( " " );
 
        if  ( diff.size() == 0 )
            {
        	  delete_diff_file();
            }
        else
            {
        	  try   {
				     create_diff_file( diff );
			        }
        	  catch (IOException e) 
        	        {
			    	 e.printStackTrace();
			        }
            }
        return ( diff.size() == 0 );
}
private ArrayList<String>     load_List ( String                   File_Name){
	    ArrayList<String>          list = new ArrayList<String>();
	    File                          f = new File                (File_Name);
	    if   ( f.exists() )
	         {
//	    	   System.out.println( "In load_List: file          exists = >"
//	    			             +  File_Name
//	    			             + "<"
//	    			             )  ;
	         }
	    else {
//	    	   System.out.println( "In load_List: file does NOT exists = >"
//			                     +  File_Name
//			                     + "<"
//			                     )  ;	
	         }
try    {	    
	    Scanner                 scanner = new Scanner( f );
        while (                 scanner . hasNextLine()
              )
              { 
                list.add(       scanner . nextLine   () );
              }
        scanner.close();
       }
catch  (Exception e)
       {System.out.println( "ERROR: Input file ..... = >"
    		              +  File_Name
    		              + "< does not exist or cannot be found."
    		              )  ;
        System.out.println( "       exception msg .. = >"
        		          +  e.getMessage()
        		          + "<"
                          )  ;
       
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

	      FileWriter        d    = new  FileWriter( File_Name_Contents_Difference);
	      Iterator<String>  iter =      diff.iterator();
	      while ( iter.hasNext() )
	            {
	    	      String     line = iter.next();
	    	      Formatter  fmt  = new Formatter();
	    	      fmt.format ( "%s\n", line   );
	    	      d.write    ( fmt.toString() );
	            }
	      d.close();
         }
catch    (IOException e)
         { throw      e;
         }
         }
	      
}