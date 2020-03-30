package skeleton;

/**
 * Másik játékos kimentésénél lehet felhasználni.
 * Az Item osztályból származik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Rope extends Item {

	/**
	 * Kötél használata, vízbe esett karakter kiemenekítésére.
	 * @param cmd amire felhasználnák
	 * @return true ha dobni akarják
	 */
	@Override
	public boolean use(String cmd) {
		if(cmd == "Throw") return true;
		return false;
	}

}
