package com.knitting.jamacoi;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * This class provides the ability to read in a rectangular matrix
 * from a disk file which can then be used as input to the Regression
 * class.
 * <br>
 * <br>
 * The rectangular matrix must contain the same number of fields on
 * each line.  Each field on a line must be separated from its neighboring
 * field by a comma.  Hence the CVS string in the class name. 
 * <br>
 * <br>
 * Hint: after the comma field-separater, spaces can be used before the
 * next field's digits start.  This allows the data be vertically aligned
 * to aid in human review of the file's contents.
 * @author Owner
 */

public class Rectangular_CVS_Matrix 
{
	/***********************************************
	private String            Name_Directory;
	private String            Name_File_Short;
	***********************************************/
	private Analysis_Parms    ap;
	private int               cols_min         = Integer.MAX_VALUE;
	private int               cols_max         = Integer.MIN_VALUE;
	private int               matrix_rows;
	private int               matrix_cols;
	private boolean           has_row_id;
	private double [][]       matrix;
	private String []         ids;
	/**
	 * This method attempts to read the file referenced by its two input 
	 * parameters.
	 * @param Name_Directory is the directory name that contains the input file.
	 * @param Name_File_Short is the file name that contains the input data for
	 * the Regression class. 
	 */   
	public         Rectangular_CVS_Matrix ( final Analysis_Parms my_parms_02
	                                      )
	        throws IOException  
	             , not_rectangular
	{
		set_Analysis_Parms  ( my_parms_02 );
		/**********************************************************
	    set_Name_Directory  ( my_parms_02.getNAME_IN_DIR () );
	    set_Name_File_Short ( my_parms_02.getNAME_IN_FILE() );
	    **********************************************************/
	    set_has_row_id      ( true );
	    check_directory     ();
	    get_data            ();
	}   
	private void   set_Analysis_Parms ( final  Analysis_Parms  my_parms_02 ){
		    ap   = my_parms_02;
	}
	private void   check_directory()
	        throws IOException
	{
	   URL   d   = new URL ( ap.getURL_NAME_IN_DIR() );
	   File  dir = new File(  d.getFile()            );
	    if  ( dir.isDirectory() )
	        {
	        }
	    else
	        {
	          throw new IOException("Directory does NOT exist: >"
	                               + get_Name_Directory()
	                               +"<"
	                               );
	        }    
	}
	private int     get_cols_max(){
	        return      cols_max;
	}
	private void    set_cols_max(final int i){
	                    cols_max =         i;
	}
	private int     get_cols_min(){
	        return      cols_min;
	}
	private void    set_cols_min(final int i){
	                    cols_min =         i;
	}
	/******************************************************************
	private void    set_Name_Directory  (final String Name_Directory){
	               this.Name_Directory  =             Name_Directory;
	}
	******************************************************************/
	public  String  get_Name_Directory  (){
		    try    {
		    	    URL  d  =   new URL ( ap.getURL_NAME_IN_DIR() );
		            return      d.toExternalForm();
		           }
		    catch  (MalformedURLException e)
		           {
		    	    return     "cannot find Directory Name";
		           }
	}
	/*******************************************************************
	private void    set_Name_File_Short (final String Name_File_Short){
	               this.Name_File_Short =             Name_File_Short;
	}
	*******************************************************************/
	private void    set_has_row_id ( boolean b){
	               this.has_row_id = b;
	}
	public  boolean get_has_row_id(){return has_row_id;}
	        
	public  String  get_Name_File_Short (){
		    try    {
		        	URL  d  =   new URL ( ap.getURL_NAME_IN_FILE() );
		            return      d.toExternalForm();
		           }
		    catch  (MalformedURLException e)
		           {
		    	    return     "cannot find in_file";
		           }
	}
	/******************************************************************
	private void    set_Name_File_Full  (){
	                    Name_File_Full  = get_Name_Directory ()
	                                    + "\\"
	                                    + get_Name_File_Short();
	}
	******************************************************************/
	public  String  get_Name_File_Full  () 
	        throws  MalformedURLException{
		    URL  d  =   new URL ( ap.getURL_NAME_IN_DIR() );
	        return      d.toExternalForm();
	}

