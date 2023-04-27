package car;

public class Engine {

	public boolean isRunning = false;

	/**
	 * This method turns is running to true
	 * and starts the engine

	 * @param  none
	 * @return  void
	 */
	public void startEngine() {
		isRunning = true;
	}
	
	/**
	 * This method turns is running to false
	 * and stops the engine
	 * 
	 * @param  none
	 * @return  void
	 */
	public void stopEngine() {
		isRunning = false;
	}
}
