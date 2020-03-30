package skeleton;

import java.util.ArrayList;

/**
 * Egy j�t�kost reprezent�l. Van testh�je �s felhaszn�lhat� munka egys�ge. Tev�kenys�geket k�pes v�grehajtani, p�ld�ul l�p�s, h�takar�t�s.
 * @author Csaba Popovics
 *
 */

public class Pawn {
	/**
	 * Karakter neve
	 */
	protected String name;
	/**
	 * Karakter testh�je, alapvet�en 4, eszkim�nak eggyel t�bb lesz.
	 */
	protected int bodyTemp = 4;
	/**
	 * Az �sszeszerel�s m�rt�ke. Ez csak az�rt van itt, hogy az �sszeszerel�s valahogy demonstr�lhat� legyen.
	 */
	protected static int progress = 0;
	
	/**
	 * A mez�, amin a karakter van.
	 */
	protected Field field;
	/**
	 * A mez�n l�v� t�bbi j�t�kos.
	 */
	protected ArrayList<Pawn> theOthers = new ArrayList<Pawn>();
	/**
	 * A karaktern�l l�v� t�rgyak.
	 */
	protected ArrayList<Item> inventory = new ArrayList<Item>();
	
	/**
	 * A karakter konstruktora.
	 * @param name a karakter neve
	 * @param field a mez�, amin a karakter kezd
	 */
	public Pawn(String name, Field field) {
		this.name = name;
		this.field = field;
	}
	
	/**
	 * Karakter l�p�se egy adott ir�nyba. Ha van �rv�nyes mez� ott, akkor �tker�l oda, egy�bk�nt helyben marad.
	 * @param d a l�p�s ir�nya
	 */
	public void step(Direction d) {
		System.out.println(name + " attempts to step in " + d.name() + " direction.");
		Field destination = field.getNeighbour(d);
		if(destination != null) {
			System.out.println("In the given direction there is the " + destination.getName() + " field");
			System.out.println(name + " steps.");
			field.remove(this);
			destination.accept(this);
		} else if(destination == null)
			System.out.println("There is nothing in that direction.");
	}
	
	/**
	 * H� eltakar�t�sa a mez�r�l egy adott t�rggyal. �s�val egy extra r�teg h� elt�nik, egy�bk�nt csak egy.
	 * @param i a takar�t�sra kiv�lasztott t�rgy
	 */
	public void clearSnow(Item i) {
		System.out.println(name + " clears snow from " + field.getName());
		System.out.println(field.getName() + "'s level of snow before cleaning: " + field.getSnowLevel());
		if(i != null) {
			boolean isShovel = i.use("Clear");
			if(!isShovel)
				System.out.println("The chosen item cannot be used to clear snow.");
		}
		field.updateSnow(-1);
		System.out.println(field.getName() + "'s new level of snow: " + field.getSnowLevel());
	}
	
	/**
	 * T�rgy ki�s�sa a mez�b�l. Ha a mez� tiszta �s volt benne valami, akkor az a t�rgy �tker�l a karakterhez.
	 */
	public void excavate() {
		System.out.println(name + " attempts to excavate.");
		Item excavatedItem = field.getItem();
		if(excavatedItem != null) {
			addToInventory(excavatedItem);
			field.removeItem();
			System.out.println("The item is now in " + name + "'s inventory.");
		} else {
			System.out.println("There is nothing in the ice.");
		}
	}
	
	/**
	 * T�rgy felv�tele.
	 * @param i a felvett t�rgy
	 */
	public void addToInventory(Item i) {
		inventory.add(i);
		i.setOwner(this);
	}
	
	/**
	 * A jelz�rak�ta �sszeszerel�s�re tett k�s�rlet. Minden a mez�n l�v� j�t�kos minden n�luk l�v� t�rgyat megpr�b�l hozz�adni.
	 * V�g�l a karakter meg is pr�b�lja els�tni a fegyvert.
	 */
	public void assembleGun() {
		System.out.println(name + " attempts to assemble the flaregun...");
		theOthers = field.getCharacters();
		if(theOthers != null) {
			for(Pawn p : theOthers) {
				for(Item i : p.getInventory()) {
					p.addPart(i);
				}
			}
		}
		
		fire();
	}
	
	/**
	 * T�rgy hozz�ad�sa a jelz�rak�t�hoz.
	 * @param i a hozz�adni k�v�nt t�rgy.
	 */
	public void addPart(Item i) {
		i.use("AddPart");
	}
	
	/**
	 * A jelz�rak�ta els�t�s�re tett k�s�rlet. Ha mindh�rom darab hozz� lett adva akkor siker�l �s nyertek.
	 * Ez itt most but�cska verzi� �s az sincs ellen�rizve, hogy mindenki egy mez�n van-e.
	 */
	public void fire() {
		if(progress == 3) {
			System.out.println("Flaregun successfully assembled and fired.");
		} else {
			System.out.println("Flaregun is not complete.");
			progress = 0;
		}
	}
	
	/**
	 * A karakter meghal. Ez akkor k�vetkezik be, ha a testh� 0-ra cs�kken vagy v�zbe esik mindenf�le seg�ts�g n�lk�l.
	 */
	public void die() {
		System.out.println(name + " dies, game over for everyone.");
	}
	
