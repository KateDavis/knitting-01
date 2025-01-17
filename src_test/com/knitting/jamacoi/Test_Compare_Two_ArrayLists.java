package com.knitting.jamacoi;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public  class  Test_Compare_Two_ArrayLists {
private static String line_01_e = "line 01 abcd";
private static String line_01_a = "line 01 accd";
private static String line_02_e = "line 02 efghijk";
private static String line_02_a = "line 02 efghhjk";
private static String line_03_a = "line 03 xyz";

public         Compare_Two_ArrayLists c            ;
public         ArrayList<String>      e            ;
public         ArrayList<String>      e_empty      ;
public         ArrayList<String>      a_eq         ;
public         ArrayList<String>      a_different_1;
public         ArrayList<String>      a_different_2;
public         ArrayList<String>      a_missing    ;
public         ArrayList<String>      a_extra      ;
public         ArrayList<String>      a_empty      ;
	@Before
	public void setUp(){
		   e            = new ArrayList<String>();
		   e            . add( line_01_e );
		   e            . add( line_02_e );
		   
		   a_eq         = new ArrayList<String>();
           a_eq         . add( line_01_e );
           a_eq         . add( line_02_e );
		   
		   a_different_1= new ArrayList<String>();
           a_different_1. add( line_01_a );
           a_different_1. add( line_02_e );
		   
           a_different_2= new ArrayList<String>();
           a_different_2. add( line_01_e );
           a_different_2. add( line_02_a );
		   
		   a_missing    = new ArrayList<String>();
           a_missing    . add( line_01_e );
                             
		   a_extra      = new ArrayList<String>();
           a_extra      . add( line_01_e );
           a_extra      . add( line_02_e );
           a_extra      . add( line_03_a );

		   a_empty      = new ArrayList<String>();
		   e_empty      = new ArrayList<String>();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testGet_Min() {
		c       = new Compare_Two_ArrayLists ( e, a_eq );
		
		assert (e    . size() == c.get_Min() );
		assert (a_eq . size() == c.get_Min() );
	}

	@Test
	public void test_01_Find_First_Difference() {
		              c = new Compare_Two_ArrayLists ( e, a_eq          );
    ArrayList<String> d = c.find_First_Difference();
    assert           (d.size() == 0 );
	}
	
	@Test
	public void test_02_Act_Difference_1() {
		              c = new Compare_Two_ArrayLists ( e, a_different_1 );
    ArrayList<String> d = c.find_First_Difference();
    assert           (d.size()  > 0 );
                      c.print_ArrayList(d);
                      System.out.println( " " );
	}
	@Test
	public void test_03_Act_Difference_2() {
		              c = new Compare_Two_ArrayLists ( e, a_different_2 );
    ArrayList<String> d = c.find_First_Difference();
    assert           (d.size()  > 0 );
                      c.print_ArrayList(d);
                      System.out.println( " " );
	}
	
	@Test
	public void test_04_Act_Difference_Missing() {
		              c = new Compare_Two_ArrayLists ( e, a_missing     );
    ArrayList<String> d = c.find_First_Difference();
    assert           (d.size()  > 0 );
                      c.print_ArrayList(d);
                      System.out.println( " " );
	}
	
	@Test
	public void test_05_Act_Difference_Extra() {
		              c = new Compare_Two_ArrayLists ( e, a_extra       );
    ArrayList<String> d = c.find_First_Difference();
    assert           (d.size()  > 0 );
                      c.print_ArrayList(d);
                      System.out.println( " " );
	}
	
	@Test
	public void test_06_Act_Difference_Empty() {
		              c = new Compare_Two_ArrayLists ( e, a_empty       );
    ArrayList<String> d = c.find_First_Difference();
    assert           (d.size()  > 0 );
                      c.print_ArrayList(d);
                      System.out.println( " " );
	}
	@Test
	public void test_07_Exp_Act_Empty() {
		              c = new Compare_Two_ArrayLists ( e_empty, a_empty );
    ArrayList<String> d = c.find_First_Difference();
    assert           (d.size() == 0 );
                      System.out.println( " " );
	}
	@Test
	public void test_08_Exp_Empty() {
		              c = new Compare_Two_ArrayLists ( e_empty, a_eq );
    ArrayList<String> d = c.find_First_Difference();
    assert           (d.size() > 0 );
                      c.print_ArrayList(d);
                      System.out.println( " " );
	}

}
