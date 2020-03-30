package skeleton;

/**
 * Ugyanaz a felel�ss�ge, mint a Pawn-nak, ezen k�v�l tud iglut is �p�teni. Alapvet�en 5 testh�je van.
 * A Pawn oszt�ly lesz�rmozottja.
 * @see Pawn
 * @author Csaba Popovics
 *
 */

public class Eskimo extends Pawn {
	
	/**
	 * Eszkim� konstruktora, eggyel t�bb testh�je van.
	 * @param name az eszkim� neve
	 * @param field a mez�, amin az eszkim� tart�zkodik
	 */
	public Eskimo(String name, Field field) {
		super(name, field);
		bodyTemp++;
	}

	/**
	 * Iglu �p�t�se az eszkim� mez�j�n.
	 */
	public void buildIgloo() {
		System.out.println(name + " attempts to build an igloo on " + field.getName());
		field.setIgloo();
	}

}
