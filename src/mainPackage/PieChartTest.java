package mainPackage;

import java.awt.BasicStroke;
import java.awt.Color;

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
public class PieChartTest extends JPanel{
    private static final long serialVersionUID = 1L;
    ChartPanel panel;

    public PieChartTest(String applicationTitle, String chartTitle) {
        super();
//        // This will create the dataset
//        PieDataset dataset = createDataset();
//        // based on the dataset we create the chart
//        JFreeChart chart = createChart(dataset, chartTitle);
//        // we put the chart into a panel
//        panel = new ChartPanel(chart);
//        // default size
//        panel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
       // setContentPane(chartPanel);
        
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, chartTitle);
        panel = new ChartPanel( chart);
        panel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot =chart.getXYPlot( );
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        plot.setRenderer( renderer ); 
    }

//    /**
//     * Creates a sample dataset
//     */
//    private  PieDataset createDataset() {
//        DefaultPieDataset result = new DefaultPieDataset();
//        result.setValue("Linux", 29);
//        result.setValue("Mac", 20);
//        result.setValue("Windows", 51);
//        return result;
//
//    }

    private XYDataset createDataset( ) {
        final XYSeries firefox = new XYSeries( "Firefox" );          
        firefox.add( 1.0 , 1.0 );          
        firefox.add( 2.0 , 4.0 );          
        firefox.add( 3.0 , 3.0 );          
        
        final XYSeries chrome = new XYSeries( "Chrome" );          
        chrome.add( 1.0 , 4.0 );          
        chrome.add( 2.0 , 5.0 );          
        chrome.add( 3.0 , 6.0 );          
        
        final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
        iexplorer.add( 3.0 , 4.0 );          
        iexplorer.add( 4.0 , 5.0 );          
        iexplorer.add( 5.0 , 4.0 );          
        
        final XYSeriesCollection dataset = new XYSeriesCollection( );          
        dataset.addSeries( firefox );          
        dataset.addSeries( chrome );          
        dataset.addSeries( iexplorer );
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
                createDataset() ,
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
