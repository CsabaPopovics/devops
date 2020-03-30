package skeleton;

/**
 * Felelõssége ugyanaz, mint az IceField-nek, de ha átlépi a limitét, akkor a karakterek, akik rajta vannak, vízbe esnek.
 * Az IceField osztályból származik le.
 * @see IceField
 * @author Csaba Popovics
 *
 */

public class UnstableIceField extends IceField {
	/**
	 * Az instabil mezõn egyszerre csak ennyien tartózkodhatnak, ha túllépik felborul.
	 */
	private int limit;
	
	/**
	 * Instabil mezõ konstruktora.
	 * @param name mezõ neve
	 * @param snowLevel mezõn lévõ hómennyiség
	 * @param limit mezõ maximum terhelhetõsége
	 */
	public UnstableIceField(String name, int snowLevel, int limit) {
		super(name, snowLevel);
		this.limit = limit;
	}
	
	
	/**
	 * Az instabil mezõ terhelhetõségének lekérdezése.
	 * @return mezõ terhelhetõsége
	 */
	@Override
	public int getLimit() {
		System.out.println(name + " is an unstable field, its limit: " + limit);
		return limit;
	}
	
	/**
	 * A mezõ felborulása. Ekkor minden rajta lévõ karakter vízbe esik.
	 */
	public void flip() {
		System.out.println(name + " flips over, every character on this field falls into water.");
		for(Pawn p : characters) {
			p.fallIntoWater();
		}
	}
	
	/**
	 * Karakter fogadása a mezõn. Ha az új létszám túllépi a korlátot felborul.
	 * @param p a karakter, aki a mezõre érkezik
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
