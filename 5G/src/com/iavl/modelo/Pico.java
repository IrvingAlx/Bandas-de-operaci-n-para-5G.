package com.iavl.modelo;


import java.util.ArrayList;

public class Pico {
	double f[];
	double d0;
	double d1;
	double htp;

	public Pico(double f[] ,double d0,double d1,double htp) {
		// TODO Auto-generated constructor stub
		this.f = f;
		this.d0 = d0;
		this.d1 = d1;
		this.htp = htp;
	}
	
	public ArrayList<ArrayList<Double>> PicoModel() {
		int n = f.length+1;
		ArrayList<ArrayList<Double> > aList = new ArrayList<ArrayList<Double>>(n);
		ArrayList<Double> temp0 = new ArrayList<Double>();
		ArrayList<Double> temp1 = new ArrayList<Double>();
		ArrayList<Double> temp2 = new ArrayList<Double>();
		ArrayList<Double> temp3 = new ArrayList<Double>();
		ArrayList<Double> temp4 = new ArrayList<Double>();
		ArrayList<Double> temp5 = new ArrayList<Double>();
			
				for(double d = d0; d <= d1; d+=20) {
			        temp0.add(13.54 + (20*(Math.log10(f[0]))) + (39.08*(Math.log10(d))) - (0.6*(htp -1.5)));
			        temp1.add(13.54 + (20*(Math.log10(f[1]))) + (39.08*(Math.log10(d))) - (0.6*(htp -1.5)));
			        temp2.add(13.54 + (20*(Math.log10(f[2]))) + (39.08*(Math.log10(d))) - (0.6*(htp -1.5)));
			        temp3.add(13.54 + (20*(Math.log10(f[3]))) + (39.08*(Math.log10(d))) - (0.6*(htp -1.5)));
			        temp4.add(13.54 + (20*(Math.log10(f[4]))) + (39.08*(Math.log10(d))) - (0.6*(htp -1.5)));
			        temp5.add((double) 125);

				}
				aList.add(temp0);
				aList.add(temp1);
				aList.add(temp2);
				aList.add(temp3);				
				aList.add(temp4);
				aList.add(temp5);
			return aList;
		
	}
	
}
