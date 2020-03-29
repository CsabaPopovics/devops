package characters;

public class Eskimo extends Pawn {
	
	public Eskimo(String name) {
		super(name);
		bodyTemp++;
	}

	public void buildIgloo() {
		field.setIgloo();
	}

}
