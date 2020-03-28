package items;

import skeleton.Game;

public class Flare extends Item {
	
	@Override
	public boolean use(String cmd) {
		if(cmd == "AddPart") {
			Game.addFlare(this);
			return true;
		}
		return false;
	}
}
