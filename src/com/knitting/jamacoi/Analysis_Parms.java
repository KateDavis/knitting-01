package com.knitting.jamacoi;


public class Analysis_Parms {
    
    private int    COUNT_MAX_MATRIX_ROWS          = 200;
    private int    COUNT_MAX_COLUMNS              =   3;
    private int    COUNT_MAX_REGRESSION_ANALYSIS  =  60;
    private int    ROW_TARGET                     =  10;
    private int    COL_START                      =   0;
    private int    COL_END                        =   2;
    private int    ROW_BASE                       = 300;
    private String URL_NAME_WORKSPACE             = "";
    private String URL_NAME_IN_DIR                = "";
    private String URL_NAME_IN_FILE               = "";
    private String URL_NAME_OUT_DIR_BASE          = "";
    private String URL_NAME_OUT_DIR_FAMILY        = "";
    private String URL_NANE_OUT_DIR_REQUEST       = "";
    private String URL_NAME_OUT_FILE_DETAILS      = "";
    private String URL_NAME_OUT_FILE_SUMMARY      = "";
    private String NAME_IN_DIR        = "/Temp/Residual_attempt_01";
    private String NAME_IN_FILE       = "GLD_vs_London_Spot_2_with_lag_1_day.txt";
    private String NAME_OUT_DIR       = "/Temp";
    private String NAME_OUT_DETAILS   = "Regression_Details.txt";
    private String NAME_OUT_SUMMARY   = "Regression_Summary.txt";
    
    private String NAME_REL_APP_BASE       = "knitting_01/src_test/com/knitting/regression";
    private String NAME_REL_FAMILY         = "aapl_amzn_qcom";
    private String NAME_REL_REQUEST        = "request_0001";
    
    private String NAME_REL_REPORTS        = "reports/";
    private String NAME_REL_REQUEST_SERIES = "request_series/";
    private String NAME_REL_REQUEST_SET    = "request_set/";
    private String NAME_REL_RESIDUALS      = "residuals/";
    
    private String NAME_RPT_DETAILS        = "rpt_details.txt";
    private String NAME_RPT_SUMMARY        = "rpt_summary.txt";
    
    private String URL_REL_APP_BASE        = "";
    private String URL_REL_FAMILY          = "";
    private String URL_REL_REQUEST         = "";
    private String URL_REL_REPORTS         = "";
    private String URL_REL_REQUEST_SERIES  = "";
    private String URL_REL_REQUEST_SET     = "";
    private String URL_REL_RESIDUALS       = "";
    private String URL_REL_RPT_DETAILS     = "";
    private String URL_REL_RPT_SUMMARY     = "";

    public int getCOL_END() {
        return COL_END;
    }

    public void setCOL_END(int COL_END) {
        this.COL_END = COL_END;
    }

    public int getCOL_START() {
        return COL_START;
    }

    public void setCOL_START(int COL_START) {
        this.COL_START = COL_START;
    }

