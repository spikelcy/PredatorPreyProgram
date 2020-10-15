package mainPackage;

public class Animal {
	String name;
	int id = 0;
	int hierachID = 0;
	int energy = 0;
	int reprodrate = 0;
	int x,y;
	
	public Animal(String name,int id,int energy,int reprodrate,int hierachID) {
		this.name = name;
		this.id = id;
		this.energy = energy;
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
