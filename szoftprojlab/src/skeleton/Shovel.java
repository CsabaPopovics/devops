package skeleton;

/**
 * Felhasználásával két egység hó takarítható el egy helyett.
 * Az Item osztályból származik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Shovel extends Item {

	/**
	 * Ásó használata, helyesen felhasználva 2 egység hó is eltakarítható.
	 * @param cmd amire használni akarja a tulajdonos
	 * @return true ha takarításra használják, egyébként false
	 */
	@Override
	public boolean use(String cmd) {
		if(owner != null && owner.getField() != null) {
			if(cmd == "Clear") {
				System.out.println(owner.getName() + " uses a shovel to clear an extra unit of snow.");
				owner.getField().updateSnow(-1);
				return true;
			}
			return false;
		}
		return false;
	}

}
