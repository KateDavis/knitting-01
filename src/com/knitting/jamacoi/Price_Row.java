package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Formatter;

public     class    Price_Row {
	       private  int               cols;
           private  ArrayList<Double> pr;

private             Price_Row(){ // to prevent this constructor's use
	
}
public              Price_Row( final  int   cols){
	       set_cols( cols );
	       pr = new ArrayList<Double>( get_cols() );
	
}
protected  void     set_cols( final  int  cols ){
           this        .cols  =   cols; 
}
public     int      get_cols(){
	       return       cols;
}
public     boolean  add_price( final  Double  price ){
	       
	       if   (  
	    		  ( pr.size() <  get_cols() )
	    		  ||
	    		  ( pr.size() == get_cols() )
	    	    )
	            {
	                return pr.add( price ); 	   
	            }
	       else 
	            {
	    	        return false;
	            }
}
public     boolean  set_price( final  int    col
		                     , final  Double price
		                     ) {
           if   (  col   <   get_cols() )
                {
        	       pr.set( cols , price );
        	       return true;
                }
           else
                {
        	       return false;
                }
}
public     Double   get_price( final  int  col){
	       return   pr.get( col );
}
public     String   fmt_row_space_and_decimal(){
	       return   fmt_row( "  %9.4f" );
}
public     String   fmt_row_comma_and_decimal(){
           return   fmt_row( ",%9.4f" );
}
public     String   fmt_row_comma_and_scientific(){
           return   fmt_row( ",%12.5E" );
}
public     String     fmt_row(final String fmt_str ){
	       Formatter  fmt = new Formatter();
	       for ( Double price: pr)
	           {
	    	     fmt.format( fmt_str, price.floatValue() );
	           }
	       return fmt.toString();
	       
	
}
}
