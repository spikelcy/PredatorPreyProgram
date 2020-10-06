package mainPackage;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JSlider;

public class Options extends JPanel {
	
	private Main main;

	/**
	 * Create the panel.
	 */
	public Options(Main main) {
		this.main= main;
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextPane txtpnWolfOptions = new JTextPane();
		txtpnWolfOptions.setText("Wolf Options");
		add(txtpnWolfOptions);
		
		JSlider slider = new JSlider();
		add(slider);
	}

}
