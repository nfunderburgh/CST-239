package app;

public class Gun implements WeaponInterface{

	
	/**
	 * prints message and Fires gun with amount of power inserted
	 * 
	 * @param  power  the amount of power of the bomb
	 * @return void
	 */
	public void fireWeapon(int power) {
		System.out.println("In Gun.fireWeapon() with a power of " + power);
	}
	
	/**
	 * prints message and Fires gun weapon with fixed five power
	 +
	 * @param  power  the amount of power of the bomb
	 * @return void
	 */
	public void fireWeapon() {
		System.out.println("In overload Gun.fireWeapon()");
	}

	/**
	 * Prints if Gun is active
	 * 
	 * @param  enable  this parameter activates or deactivates the gun
	 * @return void
	 */
	public void activate(boolean enable) {
		System.out.println("In the Gun.active() with an enable of " + enable);
		
	}
}
