package characters;

import enums.Direction;

import fields.*;

public class Researcher extends Pawn {
	
	public Researcher(String name) {
		super(name);
	}

	public void inspect(Direction d) {
		Field inspectedField = field.getNeighbour(d);
		if(inspectedField != null) {
			inspectedField.getLimit();
			inspectedField.getLoad();
		}
	}

}
