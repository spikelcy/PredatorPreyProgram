package mainPackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

// Testing XYPlot without renaming file
public class GraphPlot extends JPanel{
    private static final long serialVersionUID = 1L;
    ChartPanel panel;

    public GraphPlot(String applicationTitle, String chartTitle,
    		ArrayList<Integer> wolvesCount,ArrayList<Integer> sheepCount,int ticks) {
        super();

        
        XYDataset dataset = createDataset(wolvesCount,sheepCount,ticks);
        JFreeChart chart = createChart(dataset, chartTitle);
        panel = new ChartPanel( chart);
        panel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot =chart.getXYPlot( );
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesStroke( 0 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        plot.setRenderer( renderer ); 
    }


    private XYDataset createDataset(ArrayList<Integer> wolvesCount,ArrayList<Integer> sheepCount,
    		int ticks ) {
        final XYSeries wolves = new XYSeries( "Wolves" );
        final XYSeries sheep = new XYSeries( "Sheep" );
    	for(int i = 0; i < ticks; i++){
    		wolves.add(i+1,wolvesCount.get(i));
    		sheep.add(i+1,sheepCount.get(i));
    		
    	}
        
        final XYSeriesCollection dataset = new XYSeriesCollection( );          
        dataset.addSeries( wolves );          
        dataset.addSeries( sheep );          
        return dataset;
     }
    /**
     * Creates a chart
     */
    private JFreeChart createChart(XYDataset dataset, String title) {

        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                title ,
                "Category" ,
                "Score" ,
                dataset,
                PlotOrientation.VERTICAL ,
                true , true , false);
        
        
        //PiePlot3D plot = (PiePlot3D) chart.getPlot();
        //plot.setStartAngle(290);
        //plot.setDirection(Rotation.CLOCKWISE);
        //plot.setForegroundAlpha(0.5f);
 
        return xylineChart;

    }
    
    /**
     * @return the panel to display
     */
    public ChartPanel getChart() {
		return panel;
    	
    }
}
