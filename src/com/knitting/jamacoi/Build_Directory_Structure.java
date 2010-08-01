package com.knitting.jamacoi;

import static org.junit.Assert.assertNotNull;

import java.net.URL;

public   class    Build_Directory_Structure {
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
         private  String  str_4_reports;
         private  String  str_4_request_series;
         private  String  str_4_request_set;
         private  String  str_4_residuals;
private           Build_Directory_Structure (){;}     // to prevent this constructor
public            Build_Directory_Structure ( URL     url_workspace
		                                    , String  str_1_application_base
		                                    , String  str_2_family
		                                    , String  str_3_request
		                                    , String  str_4_reports
		                                    , String  str_4_request_series
		                                    , String  str_4_request_set
		                                    , String  str_4_residuals
		                                    ){
	     this.url_workspace                 =         url_workspace;
	     this.str_1_application_base        =         str_1_application_base;        
	     this.str_2_family                  =         str_2_family;
	     this.str_3_request                 =         str_3_request;
	     this.str_4_reports                 =         str_4_reports;
	     this.str_4_request_series          =         str_4_request_series;
	     this.str_4_request_set             =         str_4_request_set;
	     this.str_4_residuals               =         str_4_residuals;
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

                 sb4.append(str_4_reports);
                 rel_4_reports          = new URL ( url_workspace,  sb.toString() );
assertNotNull   (rel_4_reports);

                 sb4.replace( sb4_base_len
                		    , sb4.length()
                		    , str_4_request_series
                		    );
                 
                 rel_4_request_series   = new URL ( url_workspace,  sb.toString() );
assertNotNull   (rel_4_request_series);

                 sb4.replace( sb4_base_len
		                    , sb4.length()
		                    , str_4_request_set
		                    );

                 rel_4_request_set      = new URL ( url_workspace,  sb.toString() );
assertNotNull   (rel_4_request_set);

                 sb4.replace( sb4_base_len
                            , sb4.length()
                            , str_4_residuals
                            );

                 rel_4_residuals        = new URL ( url_workspace,  sb.toString() );
assertNotNull   (rel_4_residuals);               
}
public void     show_urls(){
	            System.out.println( " " );
	            show_url ( rel_1_application_base );
	            show_url ( rel_2_family           );
	            show_url ( rel_3_request          );
	            show_url ( rel_4_reports          );
	            show_url ( rel_4_request_series   );
	            show_url ( rel_4_request_set      );
	            show_url ( rel_4_residuals        );
	            System.out.println( " " );
}
public void     show_url ( URL  u ){
	            System.out.print( "url = >"
	            		        +  u.toExternalForm()
	            		        + "<"
	                            );
	
}

	
}