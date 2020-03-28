package items;

public class Food extends Item {
	
	public boolean use(String cmd) {
		if(cmd == "Eat") {
			this.getOwner().updateBodyTemp(1);
			return true;
		}
		return false;
	}
}
