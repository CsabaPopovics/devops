package items;

import skeleton.Game;

public class Ammo extends Item {
	
	@Override
	public boolean use(String cmd) {
		if(cmd == "AddPart") {
			Game.addAmmo(this);
			return true;
		}
		return false;
	}
}
