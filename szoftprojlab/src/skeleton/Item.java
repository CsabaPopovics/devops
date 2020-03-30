package skeleton;

/**
 * Egy j�gmez�be fagyott t�rgyat reprezent�l, fel lehet venni, illetve fel lehet haszn�lni.
 * @author Csaba Popovics
 *
 */

public abstract class Item {
	/**
	 * A t�rgy tulajdonosa.
	 */
	protected Pawn owner;
	
	/**
	 * A t�rgy felhaszn�l�sa
	 * @param cmd amire felhaszn�ln�k
	 * @return true ha arra haszn�lj�k, amire van
	 */
	public abstract boolean use(String cmd);
	
	
	/**
	 * A t�rgy tulajdonos�nak be�ll�t�sa
	 * @param p a karakter, akihez a t�rgy ker�lt.
	 */
	public void setOwner(Pawn p) {
		owner = p;
	}
	
	/**
	 * A t�rgy tulajdonos�nak lek�rdez�se.
	 * @return t�rgy tulajdonosa
	 */
	public Pawn getOwner() {
		return owner;
	}

}
