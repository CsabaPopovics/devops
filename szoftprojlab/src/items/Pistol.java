package items;

import skeleton.Game;

public class Pistol extends Item {
	
	@Override
	public boolean use(String cmd) {
		if(cmd == "AddPart") {
			Game.addPistol(this);
			return true;
		}
		return false;
	}

}
