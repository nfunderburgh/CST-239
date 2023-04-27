package app;

public class Bomb implements WeaponInterface{
	
	/**
	 * prints message and fires bomb with amount of power inserted
	 * 
	 * @param  power  the amount of power of the bomb
	 * @return void
	 */
	public void fireWeapon(int power) {
		System.out.println("In Bomb.fireWeapon() with a power of " + power);
	}
	
	/**
	 * prints message and fires bomb weapon with fixed ten power
	 * 
	 * @param  power  the amount of power of the bomb
	 * @return void
	 */
	public void fireWeapon() {
		System.out.println("In Bomb.fireWeapon()");
	}

	/**
	 * Prints if bomb is active
	 * 
	 * @param  enable  this parameter activates or deactivates the bomb
	 * @return void
	 */
	public void activate(boolean enable) {
		System.out.println("In the Bomb.active() with an enable of " + enable);
	}
}
