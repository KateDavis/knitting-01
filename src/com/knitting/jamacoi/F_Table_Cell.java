package com.knitting.jamacoi;
/**
 * This is a utility class that is useful in several situations where
 * each instance contains three fields: row, col and an f-value.
 * @author Owner
 */

public class F_Table_Cell 
{
    private Integer row;
    private Integer col;
    private Double  f;
/**
 * creates an instance of this class.  Each instance contains only the input
 * values supplied with this constructor: row, col and an f-value.
 * @param row is used in table lookup functions.</pre>
 * @param col is used in table lookup functions.</pre>
 * @param f is an "f" value which is a measure of significance.</pre>
 * @author Owner
 */    
public       F_Table_Cell (Integer row
                          ,Integer col
                          ,Double  f
                          )
{
 this.row = row;
 this.col = col;
 this.f   = f;
}
public Integer get_Row(){return row;}
public Integer get_Col(){return col;}
public Double  get_F  (){return f  ;}
	

}
