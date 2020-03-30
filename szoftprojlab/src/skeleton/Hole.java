package skeleton;

/**
 * A Field felel�ss�gein k�v�l, amikor karaktereket fogad, akkor azokat v�zbe ejti.
 * A Field oszt�lyb�l sz�rmazik le.
 * @see Field
 * @author Csaba Popovics
 *
 */

public class Hole extends Field {
	
	/**
	 * Luk konstruktora.
	 * @param name luk neve
	 * @param snowLevel lukon l�v� h�mennyis�g
	 */
	public Hole(String name, int snowLevel) {
		super(name, snowLevel);
	}

	/**
	 * Karakter fogad�sa a lukon. Automatikusan v�zbe esik a j�vev�ny.
	 * @param p a be�rkez� karakter
	 */
	@Override
	public void accept(Pawn p) {
		super.accept(p);
		System.out.println(p.getName() + " is currently in the " + name + " hole.");
		p.fallIntoWater();
	}
	
	/**
	 * A lukon l�v� h�mennyis�g m�dosul�sa. Ha h�vihar �rte, akkor mindenki, aki a lukban van vesz�t egy testh�t.
	 * @param i a v�ltoz�s m�rt�ke, ha negat�v, akkor h� van takar�tva, ha pozit�v akkor h�vihar �rte
	 */
	@Override
	public void updateSnow(int i) {
		super.updateSnow(i);
		if(i > 0) {
			for(Pawn p : characters)
				p.updateBodyTemp(-1);
		}
	}

	/**
	 * Benne l�v� t�rgy lek�rdez�se.
	 * @return null mert nem lehet benne semmi.
	 */
	@Override
	public Item getItem() {
		return null;
	}

	/**
	 * Benne l�v� t�rgy elt�vol�t�sa. Nem csin�l semmit, mert nem lehet benne semmi.
	 */
	@Override
	public void removeItem() {
		return;
	}
	
	/**
	 * Luk terhelhet�s�g�nek lek�rdez�se.
	 * @return 0 mert luk
	 */
	@Override
	public int getLimit() {
		System.out.println("This is a hole, so zero is its limit.");
		return 0;
	}

	/**
	 * Iglu �p�t�se.
	 * @return false nem lehet lukon iglu
	 */
	@Override
	public boolean setIgloo() {
		return false;
	}
}
