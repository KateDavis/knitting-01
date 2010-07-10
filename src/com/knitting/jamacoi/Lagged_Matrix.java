 
 package com.knitting.jamacoi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.knitting.util.K_Calendar;


public    class      Lagged_Matrix {
          private    int                      price_cols;
          private    String_Row               name_security;
          private    String_Row               name_lag;
	      private    TreeMap<Date, Price_Row> tm;

private              Lagged_Matrix(){   // to prevent this constructor's use
	
}
public               Lagged_Matrix( final int         price_cols
		                          , final String_Row  ns
		                          , final String_Row  nl
		                          ){

                              set_price_cols( price_cols )  ;
          name_security =     ns;
          name_lag      =     nl;
          tm            = new TreeMap<  Date, Price_Row>()  ;
}
protected void       set_price_cols(final int cols){
	                     price_cols =         cols;
}
public    int        get_price_cols(){
          return         price_cols;
}
public    String     get_name_security( final int col){
	      return         name_security.get_string(col);
}
public    void       set_name_security( final int    col
		                              , final String s
		                              ){
                         name_security.set_string  ( col
                        		                   , s
                        		                   );
}
public    void       add_name_security( final String s ){
	                     name_security.add_string  ( s );
}
public    String     get_name_lag     ( final int col ){
          return         name_lag.get_string    ( col );   
}
public    void       set_name_lag     ( final int    col
                                      , final String s
                                      ){
                         name_lag.set_string       ( col
                        		                   , s
                        		                   );
}                         
public    void       add_name_lag     ( final String s ){
	                     name_lag.add_string        (s );
}
public    void       put( final Date       date
		                , final Price_Row  pr
		                ) {
	      tm.put(date, pr);
}
public    void       print_name_security ( final  String_Row_Format  srf ) {
	      String     s   = name_security.fmt_row( srf.get_string_row_format() );
          System.out.println( "          "
        		            +  s
        		            );
}
public    void       print_name_lag ( final  String_Row_Format  srf ) {
          String     s   = name_lag.fmt_row( srf.get_string_row_format() );
          System.out.println( "ccyy_mm_dd"
  		                    +  s
  		                    );
}
public   void        print_ix_entries ( final  int               ix_max
		                              , final  Price_Row_Format  prf
		                              ){
         Set     <Map.Entry<Date,Price_Row>> set  = tm .entrySet();
         Iterator<Map.Entry<Date,Price_Row>> iter = set.iterator();
         int                                 ix   = 0;
    
         while (
  		          ( iter.hasNext()   )
  		          &&
  		          ( ix < ix_max      )
  		       )
               {
        	        System.out.println(fmt_entry( iter.next() 
        	        		                    , prf
        	        		                    ) 
        	        		          );
  	              ++ix;
               }
}
protected String     fmt_entry(final  Map.Entry<Date,Price_Row>  me 
		                      ,final  Price_Row_Format           prf
		                      ){
          K_Calendar kcal = new K_Calendar();
          String     date =     kcal.get_ccyy_mm_dd( (  me.getKey  () ) );
          Price_Row  pr   =                             me.getValue()    ;
          String     row  =     pr.fmt_row(prf.get_price_row_format() )  ;
          return     (  date
  		             +  row
  		             ) ;
}
public   void        write_ix_entries ( final  int               ix_max
                                      , final  Price_Row_Format  prf
                                      , final  String            file_name
                                      ){
         FileWriter                          fw;
         Set     <Map.Entry<Date,Price_Row>> set  = tm .entrySet();
         Iterator<Map.Entry<Date,Price_Row>> iter = set.iterator();
         int                                 ix   = 0;
         try   {
  	             fw     =   new  FileWriter  ( file_name );      	 
                 while  (
                          ( iter.hasNext()   )
                          &&
                          ( ix < ix_max      )
                        )
                        {
        	                fw.write( fmt_entry ( iter.next() , prf )
                                    );
                          ++ix;
                        }
                 fw.close();       
               }  
         catch ( IOException e ) 
               {
                 e.printStackTrace();
               }
}
}
