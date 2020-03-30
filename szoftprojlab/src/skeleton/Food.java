package skeleton;

/**
 * A felelõssége az, hogy ha a játékos használja akkor a testhõmérséklete eggyel növekszik.
 * Az Item osztályból származik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Food extends Item {
	
	/**
	 * Étel felhasználása.
	 * @param cmd amire felhasználnák
	 * @return true ha evésre használják
	 */
	@Override
	public boolean use(String cmd) {
		if(cmd == "Eat") {
			owner.updateBodyTemp(1);
			owner.removeItem(this);
			return true;
		}
		return false;
	}
}
