package fields;

import java.util.Random;

import characters.Pawn;
import skeleton.Game;

public class UnstableIceField extends IceField {
	private int limit;
	
	public void setLimit() {
		Random r = new Random();
		limit = r.nextInt(Game.getPlayerCount());
	}
	
	@Override
	public int getLimit() {
		return limit;
	}
	
	public void flip() {
		for(Pawn p : characters)
			p.fallIntoWater();
	}
	
	@Override
	public void accept(Pawn p) {
		super.accept(p);
		if(characters.size()>limit)
			flip();
	}
	
	

}
