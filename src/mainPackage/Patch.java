package mainPackage;

import java.util.ArrayList;

public class Patch {
	
	private int x , y;
	// The animals who targets here and are moving here
	ArrayList<Animal> animalsTarget = new ArrayList<Animal>();
	//Animals who are already here and eating
	ArrayList<Animal> animalsHere = new ArrayList<Animal>();

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

	public Patch(int i, int j) {
		// TODO Auto-generated constructor stub
		x = i;
		y = j;
	}
	
	/**
	 * Lets an animal enter this patch and updates the array of people here.
	 * @param p
	 */
	public void enter(Animal a) {
		animalsHere.add(a);

	}

}
