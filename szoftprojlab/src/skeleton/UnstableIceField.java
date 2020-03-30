package skeleton;

/**
 * Felel�ss�ge ugyanaz, mint az IceField-nek, de ha �tl�pi a limit�t, akkor a karakterek, akik rajta vannak, v�zbe esnek.
 * Az IceField oszt�lyb�l sz�rmazik le.
 * @see IceField
 * @author Csaba Popovics
 *
 */

public class UnstableIceField extends IceField {
	/**
	 * Az instabil mez�n egyszerre csak ennyien tart�zkodhatnak, ha t�ll�pik felborul.
	 */
	private int limit;
	
	/**
	 * Instabil mez� konstruktora.
	 * @param name mez� neve
	 * @param snowLevel mez�n l�v� h�mennyis�g
	 * @param limit mez� maximum terhelhet�s�ge
	 */
	public UnstableIceField(String name, int snowLevel, int limit) {
		super(name, snowLevel);
		this.limit = limit;
	}
	
	
	/**
	 * Az instabil mez� terhelhet�s�g�nek lek�rdez�se.
	 * @return mez� terhelhet�s�ge
	 */
	@Override
	public int getLimit() {
		System.out.println(name + " is an unstable field, its limit: " + limit);
		return limit;
	}
	
	/**
	 * A mez� felborul�sa. Ekkor minden rajta l�v� karakter v�zbe esik.
	 */
	public void flip() {
		System.out.println(name + " flips over, every character on this field falls into water.");
		for(Pawn p : characters) {
			p.fallIntoWater();
		}
	}
	
	/**
	 * Karakter fogad�sa a mez�n. Ha az �j l�tsz�m t�ll�pi a korl�tot felborul.
	 * @param p a karakter, aki a mez�re �rkezik
	 */
	@Override
	public void accept(Pawn p) {
		if(p != null) {
			characters.add(p);
			System.out.println(p.getName() + " is currently on " + name + " unstable field.");
			if(characters.size()>limit) {
				System.out.println(name + " unstable field is overloaded.");
				flip();
				return;
			}
			System.out.println(name + " is still stable enough.");
		}
		
	}
	
	

}
