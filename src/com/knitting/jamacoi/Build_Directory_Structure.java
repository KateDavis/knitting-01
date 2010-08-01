package com.knitting.jamacoi;

import static org.junit.Assert.assertNotNull;

import java.net.URL;

public   class    Build_Directory_Structure {
final    private  static  String  reports         =  "reports";
final    private  static  String  request_series  =  "request_series";
final    private  static  String  request_set     =  "request_set";
final    private  static  String  residuals       =  "residuals";

         private  URL     url_workspace;
         private  URL     rel_1_application_base;
         private  URL     rel_2_family;
         private  URL     rel_3_request;
         private  URL     rel_4_reports;
         private  URL     rel_4_residuals;
         private  URL     rel_4_request_series;
         private  URL     rel_4_request_set;
         private  String  str_1_application_base;
         private  String  str_2_family;
         private  String  str_3_request;

private           Build_Directory_Structure (){;}     // to prevent this constructor
public            Build_Directory_Structure ( URL     url_workspace
		                                    , String  str_1_application_base
		                                    , String  str_2_family
		                                    , String  str_3_request
		                                    ){
	     this.url_workspace                 =         url_workspace;
	     this.str_1_application_base        =         str_1_application_base;        
	     this.str_2_family                  =         str_2_family;
	     this.str_3_request                 =         str_3_request;
}
public   void    create_urls()
         throws  java.net.MalformedURLException
{	     
final  int    levels     = 2;
final  int    prefix_len = 2;
StringBuffer  sb         = new StringBuffer( prefix_len
		                                   + levels
		                                   + str_1_application_base.length()
		                                   + str_2_family          .length()
		                                   + str_3_request         .length() 
		                                   );
                 sb .append("./");    
assertNotNull   (url_workspace);	


                 sb  . append(str_1_application_base);
                 rel_1_application_base = new URL ( url_workspace,  sb.toString()        );
assertNotNull   (rel_1_application_base );

                 sb  . append("/");
                 sb  . append(str_2_family);
	             rel_2_family           = new URL ( url_workspace,  sb.toString()        );
assertNotNull   (rel_2_family );

                 sb  . append("/");
                 sb  . append(str_3_request);
	             rel_3_request          = new URL ( url_workspace,  sb.toString()        );
assertNotNull   (rel_3_request);

StringBuffer     sb4                    = new StringBuffer();
                 sb4.append(sb);
                 sb4.append("/");
final int        sb4_base_len           = sb4.length();                 

                 sb4.append(reports);
                 rel_4_reports          = new URL ( url_workspace,  sb4.toString() );
assertNotNull   (rel_4_reports);

                 sb4.replace( sb4_base_len
                		    , sb4.length()
                		    , request_series
                		    );
                 
                 rel_4_request_series   = new URL ( url_workspace,  sb4.toString() );
assertNotNull   (rel_4_request_series);

                 sb4.replace( sb4_base_len
		                    , sb4.length()
		                    , request_set
		                    );

                 rel_4_request_set      = new URL ( url_workspace,  sb4.toString() );
assertNotNull   (rel_4_request_set);

                 sb4.replace( sb4_base_len
                            , sb4.length()
                            , residuals
                            );

                 rel_4_residuals        = new URL ( url_workspace,  sb4.toString() );
assertNotNull   (rel_4_residuals);               
}
private URL[]   get_urls(){
	    URL[]       urls    = new URL[ 7 ];
	                urls[0] =     rel_1_application_base;
	                urls[1] =     rel_2_family;
	                urls[2] =     rel_3_request;
	                urls[3] =     rel_4_reports;
	                urls[4] =     rel_4_request_series;
	                urls[5] =     rel_4_request_set;
	                urls[6] =     rel_4_residuals;
	    
return              urls;	    
}
public void     show_urls(){
final  URL[]    urls  = get_urls();

	            System.out.println( "\n" );
	                            
                for ( URL  u
                	: urls
                	)
                    { show_url ( u ); } 
                
                System.out.println( "\n" );
}
public void     show_url ( URL  u ){
	            System.out.print  ( "url = >"
	            		          +  u.toExternalForm()
	            		          + "<\n"
	                              );	
}	
public void     check_urls(){
	
}
public void     check_url ( URL  u ){
	
}
}