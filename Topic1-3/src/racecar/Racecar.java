package racecar;

import car.Engine;
import car.Tire;

public class Racecar {

	private Tire[] tires;
	private Engine engine;
	public float totalDistanceTraveled = 0;
	
	/**
	 * Creates new instance of the engine and fills all tires with 32 psi
	 * 
	 * @param  none
	 * @return  none
	 */
	public Racecar() {
		tires = new Tire[4];
		for( int i = 0; i < tires.length; i++) {
			tires[i] = new Tire(32);
		}
		engine = new Engine();
	}
	
	/**
	 * This method checks the tire pressure of all four tires
	 * 
	 * @param  none
	 * @return  boolean  return true if tire pressure is greater then 32 otherwise return false
	 */
	public boolean checkTirePressure() {
		for( int i = 0; i < tires.length; i++) {
			if(tires[i].getPsi() < 32) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method starts the race car
	 * 
	 * @param  none
	 * @return  void
	 */
	public void startRacecar() {
		if(checkTirePressure()) {
			engine.startEngine();
		}
		else {
			System.out.println("Tire pressue is to low to start up the engine.");
		}
	}
	
	/**
	 * This method stops the race car
	 * 
	 * @param  none
	 * @return  void
	 */
	public void stopRacecar() {
		engine.stopEngine();
	}
	
	/**
	 * This method restarts the distance traveled and restarts the engine
	 * 
	 * @param  none
	 * @return  void
	 */
	public void restart() {
		totalDistanceTraveled = 0;
		engine.stopEngine();
		engine.startEngine();
	}
	
	/**
	 * This method calculates total distance the race car traveled
	 * 
	 * @param  speed  the mph the race car is traveling at
	 * @param  time   how long the car is driving
	 * @return  the total distance traveled
	 */
	public float run(int speed, int time) {
		if (!this.engine.isRunning) {
			System.out.println("You're engine is off! The car didn't move...");
			return 0;
		}
		float hours = (float) time / 60;
		hours =  hours / 60;
		totalDistanceTraveled += speed * hours;
		return totalDistanceTraveled;
	}
	
	
}
