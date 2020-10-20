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
	

	/**
	 * Updates the array of animals targeting this patch with a new animal.
	 * @param p
	 */
	public void target(Animal a) {
		animalsTarget.add(a);

	}
	
	/**
	 * Moves animals from animalTarget to animalHere
	 */
	public void targetToPatch() {

		animalsHere.clear();
		animalsHere = animalsTarget;
		animalsTarget = new ArrayList<Animal>();

	}
	
	/**
	 * Moves all animal children from Target to animalHere. Only to be used after reproduce().
	 */
	public void addchildrenToPatch() {
		animalsHere.addAll(animalsTarget);
		animalsTarget = new ArrayList<Animal>();
	}

	public int getWolves() {
		// TODO Auto-generated method stub
		int count = 0;
		 for (int k = 0; k < animalsHere.size(); k++) {
			 Animal animal = animalsHere.get(k);
			 if (animal.hierachID == 2) {
				 count++;
			 }
		 }
		return count;
	}

	public int getSheep() {
		// TODO Auto-generated method stub
		int count = 0;
		 for (int k = 0; k < animalsHere.size(); k++) {
			 Animal animal = animalsHere.get(k);
			 if (animal.hierachID == 1) {
				 count++;
			 }
		 }
		return count;	
		}

	public void removeSheep(int num) {
		// TODO Auto-generated method stub
		int count = 0;
		ArrayList<Animal> removeAnimals = new ArrayList<Animal>();
		System.out.println("Patch "+ x +" "+ y +" now has animals: "+animalsHere.size());
		 for (int k = 0; k < animalsHere.size(); k++) {
			 Animal animal = animalsHere.get(k);
			 if (animal.hierachID == 1) {
				 System.out.println("Animal "+animal.id+" of type: "+animal.hierachID +" has been eaten");
				 removeAnimals.add(animal);
				 count++;
				 System.out.println("Count increases: "+count);
			 }
			 if (count == num) {
				 System.out.println("Count is: "+count+". Num is: "+ num);
				 break;
			 }
		 }
		 animalsHere.removeAll(removeAnimals);
		 System.out.println("Patch "+ x +" "+ y +" now has animals: "+animalsHere.size());
	}



}
