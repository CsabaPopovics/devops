package skeleton;

/**
 * Felelõsségei megegyeznek a Field-ével, illetve lehet belefagyva valamilyen tárgy,
 * amit ki tudnak ásni, illetve iglu is építhetõ rá.
 * A Field osztályból származik le.
 * @see Field
 * @author Csaba Popovics
 *
 */

public class IceField extends Field {
	/**
	 * Annak igazságértéke, hogy van-e iglu a mezõn, alapvetõen nincs.
	 */
	protected boolean iglooState = false;
	/**
	 * A mezõbe fagyott tárgy.
	 */
	protected Item item;
	
	/**
	 * A stabil jégmezõ konstruktora.
	 * @param name mezõ neve
	 * @param snowLevel mezõn lévõ kezdeti hómennyiség
	 */
	public IceField(String name, int snowLevel) {
		super(name, snowLevel);
	}
	
	/**
	 * A mezõbe fagyott tárgy kiadása.
	 * @return a mezõben lévõ tárgy, ha nincs benne, akkor null
	 */
	@Override
	public Item getItem() {
		if(snowLevel == 0) {
			System.out.println(name + " is clear.");
			return item;
		}
		System.out.println(name + " is not clear, can't be excavated.");
		return null;
	}

	/**
	 * A mezõbe fagyott tárgy eltávolítása.
	 */
	@Override
	public void removeItem() {
		item = null;
		
	}
	
	/**
	 * Iglu épülése a mezõn
	 * @return true ha nem volt eddig iglu a mezõn
	 */
	@Override
	public boolean setIgloo() {
		if(iglooState == false) {
			System.out.println("There is no igloo on this field.");
			iglooState = true;
			System.out.println("Igloo has been built on this field.");
			return true;
		}
		System.out.println("There is already an igloo on this field.");
		return false;
	}
	
	/**
	 * A mezõn lévõ hómennyiség módosulása. Hóvihar esetén csak akkor csökkenti a karakterek testhõjét, ha nincs rajta iglu.
	 * @param i a mérték, amivel változik a hómennyiség
	 */
	@Override
	public void updateSnow(int i) {
		super.updateSnow(i);
		if(i > 0 && !iglooState) {
			System.out.println("Blizzar hit " + name + " and there is no igloo, all occupants' body temperature is decreased.");
			for(Pawn p : characters)
				p.updateBodyTemp(-1);
		}
		if(i > 0 && iglooState) {
			System.out.println("Blizzard hit " + name + " but it has igloo, so no worries.");
		}
			
	}
	
	/**
	 * Karakter fogadása a mezõn.
	 * @param p a beérkezõ karakter
	 */
	@Override
	public void accept(Pawn p) {
		super.accept(p);
		System.out.println(p.getName() + " is currently on " + name + " stable field.");
	}
	
	/**
	 * Tárgy helyezése a mezõbe. Ez a függvény csupán demonstrációhoz volt gyorssegély.
	 * @param i a behelyezendõ tárgy
	 */
	public void placeItem(Item i) {
		item = i;
	}
	
	/**
	 * A mezõ terhelhetõségének lekérdezése.
	 * @return 100 csak hogy valamit visszaadjon, de amúgy "végtelen", ha 100-nál többen játszanának vele én kérek elnézést
	 */
	@Override
	public int getLimit() {
		System.out.println(name + " is stable, so I guess the limit is infinite.");
		return 100;
	}

}
