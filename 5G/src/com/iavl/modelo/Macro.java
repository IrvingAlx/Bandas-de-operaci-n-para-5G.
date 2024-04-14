package com.iavl.modelo;

import java.util.ArrayList;

public class Macro {
	double f[];
	double d0;
	double d1;
	double htp;
	double h;
	double W;
	double hBs;

	public Macro(double f[] ,double d0,double d1,double htp,double h, double W, double hBs) {
		// TODO Auto-generated constructor stub
		this.f = f;
		this.d0 = d0;
		this.d1 = d1;
		this.htp = htp;
		this.h = h;
		this.W = W;
		this.hBs = hBs;
	}
	
	public ArrayList<ArrayList<Double>> MacroModel() {
		int n = f.length+1;
		ArrayList<ArrayList<Double> > aList = new ArrayList<ArrayList<Double>>(n);
		ArrayList<Double> temp0 = new ArrayList<Double>();
		ArrayList<Double> temp1 = new ArrayList<Double>();
		ArrayList<Double> temp2 = new ArrayList<Double>();
		ArrayList<Double> temp3 = new ArrayList<Double>();
		System.out.println((161.04 - 7.1*(Math.log10(W)) + 7.5*(Math.log10(h)) - (24.37 - 3.7 * (Math.pow((h/hBs),2))) * Math.log10(hBs) + (43.42 - 3.1 * Math.log10(hBs)) * 
        		(Math.log10(2000)-3) + 
        		(20 * Math.log10(f[0])) - 
        		Math.pow(3.2*(Math.log10(11.75*htp)),2) - 
        		4.97));

				for(double d = d0; d <= d1; d+=1000) {
			        temp0.add(161.04 + 
			        		7.1*(Math.log10(W)) + 
			        		7.5*(Math.log10(h)) - 
			        		(24.37 - 3.7 * (Math.pow((h/hBs),2))) * 
			        		Math.log10(hBs) + 
			        		(43.42 - 3.1 * Math.log10(hBs)) * 
			        		(Math.log10(d)-3) + 
			        		(20 * Math.log10(f[0])) - 
			        		Math.pow(3.2*(Math.log10(11.75*htp)),2) - 
			        		4.97);
			        temp1.add(161.04 -
			        		7.1*(Math.log10(W)) + 
			        		7.5*(Math.log10(h)) - 
			        		(24.37 - 3.7 * (Math.pow((h/hBs),2))) * 
			        		Math.log10(hBs) + 
			        		(43.42 - 3.1 * Math.log10(hBs)) * 
			        		(Math.log10(d)-3) + 
			        		(20 * Math.log10(f[1])) - 
			        		Math.pow(3.2*(Math.log10(11.75*htp)),2) - 
			        		4.97);
			        temp2.add(161.04 -
			        		7.1*(Math.log10(W)) + 
			        		7.5*(Math.log10(h)) - 
			        		(24.37 - 3.7 * (Math.pow((h/hBs),2))) * 
			        		Math.log10(hBs) + 
			        		(43.42 - 3.1 * Math.log10(hBs)) * 
			        		(Math.log10(d)-3) + 
			        		(20 * Math.log10(f[2])) - 
			        		Math.pow(3.2*(Math.log10(11.75*htp)),2) - 
			        		4.97);
			        temp3.add((double) 135);			        
				}
				aList.add(temp0);	
				aList.add(temp1);				
				aList.add(temp2);	
				aList.add(temp3);

			return aList;
		
	}
	
}
