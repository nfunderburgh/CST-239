package car;

public class Tire {
	
	private int psi;
	
	/**
	 * Constructer creates the tire with psi
	 * 
	 * @param  psi  the pressure of the tires
	 * @return  none
	 */
	public Tire(int psi) {
		this.psi = psi;
	}
	
	/**
	 * This method gets the current psi of tires
	 * 
	 * @param  none
	 * @return  psi  returns current psi of tires
	 */
	public int getPsi() {
		return psi;
	}
}
