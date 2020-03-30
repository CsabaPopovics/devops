package skeleton;

/**
 * Vízbeesett karakter nem hal meg.
 * Az Item osztályból származik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class ScubaSuit extends Item {
	/**
	 * Búvárruha felhasználása a vízbeesés túlélésére
	 * @param cmd amire felhasználnák
	 * @return true ha felveszik ruhaként
	 */
	@Override
	public boolean use(String cmd) {
		if(cmd == "PutOn") return true;
		return false;
	}

}
