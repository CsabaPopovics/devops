package items;

public class Rope extends Item {

	@Override
	public boolean use(String cmd) {
		if(cmd == "Throw") return true;
		return false;
	}

}