    public int    getCOUNT_MAX_COLUMNS() {
           return    COUNT_MAX_COLUMNS;
    }
    public void   setCOUNT_MAX_COLUMNS(int  COUNT_MAX_COLUMNS) {
           this.     COUNT_MAX_COLUMNS   =  COUNT_MAX_COLUMNS;
    }
    public String getURL_NAME_WORKSPACE(){
    	   return    URL_NAME_WORKSPACE;
    }
    public void   setURL_NAME_WORKSPACE(String  URL_NAME_WORKSPACE ){
 	       this.     URL_NAME_WORKSPACE      =  URL_NAME_WORKSPACE;
    }
    public String getURL_NAME_IN_DIR(){
    	   return    URL_NAME_IN_DIR;
    }
    public void   setURL_NAME_IN_DIR   (String  URL_NAME_IN_DIR    ){
 	       this.     URL_NAME_IN_DIR         =  URL_NAME_IN_DIR;
    }
    public String getURL_NAME_IN_FILE(){
 	       return    URL_NAME_IN_FILE;
    }
    public void   setURL_NAME_IN_FILE  (String  URL_NAME_IN_FILE   ){
	       this.     URL_NAME_IN_FILE        =  URL_NAME_IN_FILE;
    }
    public String getURL_NAME_OUT_DIR_BASE(){
	       return    URL_NAME_OUT_DIR_BASE;
    }
    public void   setURL_NAME_OUT_DIR_BASE  (String  URL_NAME_OUT_DIR_BASE   ){
	       this.     URL_NAME_OUT_DIR_BASE        =  URL_NAME_OUT_DIR_BASE;
    }
    public String getURL_NAME_OUT_DIR_FAMILY(){
	       return    URL_NAME_OUT_DIR_FAMILY;
    }
    public void   setURL_NAME_OUT_DIR_FAMILY  (String  URL_NAME_OUT_DIR_FAMILY   ){
	       this.     URL_NAME_OUT_DIR_FAMILY        =  URL_NAME_OUT_DIR_FAMILY;
    }
    public String getURL_NANE_OUT_DIR_REQUEST(){
	       return    URL_NANE_OUT_DIR_REQUEST;
    }
    public void   setURL_NANE_OUT_DIR_REQUEST  (String  URL_NANE_OUT_DIR_REQUEST   ){
	       this.     URL_NANE_OUT_DIR_REQUEST        =  URL_NANE_OUT_DIR_REQUEST;
    }
    public String getURL_NAME_OUT_FILE_DETAILS(){
	       return    URL_NAME_OUT_FILE_DETAILS;
    }
    public void   setURL_NAME_OUT_FILE_DETAILS  (String  URL_NAME_OUT_FILE_DETAILS   ){
	       this.     URL_NAME_OUT_FILE_DETAILS        =  URL_NAME_OUT_FILE_DETAILS;
    }
    public String getURL_NAME_OUT_FILE_SUMMARY(){
	       return    URL_NAME_OUT_FILE_SUMMARY;
    }
    public void   setURL_NAME_OUT_FILE_SUMMARY  (String  URL_NAME_OUT_FILE_SUMMARY   ){
	       this.     URL_NAME_OUT_FILE_SUMMARY        =  URL_NAME_OUT_FILE_SUMMARY;
    }
    public int getROW_BASE() {
        return    ROW_BASE;
    }

    public void setROW_BASE(int ROW_BASE) {
           this.   ROW_BASE =   ROW_BASE;
    }

    public int getROW_TARGET() {
        return ROW_TARGET;
    }

    public void setROW_TARGET(int ROW_TARGET) {
        this.ROW_TARGET = ROW_TARGET;
    }
 
    public String getNAME_IN_FILE() {
        return NAME_IN_FILE;
    }

    public void setNAME_IN_FILE(String NAME_IN_FILE) {
        this.NAME_IN_FILE = NAME_IN_FILE;
    }


    public String getNAME_IN_DIR() {
        return NAME_IN_DIR;
    }

    public void setNAME_IN_DIR(String NAME_IN_DIR) {
        this.NAME_IN_DIR = NAME_IN_DIR;
    }

    public int getCOUNT_MAX_MATRIX_ROWS() {
        return COUNT_MAX_MATRIX_ROWS;
    }

    public void setCOUNT_MAX_MATRIX_ROWS(int COUNT_MAX_MATRIX_ROWS) {
        this.COUNT_MAX_MATRIX_ROWS = COUNT_MAX_MATRIX_ROWS;
    }

    public int getCOUNT_MAX_REGRESSION_ANALYSIS() {
        return COUNT_MAX_REGRESSION_ANALYSIS;
    }

    public void setCOUNT_MAX_REGRESSION_ANALYSIS(int COUNT_MAX_REGRESSION_ANALYSIS) {
        this.COUNT_MAX_REGRESSION_ANALYSIS = COUNT_MAX_REGRESSION_ANALYSIS;
    }
        public String getNAME_OUT_DETAILS() {
        return           NAME_OUT_DETAILS;
    }

    public void setNAME_OUT_DETAILS(String NAME_OUT_DETAILS) {
        this.NAME_OUT_DETAILS = NAME_OUT_DETAILS;
    }

    public String getNAME_OUT_DIR() {
        return NAME_OUT_DIR;
    }

