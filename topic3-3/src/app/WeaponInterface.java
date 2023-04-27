package app;

public interface WeaponInterface {
	

	/**
	 * implementation of fire weapon
	 * 
	 * @return void
	 */
	public void fireWeapon();
	
	/**
	 * implementation of fire weapon
	 * 
	 * @param power the power of the weapon
	 * @return void
	 */
	public void fireWeapon(int power);
	
	/**
	 * implementation of activate
	 * 
	 * @param  enable activates the weapon
	 * @return void
	 */
	public void activate(boolean enable);
}
