package com.knitting.jamacoi;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

public  class    Collected_Data {
static  private  Pattern              d_comma  =  Pattern.compile(",");	
static  private  Pattern              d_slash  =  Pattern.compile("/");
        private	 String               human_name;
        private	 String               state_desc;
        private	 TreeMap<Date,Double> s         ;
private          Collected_Data(){
	             human_name    = "error";
	             set_state_desc( "Created via no parm constructor" );
	             s             =  new TreeMap<Date,Double>();
}
public           Collected_Data( final  String  human_name
		                       , final  URI     data_location
		                       ){
	      this . human_name    =  human_name;
	             set_state_desc( "About to retreive data");
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
	Calendar         cal     =     Calendar.getInstance();
	int              count   =     tokens  .length;
	      if ( count >= 5 )
	         {
	    	  try   {
	    	                  parse_date(  tokens[0]
			                            ,  cal
			                            );
	    	          Double  close     =  Double.parseDouble( tokens[4] );
	    	                  s.put     ( cal.getTime()
	    		    		            , close
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
protected void   parse_date( String   s
		                   , Calendar cal
		                   )
          throws NumberFormatException{
	      String mmddyy [] = d_slash.split( s );
	      int    mm        = Integer.parseInt(mmddyy[0]);
	      int    dd        = Integer.parseInt(mmddyy[1]);
	      int    yy        = Integer.parseInt(mmddyy[2]);
	             cal       . set( yy
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
public  TreeMap  <Date, Double> get_prices(){
//	    SortedMap<Date, Double> usm = SortedMap.unmodifiableSortedMap( s );
//	    return                  usm;
	    return                    s;
}
public  String           get_first_date(){
	    SimpleDateFormat sdf     = new SimpleDateFormat("yyyy_MM_dd");
	    return           sdf     .     format          ( get_prices().firstKey());     
}
public  Date             get_firstKey(){
        return             s.firstKey();     
}
public  String           get_last__date(){
        SimpleDateFormat sdf     = new SimpleDateFormat("yyyy_MM_dd");
        return           sdf     .     format          ( get_prices().lastKey());     
}
public  Date             get_lastKey(){
        return             s.lastKey();     
}
public  Double  get_price_on_date( Date d ){
	    return             s.get (      d );
}
public  Set<Date>        get_keys(){
	    return             s.keySet();
}
public  Double  get_first_price(){
        return  s.get( get_firstKey() ) ;       
}
public  Double  get_last__price(){
        return  s.get( get_lastKey() ) ;        
}
public  boolean is_data_empty(){
	    return  s.isEmpty();
}

}
