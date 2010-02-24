package com.knitting.jamacoi;
import  java.util.*;
public class F_Distribution_Table_at_05_00_Percent 
{
	private TreeMap<Integer,TreeMap<Integer, Double> > tm_5 = new 
            TreeMap<Integer,TreeMap<Integer, Double> >();
public  F_Distribution_Table_at_05_00_Percent(){

   tm_5.put(  1 , tm_build_5_01_degree());
   tm_5.put(  2 , tm_build_5_02_degree());  
   tm_5.put(  3 , tm_build_5_03_degree()); 
   tm_5.put(  4 , tm_build_5_04_degree());
   tm_5.put(  5 , tm_build_5_05_degree());
   tm_5.put(  6 , tm_build_5_06_degree());
   tm_5.put(  7 , tm_build_5_07_degree());
   tm_5.put(  8 , tm_build_5_08_degree());
   tm_5.put(  9 , tm_build_5_09_degree());
   tm_5.put( 10 , tm_build_5_10_degree());
   tm_5.put( 11 , tm_build_5_11_degree());
   tm_5.put( 12 , tm_build_5_12_degree());
   tm_5.put( 13 , tm_build_5_13_degree());
   tm_5.put( 14 , tm_build_5_14_degree());
   tm_5.put( 15 , tm_build_5_15_degree());
   tm_5.put( 16 , tm_build_5_16_degree());
   tm_5.put( 17 , tm_build_5_17_degree());
   tm_5.put( 18 , tm_build_5_18_degree());
   tm_5.put( 19 , tm_build_5_19_degree());
   tm_5.put( 20 , tm_build_5_20_degree());
   tm_5.put( 21 , tm_build_5_21_degree());
   tm_5.put( 22 , tm_build_5_22_degree());
   tm_5.put( 23 , tm_build_5_23_degree());
   tm_5.put( 24 , tm_build_5_24_degree());
   tm_5.put( 25 , tm_build_5_25_degree());
   tm_5.put( 30 , tm_build_5_30_degree());
   tm_5.put( 40 , tm_build_5_40_degree());
   tm_5.put( 60 , tm_build_5_60_degree());
   tm_5.put(120 , tm_build_5_120_degree());
   tm_5.put(9999999 , tm_build_5_MAX_degree());
   
 } 
 public  TreeMap<Integer, TreeMap<Integer, Double> > get_data(){return tm_5;}
 private TreeMap<Integer, Double> tm_build_5_01_degree() {

     TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1, 161.0);
     tm . put(  2, 200.0);
     tm . put(  3, 216.0);
     tm . put(  4, 225.0);
     tm . put(  5, 230.0);
     tm . put(  6, 234.0);
     tm . put(  7, 237.0);
     tm . put(  8, 239.0);
     tm . put(  9, 241.0);
     tm . put( 10, 242.0);
     tm . put( 12, 244.0);
     tm . put( 15, 246.0);
     tm . put( 20, 248.0);
     tm . put( 24, 249.0);
     tm . put( 30, 250.0);
     tm . put( 40, 251.0);
     tm . put( 60, 252.0);
     tm . put(120, 253.0);
     tm . put(999, 254.0);
     return tm;
     }

 private TreeMap<Integer, Double> tm_build_5_02_degree() 
 {
     TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1, 18.5);
     tm . put(  2, 19.0);
     tm . put(  3, 19.2);
     tm . put(  4, 19.2);
     tm . put(  5, 19.3);
     tm . put(  6, 19.3);
     tm . put(  7, 19.4);
     tm . put(  8, 19.4);
     tm . put(  9, 19.4);
     tm . put( 10, 19.4);
     tm . put( 12, 19.4);
     tm . put( 15, 19.4);
     tm . put( 20, 19.4);
     tm . put( 24, 19.5);
     tm . put( 30, 19.5);
     tm . put( 40, 19.5);
     tm . put( 60, 19.5);
     tm . put(120, 19.5);
     tm . put(999, 19.5);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_03_degree() {

     TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1, 10.10);
     tm . put(  2,  9.55);
     tm . put(  3,  9.28);
     tm . put(  4,  9.12);
     tm . put(  5,  9.01);
     tm . put(  6,  8.94);
     tm . put(  7,  8.89);
     tm . put(  8,  8.85);
     tm . put(  9,  8.81);
     tm . put( 10,  8.79);
     tm . put( 12,  8.74);
     tm . put( 15,  8.70);
     tm . put( 20,  8.66);
     tm . put( 24,  8.64);
     tm . put( 30,  8.62);
     tm . put( 40,  8.59);
     tm . put( 60,  8.57);
     tm . put(120,  8.55);
     tm . put(999,  8.53);
     return tm;
     }   
 private TreeMap<Integer, Double> tm_build_5_04_degree() {

     TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  7.71);
     tm . put(  2,  6.94);
     tm . put(  3,  6.59);
     tm . put(  4,  6.39);
     tm . put(  5,  6.26);
     tm . put(  6,  6.16);
     tm . put(  7,  6.09);
     tm . put(  8,  6.04);
     tm . put(  9,  6.00);
     tm . put( 10,  5.96);
     tm . put( 12,  5.91);
     tm . put( 15,  5.86);
     tm . put( 20,  5.80);
     tm . put( 24,  5.77);
     tm . put( 30,  5.75);
     tm . put( 40,  5.72);
     tm . put( 60,  5.69);
     tm . put(120,  5.66);
     tm . put(999,  5.63);
     return tm;
     }   
 private TreeMap<Integer, Double> tm_build_5_05_degree() 
 {
     TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  6.61);
     tm . put(  2,  5.79);
     tm . put(  3,  5.41);
     tm . put(  4,  5.19);
     tm . put(  5,  5.05);
     tm . put(  6,  4.95);
     tm . put(  7,  4.88);
     tm . put(  8,  4.82);
     tm . put(  9,  4.77);
     tm . put( 10,  4.74);
     tm . put( 12,  4.68);
     tm . put( 15,  4.62);
     tm . put( 20,  4.56);
     tm . put( 24,  4.53);
     tm . put( 30,  4.50);
     tm . put( 40,  4.46);
     tm . put( 60,  4.43);
     tm . put(120,  4.40);
     tm . put(999,  4.37);
     return tm;
     }   
 private TreeMap<Integer, Double> tm_build_5_06_degree() 
 {
     TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  5.99);
     tm . put(  2,  5.14);
     tm . put(  3,  4.76);
     tm . put(  4,  4.53);
     tm . put(  5,  4.39);
     tm . put(  6,  4.28);
     tm . put(  7,  4.21);
     tm . put(  8,  4.15);
     tm . put(  9,  4.10);
     tm . put( 10,  4.06);
     tm . put( 12,  4.00);
     tm . put( 15,  3.94);
     tm . put( 20,  3.87);
     tm . put( 24,  3.84);
     tm . put( 30,  3.81);
     tm . put( 40,  3.77);
     tm . put( 60,  3.74);
     tm . put(120,  3.70);
     tm . put(999,  3.67);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_07_degree() 
 {
     TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  5.59);
     tm . put(  2,  4.74);
     tm . put(  3,  4.35);
     tm . put(  4,  4.12);
     tm . put(  5,  3.97);
     tm . put(  6,  3.87);
     tm . put(  7,  3.79);
     tm . put(  8,  3.73);
     tm . put(  9,  3.68);
     tm . put( 10,  3.64);
     tm . put( 12,  3.57);
     tm . put( 15,  3.51);
     tm . put( 20,  3.44);
     tm . put( 24,  3.41);
     tm . put( 30,  3.38);
     tm . put( 40,  3.34);
     tm . put( 60,  3.30);
     tm . put(120,  3.27);
     tm . put(999,  3.23);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_08_degree()
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  5.32);
     tm . put(  2,  4.46);
     tm . put(  3,  4.07);
     tm . put(  4,  3.84);
     tm . put(  5,  3.69);
     tm . put(  6,  3.58);
     tm . put(  7,  3.50);
     tm . put(  8,  3.44);
     tm . put(  9,  3.39);
     tm . put( 10,  3.35);
     tm . put( 12,  3.28);
     tm . put( 15,  3.22);
     tm . put( 20,  3.15);
     tm . put( 24,  3.12);
     tm . put( 30,  3.08);
     tm . put( 40,  3.04);
     tm . put( 60,  3.01);
     tm . put(120,  2.97);
     tm . put(999,  2.93);
     return tm;
     }  
 private TreeMap<Integer, Double> tm_build_5_09_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  5.12);
     tm . put(  2,  4.26);
     tm . put(  3,  3.86);
     tm . put(  4,  3.63);
     tm . put(  5,  3.48);
     tm . put(  6,  3.37);
     tm . put(  7,  3.29);
     tm . put(  8,  3.23);
     tm . put(  9,  3.18);
     tm . put( 10,  3.14);
     tm . put( 12,  3.07);
     tm . put( 15,  3.01);
     tm . put( 20,  2.94);
     tm . put( 24,  2.90);
     tm . put( 30,  2.86);
     tm . put( 40,  2.83);
     tm . put( 60,  2.79);
     tm . put(120,  2.75);
     tm . put(999,  2.71);
     return tm;
     }  
 private TreeMap<Integer, Double> tm_build_5_10_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.96);
     tm . put(  2,  4.10);
     tm . put(  3,  3.71);
     tm . put(  4,  3.48);
     tm . put(  5,  3.33);
     tm . put(  6,  3.22);
     tm . put(  7,  3.14);
     tm . put(  8,  3.07);
     tm . put(  9,  3.02);
     tm . put( 10,  2.98);
     tm . put( 12,  2.91);
     tm . put( 15,  2.85);
     tm . put( 20,  2.77);
     tm . put( 24,  2.74);
     tm . put( 30,  2.70);
     tm . put( 40,  2.66);
     tm . put( 60,  2.62);
     tm . put(120,  2.58);
     tm . put(999,  2.54);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_11_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.84);
     tm . put(  2,  3.98);
     tm . put(  3,  3.59);
     tm . put(  4,  3.36);
     tm . put(  5,  3.20);
     tm . put(  6,  3.09);
     tm . put(  7,  3.01);
     tm . put(  8,  2.95);
     tm . put(  9,  2.90);
     tm . put( 10,  2.85);
     tm . put( 12,  2.79);
     tm . put( 15,  2.72);
     tm . put( 20,  2.65);
     tm . put( 24,  2.61);
     tm . put( 30,  2.57);
     tm . put( 40,  2.53);
     tm . put( 60,  2.49);
     tm . put(120,  2.45);
     tm . put(999,  2.40);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_12_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.75);
     tm . put(  2,  3.89);
     tm . put(  3,  3.49);
     tm . put(  4,  3.26);
     tm . put(  5,  3.11);
     tm . put(  6,  3.00);
     tm . put(  7,  2.91);
     tm . put(  8,  2.85);
     tm . put(  9,  2.80);
     tm . put( 10,  2.75);
     tm . put( 12,  2.69);
     tm . put( 15,  2.62);
     tm . put( 20,  2.54);
     tm . put( 24,  2.51);
     tm . put( 30,  2.47);
     tm . put( 40,  2.43);
     tm . put( 60,  2.38);
     tm . put(120,  2.34);
     tm . put(999,  2.30);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_13_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.67);
     tm . put(  2,  3.81);
     tm . put(  3,  3.41);
     tm . put(  4,  3.18);
     tm . put(  5,  3.03);
     tm . put(  6,  2.92);
     tm . put(  7,  2.83);
     tm . put(  8,  2.77);
     tm . put(  9,  2.71);
     tm . put( 10,  2.67);
     tm . put( 12,  2.60);
     tm . put( 15,  2.53);
     tm . put( 20,  2.46);
     tm . put( 24,  2.42);
     tm . put( 30,  2.38);
     tm . put( 40,  2.34);
     tm . put( 60,  2.30);
     tm . put(120,  2.25);
     tm . put(999,  2.21);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_14_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.60);
     tm . put(  2,  3.74);
     tm . put(  3,  3.34);
     tm . put(  4,  3.11);
     tm . put(  5,  2.96);
     tm . put(  6,  2.85);
     tm . put(  7,  2.76);
     tm . put(  8,  2.70);
     tm . put(  9,  2.65);
     tm . put( 10,  2.60);
     tm . put( 12,  2.53);
     tm . put( 15,  2.46);
     tm . put( 20,  2.39);
     tm . put( 24,  2.35);
     tm . put( 30,  2.31);
     tm . put( 40,  2.27);
     tm . put( 60,  2.22);
     tm . put(120,  2.18);
     tm . put(999,  2.13);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_15_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.54);
     tm . put(  2,  3.68);
     tm . put(  3,  3.29);
     tm . put(  4,  3.06);
     tm . put(  5,  2.90);
     tm . put(  6,  2.79);
     tm . put(  7,  2.71);
     tm . put(  8,  2.64);
     tm . put(  9,  2.59);
     tm . put( 10,  2.54);
     tm . put( 12,  2.48);
     tm . put( 15,  2.40);
     tm . put( 20,  2.33);
     tm . put( 24,  2.29);
     tm . put( 30,  2.25);
     tm . put( 40,  2.20);
     tm . put( 60,  2.16);
     tm . put(120,  2.11);
     tm . put(999,  2.07);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_16_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.49);
     tm . put(  2,  3.63);
     tm . put(  3,  3.24);
     tm . put(  4,  3.01);
     tm . put(  5,  2.85);
     tm . put(  6,  2.74);
     tm . put(  7,  2.66);
     tm . put(  8,  2.59);
     tm . put(  9,  2.54);
     tm . put( 10,  2.49);
     tm . put( 12,  2.42);
     tm . put( 15,  2.35);
     tm . put( 20,  2.28);
     tm . put( 24,  2.24);
     tm . put( 30,  2.19);
     tm . put( 40,  2.15);
     tm . put( 60,  2.11);
     tm . put(120,  2.06);
     tm . put(999,  2.01);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_17_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.45);
     tm . put(  2,  3.59);
     tm . put(  3,  3.20);
     tm . put(  4,  2.96);
     tm . put(  5,  2.81);
     tm . put(  6,  2.70);
     tm . put(  7,  2.61);
     tm . put(  8,  2.55);
     tm . put(  9,  2.49);
     tm . put( 10,  2.45);
     tm . put( 12,  2.38);
     tm . put( 15,  2.31);
     tm . put( 20,  2.23);
     tm . put( 24,  2.19);
     tm . put( 30,  2.15);
     tm . put( 40,  2.10);
     tm . put( 60,  2.06);
     tm . put(120,  2.01);
     tm . put(999,  1.96);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_18_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.41);
     tm . put(  2,  3.55);
     tm . put(  3,  3.16);
     tm . put(  4,  2.93);
     tm . put(  5,  2.77);
     tm . put(  6,  2.66);
     tm . put(  7,  2.58);
     tm . put(  8,  2.51);
     tm . put(  9,  2.46);
     tm . put( 10,  2.41);
     tm . put( 12,  2.34);
     tm . put( 15,  2.27);
     tm . put( 20,  2.19);
     tm . put( 24,  2.15);
     tm . put( 30,  2.11);
     tm . put( 40,  2.06);
     tm . put( 60,  2.02);
     tm . put(120,  1.97);
     tm . put(999,  1.92);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_19_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.38);
     tm . put(  2,  3.52);
     tm . put(  3,  3.13);
     tm . put(  4,  2.90);
     tm . put(  5,  2.74);
     tm . put(  6,  2.63);
     tm . put(  7,  2.54);
     tm . put(  8,  2.48);
     tm . put(  9,  2.42);
     tm . put( 10,  2.38);
     tm . put( 12,  2.31);
     tm . put( 15,  2.23);
     tm . put( 20,  2.16);
     tm . put( 24,  2.11);
     tm . put( 30,  2.07);
     tm . put( 40,  2.03);
     tm . put( 60,  1.98);
     tm . put(120,  1.93);
     tm . put(999,  1.88);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_20_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.35);
     tm . put(  2,  3.49);
     tm . put(  3,  3.10);
     tm . put(  4,  2.87);
     tm . put(  5,  2.71);
     tm . put(  6,  2.60);
     tm . put(  7,  2.51);
     tm . put(  8,  2.45);
     tm . put(  9,  2.39);
     tm . put( 10,  2.35);
     tm . put( 12,  2.28);
     tm . put( 15,  2.20);
     tm . put( 20,  2.12);
     tm . put( 24,  2.08);
     tm . put( 30,  2.04);
     tm . put( 40,  1.99);
     tm . put( 60,  1.95);
     tm . put(120,  1.90);
     tm . put(999,  1.84);
     return tm;
     }  
 private TreeMap<Integer, Double> tm_build_5_21_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.32);
     tm . put(  2,  3.47);
     tm . put(  3,  3.07);
     tm . put(  4,  2.84);
     tm . put(  5,  2.68);
     tm . put(  6,  2.57);
     tm . put(  7,  2.49);
     tm . put(  8,  2.42);
     tm . put(  9,  2.37);
     tm . put( 10,  2.32);
     tm . put( 12,  2.25);
     tm . put( 15,  2.18);
     tm . put( 20,  2.10);
     tm . put( 24,  2.05);
     tm . put( 30,  2.01);
     tm . put( 40,  1.96);
     tm . put( 60,  1.92);
     tm . put(120,  1.87);
     tm . put(999,  1.81);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_22_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.30);
     tm . put(  2,  3.44);
     tm . put(  3,  3.05);
     tm . put(  4,  2.82);
     tm . put(  5,  2.66);
     tm . put(  6,  2.55);
     tm . put(  7,  2.46);
     tm . put(  8,  2.40);
     tm . put(  9,  2.34);
     tm . put( 10,  2.30);
     tm . put( 12,  2.23);
     tm . put( 15,  2.15);
     tm . put( 20,  2.07);
     tm . put( 24,  2.03);
     tm . put( 30,  1.98);
     tm . put( 40,  1.94);
     tm . put( 60,  1.89);
     tm . put(120,  1.84);
     tm . put(999,  1.78);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_23_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.28);
     tm . put(  2,  3.42);
     tm . put(  3,  3.03);
     tm . put(  4,  2.80);
     tm . put(  5,  2.64);
     tm . put(  6,  2.53);
     tm . put(  7,  2.44);
     tm . put(  8,  2.37);
     tm . put(  9,  2.32);
     tm . put( 10,  2.27);
     tm . put( 12,  2.20);
     tm . put( 15,  2.13);
     tm . put( 20,  2.05);
     tm . put( 24,  2.01);
     tm . put( 30,  1.96);
     tm . put( 40,  1.91);
     tm . put( 60,  1.86);
     tm . put(120,  1.81);
     tm . put(999,  1.76);
     return tm;
     } 
 private TreeMap<Integer, Double> tm_build_5_24_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.26);
     tm . put(  2,  3.40);
     tm . put(  3,  3.01);
     tm . put(  4,  2.78);
     tm . put(  5,  2.62);
     tm . put(  6,  2.51);
     tm . put(  7,  2.42);
     tm . put(  8,  2.36);
     tm . put(  9,  2.30);
     tm . put( 10,  2.25);
     tm . put( 12,  2.18);
     tm . put( 15,  2.11);
     tm . put( 20,  2.03);
     tm . put( 24,  1.98);
     tm . put( 30,  1.94);
     tm . put( 40,  1.89);
     tm . put( 60,  1.84);
     tm . put(120,  1.79);
     tm . put(999,  1.73);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_25_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.24);
     tm . put(  2,  3.39);
     tm . put(  3,  2.99);
     tm . put(  4,  2.76);
     tm . put(  5,  2.60);
     tm . put(  6,  2.49);
     tm . put(  7,  2.40);
     tm . put(  8,  2.34);
     tm . put(  9,  2.28);
     tm . put( 10,  2.24);
     tm . put( 12,  2.16);
     tm . put( 15,  2.09);
     tm . put( 20,  2.01);
     tm . put( 24,  1.96);
     tm . put( 30,  1.92);
     tm . put( 40,  1.87);
     tm . put( 60,  1.82);
     tm . put(120,  1.77);
     tm . put(999,  1.71);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_30_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.17);
     tm . put(  2,  3.32);
     tm . put(  3,  2.92);
     tm . put(  4,  2.69);
     tm . put(  5,  2.53);
     tm . put(  6,  2.42);
     tm . put(  7,  2.33);
     tm . put(  8,  2.27);
     tm . put(  9,  2.21);
     tm . put( 10,  2.16);
     tm . put( 12,  2.09);
     tm . put( 15,  2.01);
     tm . put( 20,  1.93);
     tm . put( 24,  1.89);
     tm . put( 30,  1.84);
     tm . put( 40,  1.79);
     tm . put( 60,  1.74);
     tm . put(120,  1.68);
     tm . put(999,  1.62);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_40_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.08);
     tm . put(  2,  3.23);
     tm . put(  3,  2.84);
     tm . put(  4,  2.61);
     tm . put(  5,  2.45);
     tm . put(  6,  2.34);
     tm . put(  7,  2.25);
     tm . put(  8,  2.18);
     tm . put(  9,  2.12);
     tm . put( 10,  2.08);
     tm . put( 12,  2.00);
     tm . put( 15,  1.92);
     tm . put( 20,  1.84);
     tm . put( 24,  1.79);
     tm . put( 30,  1.74);
     tm . put( 40,  1.69);
     tm . put( 60,  1.64);
     tm . put(120,  1.58);
     tm . put(999,  1.51);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_60_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  4.00);
     tm . put(  2,  3.15);
     tm . put(  3,  2.76);
     tm . put(  4,  2.53);
     tm . put(  5,  2.37);
     tm . put(  6,  2.25);
     tm . put(  7,  2.17);
     tm . put(  8,  2.10);
     tm . put(  9,  2.04);
     tm . put( 10,  1.99);
     tm . put( 12,  1.92);
     tm . put( 15,  1.84);
     tm . put( 20,  1.75);
     tm . put( 24,  1.70);
     tm . put( 30,  1.65);
     tm . put( 40,  1.59);
     tm . put( 60,  1.53);
     tm . put(120,  1.47);
     tm . put(999,  1.39);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_120_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  3.92);
     tm . put(  2,  3.07);
     tm . put(  3,  2.68);
     tm . put(  4,  2.45);
     tm . put(  5,  2.29);
     tm . put(  6,  2.18);
     tm . put(  7,  2.09);
     tm . put(  8,  2.02);
     tm . put(  9,  1.96);
     tm . put( 10,  1.91);
     tm . put( 12,  1.83);
     tm . put( 15,  1.75);
     tm . put( 20,  1.66);
     tm . put( 24,  1.61);
     tm . put( 30,  1.55);
     tm . put( 40,  1.50);
     tm . put( 60,  1.43);
     tm . put(120,  1.35);
     tm . put(999,  1.25);
     return tm;
     }
 private TreeMap<Integer, Double> tm_build_5_MAX_degree() 
 {       TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
     tm . put(  1,  3.84);
     tm . put(  2,  3.00);
     tm . put(  3,  2.60);
     tm . put(  4,  2.37);
     tm . put(  5,  2.21);
     tm . put(  6,  2.10);
     tm . put(  7,  2.01);
     tm . put(  8,  1.94);
     tm . put(  9,  1.88);
     tm . put( 10,  1.83);
     tm . put( 12,  1.75);
     tm . put( 15,  1.67);
     tm . put( 20,  1.57);
     tm . put( 24,  1.52);
     tm . put( 30,  1.46);
     tm . put( 40,  1.39);
     tm . put( 60,  1.32);
     tm . put(120,  1.22);
     tm . put(999,  1.00);
     return tm;
     }

}
