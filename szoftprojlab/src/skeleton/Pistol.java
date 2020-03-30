package skeleton;

/**
 * Fel lehet haszn�lni a jelz�f�ny �sszerak�s�hoz.
 * Az Item oszt�lyb�l sz�rmazik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Pistol extends Item {
	
	/**
	 * Pisztoly felhaszn�l�sa �sszeszerel�shez.
	 * @param cmd amire felhaszn�ln�k
	 * @return true ha �sszeszerel�shez haszn�lj�k
	 */
	@Override
	public boolean use(String cmd) {
		if(cmd == "AddPart") {
			System.out.println(owner.getName() + " adds pistol.");
			owner.levelUp();
			return true;
		}
		return false;
	}

}
