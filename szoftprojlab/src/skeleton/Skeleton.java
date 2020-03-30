package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Az osztály felelõssége demonstrálni a projekt egyes elemeinek mûködését néhány elemtõl eltekintve.
 * @author Csaba Popovics
 *
 */

public class Skeleton {
	
	/**
	 *Demonstrálja mi történik, ha érvénytelen mezõre próbálnak lépni.
	 */
	public static void setup11() {
		IceField f1 = new IceField("f1", 2);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		r1.step(Direction.Up);
	}
	
	/**
	 * Demonstrálja egy sikeres lépés menetét.
	 */
	public static void setup12() {
		IceField f1 = new IceField("f1", 2);
		IceField f2 = new IceField("f2", 2);
		f1.addNeighbour(f2, Direction.Up);
		f2.addNeighbour(f1, Direction.Down);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		r1.step(Direction.Up);
	}
	
	/**
	 * Hó takarítása ásóval.
	 */
	public static void setup21() {
		IceField f1 = new IceField("f1", 2);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		Shovel shovel = new Shovel();
		r1.addToInventory(shovel);
		r1.clearSnow(shovel);
	}
	
	/**
	 * Hó takarítása ha nem ásó van használva.
	 */
	public static void setup22() {
		IceField f1 = new IceField("f1", 2);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		Rope rope = new Rope();
		r1.addToInventory(rope);
		r1.clearSnow(r1.getInventory().get(0));
	}
	
	/**
	 * Tárgy kiásására tett kísérlet, de a mezõ nem tiszta.
	 */
	public static void setup31() {
		IceField f1 = new IceField("f1", 2);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		Food food = new Food();
		f1.placeItem(food);
		r1.excavate();
	}
	
	/**
	 * Tárgy kiásása tiszta mezõbõl.
	 */
	public static void setup32() {
		IceField f1 = new IceField("f1", 0);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		Food food = new Food();
		f1.placeItem(food);
		r1.excavate();
	}
		
	/**
	 * Tiszta mezõbõl való kiásás, de nincs tárgy.
	 */
	public static void setup33() {
		IceField f1 = new IceField("f1", 0);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		r1.excavate();
	}
		
	/**
	 * Étel fogyasztása.
	 */
	public static void setup41() {
		IceField f1 = new IceField("f1", 0);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		Food food = new Food();
		r1.addToInventory(food);
		r1.eat(r1.getInventory().get(0));
	}
		
	/**
	 * Nem étel fogyasztására tett kísérlet.
	 */
	public static void setup42() {
		IceField f1 = new IceField("f1", 0);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		Shovel shovel = new Shovel();
		r1.addToInventory(shovel);
		r1.eat(r1.getInventory().get(0));
	}
		
	/**
	 * Jelzõrakéta sikeres összeszerelése és elsütése.
	 */
	public static void setup51() {
		IceField f1 = new IceField("f1", 0);
		Researcher r1 = new Researcher("Bob", f1);
		Researcher r2 = new Researcher("Alice", f1);
		f1.accept(r1);
		f1.accept(r2);
		Ammo ammo = new Ammo();
		Pistol pistol = new Pistol();
		Flare flare = new Flare();
		r1.addToInventory(ammo);
		r1.addToInventory(flare);
		r2.addToInventory(pistol);
		r1.assembleGun();
	}
		
	/**
	 * Jelzõrakéta sikertelen összeszerelése.
	 */
	public static void setup52() {
		IceField f1 = new IceField("f1", 0);
		Researcher r1 = new Researcher("Bob", f1);
		Researcher r2 = new Researcher("Alice", f1);
		f1.accept(r1);
		f1.accept(r2);
		Ammo ammo = new Ammo();
		Flare flare = new Flare();
		r1.addToInventory(ammo);
		r2.addToInventory(flare);
		r2.assembleGun();
	}
		
	/**
	 * Kutató vizsgál egy adott irányban.
	 */
	public static void setup6() {
		IceField f1 = new IceField("f1", 3);
		Researcher r1 = new Researcher("Bob", f1);
		f1.accept(r1);
		UnstableIceField f2 = new UnstableIceField("f2", 1, 3);
		f1.addNeighbour(f2, Direction.Right);
		f2.addNeighbour(f1, Direction.Left);
		r1.inspect(Direction.Right);
	}
		
	/**
	 * Eszkimó iglut épít.
	 */
	public static void setup71() {
		IceField f1 = new IceField("f1", 3);
		Eskimo e1 = new Eskimo("Alice", f1);
		f1.accept(e1);
		e1.buildIgloo();
	}
		
	/**
	 * Eszkimó iglut építene, de már van.
	 */
	public static void setup72() {
		IceField f1 = new IceField("f1", 3);
		Eskimo e1 = new Eskimo("Alice", f1);
		f1.accept(e1);
		f1.setIgloo();
		e1.buildIgloo();
	}
		
	/**
	 * Hóvihar iglus mezõt érint.
	 */
	public static void setup81() {
		IceField f1 = new IceField("f1", 3);
		Eskimo e1 = new Eskimo("Alice", f1);
		f1.accept(e1);
		f1.setIgloo();
		f1.updateSnow(5);
	}
		
