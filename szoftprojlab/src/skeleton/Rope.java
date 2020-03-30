package skeleton;

/**
 * M�sik j�t�kos kiment�s�n�l lehet felhaszn�lni.
 * Az Item oszt�lyb�l sz�rmazik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Rope extends Item {

	/**
	 * K�t�l haszn�lata, v�zbe esett karakter kiemenek�t�s�re.
	 * @param cmd amire felhaszn�ln�k
	 * @return true ha dobni akarj�k
	 */
	@Override
	public boolean use(String cmd) {
		if(cmd == "Throw") return true;
		return false;
	}

}
