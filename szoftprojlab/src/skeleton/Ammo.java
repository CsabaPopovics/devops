package skeleton;

/**
 * Az Ammo oszt�ly felel�ss�ge, hogy amikor haszn�lj�k hozz�j�rul a jelz�rak�ta �sszeszerel�s�hez.
 * Az Item oszt�lyb�l sz�rmazik le.
 * @see Item
 * @author Csaba Popovics
 *
 */

public class Ammo extends Item {
	
	/**
	 * T�lt�ny felhaszn�l�sa.
	 * @param cmd amire felhaszn�ln�k
	 * @return true ha �sszeszerel�shez haszn�lj�k
	 */
	@Override
	public boolean use(String cmd) {
		if(cmd == "AddPart") {
			System.out.println(owner.getName() + " adds ammo.");
			owner.levelUp();
			return true;
		}
		return false;
	}
}
