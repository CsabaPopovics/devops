package skeleton;

/**
 * Felhaszn�l�s�val k�t egys�g h� takar�that� el egy helyett.
 * Az Item oszt�lyb�l sz�rmazik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Shovel extends Item {

	/**
	 * �s� haszn�lata, helyesen felhaszn�lva 2 egys�g h� is eltakar�that�.
	 * @param cmd amire haszn�lni akarja a tulajdonos
	 * @return true ha takar�t�sra haszn�lj�k, egy�bk�nt false
	 */
	@Override
	public boolean use(String cmd) {
		if(owner != null && owner.getField() != null) {
			if(cmd == "Clear") {
				System.out.println(owner.getName() + " uses a shovel to clear an extra unit of snow.");
				owner.getField().updateSnow(-1);
				return true;
			}
			return false;
		}
		return false;
	}

}
