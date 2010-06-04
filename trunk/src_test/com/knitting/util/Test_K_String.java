package com.knitting.util;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class  Test_K_String {
       String s1  = "a/b";
       String s2  = "a/b/c";
       String s3  = "a";
       String s4  = "/";
       String s5  = "";
       String s6  = "a.b";
       String s7  = "a.b.c";
       String s8  = "a";
       String s9  = ".";
       String s10 = "";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void Test_01_s1_a_b()
	{
		String s = K_String.get_file_name_short(s1);
		assertNotNull( s );
		assertTrue   ( s.length() == 1 );
		assertTrue   ( s.equals( "b" ) );
	}
	@Test
	public void Test_02_s2_a_b_c()
	{
		String s = K_String.get_file_name_short(s2);
		assertNotNull( s );
		assertTrue   ( s.length() == 1 );
		assertTrue   ( s.equals( "c" ) );
	}
	@Test
	public void Test_03_s3_a()
	{
		String s = K_String.get_file_name_short(s3);
		assertNotNull( s );
		assertTrue   ( s.length() == 1 );
		assertTrue   ( s.equals( "a" ) );
	}
	@Test
	public void Test_04_s4_slash()
	{
		String s = K_String.get_file_name_short(s4);
		assertNotNull( s );
		assertTrue   ( s.length() == 0 );
		assertTrue   ( s.equals( "" )  );
	}
	@Test
	public void Test_05_s5_empty()
	{
		String s = K_String.get_file_name_short(s5);
		assertNotNull( s );
		assertTrue   ( s.length() == 0 );
		assertTrue   ( s.equals( "" )  );
	}
	public void Test_06_s1_a_dot_b()
	{
		String s = K_String.remove_file_extention(s6);
		assertNotNull( s );
		assertTrue   ( s.length() == 1 );
		assertTrue   ( s.equals( "b" ) );
	}

}
