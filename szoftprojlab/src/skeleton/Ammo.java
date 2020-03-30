package skeleton;

/**
 * Az Ammo osztály felelõssége, hogy amikor használják hozzájárul a jelzõrakéta összeszereléséhez.
 * Az Item osztályból származik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Ammo extends Item {
	
	/**
	 * Töltény felhasználása.
	 * @param cmd amire felhasználnák
	 * @return true ha összeszereléshez használják
	 */
	@Override
	public boolean use(String cmd) {
		if(cmd == "AddPart") {
			System.out.println(owner.getName() + " adds ammo.");
			owner.levelUp();
			return true;
		}
		return false;
	}
}