	/**
	 * Hóvihar nem iglus mezõt érint, de mindenki túléli.
	 */
	public static void setup821() {
		IceField f1 = new IceField("f1", 3);
		Eskimo e1 = new Eskimo("Alice", f1);
		Eskimo e2 = new Eskimo("Bob", f1);
		f1.accept(e1);
		f1.accept(e2);
		f1.updateSnow(5);
	}
		
	/**
	 * Hóvihar nem iglus mezõt érint, valaki meg is hal.
	 */
	public static void setup822() {
		IceField f1 = new IceField("f1", 3);
		Eskimo e1 = new Eskimo("Alice", f1);
		Eskimo e2 = new Eskimo("Bob", f1);
		f1.accept(e1);
		f1.accept(e2);
		e2.updateBodyTemp(-4);
		f1.updateSnow(5);
	}
		
	/**
	 * Kimenekítés kötéllel a vízbõl.
	 */
	public static void setup9() {
		Hole h1 = new Hole("h1", 4);
		IceField f1 = new IceField("f1", 3);
		f1.addNeighbour(h1, Direction.Down);
		h1.addNeighbour(f1, Direction.Up);
		Eskimo e1 = new Eskimo("Alice", f1);
		Eskimo e2 = new Eskimo("Bob", f1);
		Rope rope = new Rope();
		e2.addToInventory(rope);
		f1.accept(e1);
		f1.accept(e2);
		e1.step(Direction.Down);
	}
		
	/**
	 * Búvárruha használata.
	 */
	public static void setup10() {
		Hole h1 = new Hole("h1", 4);
		IceField f1 = new IceField("f1", 3);
		f1.addNeighbour(h1, Direction.Down);
		h1.addNeighbour(f1, Direction.Up);
		Eskimo e1 = new Eskimo("Alice", f1);
		Eskimo e2 = new Eskimo("Bob", f1);
		ScubaSuit suit = new ScubaSuit();
		e1.addToInventory(suit);
		f1.accept(e1);
		f1.accept(e2);
		e1.step(Direction.Down);
	}
		
	/**
	 * Vízbeesés után fulladás
	 */
	public static void setup110() {
		Hole h1 = new Hole("h1", 4);
		IceField f1 = new IceField("f1", 3);
		f1.addNeighbour(h1, Direction.Down);
		h1.addNeighbour(f1, Direction.Up);
		Eskimo e1 = new Eskimo("Alice", f1);
		Eskimo e2 = new Eskimo("Bob", f1);
		f1.accept(e1);
		f1.accept(e2);
		e1.step(Direction.Down);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String command = "";
		while(command != "000") {
			System.out.println("===========================================================================");
			System.out.println();
			System.out.println("What should the Skeleton show? Enter the serial next to the option!");
			System.out.println("11 - Stepping in invalid direction.");
			System.out.println("12 - Stepping in a valid direction.");
			System.out.println("21 - Using a shovel to clear snow.");
			System.out.println("22 - Trying to use something that's not a shovel to clear snow.");
			System.out.println("31 - Trying to excavate when the field is not clean.");
			System.out.println("32 - Excavating an item.");
			System.out.println("33 - Excavating, but there is no item.");
			System.out.println("41 - Eating food.");
			System.out.println("42 - Trying to eat something that's not food.");
			System.out.println("51 - Successful flaregun assembly and use.");
			System.out.println("52 - Failed flaregun assembly.");
			System.out.println("6 - Researcher inspects.");
			System.out.println("71 - Eskimo builds igloo.");
			System.out.println("72 - Eskimo tries to build igloo when there is already a built one.");
			System.out.println("81 - Blizzard hits a field with an igloo.");
			System.out.println("821 - Blizzard hits a field with no igloo, but everyone survives it.");
			System.out.println("822 - Blizzard hits a field with no igloo, someone dies.");
			System.out.println("9 - Rescue with a rope.");
			System.out.println("10 - Using scuba suit to survive.");
			System.out.println("110 - Drowning");
			System.out.println("000 - Quit");
			System.out.println();
			System.out.println("===========================================================================");
			
			command = reader.readLine();
			switch(command) {
				case "11":
					setup11();
					break;
				case "12":
					setup12();
					break;
				case "21":
					setup21();
					break;
				case "22":
					setup22();
					break;
				case "31":
					setup31();
					break;
				case "32":
					setup32();
					break;
				case "33":
					setup33();
					break;
				case "41":
					setup41();
					break;
				case "42":
					setup42();
					break;
				case "51":
					setup51();
					break;
				case "52":
					setup52();
					break;
				case "6":
					setup6();
					break;
				case "71":
					setup71();
					break;
				case "72":
					setup72();
					break;
				case "81":
					setup81();
					break;
				case "821":
					setup821();
					break;
				case "822":
					setup822();
					break;
				case "9":
					setup9();
					break;
				case "10":
					setup10();
					break;
				case "110":
					setup110();
					break;
				case "000":
					return;
				default:
					System.out.println("Invalid input!");
					break;
			}
		}

	}

}