	/**
	 * A karakter v�zbees�se. El�sz�r k�s�rletet tesz b�v�rruha felv�tel�re. Ha nincs n�la, akkor elkezd k�rbe k�rdezni a szomsz�dos mez�k�n.
	 * Ha van valaki szomsz�dban k�t�llel, akkor megmenek�l. Ha ez sincs, akkor meghal.
	 */
	public void fallIntoWater() {
		System.out.println(name + " falls into water.");
		System.out.println(name + " tries to put on a scubasuit.");
		for(Item i : inventory) {
			if(putOn(i)) {
				System.out.println(name + " has a scubasuit, so survives.");
				return;
			}
		}
		System.out.println(name + " doesn't have a scubasuit, so tries to cry for help.");
		boolean saved = cryForHelp();
		if(!saved) {
			System.out.println(name + " can't be saved.");
			die();
		}
		
	}
	
	/**
	 * A karakter eszik. Ha �telt eszik eggyel n� a testh� �s az �tel elt�vol�t�sra ker�l az inventory-b�l
	 * @param i az ev�sre sz�nt t�rgy
	 */
	public void eat(Item i) {
		System.out.println(name + " attempts to eat.");
		boolean isFood = i.use("Eat");
		if(!isFood)
			System.out.println("The chosen item is not edible.");
		else {
			System.out.println(name + " ate the chosen food, body temperature increased.");
		}
	}
	
	/**
	 * Kijel�lt t�rgy felv�tele, mint ruha.
	 * @param i a felvenni k�v�nt t�rgy
	 * @return true ha b�v�rruha a kijel�lt t�rgy
	 */
	public boolean putOn(Item i) {
		return i.use("PutOn");
	}
	
	/**
	 * Seg�ts�g k�r�se. K�rbek�rdez a szomsz�dokon, hogy valaki nem tudja-e megmenteni k�t�llel.
	 * @return true ha valaki van az egyik szomsz�dos mez�n k�t�llel
	 */
	public boolean cryForHelp() {
		for(Direction d : Direction.values()) {
			Field helpingField = field.getNeighbour(d);
			if(helpingField != null) {
				ArrayList<Pawn> mySaviors = new ArrayList<Pawn>();
				mySaviors = helpingField.getCharacters();
				if(mySaviors != null) {
					for(Pawn savior : mySaviors) {
						if(savior.rescue(this)) {
							return true;
						}
					}
				}
			}
			
		}
		return false;
	}
	
	/**
	 * Adott karakter megment�s�re tett k�s�rlet.
	 * @param p a megmentend� karakter
	 * @return true ha meg tudja menteni, azaz tud k�telet dobni
	 */
	public boolean rescue(Pawn p) {
		for(Item i : inventory) {
			if(throwRope(i, p)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adott t�rgy dob�sa.
	 * @param i a dob�sra sz�nt t�rgy
	 * @param p a dobott t�rgy fogad�ja
	 * @return true ha el lehet dobni, azaz, ha k�t�l
	 */
	public boolean throwRope(Item i, Pawn p) {
		if(i.use("Throw")) {
			System.out.println(name + " can save " + p.getName());
			p.getField().remove(p);
			field.accept(p);
			return true;
		}
		return false;
	}
	
	/**
	 * A karaktern�l l�v� t�rgyak lek�rdez�se.
	 * @return a karaktern�l l�v� t�rgyak
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	/**
	 * A karakter testh�j�nek v�ltoz�sa. N�het �tel fogyaszt�s�val, cs�kkenhet ha h�vihar �rte iglun k�v�l.
	 * Ha a testh� 0-ra cs�kken akkor meghal.
	 * @param i a v�ltoz�s m�rt�ke
	 */
	public void updateBodyTemp(int i) {
		System.out.println(name + "'s body temperature was " + bodyTemp);
		bodyTemp += i;
		if(bodyTemp <= 0) {
			System.out.println(name + "'s body temperature reached zero.");
			die();
		}
		if(bodyTemp > 0)
			System.out.println(name + "'s new body temperature is " + bodyTemp);
	}
	
	/**
	 * A karakter tart�zkod�si mez�j�nek lek�rdez�se.
	 * @return a mez�, amin a karakter van
	 */
	public Field getField() {
		return field;
	}
	
	/**
	 * T�rgy elt�vol�t�sa az inventory-b�l. Erre akkor van csak sz�ks�g ha �telt evett a karakter.
	 * @param i az elt�vol�tand� t�rgy
	 */
	public void removeItem(Item i) {
		inventory.remove(i);
	}
	
	/**
	 * Karakter nev�nek lek�rdez�se
	 * @return
	 */
	public String getName() {return name;}
	
	/**
	 * Az �sszeszerel�shez haszn�lt seg�ts�g, hogy l�that� legyen valami eredm�ny.
	 * Eggyel n�veli a progress-t ha j� r�sz lett a jelz�rak�t�hoz adva.
	 */
	public void levelUp() {
		progress++;
	}
	
	/**
	 * A karakter tart�zkod�si mez�j�nek be�ll�t�sa.
	 * @param f a mez�, amire a karakter ker�l
	 */
	public void setField(Field f) {
		field = f;
	}

}
