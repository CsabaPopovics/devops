package items;

public class Shovel extends Item {

	@Override
	public boolean use(String cmd) {
		if(cmd == "Clear") {
			this.getOwner().getField().updateSnow(-1);
			return true;
		}
		return false;
	}

}
