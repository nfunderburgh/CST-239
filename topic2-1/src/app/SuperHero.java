package app;

import java.util.Random;

public class SuperHero {
	private String name;
	private int health;
	private boolean isDead;
	
	/**
	 * parameterized constructor
	 * 
	 * @param  health  superhero's health
	 * @param  name  the name of the superhero
	 * @return none
	 */
	public SuperHero(String name, int health) {
		this.name = name;
		this.health = health;
	}
	
	
	/**
	 * Attacks an a opposing superhero by randomly generating a amount of damage to attack
	 * 
	 * @param  opponent  the opponent to attack
	 * @return none
	 */
	public void attack(SuperHero opponent) {
		Random rand = new Random();
		int damage = rand.ints(1, (10_1)).findFirst().getAsInt();
		
		opponent.determineHealth(damage);
		System.out.println(String.format("%s has damage of %d and health of %d", opponent.name,damage, opponent.health));
	}
	
	/**
	 * returns value of isDead
	 * 
	 * @param  none
	 * @return boolean  returns the values of isDead
	 */
	public boolean isDead() {
		return this.isDead;
	}
	
	/**
	 * used to determine is superhero's health is 0 or below
	 * 
	 * @param  damage  the amount of damage done to the super hero
	 * @return none
	 */
	private void determineHealth(int damage) {
		if(this.health - damage <= 0) {
			this.health = 0;
			this.isDead = true;
		}
		else {
			this.health = this.health - damage;
		}
	}
}
