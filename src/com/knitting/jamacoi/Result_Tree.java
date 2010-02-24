package com.knitting.jamacoi;
import  java.io.FileWriter;
import  java.util.*;

/**
 * This class provides the mechanism of saving f-values returned by a
 * search of an instance of the Table_of_F_Tables class.  The returned
 * f-values are the ones that "match" the regression data's 
 * degrees-of-freedom for:
 * <br>
 * <br>
 * 1) the sum-of-squared errors explained by the independent variables.
 * <br>
 * 2) the sum-of-squared errors NOT explained by the independent variables.
 * <br>
 * <br>
 * In addition to saving the "matching" f-values, this class:
 * <br>
 * <br>
 * 1) provides the method to organize and list the returned f-value matches.
 * <br>
 * 2) provides the method to compare each returned f-value to the 
 * regression's f-value result.
 * @author Owner
 */
public class Result_Tree 
{
    TreeMap<String, F_Table_Cell>     rt = new
    TreeMap<String, F_Table_Cell>();        
/**
 * This method adds elements to the instance of the TreeMap in
 * the Result_Tree class. Each element in the TreeMap contains:
 * <br>
 * <br>
 * 1) the name of the F_Table_Cell instance. The name is the significance
 * level from which the F_Table_Cell was extracted.
 * <br>
 * 2) a F_Table_Cell instance. 
 * @param s is the name (or significance level) of the F_Table_Cell
 * @param c is an F_Table_Cell instance that "matched" the regression's
 * pair of degrees-of-freedom values.
 */
public void  put_data (String       s
                      ,F_Table_Cell c
                      )
             {
              rt.put(s, c);            
             }
public void  list_data()
 {
   Set<Map.Entry<String, F_Table_Cell>> set = rt.entrySet();
   
   for(Map.Entry<String, F_Table_Cell>
       ix
      :set
      )
      {
       String         table_sig = ix.getKey();
       F_Table_Cell   cell      = ix.getValue();
       Integer        row       = cell.get_Row();
       Integer        col       = cell.get_Col();
       Double         f         = cell.get_F();
       
     Formatter line_2 = new Formatter(); 
   
     line_2.format("%s%s%s%15.5E%s%15.5E%s%15.5E%s"
                  ,"X_Table = >" 
                  , table_sig
                  ,"<  row = >"
                  ,    row
                  ,"<  cols = >"
                  ,    col
                  ,"<  f =>"
                  ,    f
                  ,"<"
                  );
       System.out.println(line_2);
     
       System.out.println("A_Table = >"
                         + table_sig
                         +"<  row = >"
                         +    row
                         +"<  col = >"
                         +    col
                         +"<  f = >" +
                         +    f
                         +"<"
                         );
                         
      } 
 }       
public void   compare_reg_with_data( FileWriter  Rpt_Detail
                                   , Integer     reg_row
                                   , Integer     reg_col
                                   , Double      reg_f
                                   )
       throws java.io.IOException
 {
   Set<Map.Entry<String, F_Table_Cell>> set = rt.entrySet();
   
   for(Map.Entry<String, F_Table_Cell>
       ix
      :set
      )
      {
       String           table_sig = ix.getKey   ();
       F_Table_Cell     cell      = ix.getValue ();
       Integer          row       = cell.get_Row();
       Integer          col       = cell.get_Col();
       Double           f         = cell.get_F  ();
       
       String           msg;
       if (reg_f >= f) {msg = "    Significant  ";}
       else            {msg = "NOT Significant  ";}
       
       Formatter line_1 = new Formatter(); 

       line_1.format("%n    %s%s%s%10.4E%s%10.4E%s%12.5E%s%n"        
                    ,"F_Table = >" 
                    , table_sig
                    ,"<  row = >"
                    ,    row.doubleValue()
                    ,"<  cols = >"
                    ,    col.doubleValue()
                    ,"<  f =>"
                    ,    f
                    ,"<"
                    );
       Rpt_Detail.write(line_1.toString());

       Formatter line_2 = new Formatter(); 

       line_2.format("    %s%s%10.4E%s%10.4E%s%12.5E%s%n"        
                    , msg 
                    ,"<  row = >"
                    ,    reg_row.doubleValue()
                    ,"<  cols = >"
                    ,    reg_col.doubleValue()
                    ,"<  f =>"
                    ,    reg_f
                    ,"<"
                    );
       Rpt_Detail.write(line_2.toString());

      } 
 }
}
