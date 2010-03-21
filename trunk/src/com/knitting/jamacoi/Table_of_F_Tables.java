package com.knitting.jamacoi;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * This class builds a table-of-tables of F-Values.  Each table
 * represents a specific level of significance; 5% and 1% are 
 * the only two tables currently  contained in instance of this class.
 * <br>
 * <br>
 * The construction of a table-of-tables of F-values permits searching
 * for a specific set of degrees-of-freedom pairs to determine if a
 * particular regression result has risen above random chance in
 * explaining the dependent variables.
 * <br>
 * This class also implements two other critical functions:
 * <br>
 * <br>
 * 1) Searching the table-of-tables given a specific pair of 
 * degrees-of-freedom (i.e. the pair that describes a requession's data).
 * 2) the building and saving of the search results for each F-table searched.
 * The returned "matches" are stored in an instance of the Result_Tree class.
 * <br> 
 * In the future, other F tables at other levels of significance
 * can be added to this table of tables.
 * <br>
 * <br>
 * In addition to having a constant level of significance, each
 * F-table has a set of degrees-of-freedom pairs.  Each pair has
 * a specific value for its F-value.  The set of degrees-of-freedom
 * describe the degrees-of-freedom for the dependent variables and the
 * degrees-of-freedom for the independent variables. Different F-Tables do not
 * have to have the same set of pairs of degrees-of-freedom.  The specifics
 * of this class and its associated F_Distribition_Table Class management
 * this variability.
 * @author Owner
 */

public class Table_of_F_Tables 
{

	private  TreeMap<String ,TreeMap< Integer,
	                         TreeMap <Integer,Double>
	                                >
	                >                           tree_of_tables;
	/**
	 * 
	 */
	public   Table_of_F_Tables(){
	  tree_of_tables = build_tree_of_tables();
	}
	private TreeMap<String ,TreeMap< Integer, 
	                        TreeMap <Integer,Double>
	                               >
	               >                           build_tree_of_tables()
	{
	    
	  F_Distribution_Table_at_01_00_Percent    fdt_01         = new
	  F_Distribution_Table_at_01_00_Percent(); 
	  
	  TreeMap<Integer,TreeMap<Integer,Double>> tm_01          = fdt_01.get_data();
	  
	  F_Distribution_Table_at_05_00_Percent    fdt_05         = new
	  F_Distribution_Table_at_05_00_Percent();      

	  TreeMap<Integer,TreeMap<Integer,Double>> tm_05          = fdt_05.get_data();
	      
	  TreeMap<String ,TreeMap< Integer,
	                  TreeMap <Integer,Double>
	                         >
	         >                                 t_of_tables    = new
	  TreeMap<String ,TreeMap< Integer,
	                  TreeMap <Integer,Double>
	                         >
	         >();
	        
	              t_of_tables . put ("01.00%", tm_01);
	              t_of_tables . put ("05.00%", tm_05);
	        
	  return      t_of_tables;
	}
	/**
	 * This method builds an instance of a Result_Tree class that is loaded
	 * with "match" results from searches of every F-Table contained in
	 * the Table_of_F_Tables class.  A "match" is determined by comparing
	 * the pair of degrees-of-freedom values from the regressions's data to
	 * the various F-Table's pairs of degrees-of-freedom.  The "match" logic
	 * selects one pair of degrees-of-freedom from each F-Table.  A selected
	 * pair is an instance of the F_Table_Cell class.  The selected pair and
	 * the name of the table in which it was found are then placed into
	 * an instance of the Result_Tree class. 
	 *  
	 * @param row is the degrees of freedom associated with the regression's
	 * independent variables.  In other words, the sum-of-squared errors
	 * explained by the independent variables. 
	 * 
	 * @param col is the degrees of freedom associated with the regression's
	 * sum-of-squared errors NOT explained by the independent variables.
	 * 
	 * @return Result_Tree
	 */       
	public Result_Tree build_Result_Tree (Integer row
	                                     ,Integer col
	                                     )
	{   
	  Result_Tree                     rt  = new
	  Result_Tree();
	  
	  Set<Map.Entry<String, TreeMap< Integer,
	                        TreeMap <Integer,Double>
	                               >
	               >
	     >                            set = tree_of_tables.entrySet();
	  for(Map.Entry<String, TreeMap< Integer,
			                TreeMap <Integer,Double>
	                               >
	               >
	      ix
	     :set
	     )
	     {
	      String                    title = ix.getKey   ();
	      TreeMap<Integer, 
	      TreeMap<Integer, Double>> table = ix.getValue ();
	      F_Table_Cell              cell  = find_f_value( row
	                                                    , col
	                                                    , table
	                                                    );
	      rt . put_data(title, cell);
	     }
	  return rt;   
	}
	public F_Table_Cell find_f_value  (Integer                   row
	                                  ,Integer                   col
	                                  ,TreeMap<Integer, 
	                                   TreeMap<Integer,Double>>  table 
	                                  )
{   
SortedMap<Integer, 
  TreeMap<Integer,Double>>  sorted_rows  = table           .headMap(row + 1 );
Integer                     row_key      = sorted_rows     .lastKey(        );
TreeMap  <Integer, Double>  selected_row = table           .get    (row_key );
SortedMap<Integer, Double>  sorted_cols  = selected_row    .headMap(col + 1 );
Integer                     col_key      = sorted_cols     .lastKey(        );
Double                      f            = selected_row    .get    (col_key );
F_Table_Cell                cell         = new F_Table_Cell(row_key
	                                                             ,col_key
	                                                             ,f
	                                                             );
return                      cell;
} 

}
