package mainPackage;

import java.awt.EventQueue;
import java.util.Random;
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
	private static int MAP_SIZE = 200;
	int intWolvesNum;
	int wolvesEnergy;
	int WolvesReproduction;
	int intSheepNum;
	int sheepEnergy;
	int sheepReproduction;
	Results resultsMenu;
	 static Main frame;
	static Patch[][] map = new Patch[200][200];
	/**
	 * Create the frame.
	 */
	public Main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//start at connectionMenu first
		Options optionMenu = new Options(this);
		resultsMenu = new Results(this);
		
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(optionMenu);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frame = new Main();
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
		
		
		frame.setContentPane(resultsMenu);
		frame.validate();
		
		initMap();
		placeAnimal("wolf",intWolvesNum);
		placeAnimal("sheep",intSheepNum);
		
		
		
		

	}
	
	/**
	 * initializing map of patches
	 */
	private static void initMap() {
		// Sets up starting patches by randomly selecting a section
		// of patches to be best land.
		for(int i = 0; i < MAP_SIZE; i++){
			for(int j = 0; j < MAP_SIZE; j++){
					map[i][j] = new Patch(i,j);
			}
		}
	}
	
	public void placeAnimal(String name,int num) {
		//Place people around map
				for (int j = 0; j < num; j++) {
					Animal animal = new Animal(name);
					Random rand = new Random(); 
					while(true) {	
						int x = rand.nextInt(MAP_SIZE);
						int y = rand.nextInt(MAP_SIZE);
						//Makes sure that there is only 1 person per patch
						if(map[x][y].animalsHere.size() == 0) {
							map[x][y].enter(animal);
							animal.setLocation(x, y);
							break;
						}else {
							System.out.println("Someone was already placed at "+x+","+y);
						}

					}
				}
	}
}
