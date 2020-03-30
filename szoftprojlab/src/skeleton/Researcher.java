package skeleton;

/**
 * Ugyanazok a felelõsségei, mint a Character-nek, továbbá meg tud vizsgálni egy szomszédos
 * mezõt a terhelhetõségével kapcsolatban. Alapvetõen 4 testhõje van.
 * A Pawn osztályból származik le.
 * @see Pawn
 * @author Csaba Popovics
 *
 */

public class Researcher extends Pawn {
	
	/**
	 * Kutató konstruktora.
	 * @param name a kutató neve
	 * @param field a mezõ, amire a kutató kerül
	 */
	public Researcher(String name, Field field) {
		super(name, field);
	}

	/**
	 * Egy adott irányba való vizsgálódás, mi a szomszédos mezõ terhelhetõsége és az aktuális terhelése.
	 * @param d az irány, amelyben a szomszédos mezõt vizsgálná
	 */
	public void inspect(Direction d) {
		System.out.println(name + " inspects in " + d.name() + " direction.");
		Field inspectedField = field.getNeighbour(d);
		if(inspectedField != null) {
			System.out.println("In the given direction there is a field: " + inspectedField.getName());
			inspectedField.getLimit();
			inspectedField.getLoad();
			return;
		}
		System.out.println("There is nothing in that direction.");
	}

}
