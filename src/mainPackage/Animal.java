package mainPackage;

import java.util.Random;

public class Animal {
	String name;
	int id = 0;
	int hierachID = 0;
	int energy = 0;
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	int reprodrate = 0;
	int x,y;
	
	/**
	 * add new energy value to current energy value
	 */
	public void addEnergy(int energy) {
		this.energy = this.energy + energy;
	}
	
	public Animal(String name,int id,int energy,int reprodrate,int hierachID) {
		this.name = name;
		this.id = id;
		
		//If animal is sheep, randomize energy else just set.
		if (hierachID == 1) {
			Random rand = new Random(); 
			int initialenergy = rand.nextInt(energy);
			this.energy = 1 + initialenergy;
		}else {
			this.energy = energy;
		}
		this.reprodrate = reprodrate;
		this.hierachID = hierachID;
	}

	public void setLocation(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Move and set new position
	 * @param x,y = new positions
	 */
	public void move(int x, int y){
		this.x = x;
		this.y = y;

	}
}
