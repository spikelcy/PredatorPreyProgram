package mainPackage;

import java.awt.EventQueue;
import java.util.ArrayList;
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
	private static int TICKS = 5;
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
		placeAnimal("wolf",intWolvesNum,wolvesEnergy,WolvesReproduction,2);
		placeAnimal("sheep",intSheepNum,sheepEnergy,sheepReproduction,1);
		
		
		//run simulation of movement
		//Run the model for the pre-defined number of ticks
				for (int i = 0; i < TICKS;i++) {
					System.out.println("----------------------------------------------------------");
					System.out.println("Tick "+i);
					// Simulate each tick
					tickFunctions(i);
					// update animal in patches
					targetToPatch();
					//get wolves to attempt to catch a sheep
					catchSheep();
					//check death
					death();
					//reproduce
					reproduce();
					//add all newly made & moved children to their patches
					childrenTargetToPatch();

					
				}
		
		
		
		

	}
	
	private void catchSheep() {
		// TODO Auto-generated method stub
		for(int i = 0; i < MAP_SIZE; i++){
			for(int j = 0; j < MAP_SIZE; j++){
					Patch currentPatch = map[i][j];
					//get number of wolves and sheep
					int wolves = currentPatch.getWolves();
					int sheep = currentPatch.getSheep();
					//Remove Sheep based on number of wolves
					if (wolves != 0 && sheep != 0) {
						currentPatch.removeSheep(sheep);
					}
			}
		}
	}

	private void reproduce() {
		// TODO Auto-generated method stub
				for(int i = 0; i < MAP_SIZE; i++){
					for(int j = 0; j < MAP_SIZE; j++){
						Patch currentPatch = map[i][j];
				    	int numAnimals = currentPatch.animalsHere.size();
				    	   if (numAnimals != 0) {
				    		   for (int k = 0; k < numAnimals; k++) {
				    			   Animal animal = currentPatch.animalsHere.get(k);
				    			   Random rand = new Random();
				    			   int num = rand.nextInt(101);
				    			   // if num is within reproduction rate, reproduce
				    			   if (num <= animal.reprodrate ) {
				    				   //System.out.println("Animal "+animal.id+" of type: "+animal.hierachID +" reproduces");
				    				   //set energy of animal to half
				    				   //System.out.println("Animal "+animal.id+" of type: "+animal.hierachID +" has energy: "+animal.getEnergy());
				    				   int newEnergy = (animal.getEnergy()/2);
				    				   animal.setEnergy(newEnergy);
				    				  // System.out.println("Animal "+animal.id+" of type: "+animal.hierachID +" has new energy: "+animal.getEnergy());
				    				   Animal newAnimal;
				    				   //make new animal and move it.
				    				   //Use attributes based on heirchID
				    				   if (animal.hierachID == 1) {
				    					   newAnimal = new Animal("sheep",lastID++,sheepEnergy,sheepReproduction,1);
				    				   }else {
				    					   newAnimal = new Animal("wolf",lastID++,wolvesEnergy,WolvesReproduction,2);
				    				   }
				    				   
				    				   newAnimal.setX(animal.getX());
				    				   newAnimal.setY(animal.getY());
				    				   
				    				   move(newAnimal);
				    			   }
				    		   }
				    	   }
					}
				}
		
	}

	private void death() {
		// TODO Auto-generated method stub
		for(int i = 0; i < MAP_SIZE; i++){
			for(int j = 0; j < MAP_SIZE; j++){
				Patch currentPatch = map[i][j];
		    	int numAnimals = currentPatch.animalsHere.size();
		    	ArrayList<Animal> removeAnimals = new ArrayList<Animal>();
		    	   if (numAnimals != 0) {
		    		   System.out.println("Patch "+ i +" "+ j +" checking death!");
		    		   System.out.println("Patch "+ i +" "+ j +" now has animals: "+currentPatch.animalsHere.size());
		    		   for (int k = 0; k < numAnimals; k++) {
		    			   Animal animal = currentPatch.animalsHere.get(k);
		    			   // if num is within reproduction rate, reproduce
		    			   // 10 for testing
		    			   if (animal.getEnergy() <= 0) {
		    				   System.out.println("Animal "+animal.id+" of type: "+animal.hierachID +" dies");
		    				   System.out.println("Animal "+animal.id+" of type: "+animal.hierachID +" has energy: "+animal.getEnergy());
		    				   removeAnimals.add(animal);
		    			   }
		    		   }
	
		    		   currentPatch.animalsHere.removeAll(removeAnimals);
		    		   System.out.println("Patch "+ i +" "+ j +" now has animals: "+currentPatch.animalsHere.size());

		    	   }
			}
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
	
	public void placeAnimal(String name,int num,int energy,int reprodrate,int heircID) {
		//Place people around map
				for (int j = 0; j < num; j++) {
					Animal animal = new Animal(name,lastID++,energy,reprodrate,heircID);
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
	
	
	/**
	 * Move from one patch to another based on random direction
	 * @param person
	 * @param movement
	 */
	private static void move(Animal animal) {
		int x = animal.getX();
		int y = animal.getY();
		Random rand = new Random();
		
		//if animal is not the lowest on the hierarchy, lose 1 energy on move)
		if (animal.hierachID > 1) {
			int newEnergy = animal.getEnergy() - 1;
			animal.setEnergy(newEnergy);
		}
		//System.out.println("Animal "+animal.id+" is at pos x: "+x+"and pos y:"+y);
		do {
			x = animal.getX();
			y = animal.getY();
			// 0 = N, 1 = S, 2 = E, 3 = W
			int directionNum = rand.nextInt(4);
			//System.out.println("number:"+directionNum);
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
			//System.out.println("Animal "+animal.id+" of hierch: "+animal.hierachID +" wants to move to pos x:"+x+"and pos y:"+y);
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
	 * Move animal children from animalTarget to animalHere in patch
	 */
	private static void childrenTargetToPatch() {

		//System.out.println("Update people in patches");
		for(int i = 0; i < MAP_SIZE; i++){
			for(int j = 0; j < MAP_SIZE; j++){
				map[i][j].addchildrenToPatch();;
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
