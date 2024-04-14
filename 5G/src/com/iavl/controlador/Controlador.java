package com.iavl.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.iavl.modelo.Femto;
import com.iavl.modelo.Pico;
import com.iavl.modelo.Micro;
import com.iavl.modelo.Macro;
import com.iavl.modelo.Modelo;
import com.iavl.vista.GrafiicaLD;
import com.iavl.vista.Vista;

public class Controlador implements ActionListener {

	// Instancia del frame principal
	Vista vista;
	Modelo modelo; // Instancia de clase 
    String newline = "\n";

	ArrayList<ArrayList<Double>> LuArray  = new ArrayList<ArrayList<Double>>(6);	
	
	public Controlador(Vista vista, Modelo modelo) {

		this.vista = vista;
		this.modelo = modelo;

		// Al boton que genera acci�n se debe asignar un addActionListener
		Vista.buttonUpload.addActionListener(this);

	}

	
	// Metodo que implementa ActionListener
	@SuppressWarnings({ "static-access", "unused" })
	public void actionPerformed(ActionEvent e) {
		double htp=1.5,htm=1.5,htM=1.5,h=5,W=20,hBs=25;
		double df0=0,df1=100,dp0=100,dp1=200,dm0=200,dm1=2000,dM0=2000,dM1=8000;
		double ff[] = {26,38,42,48,51}; 
		double fp[] = {26,38,42,48,51}; 
		double fm[] = {0.7,2.5,3.5,26}; 
		double fM[] = {0.7,2.5,3.5}; 

		int errorT = 0,opc=0;;
		String Titulo = "";
		String ejeX = "";
		String ejeY = "";
		String GrafType  = "";

		DecimalFormat dF = new DecimalFormat("#.0");
			dF.setMaximumFractionDigits(2);
        
		ArrayList<String> EjeX = new ArrayList<String>();	
		
		if (e.getSource() == Vista.buttonUpload) {


			
			if (vista.radioButtonFemto.isSelected()) {
				Titulo = "Femto celda (Interno)";
			} else if (vista.radioButtonPico.isSelected()) {
				Titulo = "Pico celda (Externo)";
			} else if (vista.radioButtonMicro.isSelected()) {
				Titulo = "Micro celda (Externo)";
			} else if (vista.radioButtonMacro.isSelected()) {
				Titulo = "Macro celda (Externo)";
			}
			if (Titulo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error, eija una opcion para modelo" + JOptionPane.ERROR_MESSAGE);
				errorT++;
			}
			
				GrafType = "Loss v/s D";
				ejeX = "Distance";
				ejeY = "Loss";
			Femto Inst1 =  new Femto(ff,df0,df1);
			Pico  Inst2 =  new Pico(fp,dp0,dp1,htp);
			Micro Inst3 =  new Micro(fm,dm0,dm1,htm);
			Macro Inst4 =  new Macro(fM,dM0,dM1,htM,h,W,hBs);

			
			switch(Titulo){
				case "Femto celda (Interno)":
					switch(GrafType){
						case "Loss v/s D":
							LuArray = Inst1.FemtoModel();
							System.out.println("Controlador despues femto");
								for (double i = df0; i <= df1; i+=20) {
									EjeX.add(Double.toString(i+1));
								}
							opc=1;
						break;
					}
				break;
				case "Pico celda (Externo)":
					switch(GrafType){
						case "Loss v/s D":
							LuArray = Inst2.PicoModel();
							for (double i = dp0; i <= dp1; i+=20) {
								EjeX.add(Double.toString(i+1));
							}		
							opc=2;
						break;
					}					
				break;
				case "Micro celda (Externo)":
					switch(GrafType){
						case "Loss v/s D":
							LuArray = Inst3.MicroModel();
							for (double i = dm0; i <= dm1; i+=200) {
								EjeX.add(Double.toString(i+1));
							}	
							opc=3;
						break;
					}					
				break;
				case "Macro celda (Externo)":
					switch(GrafType){
						case "Loss v/s D":
							LuArray = Inst4.MacroModel();
							for (double i = dM0; i <= dM1; i+=1000) {
								EjeX.add(Double.toString(i+1));
							}
							opc=4;
						break;
					}					
				break;
			}
			
			
			GrafiicaLD graficador = new GrafiicaLD(Titulo,ejeX,ejeY,LuArray,EjeX,opc);
			
			vista.graficaLd.removeAll();
			vista.graficaLd.add(graficador.createDemoPanel());
			vista.graficaLd.updateUI();
			
			vista.texto2.append("\n" + Titulo + "\n\n");


	        for (int i = 0; i < LuArray.size(); i++) {
	            for (int j = 1; j < LuArray.get(i).size(); j++) {
	            	vista.texto2.append(ff[i]+ "	" +dF.format(LuArray.get(i).get(j)) + "	");
	            }
	            vista.texto2.append("\n");
	        }
		
		}

	}
	

}

