package com.knitting.jamacoi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Jama.Matrix;

public class Test_Partial_Auto_Correlation {

	Matrix                             ac_1;
	Matrix                             ac_2;
	Matrix                             ac[] = new Matrix[2]; 
	Partial_Auto_Correlation_Detail_3  pac;

	@BeforeClass
	public static void setUpBeforeClass()   throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp()    throws Exception {
		
	ac_1  = new Matrix (6,1);
	ac_1  . set(0, 0, -0.8445 );
	ac_1  . set(1, 0,  0.5910 );
	ac_1  . set(2, 0, -0.4140 );
	ac_1  . set(3, 0,  0.2900 );
	ac_1  . set(4, 0, -0.2030 );
	ac_1  . set(5, 0,  0.1420 );
	
	ac_2  = new Matrix (6,1);
	ac_2  . set(0, 0, -0.8445 );
	ac_2  . set(1, 0,  0.7 * ac_2.get(0,0) ); //  0.5910 );
	ac_2  . set(2, 0,  0.7 * ac_2.get(1,0) ); // -0.4140 );
	ac_2  . set(3, 0,  0.7 * ac_2.get(2,0) ); //  0.2900 );
	ac_2  . set(4, 0,  0.7 * ac_2.get(3,0) ); // -0.2030 );
	ac_2  . set(5, 0,  0.7 * ac_2.get(4,0) ); //  0.1420 );
	
	ac[0] = ac_1;
	ac[1] = ac_2;
	
	}
	
	
/********************************************	
	System.out.println("Results for ac_1:");
	System.out.println("");
	pac =  new Partial_Auto_Correlation_Detail_3( ac_1 );
	
	System.out.println("Results for ac_2:");
	System.out.println("");
	pac =  new Partial_Auto_Correlation_Detail_3( ac_2 );
	}
*******************************************/

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoad_matrix() {
	for ( int   i = 0
		;       i < 2
		;     ++i
		)
	    {
		 System.out.println("Processing a new auto correlation matrix:");
		 System.out.println("");
	   
		  pac =  new Partial_Auto_Correlation_Detail_3 ( ac[i] );
          pac .  load_matrix();
          System.out.println( " " );
          for (  int   row  =  0
    	      ;	     row  < pac.getRowDimension()
    	      ;      ++row
    	      )
              {
                 double r         =   pac.get(row, row);  
                 System.out.println( "partial auto_correlation r("
    		                        +  row
    		                        + " "
    		                        +  row
    		                        + ") = >"
    		                        +  r
    		                        + "<"
    		                        );
              }
  		  System.out.println("");
		  System.out.println("");
	    }
	}
}
