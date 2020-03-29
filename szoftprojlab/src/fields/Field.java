package fields;

import java.util.ArrayList;
import java.util.Map;

import enums.Direction;
import items.Item;
import characters.*;

public abstract class Field {
	protected ArrayList<Pawn> characters;
	protected Map<Direction, Field> neighbours;
	
	protected int snowLevel;
	protected String name;
	
	public void accept(Pawn p) {
		characters.add(p);
	}
	
	public void remove(Pawn p) {
		characters.remove(p);
	}
	
	public abstract Item getItem();
	
	public Field getNeighbour(Direction d) {
		return neighbours.get(d);
	}
	
	public int getSnowLevel() {
		return snowLevel;
	}
	
	
	public void updateSnow(int i) {
		snowLevel += i;
	}
	
	public int getLoad() {
		return characters.size();
	}
	
	public int getLimit() {
		return 100;
	}
	
	public ArrayList<Pawn> getCharacters(){
		return characters;
	}

	public abstract void removeItem();

	public abstract boolean setIgloo();
	
	public String getName() {return name;}
}
