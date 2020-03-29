package skeleton;

import java.util.ArrayList;
import java.util.Random;

import characters.Pawn;
import fields.*;
import items.*;

public class Game {
	private static ArrayList<Pawn> characters;
	private static ArrayList<Field> fields;
	
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
	
	public static int getPlayerCount() {
		return characters.size();
	}
	
	public void blizzard() {
		Random extraSnow = new Random();
		for(Field f : fields){
			if(Math.random()>0.55)
				f.updateSnow(extraSnow.nextInt(5)+1);
		}
	}
	
	public static void end() {
	}
	
	public static void win() {
	}

	public static void checkConditions() {
		if(collectedAmmo != null && collectedPistol != null && collectedFlare != null) {
			if(characters.get(0).getField().getCharacters().size()==fields.size()) {
				win();
				return;
			}
			
		}
		collectedAmmo = null;
		collectedPistol = null;
		collectedFlare = null;
		
	}
	

}
