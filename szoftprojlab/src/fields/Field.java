package fields;

import java.util.ArrayList;
import java.util.Map;

import enums.Direction;
import characters.*;

public class Field {
	private ArrayList<Pawn> characters;
	private Map<Direction, Field> neighbours;
	
	private int snowLevel;
	private int limit = 100;
	
	public void accept(Pawn p) {
		characters.add(p);
	}
	
	public void remove(Pawn p) {
		characters.remove(p);
	}
	
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
		return limit;
	}
	
	public ArrayList<Pawn> getCharacters(){
		return characters;
	}
}
