package skeleton;

/**
 * Ugyanazok a felel�ss�gei, mint a Character-nek, tov�bb� meg tud vizsg�lni egy szomsz�dos
 * mez�t a terhelhet�s�g�vel kapcsolatban. Alapvet�en 4 testh�je van.
 * A Pawn oszt�lyb�l sz�rmazik le.
 * @see Pawn
 * @author Csaba Popovics
 *
 */

public class Researcher extends Pawn {
	
	/**
	 * Kutat� konstruktora.
	 * @param name a kutat� neve
	 * @param field a mez�, amire a kutat� ker�l
	 */
	public Researcher(String name, Field field) {
		super(name, field);
	}

	/**
	 * Egy adott ir�nyba val� vizsg�l�d�s, mi a szomsz�dos mez� terhelhet�s�ge �s az aktu�lis terhel�se.
	 * @param d az ir�ny, amelyben a szomsz�dos mez�t vizsg�ln�
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
