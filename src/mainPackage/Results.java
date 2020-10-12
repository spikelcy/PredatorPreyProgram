package mainPackage;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;

public class Results extends JPanel {
	private JTextField txtThisWorks;
	

	/**
	 * Create the panel.
	 * @param main 
	 */
	public Results(Main main) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtThisWorks = new JTextField();
		txtThisWorks.setText("This Works!");
		GridBagConstraints gbc_txtThisWorks = new GridBagConstraints();
		gbc_txtThisWorks.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtThisWorks.gridx = 6;
		gbc_txtThisWorks.gridy = 0;
		add(txtThisWorks, gbc_txtThisWorks);
		txtThisWorks.setColumns(10);

	}


}
