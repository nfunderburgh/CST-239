package app;

public abstract class Weapon {
	
	/**
	 * prints message and fires weapon with amount of power inserted
	 * 
	 * @param  power  the amount of power of the bomb
	 * @return void
	 */
	public void fireWeapon(int power) {
		System.out.println("In Weapon.fireWeapon() with a power of " + power);
	}
	
	/**
	 * prints message and Fires gun with amount of power inserted
	 * 
	 * @param  enable  activates the method
	 * @return void
	 */
	public abstract void activate(boolean enable);
}
