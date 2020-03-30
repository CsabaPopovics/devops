package skeleton;

/**
 * Ugyanaz a felelõssége, mint a Pawn-nak, ezen kívül tud iglut is építeni. Alapvetõen 5 testhõje van.
 * A Pawn osztály leszármozottja.
 * @see Pawn
 * @author Csaba Popovics
 *
 */

public class Eskimo extends Pawn {
	
	/**
	 * Eszkimó konstruktora, eggyel több testhõje van.
	 * @param name az eszkimó neve
	 * @param field a mezõ, amin az eszkimó tartózkodik
	 */
	public Eskimo(String name, Field field) {
		super(name, field);
		bodyTemp++;
	}

	/**
	 * Iglu építése az eszkimó mezõjén.
	 */
	public void buildIgloo() {
		System.out.println(name + " attempts to build an igloo on " + field.getName());
		field.setIgloo();
	}

}
