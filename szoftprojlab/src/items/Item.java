package items;

import characters.Pawn;

public abstract class Item {
	private Pawn owner;
	
	public abstract boolean use(String cmd);
	
	public void setOwner(Pawn p) {
		owner = p;
	}
	
	public Pawn getOwner() {
		return owner;
	}

}
