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
	int intWolvesNum;
	int wolvesEnergy;
	int WolvesReproduction;
	int intSheepNum;
	int sheepEnergy;
	int sheepReproduction;
	static Patch[][] map = new Patch[200][200];
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
	
	public void start(int wolvnum,int wolven,int wolvrec,int shnum,int shen,int sherep) {
		intWolvesNum = wolvnum;
		wolvesEnergy = wolven;
		WolvesReproduction = wolvrec;
		intSheepNum = shnum;
		sheepEnergy = shen;
		sheepReproduction = sherep;
		
		System.out.println(intWolvesNum);
		System.out.println(map.length);
	}
}
