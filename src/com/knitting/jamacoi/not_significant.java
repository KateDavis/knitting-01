package com.knitting.jamacoi;

public class        not_significant 
       extends      Exception
{
	/**
	 * 
	 */
	private static  final long serialVersionUID = 1L;

public              not_significant (double      min_error
                                    ,Regression  r
                                    ) 
{
       super ( "Error: the determinate is too small to be "
             +        "significant:\n"
             + "       det = "
             + r.get_det_XX_dev()
             + "<\n"
             + "       min_error = >"
             + min_error
             + "<\n"
             );
}

}
