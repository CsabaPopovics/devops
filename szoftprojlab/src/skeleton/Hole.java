package skeleton;

/**
 * A Field felelõsségein kívül, amikor karaktereket fogad, akkor azokat vízbe ejti.
 * A Field osztályból származik le.
 * @see Field
 * @author Csaba Popovics
 *
 */

public class Hole extends Field {
	
	/**
	 * Luk konstruktora.
	 * @param name luk neve
	 * @param snowLevel lukon lévõ hómennyiség
	 */
	public Hole(String name, int snowLevel) {
		super(name, snowLevel);
	}

	/**
	 * Karakter fogadása a lukon. Automatikusan vízbe esik a jövevény.
	 * @param p a beérkezõ karakter
	 */
	@Override
	public void accept(Pawn p) {
		super.accept(p);
		System.out.println(p.getName() + " is currently in the " + name + " hole.");
		p.fallIntoWater();
	}
	
	/**
	 * A lukon lévõ hómennyiség módosulása. Ha hóvihar érte, akkor mindenki, aki a lukban van veszít egy testhõt.
	 * @param i a változás mértéke, ha negatív, akkor hó van takarítva, ha pozitív akkor hóvihar érte
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
	 * Benne lévõ tárgy lekérdezése.
	 * @return null mert nem lehet benne semmi.
	 */
	@Override
	public Item getItem() {
		return null;
	}

	/**
	 * Benne lévõ tárgy eltávolítása. Nem csinál semmit, mert nem lehet benne semmi.
	 */
	@Override
	public void removeItem() {
		return;
	}
	
	/**
	 * Luk terhelhetõségének lekérdezése.
	 * @return 0 mert luk
	 */
	@Override
	public int getLimit() {
		System.out.println("This is a hole, so zero is its limit.");
		return 0;
	}

	/**
	 * Iglu építése.
	 * @return false nem lehet lukon iglu
	 */
	@Override
	public boolean setIgloo() {
		return false;
	}
}
