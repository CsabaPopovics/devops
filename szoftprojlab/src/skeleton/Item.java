package skeleton;

/**
 * Egy jégmezõbe fagyott tárgyat reprezentál, fel lehet venni, illetve fel lehet használni.
 * @author Csaba Popovics
 *
 */

public abstract class Item {
	/**
	 * A tárgy tulajdonosa.
	 */
	protected Pawn owner;
	
	/**
	 * A tárgy felhasználása
	 * @param cmd amire felhasználnák
	 * @return true ha arra használják, amire van
	 */
	public abstract boolean use(String cmd);
	
	
	/**
	 * A tárgy tulajdonosának beállítása
	 * @param p a karakter, akihez a tárgy került.
	 */
	public void setOwner(Pawn p) {
		owner = p;
	}
	
	/**
	 * A tárgy tulajdonosának lekérdezése.
	 * @return tárgy tulajdonosa
	 */
	public Pawn getOwner() {
		return owner;
	}

}
