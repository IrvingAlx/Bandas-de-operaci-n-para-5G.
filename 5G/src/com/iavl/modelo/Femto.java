package com.iavl.modelo;

import java.util.ArrayList;

public class Femto {
	double f[];
	double d0;
	double d1;

	public Femto(double f[] ,double d0,double d1) {
		// TODO Auto-generated constructor stub
		this.f = f;
		this.d0 = d0;
		this.d1 = d1;
	}
	
	public ArrayList<ArrayList<Double>> FemtoModel() {
		int n = f.length+1;

		ArrayList<ArrayList<Double> > aList = new ArrayList<ArrayList<Double>>(n);
		ArrayList<Double> temp0 = new ArrayList<Double>();
		ArrayList<Double> temp1 = new ArrayList<Double>();
		ArrayList<Double> temp2 = new ArrayList<Double>();
		ArrayList<Double> temp3 = new ArrayList<Double>();
		ArrayList<Double> temp4 = new ArrayList<Double>();
		ArrayList<Double> temp5 = new ArrayList<Double>();
			
				for(double d = d0; d <= d1; d+=20) {
			        temp0.add(17.3 + (24.9*(Math.log10(f[0]))) + (38.3*(Math.log10(d))));
			        temp1.add(17.3 + (24.9*(Math.log10(f[1]))) + (38.3*(Math.log10(d))));
			        temp2.add(17.3 + (24.9*(Math.log10(f[2]))) + (38.3*(Math.log10(d))));
			        temp3.add(17.3 + (24.9*(Math.log10(f[3]))) + (38.3*(Math.log10(d))));
			        temp4.add(17.3 + (24.9*(Math.log10(f[4]))) + (38.3*(Math.log10(d))));
			        temp5.add((double) 110);
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
