package com.knitting.jamacoi;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public   class    Report_Auto_Correlations_3 
         extends  Report_Abstract {
	
public            Report_Auto_Correlations_3( Regression  r
                                            , Sub_Matrix  sub_matrix
                                            , FileWriter  Rpt_Detail
                                            )	
                  throws                      java.io.IOException{
         super  ( r
                , sub_matrix
                , Rpt_Detail
                );
}	

	@Override
	public void write_headers() throws IOException, not_estimated
	{;}
	@Override
	public     void     write_details() 
	           throws   IOException
	                ,   not_estimated 
	{ 
	           get_Rpt_Detail().write( fmt_line_01() ); 
	           get_Rpt_Detail().write( fmt_line_03() ); 
	           get_Rpt_Detail().write( fmt_line_04() );
	           get_Rpt_Detail().write( fmt_line_05() );
	           get_Rpt_Detail().write( fmt_line_06() );
	           loop_thru_rows();
	}
	protected  String   fmt_line_01(){
	Formatter  line =   new Formatter();
			   line .   format("%n%n%s%n"
			                  ,"7_3) Sample Auto-Correlations values ==========================="
			                  ); 
	return     line .   toString();	
	}
	protected  String   fmt_line_03(){
	Formatter  line =   new Formatter();
			   line .   format("%4s%15s%15s%15s%15s%15s%15s%15s%n"
					          ,""
					          ,""
					          ,"2 times"
					          ,""
					          ,""
					          ,""
					          ,""
					          ,""
					          ); 
	return     line .   toString();	
		}
	protected  String   fmt_line_04(){
	Formatter  line =   new Formatter();
			   line .   format("%4s%15s%15s%15s%15s%15s%15s%15s%n"
				              ,""
				              ,"auto"
				              ,"standard"
				              ,""
				              ,""
				              ,""
				              ,""
				              ,""
				              ); 
	return     line .   toString();	
	}
	protected  String   fmt_line_05(){
	Formatter  line =   new Formatter();
			   line .   format("%4s%15s%15s%15s%15s%15s%15s%15s%n"
					          ,"lag"
					          ,"correlation"
					          ,"deviation"
					          ,""
					          ,"x std dev"
					          ,"y std dev"
					          ,""
					          ,"variance"
				              ); 
	return     line .   toString();	
	}
	protected  String   fmt_line_06(){
	Formatter  line =   new Formatter();
			   line .   format("%4s%15s%15s%15s%15s%15s%15s%15s%n"
						      ,"===="
						      ,"============"
						      ,"============"
						      ,"============"
						      ,"============"
						      ,"============"
						      ,"============"
						      ,"============"
						      ); 
	return     line .   toString();	
	}
	protected  void   loop_thru_rows()
	           throws java.io.IOException
	{	
	           for  (int  ir   = 0
	                ;     ir   < get_Regression()
	                            .get_Auto_Correlation_3()
	                            .getRowDimension() 
	                ;   ++ir
	                )
	                {
	                  Formatter line = new Formatter();
	                            line .  format("%4d"
	         		                          , ir
	         		                          );
		                        line . format("%s%n" 
		     		                         , fmt_line_07_cells(ir)
		     		                         );
		                        get_Rpt_Detail().write( line.toString() );
		     
		                        line = null;
	                }
	}
	protected  String  fmt_line_07_cells(int  ir){
	Formatter  line =  new Formatter();

	           for (int   ic   =    0
	               ;      ic   <    get_Regression()
	                               .get_Auto_Correlation_3()
	                               .getColumnDimension()
	               ;    ++ic
	               )
	               {
	                 line . format( "%15.5E"
		                          ,  get_Regression()
		                            .get_Auto_Correlation_3()
		                            .get(ir, ic)
		                          );
	                 if ( ic == 1 )
	                    {
	                	      line . format( "%15s"
		                                   ,  get_Regression()
		                                   .  get_Auto_Correlation_3()
		                                   .  get_significance      (ir)
		                                   );
	                    }
	               }
	return           line . toString();	
	}

}
