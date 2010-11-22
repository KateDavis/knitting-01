package com.knitting.jamacoi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Formatter;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_DIrectory_Manager {
	
	Directory_Triples  dir_t;

	@BeforeClass
	public static void setUpBeforeClass  () 
	       throws      Exception 
	{
	}

	@AfterClass
	public static void tearDownAfterClass() 
	       throws      Exception 
	{
	}

	@Before
	public void   setUp() 
	       throws Exception 
	{
		   dir_t  =  new  Directory_Triples ( "family"
				                            , "appl_amzn_qcom"
				                            );
		   dir_t  .  put  ( "request"
				          , "family"
				          , "request_dir"
				          );
	}

	@After
	public void   tearDown() 
	       throws Exception 
	{
	}

	@Test
	public void testDirectory_Manager() 
	{
	       try   {
			       Directory_Manager dm = new Directory_Manager ( dir_t );
		         } 
	       catch ( MalformedURLException e) 
		         {
		           e.printStackTrace();
		         }	
	}

	@Test
	public void testGet_Map_URL() 
	{
	       try   {
		           Directory_Manager    dm =  new  Directory_Manager ( dir_t );
		           list_Keys_and_URLs ( dm );
	             } 
           catch ( MalformedURLException e) 
	             {
	               e.printStackTrace();
	             }	
	}
private  void  list_Keys_and_URLs ( Directory_Manager  dm )
{
for   ( Map.Entry < String,  URL >  entry
      : dm .get_Map_URL()        .  entrySet()
      )
      {
      ;	Formatter fmt  =  new Formatter();
                  fmt  .  format ( "Key   =>%s<%nValue =>%s<%n"
                		         ,  entry.getKey  ()
                		         ,  entry.getValue().toExternalForm()
        		                 );
        System.out.println       (  fmt  .toString() );          
      }
	
}

}
