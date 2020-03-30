package skeleton;

/**
 * Fel lehet haszn�lni a jelz�f�ny �sszerak�s�hoz.
 * Az Item oszt�lyb�l sz�rmazik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Flare extends Item {
	
	/**
	 * A jelz�f�ny felhaszn�l�sa.
	 * @param cmd amire felhaszn�ln�k
	 * @return true ha �sszeszerel�shez haszn�lj�k
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
