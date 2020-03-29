package characters;

import java.util.ArrayList;

import fields.*;
import items.*;
import skeleton.Game;
import enums.*;

public class Pawn {
	private int bodyTemp;
	//private int workUnit = 4;
	//private boolean done = false;
	
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
	
	public void addPart(Item i) {
		i.use("AddPart");
	}
	
	public void fire() {
		Game.checkConditions();
	}
	
	public void assembleGun() {
		for(Item i : inventory) {
			addPart(i);
		}
		for(Pawn p : theOthers) {
			for(Item ti : inventory) {
				p.addPart(ti);
			}
		}
		fire();
		workUnit--;
	}
	
	public void die() {
		Game.end();
	}
	
	public void fallIntoWater() {
		for(Item i : inventory) {
			if(putOn(i))
				return;
		}
		boolean saved = cryForHelp();
		if(!saved)
			die();
		
	}
	
	public boolean putOn(Item i) {
		return i.use("PutOn");
	}
	
	public boolean cryForHelp() {
		for(Direction d : Direction.values()) {
			ArrayList<Pawn> mySaviors = field.getNeighbour(d).getCharacters();
			for(Pawn savior : mySaviors) {
				if(savior.rescue(this))
					return true;
			}
			
		}
		return false;
	}
	
	public boolean rescue(Pawn p) {
		for(Item i : inventory) {
			if(throwRope(i, p))
				return true;
		}
		return false;
	}
	
	public boolean throwRope(Item i, Pawn p) {
		if(i.use("Throw")) {
			p.getField().remove(p);
			field.accept(p);
			return true;
		}
		return false;
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void updateBodyTemp(int i) {
		bodyTemp += i;
		if(bodyTemp <= 0)
			die();
	}
	
	public Field getField() {
		return field;
	}
	
	public void removeItem(Item i) {
		inventory.remove(i);
	}

	/*
	public void command() {
		
		while(!done && workUnit > 0) {
		}
	}
	
	public void finish() {
		done = true;
	}*/
	
	/*public void choose(char c) {
		switch(c) {
		case 'W':
		case 'w': 
			step(Direction.Up);
			break;
		case 'A':
		case 'a':
			step(Direction.Left);
			break;
		case 'S':
		case 's':
			step(Direction.Down);
			break;
		case 'D':
		case 'd':
			step(Direction.Right);
			break;
		case 'E':
		case 'e':
			
		}
	}*/
	
	

}
