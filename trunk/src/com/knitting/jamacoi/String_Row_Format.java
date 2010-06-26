package com.knitting.jamacoi;


public    class     String_Row_Format {
static	  enum      fmt_type   { SPACE_DECIMAL
                               , COMMA_DECIMAL
                               , COMMA_SCIENTIFIC;
                               };
static    String[]  fmt_strs = { "  %9.4f"
                               ,  ",%9.4f"
                               , ",%12.5E"
                               } ;
private   String    fmt_str;
public              String_Row_Format(){
                    fmt_str = fmt_strs[fmt_type.COMMA_SCIENTIFIC.ordinal()];
}
public              String_Row_Format ( final  fmt_type  f  ){
                    fmt_str = fmt_strs                 [ f.ordinal() ];
}
public              String_Row_Format ( final  String    s  ){
                    fmt_str = s;
}
public              String_Row_Format ( final  int       ix ){
                    fmt_str = fmt_strs[ix];
}
public    String    get_string_row_format(){
          return    fmt_str;
}
public    void      set_string_row_format( final String s ){
                    fmt_str = s;
}
}
