package skeleton;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A j�t�kt�r egy �p�t�eleme. Tudja, hogy milyen karakterek vannak rajta �s ismeri a
 * szomsz�dos mez�ket.
 * @author Csaba Popovics
 *
 */

public abstract class Field {
	/**
	 * A mez�n tart�zkod� karakterek
	 */
	protected ArrayList<Pawn> characters = new ArrayList<Pawn>();
	/**
	 * A mez� szomsz�dai
	 */
	protected HashMap<Direction, Field> neighbours = new HashMap<Direction, Field>();
	
	/**
	 * A mez�n l�v� h�mennyis�g
	 */
	protected int snowLevel;
	
	/**
	 * A mez� neve
	 */
	protected String name;
	
	/**
	 * A mez� konstruktora
	 * @param name a mez� neve
	 * @param snowLevel a mez�n l�v� kezdeti h�mennyis�g
	 */
	public Field(String name, int snowLevel) {
		this.name = name;
		this.snowLevel = snowLevel;
	}
	
	/**
	 * Szomsz�dos mez� be�ll�t�sa.
	 * @param field a szomsz�dnak be�ll�tand� mez�
	 * @param d az ir�ny, ahol a szomsz�doss�g van
	 */
	public void addNeighbour(Field field, Direction d) {
		if(field != null)
			neighbours.put(d, field);
	}
	
	/**
	 * Karakter fogad�sa a mez�n.
	 * @param p a be�rkez� karakter
	 */
	public void accept(Pawn p) {
		if(p != null) {
			characters.add(p);
			p.setField(this);
		}
	}
	
	/**
	 * Karakter elt�vol�t�sa a mez�r�l.
	 * @param p a mez�t elhagy� karakter
	 */
	public void remove(Pawn p) {
		characters.remove(p);
	}
	
	/**
	 * A mez�ben l�v� t�rgy lek�rdez�se. Lesz�rmazottakt�l f�gg az implement�ci�.
	 * @return
	 */
	public abstract Item getItem();
	
	/**
	 * Szomsz�d lek�rdez�se adott ir�nyban.
	 * @param d a k�rd�ses ir�ny
	 * @return az adott ir�nyban l�v� mez�, ha nincs semmi, akkor null
	 */
	public Field getNeighbour(Direction d) {
		if(!neighbours.containsKey(d))
			return null;
		return neighbours.get(d);
	}
	
	/**
	 * A mez�n l�v� h�mennyis�g lek�rdez�se 
	 * @return a mez�n l�v� h�mennyis�g
	 */
	public int getSnowLevel() {
		return snowLevel;
	}
	
	/**
	 * A mez�n l�v� h�mennyis�g megv�ltoz�sa.
	 * @param i a v�ltoz�s m�rt�ke
	 */
	public void updateSnow(int i) {
		snowLevel += i;
	}
	
	/**
	 * A mez� terhelts�g�nek lek�rdez�se.
	 * @return a mez�n tal�lhat� karakterek sz�ma
	 */
	public int getLoad() {
		System.out.println(name + "'s current load is: " + characters.size());
		return characters.size();
	}
	
	/**
	 * A mez� terhelhet�s�g�nek lek�rdez�se
	 * @return 100, valid �rt�ket a lesz�rmazottak adnak majd.
	 */
	public int getLimit() {
		return 100;
	}
	
	/**
	 * A mez�n l�v� karakterek lek�rdez�se
	 * @return a mez�n l�v� karakterek
	 */
	public ArrayList<Pawn> getCharacters(){
		if(characters.isEmpty()) return null;
		return characters;
	}

	/**
	 * A mez�ben l�v� t�rgy elt�vol�t�sa.
	 */
	public abstract void removeItem();

	/**
	 * Iglu �p�t�se a mez�n.
	 * @return
	 */
	public abstract boolean setIgloo();
	
	/**
	 * Mez� nev�nek lek�rdez�se
	 * @return mez� neve
	 */
	public String getName() {return name;}
}
