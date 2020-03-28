package fields;

import java.util.Random;

import skeleton.Game;

public class UnstableIceField extends IceField {
	private int limit;
	
	public UnstableIceField() {
		setLimit();
	}
	
	private void setLimit() {
		Random r = new Random();
		limit = r.nextInt(Game.getPlayerCount());
	}
	
	@Override
	public int getLimit() {
		return limit;
	}

}
