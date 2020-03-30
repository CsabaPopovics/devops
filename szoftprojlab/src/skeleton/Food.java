package skeleton;

/**
 * A felel�ss�ge az, hogy ha a j�t�kos haszn�lja akkor a testh�m�rs�klete eggyel n�vekszik.
 * Az Item oszt�lyb�l sz�rmazik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Food extends Item {
	
	/**
	 * �tel felhaszn�l�sa.
	 * @param cmd amire felhaszn�ln�k
	 * @return true ha ev�sre haszn�lj�k
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
