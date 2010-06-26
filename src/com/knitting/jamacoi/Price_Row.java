package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Formatter;

public     class    Price_Row {
/**********************************************************************	
static	   enum     fmt_type  { SPACE_DECIMAL
	                          , COMMA_DECIMAL
	                          , COMMA_SCIENTIFIC
	                          };
static     String[] fmt_str = { "  %9.4f"
		                      ,  ",%9.4f"
		                      , ",%12.5E"
                              } ;
**********************************************************************/                              
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
	       Price_Row_Format f = new Price_Row_Format
	                              ( Price_Row_Format.fmt_type.SPACE_DECIMAL );
	       return   fmt_row ( f.get_price_row_format() );
}
public     String   fmt_row_comma_and_decimal(){
           Price_Row_Format f = new Price_Row_Format
                                  ( Price_Row_Format.fmt_type.COMMA_DECIMAL );
           return   fmt_row ( f.get_price_row_format() );	
}
public     String   fmt_row_comma_and_scientific(){
           Price_Row_Format f = new Price_Row_Format
                                  ( Price_Row_Format.fmt_type.COMMA_SCIENTIFIC );
           return   fmt_row ( f.get_price_row_format() );	
}
public     String   fmt_row(final String fmt_str ){
	       Formatter  fmt = new Formatter();
	       for ( Double price: pr)
	           {
	    	     fmt.format( fmt_str, price.floatValue() );
	           }
	       return fmt.toString();	
}
}
