package skeleton;

/**
 * V�zbeesett karakter nem hal meg.
 * Az Item oszt�lyb�l sz�rmazik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class ScubaSuit extends Item {
	/**
	 * B�v�rruha felhaszn�l�sa a v�zbees�s t�l�l�s�re
	 * @param cmd amire felhaszn�ln�k
	 * @return true ha felveszik ruhak�nt
	 */
	@Override
	public boolean use(String cmd) {
		if(cmd == "PutOn") return true;
		return false;
	}

}
