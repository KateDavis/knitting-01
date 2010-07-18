package com.knitting.jamacoi;

import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;

public  class  Workspace {
	
private URL    workspace;

public         Workspace ()
throws         MalformedURLException{
	
String         name           = this.getClass().getSimpleName();
URL            url_this       = this.getClass()
                              . getResource( name + ".class" );
assertNotNull( url_this );
    workspace  = new URL( url_this     , "../../../../../");
assertNotNull( workspace  ) ;
}
public URL get_Workspace (){ return workspace; }
}
