package com.knitting.jamacoi;

public    class     Price_Row_Format {
static	  enum      fmt_type   { SPACE_DECIMAL
                               , COMMA_DECIMAL
                               , COMMA_SCIENTIFIC;
                               };
static    String[]  fmt_strs = { "  %9.4f"
                               ,  ",%9.4f"
                               , ",%12.5E"
                               } ;
private   String    fmt_str;
          
public              Price_Row_Format(){
                    fmt_str = fmt_strs[fmt_type.COMMA_SCIENTIFIC.ordinal()];
}
public              Price_Row_Format ( final  fmt_type  f  ){
                    fmt_str = fmt_strs                [ f.ordinal() ];
}
public              Price_Row_Format ( final  String    s  ){
	                fmt_str = s;
}
public              Price_Row_Format ( final  int       ix ){
                    fmt_str = fmt_strs[ix];
}
public    String    get_price_row_format(){
	      return    fmt_str;
}
public    void      set_price_row_format( final String s ){
	                fmt_str = s;
}
}
