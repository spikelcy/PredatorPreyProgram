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
	private static int TICKS = 100;
	int intWolvesNum;
	int wolvesEnergy;
	int WolvesReproduction;
	int intSheepNum;
	int sheepEnergy;
	int sheepReproduction;
	Results resultsMenu;
	 static Main frame;
	static Patch[][] map = new Patch[200][200];
	// Storing the newest person's id, make sure all person have unique ID
		static int lastID = 0;
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
		
		
		//run simulation of movement
		//Run the model for the pre-defined number of ticks
				for (int i = 0; i < TICKS;i++) {
					System.out.println("----------------------------------------------------------");
					System.out.println("Tick "+i);
					// Simulate each tick
					tickFunctions(i);
					// update people in patches
					targetToPatch();
				}
		
		
		
		

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
					Animal animal = new Animal(name,lastID++);
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
	
	
	private static void pickDirection(Animal animal) {
		
	}
	/**
	 * Move from one patch to another based on random direction
	 * @param person
	 * @param movement
	 */
	private static void move(Animal animal) {
		int x = animal.getX();
		int y = animal.getY();
		Random rand = new Random();
		System.out.println("Animal "+animal.id+" is at pos x: "+x+"and pos y:"+y);
		do {
			x = animal.getX();
			y = animal.getY();
			// 0 = N, 1 = S, 2 = E, 3 = W
			int directionNum = rand.nextInt(4);
			System.out.println("number:"+directionNum);
			switch(directionNum) {
			  case 0:
			    y++;
			    break;
			  case 1:
			    y--;
			    break;
			  case 2:
			    x++;
			    break;
			  case 3:
				x--;
				break;
			}
			System.out.println("Animal "+animal.id+" wants to move to pos x:"+x+"and pos y:"+y);
			}
			while (x > 199 || y > 199 || x < 0 || y < 0);
		
			animal.move(x,y);
			//Add this person to people target in new Patch
			map[x][y].animalsTarget.add(animal);
	}
	
	/**
	 * Move animal from animalTarget to animalHere in patch
	 */
	private static void targetToPatch() {

		//System.out.println("Update people in patches");
		for(int i = 0; i < MAP_SIZE; i++){
			for(int j = 0; j < MAP_SIZE; j++){
				map[i][j].targetToPatch();
			}
		}
	}
	
	/**
	 * Performs a set of functions the model needs to do in a tick.
	 * 
	 * @param the current tick
	 */
	private static void tickFunctions(int tick) {
		
		//Loop every patch
		for(int i = 0; i < MAP_SIZE; i++){
			for(int j = 0; j < MAP_SIZE; j++){
				Patch currentPatch = map[i][j];
				int numPeople = currentPatch.animalsHere.size();
				if (numPeople != 0) {
					for (int k = 0; k < numPeople; k++) {
						Animal animal = currentPatch.animalsHere.get(k);
						move(animal);
					}		        	
				}
				
				}
			}
		}

}