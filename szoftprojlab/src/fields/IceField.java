package fields;

import characters.Pawn;
import items.Item;

public class IceField extends Field {
	protected boolean iglooState = false;
	protected Item item;
	
	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public void removeItem() {
		item = null;
		
	}
	
	@Override
	public boolean setIgloo() {
		if(iglooState == false) {
			iglooState = true;
			return true;
		}
		return false;
	}
	
	@Override
	public void updateSnow(int i) {
		super.updateSnow(i);
		if(i > 0 && !iglooState)
			for(Pawn p : characters)
				p.updateBodyTemp(-1);
	}

}
