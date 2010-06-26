package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Formatter;

public     class     String_Row {
           private   int               cols;
           private   ArrayList<String> str;

private              String_Row(){ // to prevent this constructor's use

}
public               String_Row( final  int   cols){
                     set_cols               ( cols );
           str = new ArrayList<String>  ( get_cols() );

}
protected  void     set_cols(   final  int  cols ){
           this        .cols  =             cols; 
}
public     int      get_cols(){
           return       cols;
}
public     boolean  add_string( final  String  s ){
    
           if   (  
 		          ( str.size() <  get_cols() )
 		          ||
 		          ( str.size() == get_cols() )
 	            )
                {
                    return str.add( s ); 	   
                }
           else 
                {
 	                return false;
                }
}
public     boolean  set_string( final  int     col
	                          , final  String  s
	                          ) {
           if   (  col   <   get_cols() )
                {
 	               str.set( cols , s );
 	               return true;
                }
           else
                {
 	               return false;
                }
}
public     String   get_string( final  int  col){
           return   str.get               ( col );
}
public     String   fmt_row(final String fmt_str ){
           Formatter  fmt = new Formatter();
           for ( String s: str)
               {
 	             fmt.format( fmt_str, s );
               }
           return fmt.toString();	
}
}