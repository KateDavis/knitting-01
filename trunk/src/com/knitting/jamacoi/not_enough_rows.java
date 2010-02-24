package com.knitting.jamacoi;

public class   not_enough_rows
       extends Exception
{
	 /**
	 * 
	 */
	private static final  long serialVersionUID = 1L;
	final   static String Error_msg_01 = "ERROR: the supplied data matrix "
                                       + "does NOT have enough rows:\n";
public         not_enough_rows()
{
System.out.println(Error_msg_01);   
} 
public         not_enough_rows( Integer rows
     , Integer cols
     , Integer rows_min
     )
{
System.out.println( Error_msg_01);
System.out.println("       supplied rows = >"
                  + rows
                  +"<"
                  );
System.out.println("       supplied cols = >"
                  + cols
                  +"<"
                  );
System.out.println(" ");
System.out.println("       Need at least = >"
                  + rows_min
                  +"< rows." 
                  );
}

}
