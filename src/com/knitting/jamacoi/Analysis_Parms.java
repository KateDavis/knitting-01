package com.knitting.jamacoi;

public class Analysis_Parms {
    
    private int    COUNT_MAX_MATRIX_ROWS          = 200;
    private int    COUNT_MAX_COLUMNS              =   3;
    private int    COUNT_MAX_REGRESSION_ANALYSIS  =  60;
    private int    ROW_TARGET                     =  10;
    private int    COL_START                      =   0;
    private int    COL_END                        =   2;
    private int    ROW_BASE                       = 300;
    private String NAME_IN_DIR   = "/Temp/Residual_attempt_01";
    private String NAME_IN_FILE  = "GLD_vs_London_Spot_2_with_lag_1_day.txt";
    private String NAME_OUT_DIR  = "/Temp";
    private String NAME_OUT_DETAILS = "Regression_Details.txt";
    private String NAME_OUT_SUMMARY = "Regression_Summary.txt";



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

    public int getCOUNT_MAX_COLUMNS() {
        return COUNT_MAX_COLUMNS;
    }

    public void setCOUNT_MAX_COLUMNS(int COUNT_MAX_COLUMNS) {
        this.COUNT_MAX_COLUMNS = COUNT_MAX_COLUMNS;
    }

    public int getROW_BASE() {
        return ROW_BASE;
    }

    public void setROW_BASE(int ROW_BASE) {
        this.ROW_BASE = ROW_BASE;
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
        return NAME_OUT_DETAILS;
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

    public void report_values()
    {
      System.out.println("COUNT_MAX_MATRIX_ROWS:         >"
                        + getCOUNT_MAX_MATRIX_ROWS()
                        +"<"
                        );
      System.out.println("COUNT_MAX_COLUMNS:             >"
                        + getCOUNT_MAX_COLUMNS()
                        +"<"
                        );
      System.out.println("COUNT_MAX_REGRESSION_ANALYSIS: >"
                        + getCOUNT_MAX_REGRESSION_ANALYSIS()
                        +"<"
                        );
      System.out.println("ROW_TARGET:                    >"
                        + getROW_TARGET()
                        +"<"
                        );
      System.out.println("ROW_BASE:                      >"
                        + getROW_BASE()
                        +"<"
                        );
      System.out.println("COL_START:                     >"
                        + getCOL_START()
                        +"<"
                        );
      System.out.println("COL_END:                       >"
                        + getCOL_END()   
                        +"<"
                        );
      System.out.println("NAME_IN_DIR:                   >"
                        + getNAME_IN_DIR()
                        +"<"
                        );
      System.out.println("NAME_IN_FILE:                  >"
                        + getNAME_IN_FILE()
                        +"<"
                        );
      System.out.println("NAME_OUT_DIR:                  >"
                        + getNAME_OUT_DIR()
                        +"<"
                        );
      System.out.println("NAME_OUT_DETAILS:              >"
                        + getNAME_OUT_DETAILS()
                        +"<"
                        );
      System.out.println("NAME_OUT_SUMMARY:              >"
                        + getNAME_OUT_SUMMARY()
                        +"<"
                        );
    }        
    

}
