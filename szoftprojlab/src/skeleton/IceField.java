package skeleton;

/**
 * Felel�ss�gei megegyeznek a Field-�vel, illetve lehet belefagyva valamilyen t�rgy,
 * amit ki tudnak �sni, illetve iglu is �p�thet� r�.
 * A Field oszt�lyb�l sz�rmazik le.
 * @see Field
 * @author Csaba Popovics
 *
 */

public class IceField extends Field {
	/**
	 * Annak igazs�g�rt�ke, hogy van-e iglu a mez�n, alapvet�en nincs.
	 */
	protected boolean iglooState = false;
	/**
	 * A mez�be fagyott t�rgy.
	 */
	protected Item item;
	
	/**
	 * A stabil j�gmez� konstruktora.
	 * @param name mez� neve
	 * @param snowLevel mez�n l�v� kezdeti h�mennyis�g
	 */
	public IceField(String name, int snowLevel) {
		super(name, snowLevel);
	}
	
	/**
	 * A mez�be fagyott t�rgy kiad�sa.
	 * @return a mez�ben l�v� t�rgy, ha nincs benne, akkor null
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
	 * A mez�be fagyott t�rgy elt�vol�t�sa.
	 */
	@Override
	public void removeItem() {
		item = null;
		
	}
	
	/**
	 * Iglu �p�l�se a mez�n
	 * @return true ha nem volt eddig iglu a mez�n
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
	 * A mez�n l�v� h�mennyis�g m�dosul�sa. H�vihar eset�n csak akkor cs�kkenti a karakterek testh�j�t, ha nincs rajta iglu.
	 * @param i a m�rt�k, amivel v�ltozik a h�mennyis�g
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
	 * Karakter fogad�sa a mez�n.
	 * @param p a be�rkez� karakter
	 */
	@Override
	public void accept(Pawn p) {
		super.accept(p);
		System.out.println(p.getName() + " is currently on " + name + " stable field.");
	}
	
	/**
	 * T�rgy helyez�se a mez�be. Ez a f�ggv�ny csup�n demonstr�ci�hoz volt gyorsseg�ly.
	 * @param i a behelyezend� t�rgy
	 */
	public void placeItem(Item i) {
		item = i;
	}
	
	/**
	 * A mez� terhelhet�s�g�nek lek�rdez�se.
	 * @return 100 csak hogy valamit visszaadjon, de am�gy "v�gtelen", ha 100-n�l t�bben j�tszan�nak vele �n k�rek eln�z�st
	 */
	@Override
	public int getLimit() {
		System.out.println(name + " is stable, so I guess the limit is infinite.");
		return 100;
	}

}