    public void setNAME_OUT_DIR(String NAME_OUT_DIR) {
        this.NAME_OUT_DIR = NAME_OUT_DIR;
    }

    public String getNAME_OUT_SUMMARY() {
        return NAME_OUT_SUMMARY;
    }

    public void setNAME_OUT_SUMMARY(String NAME_OUT_SUMMARY) {
        this.NAME_OUT_SUMMARY = NAME_OUT_SUMMARY;
    }
    public String getNAME_REL_APP_BASE() {
           return    NAME_REL_APP_BASE;
    }

    public void   setNAME_REL_APP_BASE(String NAME_REL_APP_BASE) {
           this.     NAME_REL_APP_BASE =      NAME_REL_APP_BASE;
    }
    public String getNAME_REL_FAMILY() {
           return    NAME_REL_FAMILY;
    }

    public void   setNAME_REL_FAMILY         (String  NAME_REL_FAMILY) {
           this.     NAME_REL_FAMILY =                NAME_REL_FAMILY;
    }    
    public String getNAME_REL_REQUEST() {
           return    NAME_REL_REQUEST;
    }

    public void   setNAME_REL_REQUEST        (String  NAME_REL_REQUEST) {
           this.     NAME_REL_REQUEST =               NAME_REL_REQUEST;
    }
  
    public  String getNAME_REL_REPORTS(){  
            return    NAME_REL_REPORTS;
    }           
    public  void   setNAME_REL_REPORTS       (String  NAME_REL_REPORTS){
            this.     NAME_REL_REPORTS  =             NAME_REL_REPORTS;
    }        
    public  String getNAME_REL_REQUEST_SERIES(){
            return    NAME_REL_REQUEST_SERIES;
    }      
    public  void   setNAME_REL_REQUEST_SERIES(String  NAME_REL_REQUEST_SERIES ){
            this.     NAME_REL_REQUEST_SERIES  =      NAME_REL_REQUEST_SERIES;
    }      
    public  String getNAME_REL_REQUEST_SET(){
            return    NAME_REL_REQUEST_SET;
    }    
    public  void   setNAME_REL_REQUEST_SET   (String  NAME_REL_REQUEST_SET){
            this.     NAME_REL_REQUEST_SET  =         NAME_REL_REQUEST_SET;
    }     
    public  String getNAME_REL_RESIDUALS(){  
            return    NAME_REL_RESIDUALS;
    }   
    public  void   setNAME_REL_RESIDUALS     (String  NAME_REL_RESIDUALS){  
            this.     NAME_REL_RESIDUALS  =           NAME_REL_RESIDUALS;
    }       
    public  String getNAME_RPT_DETAILS(){
    	    return    NAME_RPT_DETAILS;
    }
    public  void   setNAME_RPT_DETAILS       (String  NAME_RPT_DETAILS  ){
	        this.     NAME_RPT_DETAILS     =          NAME_RPT_DETAILS;
    }
    public  String getNAME_RPT_SUMMARY(){
    	    return    NAME_RPT_SUMMARY;
    }
    public  void   setNAME_RPT_SUMMARY       (String  NAME_RPT_SUMMARY  ){
	        this.     NAME_RPT_SUMMARY     =          NAME_RPT_SUMMARY;
    }    
    public  String getURL_REL_APP_BASE(){     
            return    URL_REL_APP_BASE;
    }      
    public  void   setURL_REL_APP_BASE       (String  URL_REL_APP_BASE){     
            this.     URL_REL_APP_BASE =              URL_REL_APP_BASE;
    }     
    public  String getURL_REL_FAMILY(){     
            return    URL_REL_FAMILY;
    }  
    public  void   setURL_REL_FAMILY         (String  URL_REL_FAMILY  ){     
            this.     URL_REL_FAMILY =                URL_REL_FAMILY;
    }       
    public  String getURL_REL_REQUEST(){ 
            return    URL_REL_REQUEST;
    }     
    public  void   setURL_REL_REQUEST        (String  URL_REL_REQUEST ){ 
            this.     URL_REL_REQUEST =               URL_REL_REQUEST;
    }      
    public  String getURL_REL_REPORTS(){  
            return    URL_REL_REPORTS;
    }     
    public  void   setURL_REL_REPORTS        (String  URL_REL_REPORTS ){  
            this.     URL_REL_REPORTS =               URL_REL_REPORTS;
    }     
    public  String getURL_REL_REQUEST_SERIES(){
            return    URL_REL_REQUEST_SERIES;
    }    
    public  void   setURL_REL_REQUEST_SERIES (String  URL_REL_REQUEST_SERIES){
            this.     URL_REL_REQUEST_SERIES =        URL_REL_REQUEST_SERIES;
    }      
    public  String getURL_REL_REQUEST_SET(){
            return    URL_REL_REQUEST_SET;
    }   
    public  void   setURL_REL_REQUEST_SET    (String  URL_REL_REQUEST_SET   ){
            this.     URL_REL_REQUEST_SET =           URL_REL_REQUEST_SET;
    }       
    public  String getURL_REL_RESIDUALS(){ 
            return    URL_REL_RESIDUALS;
    }     
    public  void   setURL_REL_RESIDUALS      (String  URL_REL_RESIDUALS     ){ 
            this.     URL_REL_RESIDUALS =             URL_REL_RESIDUALS;
    }    
    public  String getURL_REL_RPT_DETAILS(){
    	    return    URL_REL_RPT_DETAILS;
    }
    public  void   setURL_REL_RPT_DETAILS    (String  URL_REL_RPT_DETAILS   ){
	        this.     URL_REL_RPT_DETAILS =           URL_REL_RPT_DETAILS;
    }
    public  String getURL_REL_RPT_SUMMARY(){    
    	    return    URL_REL_RPT_SUMMARY;
    }
    public  void   setURL_REL_RPT_SUMMARY    (String  URL_REL_RPT_SUMMARY   ){    
	        this.     URL_REL_RPT_SUMMARY =           URL_REL_RPT_SUMMARY;
}

