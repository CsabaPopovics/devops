package skeleton;

import java.util.ArrayList;

/**
 * Egy játékost reprezentál. Van testhõje és felhasználható munka egysége. Tevékenységeket képes végrehajtani, például lépés, hótakarítás.
 * @author Csaba Popovics
 *
 */

public class Pawn {
	/**
	 * Karakter neve
	 */
	protected String name;
	/**
	 * Karakter testhõje, alapvetõen 4, eszkimónak eggyel több lesz.
	 */
	protected int bodyTemp = 4;
	/**
	 * Az összeszerelés mértéke. Ez csak azért van itt, hogy az összeszerelés valahogy demonstrálható legyen.
	 */
	protected static int progress = 0;
	
	/**
	 * A mezõ, amin a karakter van.
	 */
	protected Field field;
	/**
	 * A mezõn lévõ többi játékos.
	 */
	protected ArrayList<Pawn> theOthers = new ArrayList<Pawn>();
	/**
	 * A karakternél lévõ tárgyak.
	 */
	protected ArrayList<Item> inventory = new ArrayList<Item>();
	
	/**
	 * A karakter konstruktora.
	 * @param name a karakter neve
	 * @param field a mezõ, amin a karakter kezd
	 */
	public Pawn(String name, Field field) {
		this.name = name;
		this.field = field;
	}
	
	/**
	 * Karakter lépése egy adott irányba. Ha van érvényes mezõ ott, akkor átkerül oda, egyébként helyben marad.
	 * @param d a lépés iránya
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
	 * Hó eltakarítása a mezõrõl egy adott tárggyal. Ásóval egy extra réteg hó eltûnik, egyébként csak egy.
	 * @param i a takarításra kiválasztott tárgy
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
	 * Tárgy kiásása a mezõbõl. Ha a mezõ tiszta és volt benne valami, akkor az a tárgy átkerül a karakterhez.
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
	 * Tárgy felvétele.
	 * @param i a felvett tárgy
	 */
	public void addToInventory(Item i) {
		inventory.add(i);
		i.setOwner(this);
	}
	
	/**
	 * A jelzõrakéta összeszerelésére tett kísérlet. Minden a mezõn lévõ játékos minden náluk lévõ tárgyat megpróbál hozzáadni.
	 * Végül a karakter meg is próbálja elsütni a fegyvert.
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
	 * Tárgy hozzáadása a jelzõrakétához.
	 * @param i a hozzáadni kívánt tárgy.
	 */
	public void addPart(Item i) {
		i.use("AddPart");
	}
	
	/**
	 * A jelzõrakéta elsütésére tett kísérlet. Ha mindhárom darab hozzá lett adva akkor sikerül és nyertek.
	 * Ez itt most butácska verzió és az sincs ellenõrizve, hogy mindenki egy mezõn van-e.
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
	 * A karakter meghal. Ez akkor következik be, ha a testhõ 0-ra csökken vagy vízbe esik mindenféle segítség nélkül.
	 */
	public void die() {
		System.out.println(name + " dies, game over for everyone.");
	}
	
	/**
	 * A karakter vízbeesése. Elõször kísérletet tesz búvárruha felvételére. Ha nincs nála, akkor elkezd körbe kérdezni a szomszédos mezõkön.
	 * Ha van valaki szomszédban kötéllel, akkor megmenekül. Ha ez sincs, akkor meghal.
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
	 * A karakter eszik. Ha ételt eszik eggyel nõ a testhõ és az étel eltávolításra kerül az inventory-ból
	 * @param i az evésre szánt tárgy
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
	 * Kijelölt tárgy felvétele, mint ruha.
	 * @param i a felvenni kívánt tárgy
	 * @return true ha búvárruha a kijelölt tárgy
	 */
	public boolean putOn(Item i) {
		return i.use("PutOn");
	}
	
	/**
	 * Segítség kérése. Körbekérdez a szomszédokon, hogy valaki nem tudja-e megmenteni kötéllel.
	 * @return true ha valaki van az egyik szomszédos mezõn kötéllel
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
	 * Adott karakter megmentésére tett kísérlet.
	 * @param p a megmentendõ karakter
	 * @return true ha meg tudja menteni, azaz tud kötelet dobni
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
	 * Adott tárgy dobása.
	 * @param i a dobásra szánt tárgy
	 * @param p a dobott tárgy fogadója
	 * @return true ha el lehet dobni, azaz, ha kötél
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
	 * A karakternél lévõ tárgyak lekérdezése.
	 * @return a karakternél lévõ tárgyak
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	/**
	 * A karakter testhõjének változása. Nõhet étel fogyasztásával, csökkenhet ha hóvihar érte iglun kívül.
	 * Ha a testhõ 0-ra csökken akkor meghal.
	 * @param i a változás mártéke
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
	 * A karakter tartózkodási mezõjének lekérdezése.
	 * @return a mezõ, amin a karakter van
	 */
	public Field getField() {
		return field;
	}
	
	/**
	 * Tárgy eltávolítása az inventory-ból. Erre akkor van csak szükség ha ételt evett a karakter.
	 * @param i az eltávolítandó tárgy
	 */
	public void removeItem(Item i) {
		inventory.remove(i);
	}
	
	/**
	 * Karakter nevének lekérdezése
	 * @return
	 */
	public String getName() {return name;}
	
	/**
	 * Az összeszereléshez használt segítség, hogy látható legyen valami eredmény.
	 * Eggyel növeli a progress-t ha jó rész lett a jelzõrakétához adva.
	 */
	public void levelUp() {
		progress++;
	}
	
	/**
	 * A karakter tartózkodási mezõjének beállítása.
	 * @param f a mezõ, amire a karakter kerül
	 */
	public void setField(Field f) {
		field = f;
	}

}
