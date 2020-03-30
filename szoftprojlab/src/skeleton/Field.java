package skeleton;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A játéktér egy építõeleme. Tudja, hogy milyen karakterek vannak rajta és ismeri a
 * szomszédos mezõket.
 * @author Csaba Popovics
 *
 */

public abstract class Field {
	/**
	 * A mezõn tartózkodó karakterek
	 */
	protected ArrayList<Pawn> characters = new ArrayList<Pawn>();
	/**
	 * A mezõ szomszédai
	 */
	protected HashMap<Direction, Field> neighbours = new HashMap<Direction, Field>();
	
	/**
	 * A mezõn lévõ hómennyiség
	 */
	protected int snowLevel;
	
	/**
	 * A mezõ neve
	 */
	protected String name;
	
	/**
	 * A mezõ konstruktora
	 * @param name a mezõ neve
	 * @param snowLevel a mezõn lévõ kezdeti hómennyiség
	 */
	public Field(String name, int snowLevel) {
		this.name = name;
		this.snowLevel = snowLevel;
	}
	
	/**
	 * Szomszédos mezõ beállítása.
	 * @param field a szomszédnak beállítandó mezõ
	 * @param d az irány, ahol a szomszédosság van
	 */
	public void addNeighbour(Field field, Direction d) {
		if(field != null)
			neighbours.put(d, field);
	}
	
	/**
	 * Karakter fogadása a mezõn.
	 * @param p a beérkezõ karakter
	 */
	public void accept(Pawn p) {
		if(p != null) {
			characters.add(p);
			p.setField(this);
		}
	}
	
	/**
	 * Karakter eltávolítása a mezõrõl.
	 * @param p a mezõt elhagyó karakter
	 */
	public void remove(Pawn p) {
		characters.remove(p);
	}
	
	/**
	 * A mezõben lévõ tárgy lekérdezése. Leszármazottaktól függ az implementáció.
	 * @return
	 */
	public abstract Item getItem();
	
	/**
	 * Szomszéd lekérdezése adott irányban.
	 * @param d a kérdéses irány
	 * @return az adott irányban lévõ mezõ, ha nincs semmi, akkor null
	 */
	public Field getNeighbour(Direction d) {
		if(!neighbours.containsKey(d))
			return null;
		return neighbours.get(d);
	}
	
	/**
	 * A mezõn lévõ hómennyiség lekérdezése 
	 * @return a mezõn lévõ hómennyiség
	 */
	public int getSnowLevel() {
		return snowLevel;
	}
	
	/**
	 * A mezõn lévõ hómennyiség megváltozása.
	 * @param i a változás mértéke
	 */
	public void updateSnow(int i) {
		snowLevel += i;
	}
	
	/**
	 * A mezõ terheltségének lekérdezése.
	 * @return a mezõn található karakterek száma
	 */
	public int getLoad() {
		System.out.println(name + "'s current load is: " + characters.size());
		return characters.size();
	}
	
	/**
	 * A mezõ terhelhetõségének lekérdezése
	 * @return 100, valid értéket a leszármazottak adnak majd.
	 */
	public int getLimit() {
		return 100;
	}
	
	/**
	 * A mezõn lévõ karakterek lekérdezése
	 * @return a mezõn lévõ karakterek
	 */
	public ArrayList<Pawn> getCharacters(){
		if(characters.isEmpty()) return null;
		return characters;
	}

	/**
	 * A mezõben lévõ tárgy eltávolítása.
	 */
	public abstract void removeItem();

	/**
	 * Iglu építése a mezõn.
	 * @return
	 */
	public abstract boolean setIgloo();
	
	/**
	 * Mezõ nevének lekérdezése
	 * @return mezõ neve
	 */
	public String getName() {return name;}
}
