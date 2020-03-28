package characters;

import java.util.ArrayList;

import fields.*;
import items.*;
import enums.*;

public class Pawn {
	private int bodyTemp;
	private int workUnit = 4;
	
	private Field field;
	private ArrayList<Pawn> theOthers = field.getCharacters();
	private ArrayList<Item> inventory = null;
	
	public void step(Direction d) {
		Field destination = field.getNeighbour(d);
		if(destination != null) {
			field.remove(this);
			destination.accept(this);
			workUnit--;
		}
	}
	
	public void clearSnow(Item i) {
		i.use("Clear");
		field.updateSnow(-1);
	}
	
	public void excavate() {
		Item excavatedItem = field.getItem();
		if(excavatedItem != null) {
			addToInventory(excavatedItem);
			field.removeItem();
			workUnit--;
		}
		return;
	}
	
	public void addToInventory(Item i) {
		inventory.add(i);
	}
	
	
	public void updateBodyTemp(int i) {
		bodyTemp += i;
	}
	
	public Field getField() {
		return field;
	}
	
	public void removeItem(Item i) {
		inventory.remove(i);
	}

	public void command() {
		boolean done = false;
		
		while(!done && workUnit > 0) {
			
		}
	}

}
