package com.iavl.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.*;


public class Vista extends JFrame {

	public static ArrayList<ArrayList<Double> > aList = new ArrayList<ArrayList<Double>>(6);
	public static ArrayList<String> EjeX = new ArrayList<String>();

	public GrafiicaLD graficaLd;
	public TextArea textArea;
	public static JButton buttonUpload;
	public static JButton buttonSave;

	public static ButtonGroup buttonGroupType;
	public static JRadioButton radioButtonFemto;
	public static JRadioButton radioButtonPico;
	public static JRadioButton radioButtonMicro;
	public static JRadioButton radioButtonMacro;

	public static JTextArea texto2;

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public Vista() {
		super("5G");

		setLayout(new BorderLayout(50,50));
		setSize(1880,980);
		//setLocation(18, 18);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		graficaLd = new GrafiicaLD("Modelos","EjeX","EjeY", aList,EjeX,0);
			graficaLd.setVisible(true);

		Image icon = Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\jhons\\Desktop\\antena-parabolica.png");

		setIconImage(icon);
		setResizable(false);

		JPanel pTotal = new JPanel();
			pTotal.setLayout(new GridLayout(1,2,70,70));
		JPanel pIzq = new JPanel();		//800px ancho
			pIzq.setLayout(null);
		JPanel pDer = new JPanel();
			pDer.setLayout(new GridLayout(2, 0));

		JPanel pDerImg = new JPanel();
			pDerImg.setLayout(new BorderLayout(50,50));			
			
		JLabel lableTop = new JLabel("Modelo de canal 5G", SwingConstants.CENTER);
			lableTop.setFont(new Font("Abel_Regular", Font.BOLD, 60));
			
		JLabel lableBut = new JLabel("Irving Alejandro Vega Lagunas", SwingConstants.CENTER);
			lableBut.setFont(new Font("Abel_Regular", Font.BOLD, 30));

		JLabel lableL = new JLabel("L", SwingConstants.CENTER);
			lableL.setFont(new Font("Abel_Regular", Font.BOLD, 30));
			lableL.setForeground(Color.WHITE);		
		
		JLabel lableR = new JLabel("R", SwingConstants.CENTER);
			lableR.setFont(new Font("Abel_Regular", Font.BOLD, 30));
			lableR.setForeground(Color.WHITE);

		JLabel lableTop2 = new JLabel("T", SwingConstants.CENTER);
			lableTop2.setForeground(Color.WHITE);
			
		JLabel lableBut2 = new JLabel("B", SwingConstants.CENTER);
			lableBut2.setForeground(Color.WHITE);
			
		JLabel lableL2 = new JLabel("LAAAAAAAAAAAAAAAAAAA", SwingConstants.CENTER);
			lableL2.setForeground(Color.WHITE);		
		
		JLabel lableR2 = new JLabel("RAAAAAAAAAAAAAAAAAAA", SwingConstants.CENTER);
			lableR2.setForeground(Color.WHITE);
			
			
		JLabel lable4 = new JLabel("Path Loss Models", SwingConstants.CENTER);
			lable4.setFont(new Font("Abel_Regular", Font.BOLD, 40));

		buttonUpload = new JButton("Calcular");
			buttonUpload.setBounds(100, 650, 250, 80);
			buttonUpload.setFont(new Font("Abel_Regular", Font.BOLD, 20));
			buttonUpload.setForeground(Color.WHITE);
			buttonUpload.setBackground(Color.DARK_GRAY);

		buttonSave = new JButton("Guardar");
			buttonSave.setBounds(500, 650, 250, 80);		
			buttonSave.setFont(new Font("Abel_Regular", Font.BOLD, 20));
			buttonSave.setForeground(Color.WHITE);
			buttonSave.setBackground(Color.DARK_GRAY);			
			
		radioButtonFemto = new JRadioButton("Femto Celda (Interior)");

			radioButtonFemto.setBounds(150, 10, 550, 50);
			radioButtonFemto.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonFemto.setActionCommand("true");
		
		JTextArea especifi = new JTextArea("Frecuencia:		16 - 38 - 42 - 48 - 51 GHz\r\n"
				+ "Distancia del enlace:	1 – 150 m\r\n"
				+ "\r\n");
			especifi.setBounds(150, 70, 550, 50);
			especifi.setEditable(false);
			especifi.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
			especifi.setBackground(Color.WHITE);
			especifi.setForeground(Color.BLACK);	
			
		radioButtonPico = new JRadioButton("Pico Celda (Exterior)");

			radioButtonPico.setBounds(150, 130, 550, 50);
			radioButtonPico.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonPico.setActionCommand("false");
			
		JTextArea especifi1 = new JTextArea("Frecuencia:		16 - 38 - 42 - 48 - 51 GHz\r\n"
				+ "Distancia del enlace:	100 – 200 m\r\n"
				+ "Altura de la antena receptora:	1.5 – 22.5 m\r\n"
				+ "\r\n");
			especifi1.setBounds(150, 190, 550, 75);
			especifi1.setEditable(false);
			especifi1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
			especifi1.setBackground(Color.WHITE);
			especifi1.setForeground(Color.BLACK);

		radioButtonMicro = new JRadioButton("Micro celda (Exterior)");

			radioButtonMicro.setBounds(150, 275, 550, 50);
			radioButtonMicro.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonMicro.setActionCommand("false");
			
		JTextArea especifi2 = new JTextArea("Frecuencia:		0.7 - 2.5 - 3.5 - 26 GHz\r\n"
				+ "Distancia del enlace:	200 - 2000 m\r\n"
				+ "Altura de la antena receptora:	1.5 – 22.5 m\r\n"
				+ "\r\n");
			especifi2.setBounds(150, 335, 550, 75);
			especifi2.setEditable(false);
			especifi2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
			especifi2.setBackground(Color.WHITE);
			especifi2.setForeground(Color.BLACK);

		radioButtonMacro = new JRadioButton("Macro celda (Exterior)");

			radioButtonMacro.setBounds(150, 420, 550, 50);
			radioButtonMacro.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonMacro.setActionCommand("false");
			
		JTextArea especifi3 = new JTextArea("Frecuencia:		0.7 - 2.5 - 3.5 GHz\r\n"
				+ "Distancia del enlace:	2 - 2 km\r\n"
				+ "Altura de la antena estación base:	25 – 50 m\r\n"
				+ "Altura de la antena receptora:	1.5 – 22.5 m\r\n"
				+ "Ancho de calle:	5 – 50 m\r\n"
				+ "Altura media del edificio:	5 – 50 m\r\n"
				+ "\r\n");
			especifi3.setBounds(150, 480, 550, 	150);
			especifi3.setEditable(false);
			especifi3.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
			especifi3.setBackground(Color.WHITE);
			especifi3.setForeground(Color.BLACK);
					
		buttonGroupType = new ButtonGroup();

			buttonGroupType.add(radioButtonFemto);
			buttonGroupType.add(radioButtonPico);
			buttonGroupType.add(radioButtonMicro);
			buttonGroupType.add(radioButtonMacro);

		
		JLabel JLabel3 = new JLabel();
			JLabel3.setIcon(new ImageIcon("C:\\Users\\jhons\\Desktop\\img2.png"));
			
			// campo de texto JTextArea
		texto2 = new JTextArea(17,40);
			texto2.setEditable(false);
			texto2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24));
			texto2.setBackground(new Color(60,60,60));
			texto2.setForeground(new Color(240,240,240));
			
		JScrollPane pScroll = new JScrollPane(texto2, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
			
		pDerImg.add(lableTop2, BorderLayout.PAGE_START);
		pDerImg.add(lableL2, BorderLayout.LINE_START);
		pDerImg.add(JLabel3, BorderLayout.CENTER);
		pDerImg.add(lableBut2, BorderLayout.PAGE_END);
		pDerImg.add(lableR2, BorderLayout.LINE_END);			
		
		pIzq.add(radioButtonFemto);
		pIzq.add(radioButtonPico);
		pIzq.add(radioButtonMicro);
		pIzq.add(radioButtonMacro);
		
		pIzq.add(especifi);
		pIzq.add(especifi1);
		pIzq.add(especifi2);
		pIzq.add(especifi3);
		
		pIzq.add(buttonUpload);
		pIzq.add(buttonSave);		
		
		pDer.add(graficaLd);
		pDer.add(pScroll);
		
		pTotal.add(pIzq);
		pTotal.add(pDer);
		
		this.add(lableTop, BorderLayout.PAGE_START);
		this.add(lableL, BorderLayout.LINE_START);
		this.add(pTotal, BorderLayout.CENTER);
		this.add(lableBut, BorderLayout.PAGE_END);
		this.add(lableR, BorderLayout.LINE_END);
	}
	
	class LimitJTextField extends PlainDocument {

		private static final long serialVersionUID = 1L;
		private int max;

		LimitJTextField(int max) {
			super();
			this.max = max;
		}

		public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
			if (text == null)
				return;
			if ((getLength() + text.length()) <= max) {
				super.insertString(offset, text, attr);
			}
		}
	}

}