    public void report_values()
    {
      System.out.println(   "COUNT_MAX_MATRIX_ROWS:         >"
                        + getCOUNT_MAX_MATRIX_ROWS()
                        +"<"
                        );
      System.out.println(   "COUNT_MAX_COLUMNS:             >"
                        + getCOUNT_MAX_COLUMNS()
                        +"<"
                        );
      System.out.println(   "COUNT_MAX_REGRESSION_ANALYSIS: >"
                        + getCOUNT_MAX_REGRESSION_ANALYSIS()
                        +"<"
                        );
      System.out.println(   "ROW_TARGET:                    >"
                        + getROW_TARGET()
                        +"<"
                        );
      System.out.println(   "ROW_BASE:                      >"
                        + getROW_BASE()
                        +"<"
                        );
      System.out.println(   "COL_START:                     >"
                        + getCOL_START()
                        +"<"
                        );
      System.out.println(   "COL_END:                       >"
                        + getCOL_END()   
                        +"<"
                        );
      System.out.println(   "URL_NAME_WORKSPACE             >"
    		            + getURL_NAME_WORKSPACE()
    		            +"<"
    		            );
      System.out.println(   "URL_NAME_IN_DIR                >"
                        + getURL_NAME_IN_DIR()
                        +"<"
                        );
      System.out.println(   "URL_NAME_IN_FILE               >"
                        + getURL_NAME_IN_FILE()
                        +"<"
                        );
      System.out.println(   "URL_NAME_OUT_DIR_BASE          >"
                        + getURL_NAME_OUT_DIR_BASE()
                        +"<"
                        );
      System.out.println(   "URL_NAME_OUT_DIR_FAMILY        >"
                        + getURL_NAME_OUT_DIR_FAMILY()
                        +"<"
                        );
      System.out.println(   "URL_NAME_OUT_DIR_REQUEST       >"
                        + getURL_NANE_OUT_DIR_REQUEST()
                        +"<"
                        );
      System.out.println(   "URL_NAME_OUT_FILE_DETAILS      >"
                        + getURL_NAME_OUT_FILE_DETAILS()
                        +"<"
                        );
      System.out.println(   "URL_NAME_OUT_FILE_SUMMARY      >"
                        + getURL_NAME_OUT_FILE_SUMMARY()
                        +"<"
                        );
      System.out.println(   "NAME_IN_DIR:                   >"
                        + getNAME_IN_DIR()
                        +"<"
                        );
      System.out.println(   "NAME_IN_FILE:                  >"
                        + getNAME_IN_FILE()
                        +"<"
                        );
      System.out.println(   "NAME_OUT_DIR:                  >"
                        + getNAME_OUT_DIR()
                        +"<"
                        );
      System.out.println(   "NAME_OUT_DETAILS:              >"
                        + getNAME_OUT_DETAILS()
                        +"<"
                        );
      System.out.println(   "NAME_OUT_SUMMARY:              >"
                        + getNAME_OUT_SUMMARY()
                        +"<"
                        );
      System.out.println(" ");
      System.out.println(   "NAME_REL_APP_BASE:             >"
                        + getNAME_REL_APP_BASE()
                        +"<"
                        );
      System.out.println(   "NAME_REL_FAMILY:               >"
                        + getNAME_REL_FAMILY()
                        +"<"
                        );     
      System.out.println(   "NAME_REL_REQUEST:              >"
                        + getNAME_REL_REQUEST()
                        +"<"
                        );  
      System.out.println(   "NAME_REL_APP_BASE:             >"
    		            + getNAME_REL_APP_BASE()
    		            +"<"
    		            );
      System.out.println(   "NAME_REL_FAMILY:               >"
    		            + getNAME_REL_FAMILY()
    		            +"<"
    		            );
      System.out.println(   "NAME_REL_REQUEST:              >"
    		            + getNAME_REL_REQUEST()
    		            +"<"
    		            );
      System.out.println(   "NAME_REL_REPORTS:              >"
    		            + getNAME_REL_REPORTS()
    		            +"<"
    		            );
      System.out.println(   "NAME_REL_REQUEST_SERIES:       >"
    		            + getNAME_REL_REQUEST_SERIES()
    		            +"<"
    		            );
      System.out.println(   "NAME_REL_REQUEST_SET:          >"
    		            + getNAME_REL_REQUEST_SET()
    		            +"<"
    		            );
      System.out.println(   "NAME_REL_RESIDUALS:            >"
                        + getNAME_REL_RESIDUALS()
                        +"<"
                        );   
      System.out.println(" ");
      System.out.println(   "NAME_RPT_DETAILS:              >"
    		            + getNAME_RPT_DETAILS()  
    		            +"<"
    		            );
      System.out.println(   "NAME_RPT_SUMMARY:              >"
	                    + getNAME_RPT_SUMMARY()  
	                    +"<"
	                    );      
      System.out.println(" ");
      System.out.println(   "URL_REL_APP_BASE:              >"
    		            + getURL_REL_APP_BASE()
    		            +"<"
    		            );
      System.out.println(   "URL_REL_FAMILY:                >"
    		            + getURL_REL_FAMILY()
    		            +"<"
    		            );
      System.out.println(   "URL_REL_REQUEST:               >"
    		            + getURL_REL_REQUEST()
    		            +"<"
    		            );
      System.out.println(   "URL_REL_REPORTS:               >"
    		            + getURL_REL_REPORTS()
    		            +"<"
    		            );
      System.out.println(   "URL_REL_REQUEST_SERIES:        >"
    		            + getURL_REL_REQUEST_SERIES()
    		            +"<"
    		            );
      System.out.println(   "URL_REL_REQUEST_SET:           >"
    		            + getURL_REL_REQUEST_SET()
    		            +"<"
    		            );
      System.out.println(   "URL_REL_RESIDUALS:             >"
    		            + getURL_REL_RESIDUALS()
    		            +"<"
    		            );
      System.out.println(   "URL_REL_RPT_DETAILS:           >"
	                    + getURL_REL_RPT_DETAILS()
	                    +"<"
	                    );
      System.out.println(   "URL_REL_RPT_SUMMARY:           >"
                        + getURL_REL_RPT_SUMMARY()
                        +"<"
                        );
    }        
    

}
