package mainPackage;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * 
 * @author Spikelcy
 *
 */
public class Options extends JPanel {
	
	private Main main;
	private JTextField sheepReproductionText;
	private JTextField intSheepNumText;
	private JTextField sheepEnergyText;
	private JTextField WolvesReproductionText;
	private JTextField wolvesEnergyText;
	private JTextField intWolvesNumText;
	private JTextField iterationsText;
	private JTextField iterationValue;

	/**
	 * Create the panel. Default values from NetLogo Model.
	 */
	public Options(Main main) {
		this.main= main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel panelName = new JLabel("Options");
		GridBagConstraints gbc_panelName = new GridBagConstraints();
		gbc_panelName.insets = new Insets(0, 0, 5, 5);
		gbc_panelName.gridx = 3;
		gbc_panelName.gridy = 0;
		add(panelName, gbc_panelName);
		
		JLabel wolvesLabel = new JLabel("Wolves Options");
		GridBagConstraints gbc_wolvesLabel = new GridBagConstraints();
		gbc_wolvesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_wolvesLabel.gridx = 1;
		gbc_wolvesLabel.gridy = 1;
		add(wolvesLabel, gbc_wolvesLabel);
		
		JLabel intWolvesNumLabel = new JLabel("Initial Number of Wolves");
		GridBagConstraints gbc_intWolvesNumLabel = new GridBagConstraints();
		gbc_intWolvesNumLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intWolvesNumLabel.gridx = 1;
		gbc_intWolvesNumLabel.gridy = 2;
		add(intWolvesNumLabel, gbc_intWolvesNumLabel);
		
		
		JSlider intWolvesNumSlider = new JSlider();
		intWolvesNumSlider.setMaximum(250);
		intWolvesNumSlider.setValue(30);
		GridBagConstraints gbc_intWolvesNumSlider = new GridBagConstraints();
		gbc_intWolvesNumSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_intWolvesNumSlider.gridwidth = 3;
		gbc_intWolvesNumSlider.insets = new Insets(0, 0, 5, 5);
		gbc_intWolvesNumSlider.gridx = 2;
		gbc_intWolvesNumSlider.gridy = 2;
		add(intWolvesNumSlider, gbc_intWolvesNumSlider);
		
		
		intWolvesNumText = new JTextField();
		intWolvesNumText.setEditable(false);
		GridBagConstraints gbc_intWolvesNumText = new GridBagConstraints();
		gbc_intWolvesNumText.insets = new Insets(0, 0, 5, 5);
		gbc_intWolvesNumText.fill = GridBagConstraints.HORIZONTAL;
		gbc_intWolvesNumText.gridx = 6;
		gbc_intWolvesNumText.gridy = 2;
		add(intWolvesNumText, gbc_intWolvesNumText);
		intWolvesNumText.setColumns(10);
		intWolvesNumText.setText(String.valueOf(intWolvesNumSlider.getValue()));
		
		/**
		 * Change text when slider changes for initial wolves number
		 */
		intWolvesNumSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		          intWolvesNumText.setText(String.valueOf(intWolvesNumSlider.getValue()));
		        }
		      });
		
		JLabel wolvesEnergyLabel = new JLabel("Energy Gain");
		GridBagConstraints gbc_wolvesEnergyLabel = new GridBagConstraints();
		gbc_wolvesEnergyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_wolvesEnergyLabel.gridx = 1;
		gbc_wolvesEnergyLabel.gridy = 3;
		add(wolvesEnergyLabel, gbc_wolvesEnergyLabel);
		
		JSlider wolvesEnergySlider = new JSlider();
		wolvesEnergySlider.setValue(13);
		wolvesEnergySlider.setMaximum(50);
		GridBagConstraints gbc_wolvesEnergySlider = new GridBagConstraints();
		gbc_wolvesEnergySlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_wolvesEnergySlider.gridwidth = 3;
		gbc_wolvesEnergySlider.insets = new Insets(0, 0, 5, 5);
		gbc_wolvesEnergySlider.gridx = 2;
		gbc_wolvesEnergySlider.gridy = 3;
		add(wolvesEnergySlider, gbc_wolvesEnergySlider);
		
		wolvesEnergyText = new JTextField();
		wolvesEnergyText.setEditable(false);
		GridBagConstraints gbc_wolvesEnergyText = new GridBagConstraints();
		gbc_wolvesEnergyText.insets = new Insets(0, 0, 5, 5);
		gbc_wolvesEnergyText.fill = GridBagConstraints.HORIZONTAL;
		gbc_wolvesEnergyText.gridx = 6;
		gbc_wolvesEnergyText.gridy = 3;
		add(wolvesEnergyText, gbc_wolvesEnergyText);
		wolvesEnergyText.setColumns(10);
		wolvesEnergyText.setText(String.valueOf(intWolvesNumSlider.getValue()));
		
		/**
		 * Change text when slider changes for wolves energy
		 */
		wolvesEnergySlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		    	  wolvesEnergyText.setText(String.valueOf(wolvesEnergySlider.getValue()));
		        }
		      });
		
		
		JLabel wolvesReproductionLabel = new JLabel("Reproduction %");
		GridBagConstraints gbc_wolvesReproductionLabel = new GridBagConstraints();
		gbc_wolvesReproductionLabel.fill = GridBagConstraints.VERTICAL;
		gbc_wolvesReproductionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_wolvesReproductionLabel.gridx = 1;
		gbc_wolvesReproductionLabel.gridy = 4;
		add(wolvesReproductionLabel, gbc_wolvesReproductionLabel);
		
		JSlider wolvesReproductionSlider = new JSlider();
		wolvesReproductionSlider.setValue(5);
		GridBagConstraints gbc_wolvesReproductionSlider = new GridBagConstraints();
		gbc_wolvesReproductionSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_wolvesReproductionSlider.gridwidth = 3;
		gbc_wolvesReproductionSlider.insets = new Insets(0, 0, 5, 5);
		gbc_wolvesReproductionSlider.gridx = 2;
		gbc_wolvesReproductionSlider.gridy = 4;
		add(wolvesReproductionSlider, gbc_wolvesReproductionSlider);
		
		WolvesReproductionText = new JTextField();
		WolvesReproductionText.setEditable(false);
		GridBagConstraints gbc_WolvesReproductionText = new GridBagConstraints();
		gbc_WolvesReproductionText.insets = new Insets(0, 0, 5, 5);
		gbc_WolvesReproductionText.fill = GridBagConstraints.HORIZONTAL;
		gbc_WolvesReproductionText.gridx = 6;
		gbc_WolvesReproductionText.gridy = 4;
		add(WolvesReproductionText, gbc_WolvesReproductionText);
		WolvesReproductionText.setColumns(10);
		WolvesReproductionText.setText(String.valueOf(intWolvesNumSlider.getValue()));
		
		/**
		 * Change text when slider changes for wolvesReproductionSlider
		 */
		wolvesReproductionSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		    	  WolvesReproductionText.setText(String.valueOf(wolvesReproductionSlider.getValue()));
		        }
		      });
		
		
		
		JLabel sheepLabel = new JLabel("Sheep Options");
		GridBagConstraints gbc_sheepLabel = new GridBagConstraints();
		gbc_sheepLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sheepLabel.gridx = 1;
		gbc_sheepLabel.gridy = 5;
		add(sheepLabel, gbc_sheepLabel);
		
		JLabel intSheepNumLabel = new JLabel("Initial Number of Sheep");
		GridBagConstraints gbc_intSheepNumLabel = new GridBagConstraints();
		gbc_intSheepNumLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intSheepNumLabel.gridx = 1;
		gbc_intSheepNumLabel.gridy = 6;
		add(intSheepNumLabel, gbc_intSheepNumLabel);
		
		JSlider intSheepNumSlider = new JSlider();
		intSheepNumSlider.setMaximum(250);
		intSheepNumSlider.setValue(100);
		GridBagConstraints gbc_intSheepNumSlider = new GridBagConstraints();
		gbc_intSheepNumSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_intSheepNumSlider.gridwidth = 3;
		gbc_intSheepNumSlider.insets = new Insets(0, 0, 5, 5);
		gbc_intSheepNumSlider.gridx = 2;
		gbc_intSheepNumSlider.gridy = 6;
		add(intSheepNumSlider, gbc_intSheepNumSlider);
		
		intSheepNumText = new JTextField();
		intSheepNumText.setEditable(false);
		GridBagConstraints gbc_intSheepNumText = new GridBagConstraints();
		gbc_intSheepNumText.fill = GridBagConstraints.BOTH;
		gbc_intSheepNumText.insets = new Insets(0, 0, 5, 5);
		gbc_intSheepNumText.gridx = 6;
		gbc_intSheepNumText.gridy = 6;
		add(intSheepNumText, gbc_intSheepNumText);
		intSheepNumText.setColumns(10);
		intSheepNumText.setText(String.valueOf(intWolvesNumSlider.getValue()));
		
		/**
		 * Change text when slider changes for intSheepNumSlider
		 */
		intSheepNumSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		    	  intSheepNumText.setText(String.valueOf(intSheepNumSlider.getValue()));
		        }
		      });
		
		
		JLabel sheepEnergyLabel = new JLabel("Max Initial Energy");
		GridBagConstraints gbc_sheepEnergyLabel = new GridBagConstraints();
		gbc_sheepEnergyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sheepEnergyLabel.gridx = 1;
		gbc_sheepEnergyLabel.gridy = 7;
		add(sheepEnergyLabel, gbc_sheepEnergyLabel);
		
		JSlider sheepEnergySlider = new JSlider();
		sheepEnergySlider.setValue(4);
		GridBagConstraints gbc_sheepEnergySlider = new GridBagConstraints();
		gbc_sheepEnergySlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_sheepEnergySlider.gridwidth = 3;
		gbc_sheepEnergySlider.insets = new Insets(0, 0, 5, 5);
		gbc_sheepEnergySlider.gridx = 2;
		gbc_sheepEnergySlider.gridy = 7;
		add(sheepEnergySlider, gbc_sheepEnergySlider);
		
		sheepEnergyText = new JTextField();
		sheepEnergyText.setEditable(false);
		GridBagConstraints gbc_sheepEnergyText = new GridBagConstraints();
		gbc_sheepEnergyText.insets = new Insets(0, 0, 5, 5);
		gbc_sheepEnergyText.fill = GridBagConstraints.HORIZONTAL;
		gbc_sheepEnergyText.gridx = 6;
		gbc_sheepEnergyText.gridy = 7;
		add(sheepEnergyText, gbc_sheepEnergyText);
		sheepEnergyText.setColumns(10);
		sheepEnergyText.setText(String.valueOf(intWolvesNumSlider.getValue()));
		
		/**
		 * Change text when slider changes for sheepEnergySlider
		 */
		sheepEnergySlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		    	  sheepEnergyText.setText(String.valueOf(sheepEnergySlider.getValue()));
		        }
		      });
		
		
		JLabel sheepReproductionLabel = new JLabel("Reproduction %");
		GridBagConstraints gbc_sheepReproductionLabel = new GridBagConstraints();
		gbc_sheepReproductionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sheepReproductionLabel.gridx = 1;
		gbc_sheepReproductionLabel.gridy = 8;
		add(sheepReproductionLabel, gbc_sheepReproductionLabel);
		
		JSlider sheepReproductionSlider = new JSlider();
		sheepReproductionSlider.setValue(4);
		GridBagConstraints gbc_sheepReproductionSlider = new GridBagConstraints();
		gbc_sheepReproductionSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_sheepReproductionSlider.gridwidth = 3;
		gbc_sheepReproductionSlider.insets = new Insets(0, 0, 5, 5);
		gbc_sheepReproductionSlider.gridx = 2;
		gbc_sheepReproductionSlider.gridy = 8;
		add(sheepReproductionSlider, gbc_sheepReproductionSlider);
		
		sheepReproductionText = new JTextField();
		sheepReproductionText.setEditable(false);
		GridBagConstraints gbc_sheepReproductionText = new GridBagConstraints();
		gbc_sheepReproductionText.fill = GridBagConstraints.HORIZONTAL;
		gbc_sheepReproductionText.insets = new Insets(0, 0, 5, 5);
		gbc_sheepReproductionText.gridx = 6;
		gbc_sheepReproductionText.gridy = 8;
		add(sheepReproductionText, gbc_sheepReproductionText);
		sheepReproductionText.setColumns(10);
		sheepReproductionText.setText(String.valueOf(intWolvesNumSlider.getValue()));
		
		/**
		 * Change text when slider changes for sheepEnergySlider
		 */
		sheepReproductionSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		    	  sheepReproductionText.setText(String.valueOf(sheepReproductionSlider.getValue()));
		        }
		      });
		
		//Not Working yet
		iterationsText = new JTextField();
		iterationsText.setEditable(false);
		GridBagConstraints gbc_iterationsText = new GridBagConstraints();
		gbc_iterationsText.insets = new Insets(0, 0, 5, 5);
		gbc_iterationsText.fill = GridBagConstraints.HORIZONTAL;
		gbc_iterationsText.gridx = 1;
		gbc_iterationsText.gridy = 10;
		add(iterationsText, gbc_iterationsText);
		iterationsText.setColumns(10);
		
		iterationValue = new JTextField();
		iterationValue.setText("30");
		GridBagConstraints gbc_iterationValue = new GridBagConstraints();
		gbc_iterationValue.insets = new Insets(0, 0, 5, 5);
		gbc_iterationValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_iterationValue.gridx = 3;
		gbc_iterationValue.gridy = 10;
		add(iterationValue, gbc_iterationValue);
		iterationValue.setColumns(10);
		
		
		JButton startButton = new JButton("Start");
		GridBagConstraints gbc_startButton = new GridBagConstraints();
		gbc_startButton.insets = new Insets(0, 0, 5, 5);
		gbc_startButton.gridx = 8;
		gbc_startButton.gridy = 11;
		add(startButton, gbc_startButton);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int wolvesNum = intWolvesNumSlider.getValue();
				int wolvesEn = wolvesEnergySlider.getValue();
				int wolvesRep = wolvesReproductionSlider.getValue();
				int sheepNum =  intSheepNumSlider.getValue();
				int sheepEn = sheepEnergySlider.getValue();
				int sheepRep = sheepReproductionSlider.getValue();
				main.start(wolvesNum,wolvesEn,wolvesRep,sheepNum,sheepEn,sheepRep);
			}
		});
		
	}

}
