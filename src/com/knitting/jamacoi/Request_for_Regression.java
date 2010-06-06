package com.knitting.jamacoi;

import java.util.Date;

public class    Request_for_Regression {
	   private  Request_Set rs;
	   private  Date        date_min;
	   private  Date        date_max;
	   private  Integer     lag_max;
	   private  Boolean     valid_request  = false;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lag_max == null) ? 0 : lag_max.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request_for_Regression other = (Request_for_Regression) obj;
		if (lag_max == null) {
			if (other.lag_max != null)
				return false;
		} else if (!lag_max.equals(other.lag_max))
			return false;
		return true;
	}
	   
	   

}
