package com.iavl.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class GrafiicaLD extends JPanel {
	

	public static ArrayList<ArrayList<Double> > aList = new ArrayList<ArrayList<Double>>(6);
	public static ArrayList<String> EjeX = new ArrayList<String>();
	public static String titulo;	
	public static String ejeX;	
	public static String ejeY;	
	public static int opc;
	private static final long serialVersionUID = 1L;
	
	public GrafiicaLD(String Titulo,String ejeX,String ejeY, ArrayList<ArrayList<Double> > aList, ArrayList<String> EjeX,int opc) {
		super();
		GrafiicaLD.aList = aList;
		GrafiicaLD.titulo = Titulo;
		GrafiicaLD.ejeX = ejeX;
		GrafiicaLD.ejeY = ejeY;
		GrafiicaLD.EjeX = EjeX;
		GrafiicaLD.opc = opc;
		JPanel content = createDemoPanel();
		add(content);

	}

	@SuppressWarnings("deprecation")
	public static JPanel createDemoPanel() {

		JFreeChart chart = ChartFactory.createLineChart(
				titulo,
				ejeX,
				ejeY,
				createDataset(),
				PlotOrientation.VERTICAL,
				true, true, false);

	
		final Shape[] shapes = new Shape[3];
        int[] xpoints;
        int[] ypoints;

        // right-pointing triangle
        xpoints = new int[] {-3, 3, -3};
        ypoints = new int[] {-3, 0, 3};
        shapes[0] = new Polygon(xpoints, ypoints, 3);

        // vertical rectangle
        shapes[1] = new Rectangle2D.Double(-2, -3, 3, 6);

        // left-pointing triangle
        xpoints = new int[] {-3, 3, 3};
        ypoints = new int[] {0, -3, 3};
        shapes[2] = new Polygon(xpoints, ypoints, 3);

        final DrawingSupplier supplier = new DefaultDrawingSupplier(
            DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
            shapes);
        
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setDrawingSupplier(supplier);
      
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.WHITE);
         
       
        chart.setBackgroundPaint(Color.LIGHT_GRAY);

        // set the stroke for each series...
        plot.getRenderer().setSeriesStroke(
            0, 
            new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
                1.0f, new float[] {10.0f, 6.0f}, 0.0f
            )
        );
        plot.getRenderer().setSeriesStroke(
            1, 
            new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f
            )
        );
        plot.getRenderer().setSeriesStroke(
            2, 
            new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {2.0f, 6.0f}, 0.0f
            )
        );

        // customise the renderer...
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setItemLabelsVisible(true);

        // customise the range axis...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(false);
        rangeAxis.setUpperMargin(0.12);

		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(640, 320));

		return chartPanel;
		
	}

	private static CategoryDataset createDataset() {
	
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

       switch(opc) {
       case 0:
    	   		dataset.addValue(1,"h", "b");
    	   break;
       case 1:
    	   	for(int j = 1; j < EjeX.size(); j++) {

	   			dataset.addValue(aList.get(0).get(j),"26", EjeX.get(j));
	   			dataset.addValue(aList.get(1).get(j),"38", EjeX.get(j));
	   			dataset.addValue(aList.get(2).get(j),"42", EjeX.get(j));
	   			dataset.addValue(aList.get(3).get(j),"48", EjeX.get(j));
	   			dataset.addValue(aList.get(4).get(j),"51", EjeX.get(j));
	   			dataset.addValue(aList.get(5).get(j),"Lim", EjeX.get(j));

   			}
    	  break;
       case 2:
    	   for(int j = 0; j < aList.get(0).size(); j++) {
	   			dataset.addValue(aList.get(0).get(j),"26", EjeX.get(j));
	   			dataset.addValue(aList.get(1).get(j),"38", EjeX.get(j));
	   			dataset.addValue(aList.get(2).get(j),"42", EjeX.get(j));
	   			dataset.addValue(aList.get(3).get(j),"48", EjeX.get(j));
	   			dataset.addValue(aList.get(4).get(j),"51", EjeX.get(j));
	   			dataset.addValue(aList.get(5).get(j),"Lim", EjeX.get(j));
  			}    	   
     	  break;
       case 3:
    	   for(int j = 0; j < aList.get(0).size(); j++) {
	   			dataset.addValue(aList.get(0).get(j),"0.7", EjeX.get(j));
	   			dataset.addValue(aList.get(1).get(j),"2.5", EjeX.get(j));
	   			dataset.addValue(aList.get(2).get(j),"3.5", EjeX.get(j));
	   			dataset.addValue(aList.get(3).get(j),"26", EjeX.get(j));
	   			dataset.addValue(aList.get(4).get(j),"Lim", EjeX.get(j));
  			} 
    	  break;
       case 4:
    	   for(int j = 0; j < aList.get(0).size(); j++) {
	  			dataset.addValue(aList.get(0).get(j),"0.7", EjeX.get(j));
	  			dataset.addValue(aList.get(1).get(j),"2.5", EjeX.get(j));
	  			dataset.addValue(aList.get(2).get(j),"3.5", EjeX.get(j));
	  			dataset.addValue(aList.get(3).get(j),"Lim", EjeX.get(j));
    	   } 
     	  break;
       }
    		
 
		return dataset;
	}
	

}