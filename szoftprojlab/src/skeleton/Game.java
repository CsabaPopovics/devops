package skeleton;

import java.util.ArrayList;

import characters.Pawn;
import fields.*;
import items.*;

public class Game {
	private ArrayList<Pawn> characters;
	private ArrayList<Field> fields;
	
	private static Ammo collectedAmmo = null;
	private static Pistol collectedPistol = null;
	private static Flare collectedFlare = null;
	
	public static void addAmmo(Ammo ammo) {
		collectedAmmo = ammo;
	}
	
	public static void addPistol(Pistol pistol) {
		collectedPistol = pistol;
	}
	
	public static void addFlare(Flare flare) {
		collectedFlare = flare;
	}
	
	public int getPlayerCount() {
		return characters.size();
	}
	

}
