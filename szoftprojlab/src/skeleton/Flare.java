package skeleton;

/**
 * Fel lehet használni a jelzõfény összerakásához.
 * Az Item osztályból származik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Flare extends Item {
	
	/**
	 * A jelzõfény felhasználása.
	 * @param cmd amire felhasználnák
	 * @return true ha összeszereléshez használják
	 */
	@Override
	public boolean use(String cmd) {
		if(cmd == "AddPart") {
			System.out.println(owner.getName() + " adds flare.");
			owner.levelUp();
			return true;
		}
		return false;
	}
}
