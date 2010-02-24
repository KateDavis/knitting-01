package com.knitting.jamacoi;

public class   not_rectangular 
       extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final    
	static  String Error_msg_01 = "ERROR: the input data does not have the same\n"
	                            + "       number of columns in every row.";

	public         not_rectangular ()   { 
	               super ( Error_msg_01);
	}
	public         not_rectangular (final String Error_msg_02) { 
	               super ( Error_msg_01
	                     + "\n"
	                     + Error_msg_02
	                     );
	}

}
