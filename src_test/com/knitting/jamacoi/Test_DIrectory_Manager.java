package com.knitting.jamacoi;

import java.net.MalformedURLException;

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
		           Directory_Manager dm = new Directory_Manager ( dir_t );
	             } 
           catch ( MalformedURLException e) 
	             {
	               e.printStackTrace();
	             }	
	}

}
