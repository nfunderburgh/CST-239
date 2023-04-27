package app;

public class Game {

	
	/**
	 * prints message and fires bomb with amount of power inserted
	 * 
	 * @param  WeaponInterface
	 * @return void
	 */
	private static void fireWeapon(WeaponInterface weapon) {
		if (weapon instanceof Bomb) {
			System.out.println("---------> I am a Bomb");
		}
		weapon.activate(true);
		weapon.fireWeapon(5);
	}
	
	public static void main(String[] args) {
		
		WeaponInterface[] weapons = new WeaponInterface[2];
		weapons[0] = new Bomb();
		weapons[1] = new Gun();
		
		for(int x=0; x < weapons.length; ++x) {
			fireWeapon(weapons[x]);
		}
		
	}
	
	
}
