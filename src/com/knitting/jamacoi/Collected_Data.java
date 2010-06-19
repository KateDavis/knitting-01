package com.knitting.jamacoi;

import java.io.File;
import java.net.URI;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

import com.knitting.util.K_Calendar;

public  class      Collected_Data {
static  private    Pattern              d_comma  =  Pattern.compile(",");	
static  private    Pattern              d_slash  =  Pattern.compile("/");
        private	   String               human_name;
        private	   String               state_desc;
        private    TreeSet<Integer>     lags;
        private    int                  price_q_size_actual;
        private    Double[]             price_q;
        private    K_Calendar           kcal;
        private	   TreeMap<Date,Double> s         ;
private            Collected_Data(){
	               human_name    = "error";
	               set_state_desc( "Created via no parm constructor" );
	               s             =  new TreeMap<Date,Double>();
}
public             Collected_Data( final  String            human_name
		                         , final  URI               data_location
		                         , final  TreeSet<Integer>  lags
		                         , final  K_Calendar        kcal
		                         ){
	        this . human_name    =  human_name;
	               set_state_desc( "About to retreive data");
	        this . lags          =  (TreeSet<Integer>)lags.clone();
	               set_price_q();
	        this . kcal          =  kcal;
	               s             =  new TreeMap<Date,Double>();
	               load_data     (  data_location );
}
protected void  load_data( URI  d ){
	      File    f = new File (d);
	      check_if_file_exists (f);
}
protected void  check_if_file_exists       ( File  f ){
          if   ( f.exists() )
               {
        	     set_state_desc( "File exists."          );
        	     check_if_file_is_a_file   ( f );
               }
          else { set_state_desc( "File does NOT exist."  );}
}
protected void  check_if_file_is_a_file    ( File  f ){
	      if   ( f.isFile() )
               {
	             set_state_desc( "File is a file."       );
	             check_if_file_is_readable ( f );
               }
	      else { set_state_desc( "File is NOT a file."   );}
}
protected void   check_if_file_is_readable ( File f ){
          if   ( f.canRead() )
               {
	             set_state_desc( "File is a readable."   );
	             read_source( f ); 
               }
          else { set_state_desc( "File is NOT readable." );}
}
protected void   read_source   ( File f ){
	      try  {
	             Scanner scan = new Scanner( f    );
	                     load_source       ( scan );
	                     scan .     close        ();
	             set_state_desc( "File was closed."              );        
	           }
	      catch ( Exception FileNotFoundException )
	            {
	    	     set_state_desc( "File NOT found at read time."  );
	            }
}
protected void  load_source( Scanner scan){
	      boolean   parsed_ok = true;
	      while ( 
	    		  ( scan.hasNextLine() )
	    		  &&
	    		  ( parsed_ok          )
	    		)
	            {
	    	      String line = scan.nextLine();
	    	      parsed_ok   = parse_line (  line );
	            }
}
protected boolean  parse_line( final  String  line){

	String []        tokens  =     d_comma .split (line);
	int              count   =     tokens  .length;
	      if ( count >= 5 )
	         {
	    	  try   {
	    	          Date    date      =  parse_date        ( tokens[0] );
	    	          Double  close     =  Double.parseDouble( tokens[4] );
	    	                  s.put     (  date
	    		    		            ,  close
	    		    			        );
	    	        }
	    	  catch ( Exception  NumberFormatException )
	    	        {
	    		      set_state_desc( "Could not parse line data"  );
	    		      return false;
	    	        }

              return         true;
	         }
	                  set_state_desc( "line did not contain enough data to parse"  );
	      return             false;
}
protected Date   parse_date( String   s )
          throws NumberFormatException{
	             String mmddyy [] = d_slash.split( s );
	             int    mm        = Integer.parseInt(mmddyy[0]);
	             int    dd        = Integer.parseInt(mmddyy[1]);
	             int    yy        = Integer.parseInt(mmddyy[2]);
	             
	      return        kcal      . set_ccyy_mm_dd( yy
	    		                                  , mm
	    		                                  , dd
	    		                                  ) ;
}
public  int     get_date_count(){
	    return  s.size();
}
private void    set_state_desc(final  String  s){
	                state_desc = s;
}
public  String  get_state_desc(){
	    return      state_desc;
}
public  String  get_human_name(){
	    return      human_name;
}
public  TreeSet  <Integer     > get_lags  (){
	    return                      lags;
}
public  Double[]  get_price_q(){
	    return        price_q;
}
public  TreeMap  <Date, Double> get_prices(){
//	    SortedMap<Date, Double> usm = SortedMap.unmodifiableSortedMap( s );
//	    return                  usm;
	    return                    s;
}
public  String           get_first_date(){
	    return           kcal.get_ccyy_mm_dd( get_prices().firstKey() ); 
}
public  Date             get_firstKey(){
        return             s.firstKey();     
}
public  String           get_last__date(){  
        return           kcal.get_ccyy_mm_dd( get_prices().lastKey() );
}
public  Date             get_lastKey(){
        return             s.lastKey();     
}
public  Double           get_price_on_date ( Date d ) {
	    if ( s.containsKey     ( (Object)     d ) )
	       { return       s.get( (Object)     d ) ; } 
	    else
	       { return       -1.0;           }
}
public  Set<Date>        get_keys(){
	    return             s.keySet();
}
public  Double           get_first_price(){
        return           s.get( get_firstKey() ) ;       
}
public  Double           get_last__price(){
        return           s.get( get_lastKey() ) ;        
}
public  boolean          is_data_empty(){
	    return           s.isEmpty();
}
public  int              get_lag_size(){
        return              lags.size();
}
public  int              get_lags_max(){
	    return               lags.last();
}
public  int              get_price_q_size_actual(){
	    return               price_q_size_actual;
}
public  void             print_print_q(){
           for ( int     ix = 0
	    	   ;         ix <      get_price_q_size_actual()
	    	   ;       ++ix
	    	   )
	           {
	    	             System.out.println( "  price_q["
	    	               		           +    ix
	    	            		           +   "] = >"
	    	            		           +    price_q[ix]
	    	            		           +   "<"
	    	            		           );
	           }
}
public  void             add_price_q( Double  price ){
	    if   (
	    		 ( lags.last() != get_price_q_size_actual() )
	    		 ||
	    		 ( price_q        == null               )
	    	 )
	         {
	    	       insert_price( price );   
	         }
	    else
	         {
	    	       set_price_q();
	         }
}
protected  void  insert_price( Double price){
	       for ( int    ix = (get_price_q_size_actual() - 1 )
	    	   ;        ix > 0      
	    	   ;      --ix
	    	   )
	           {
	    	            price_q[ ix ] = price_q[ ix - 1 ];
	           }
	       price_q[0] = price;
}
protected  void  set_price_q(){
	                             set_price_q_size_actual();
	       price_q = new Double[ get_price_q_size_actual() ];
	       
	       for ( int   ix = 0
	    	   ;       ix <      get_price_q_size_actual()
	    	   ;     ++ix
	    	   )
	           {
	    	           price_q[ix] = -1.0;
	           } 
}
protected  void set_price_q_size_actual(){
	                price_q_size_actual = lags.last()
	                                    + 1;
}
}