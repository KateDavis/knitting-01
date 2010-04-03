#!/bin/bash

rm -rf javadoc 

javadoc -sourcepath ../src -d javadoc -classpath ../lib/Jama-1.0.2.jar:../lib/xstream-1.3.1.jar \
  com.knitting.datasource \
  com.knitting.jamacoi
