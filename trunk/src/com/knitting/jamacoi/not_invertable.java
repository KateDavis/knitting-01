package com.knitting.jamacoi;

public class   not_invertable 
       extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final   static String Error_msg_01 = "Error: the regression object "
                                       + "cannot be inverted.\n";
public         not_invertable ()   { 
               super (Error_msg_01);
}
public         not_invertable (final String Error_msg_02)   { 
               super ( Error_msg_01
                     + Error_msg_02
                     );
}

}
