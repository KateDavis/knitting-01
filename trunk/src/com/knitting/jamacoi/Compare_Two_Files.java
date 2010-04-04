package com.knitting.jamacoi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public  class   Compare_Two_Files {
	    private String                   File_Name_Expect_Contents;
        private String                   File_Name_Actual_Contents;
	   
private Compare_Two_Files       (){};    // to prevent its use.
public  Compare_Two_Files       ( String File_Name_Expect_Contents
		                        , String File_Name_Actual_Contents
		                        ) {
	    this.File_Name_Expect_Contents = File_Name_Expect_Contents;
	    this.File_Name_Actual_Contents = File_Name_Actual_Contents;	
}
public  boolean exists_Expected(){	
	    return  exists_File    (         File_Name_Expect_Contents);
	
}
public  boolean exists_Actual  (){	
        return  exists_File    (         File_Name_Actual_Contents);

}
private boolean exists_File    ( String                    File_Name ){
	    InputStream   stream  =  this.getClass()
                                     .getResourceAsStream( File_Name );
	    return        stream ==  null;
}
public  boolean equal_Files(){
        ArrayList    <String> expected = load_List( File_Name_Expect_Contents );
        ArrayList    <String> actual   = load_List( File_Name_Actual_Contents );
        
        Compare_Two_ArrayLists diff    = new Compare_Two_ArrayLists ( expected
                                                                    , actual
                                                                    );

        return diff.are_Equal();
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
	   

}