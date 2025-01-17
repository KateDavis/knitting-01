package com.knitting.jamacoi;

public class Sub_Matrix 
{
	private int                                    sub_rows_max;
	private int                                    sub_cols_max;
	private int                                    sub_row_source_first;
	private int                                    sub_row_source_last;
	private double [][]                            sub_matrix ;
	private String []                              sub_row_id;
	private String_Row                             name_security;
	private String_Row                             name_lag;
	    
	public        Sub_Matrix ( int                 sub_rows_max
	                         , int                 sub_cols_max
	                         )    
	{
	 this.sub_rows_max =                           sub_rows_max;
	 this.sub_cols_max =                           sub_cols_max;
	 this.sub_matrix   = new double         [ this.sub_rows_max ]
	                                        [ this.sub_cols_max ];
	 
	 this.sub_row_id   = new String         [ this.sub_rows_max ];
	}                 
	public int         get_rows_max()      {return sub_rows_max;}
	public int         get_cols_max()      {return sub_cols_max;}
	public int get_row_source_first()      {return sub_row_source_first;}
	public int get_row_source_last ()      {return sub_row_source_last ;}
	public double [][] get_Data()          {return sub_matrix  ;}
	public String      get_row_id  (int ix){return sub_row_id [ix];}
	
	public String      get_name_security (int ix)  {return name_security.get_string(ix); }
	public String      get_name_lag      (int ix)  {return name_lag     .get_string(ix); }

	public void Load_IDS  ( final int                     row_base
	                      , final Rectangular_CVS_Matrix  m
	                      )
	{
	       return;
	}                 
	public void Load_Name_Security ( String_Row sr ){
		        name_security =                 sr ;
	}
	public void Load_Name_Lag      ( String_Row sr ){
		        name_lag      =                 sr ;
	}
	public void Load_Data_Forwards  ( final int                     row_base
                                    , final Rectangular_CVS_Matrix  m
                                    )
	{
		 sub_row_source_first =                 row_base + 1;
		 sub_row_source_last  =  sub_rows_max + row_base + 1;
		 for ( int row_target = (row_base + 1               )    
		     ;     row_target < (row_base + 1 + sub_rows_max)
		     ;     row_target++          
		     )
		     { 
		 //   int         sub_row_target   = sub_rows_max - (row_target - row_base  ); 
		      int         sub_row_target   =                 row_target - row_base -1;
		      sub_row_id[ sub_row_target ] = m.get_id       (row_target             );   
		      /********************************************************************
		      System.out.println( "row_id = >"
  		                        +  sub_row_id[ sub_row_target ]
  		                        + "<  "
  		                        + "row_target = >"
  		                        +  row_target
  		                        + "<"               
  		                        );		      
  		      ********************************************************************/                 
		      double []   hold_row         = m.get_row      (row_target           );

		      Load_Row ( sub_row_target    // - ( row_base + 1)
		               , m.get_matrix_cols()
		               , hold_row
		               );      
		     }		
	}
	public void Load_Data_Backwards ( final int                     row_base
	                                , final Rectangular_CVS_Matrix  m
	                                )
	{
   //sub_row_source_first =                 row_base + 1;
   //sub_row_source_last  =  sub_rows_max + row_base + 1;
	 sub_row_source_first =  sub_rows_max + row_base + 1;
	 sub_row_source_last  =                 row_base + 1;
	 for ( int row_target = (row_base + 1                  )    
	     ;     row_target < (row_base + 1 + sub_rows_max)
	     ;     row_target++          
	     )
	     {
	      //        sub_row_target : this field reverses the order of the
	      //                         rows such that:
	      //                         row 1 in sub_matrix is the earliest
	      //                               in time.
	      //                         This reversal is needed because
	      //                         rows within "m" are in reverse time
	      //                         order (i.e. the 1st row in "m" is the
	      //                         most recent measurement) 
	      int         sub_row_target   = sub_rows_max - (row_target - row_base); 
	      sub_row_id[ sub_row_target ] = m.get_id       (row_target           );
	      /************************************************************************
	      System.out.println( "row_id = >"
	    		            +  sub_row_id[ sub_row_target ]
	    		            + "<"               
	    		            );
	      ************************************************************************/	            
	      double []   hold_row         = m.get_row      (row_target           );

	      Load_Row ( sub_row_target
	               , m.get_matrix_cols()
	               , hold_row
	               );      
	     }
	 }

	private void Load_Row( final int       sub_row_target
	                     , final int       cols_max
	                     , final double [] hold_row
	                     )
	{
	  /*********************************************************	
	  System.out.println ( "sub_row_target = >"
		                 +  sub_row_target
		                 + "<  sub_matrix ["
		                 +     get_rows_max()
		                 + "]["
		                 +     get_cols_max()
		                 + "]"
		                 );	
      *********************************************************/	                 
	  for ( int ix_c = 0
	      ;     ix_c < cols_max
	      ;     ix_c++
	      )
	      {
            /**************************************************
		    System.out.println ( "ix_c = >"
		    		           +  ix_c
		    		           + "<  cols_max = >" 
		    		           +     cols_max
		    		           + "<  hold_row.length = >"
		    		           +     hold_row.length
		    		           + "<  double = >"
		    		           +  hold_row[ix_c]
		    		    	   + "<"
		    		           );
		    **************************************************/ 		           
	        sub_matrix[sub_row_target][ix_c]= hold_row[ix_c];
	      }   
	    
	}

}
