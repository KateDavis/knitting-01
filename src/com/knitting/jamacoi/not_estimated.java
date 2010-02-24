package com.knitting.jamacoi;
     
public class   not_estimated 
       extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final   static String Error_msg_01 = "ERROR: the regression object has NOT been "
                                       + "estimated.\n"
                                       + "       must call method 'estimate' before "
                                       + "requesting this method.\n";
       
public         not_estimated () {
               super ( Error_msg_01 );
}        
public         not_estimated ( Regression X) {
               super ( Error_msg_01 );
}

}