	private void   get_data()        
	        throws IOException
	             , not_rectangular
	{ 
		ArrayList<
		ArrayList <Double>
	             >           aa      = new ArrayList<
	                                       ArrayList <Double>
	                                                >();
	
	    ArrayList<String>    row_ids = new ArrayList<String>();
	    
	    URL   f                      = new URL ( ap . getURL_NAME_IN_FILE() );
	    File                 file    = new File( f  . getFile()             );
	    
	    check_if_file_exists(file);
	    
	    Scanner scanner_file = new Scanner(file);
	    while ( scanner_file.hasNextLine() )
	          {
	            String  line  = scanner_file.nextLine();
	            aa.add( process_line ( line
	                                 , aa.size()
	                                 , row_ids
	                                 )
	                  );
	          }
	    set_matrix_cols(get_cols_min()  ); 
	    set_matrix_rows(aa.size     ()  );
	    
	    matrix = new double [ get_matrix_rows() ]
	                        [ get_matrix_cols() ];
	    
	    ids    = new String [ get_matrix_rows() ];
	    
	    set_matrix(aa     );
	    set_ids   (row_ids);
	}
	private ArrayList<Double>  process_line(final String            line 
	                                       ,final int               aa_row_count
	                                       ,      ArrayList<String> row_ids
	                                       )
	        throws             not_rectangular
	{ArrayList<Double>  row_d; 
	 row_d            = get_fields( line
	                              , row_ids
	                              );
	 check_col_max_min( line
	                  , row_d.size()
	                  , aa_row_count     
	                  );
	 return row_d;    
	}     
	private ArrayList<Double> get_fields( String            line
	                                    , ArrayList<String> row_ids
	                                    )
	{
	    Scanner           scanner = new Scanner(line);
	    scanner.useDelimiter(", *");  // commas an unlimited spaces
	    
	    ArrayList<Double> list    = new ArrayList<Double>();
	    if (get_has_row_id())
	       { 
	        String row_id = scanner.next();
	        row_ids.add(row_id);
//	        String x = row_ids.get(0);
	       }
	    while (scanner.hasNextDouble())
	          {
	           double    d = scanner.nextDouble();
	           list.add (d);
	          }
	    return list;
	}
	private void   set_ids   ( final ArrayList<String> row_ids )
	{
	  for ( int   ix  = 0
	      ;       ix  < row_ids.size()
	      ;     ++ix
	      )
	      {
	          ids[ix] = row_ids.get( ix );
	      }
	  return;  
	}
	public  String get_id( int ix )
	{
	        return ids[ix];
	}
	private void   check_if_file_exists(File file)
	        throws IOException
	{
	    if  (file.isFile() )
	        {
	        }
	    else
	        { String    Error_msg  = "ERROR: File does NOT exist:\n"
	                               + "       file = >"
	                               + get_Name_File_Full()
	                               + "<";
	          throw new IOException(Error_msg);      
	        }        
	}
	   
	private void   check_col_max_min(final String line
	                                ,final int    cols
	                                ,final int    rows_current
	                                )
	        throws not_rectangular
	{       set_cols_min(  Math.min (get_cols_min() ,cols));
	        set_cols_max(  Math.max (get_cols_max() ,cols));
	 if   ( get_cols_min() == get_cols_max() )
	      { 
	      }
	 else 
	      { int    row       = rows_current + 1;
	        System.out.println( "line = >"
	                          +  line
	                          + "<\n"
	                          );
	        String Error_msg =                                           " \n"
	                         + "       Check row = >" + row            + "<\n"
	                         + "       cols_min NOT equal cols_max."   + " \n"
	                         + "       cols_min  = >" + get_cols_min() + "<\n"
	                         + "       cols_max  = >" + get_cols_max() + "<";
	                
	        throw new not_rectangular(Error_msg);     
	      }  
	}    
	public  double [][] get_matrix(){
	        return          matrix;       
	}
	private void set_matrix_cols(int cols_min){
	                 matrix_cols =   cols_min;
	}     
	public  int  get_matrix_cols(){
	        return   matrix_cols;
	}   
	private void set_matrix_rows(int rows_min){
	                 matrix_rows =   rows_min;
	}     
	public  int  get_matrix_rows(){
	        return   matrix_rows;
	}  
	public  double [] get_row(int Row_Target){
	        int       ic_max = get_matrix_cols();
	        /********************************************************
	        System.out.println ( "ic_max = >"
	        		           +  ic_max
	        		           + "<"
	        		           );
	        ********************************************************/		           
	        double [] Row    = new double [ ic_max ];
	        int       ic;
	        for     ( ic = 0
	                ; ic < ic_max
	                ; ic++
	                )
	                {
	                  Row[ic] = matrix[Row_Target][ic];
	                  /*********************************************
	                  System.out.println ( "col = >"
	                		             +   ic
	                		             + "<  double = >"
	                		             +     Row[ic]
	                		             + "<"
	                		             );
	                  *********************************************/ 		             
	                }
	        return    Row;
	}
	private void set_matrix( ArrayList<
			                 ArrayList <Double>
	                                  > 
	                         aa
	                        )                     
	{
	 int   ir;
	 int   ic;
	 for ( ir   = 0
	     ; ir   < aa.size()
	     ; ir++
	     )
	     { ArrayList<Double> row = aa.get(ir);
	       for ( ic   = 0
	           ; ic   < row.size()
	           ; ic++
	           )
	           { final double cell            = row.get(ic);
	                          matrix [ir][ic] = cell;
	           } 
	     }
	}
	public void show_input_names()
	{
	 Formatter fmt_01;
	           fmt_01 = new Formatter();
	           
	           fmt_01.format( "%n%n%s%n%n%s%s%n%s%s"
	                        , "0) Input Names new:" 
	                        , "         Dir  = "
	                        ,  get_Name_Directory()
	                        , "         File = "
	                        ,  get_Name_File_Short()
	                        );
	           
	           System.out.println(fmt_01);
	}
	public void show_matrix()                      
	{int ir;
	 int ic;
	 
	 Formatter fmt_01;
	 
	 for ( ir   = 0
	     ; ir   < get_matrix_rows()
	     ; ir++
	     )
	     { 
	       fmt_01 = new Formatter();
	       for ( ic   = 0
	           ; ic   < get_matrix_cols()
	           ; ic++
	           )
	           {
	            fmt_01.format( "%15.5E"
	                         , matrix[ir][ic]
	                         );
	           }
	       System.out.println(fmt_01);
	       fmt_01 = null;
	     }
	}

}
