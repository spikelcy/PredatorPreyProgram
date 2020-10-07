package mainPackage;

import java.awt.EventQueue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * 
 * @author Spikelcy
 *
 */
public class Main extends JFrame {
	
	
	
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public Main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//start at connectionMenu first
		Options optionMenu = new Options(this);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(optionMenu);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Main frame = new Main();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
