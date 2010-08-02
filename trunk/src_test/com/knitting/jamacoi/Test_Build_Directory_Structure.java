package com.knitting.jamacoi;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Build_Directory_Structure {

	@BeforeClass
	public static void   setUpBeforeClass  () 
	              throws Exception {
	}

	@AfterClass
	public static void   tearDownAfterClass() 
	              throws Exception {
	}

	@Before
	public        void   setUp() 
	              throws Exception {
	}

	@After
	public        void   tearDown() 
	              throws Exception {
	}

	@Test
	public        void   test_01()
	              throws Exception
	{
	final  String     app      =  "regression";
	final  String     family   =  "appl_amzn_qcom_01";
	final  String     request  =  "request_01";
	
	       Workspace  ws       =   new  Workspace();
	
	Build_Directory_Structure  bds = new
	Build_Directory_Structure            ( ws.get_Workspace() 
			                             , app
			                             , family
			                             , request
			                             );
	bds.create_urls();
	bds.show_urls  ();
	bds.check_urls ();
	bds.create_directories();

	}
	@Test
	public        void   test_02()
	              throws Exception
	{
	final  String     app      =  "test/regression/app";
	final  String     family   =  "appl_amzn_qcom_01";
	final  String     request  =  "request_01";
	
	       Workspace  ws       =   new  Workspace();
	
	Build_Directory_Structure  bds = new
	Build_Directory_Structure            ( ws.get_Workspace() 
			                             , app
			                             , family
			                             , request
			                             );
	bds.create_urls();
	bds.show_urls  ();
	bds.check_urls ();
	bds.create_directories();

	}
}
