package fields;

import items.Item;

public class IceField extends Field {
	private boolean iglooState = false;
	private Item item;
	
	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public void removeItem() {
		item = null;
		
	}
	
	public boolean setIgloo() {
		if(iglooState == false) {
			iglooState = true;
			return true;
		}
		return false;
	}

}
