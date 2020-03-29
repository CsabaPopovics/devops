package fields;

import characters.*;
import items.Item;

public class Hole extends Field {
	@Override
	public void accept(Pawn p) {
		super.accept(p);
		p.fallIntoWater();
	}
	
	@Override
	public void updateSnow(int i) {
		super.updateSnow(i);
		if(i < 0) {
			for(Pawn p : characters)
				p.updateBodyTemp(-1);
		}
	}

	@Override
	public Item getItem() {
		return null;
	}

	@Override
	public void removeItem() {
		return;
	}
	
	@Override
	public int getLimit() {return 0;}
}
