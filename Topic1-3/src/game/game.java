package game;

import java.util.Scanner;

import racecar.Racecar;

public class game {

	public static void displayMenu() {
		System.out.println(
				"Enter 'race' to race your car, 'restart' to race again, or 'stop' to turn off your engine and quit.");
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Racecar rc = new Racecar();

		System.out.println("Hi welcome to Noah's Race track! Enter 'Start' to start your engine and start the race!");

		String input = userInput.nextLine().trim();
		while (!input.equalsIgnoreCase("start")) {
			System.out.println("Your engine doesn't seem to be starting...");
			input = userInput.nextLine();
		}
		if (input.equalsIgnoreCase("start")) {
			rc.startRacecar();
			System.out.println("Your engine fires to up!");
		}

		displayMenu();
		input = userInput.nextLine().trim();

		while (!input.equalsIgnoreCase("stop")) {
			if (input.equalsIgnoreCase("race")) {
				System.out.print("Enter the speed in mph you want to go for the race: ");
				int speed = (int) userInput.nextInt();
				System.out.print("Enter how many seconds you'll be holding down the gas pedal for: ");
				int time = (int) userInput.nextInt();
				float distance = rc.run(speed, time);
				System.out.println("Nice! you've traveled " + distance + " miles down the racetrack this race!\n");
				displayMenu();
			} else if (input.equalsIgnoreCase("restart")) {
				rc.restart();
				System.out.println("Your racecar was stopped and went back to the start line. It's ready to race again!\n");
				displayMenu();
			} else if (input.equalsIgnoreCase("stop")) {
				break;
			}
			input = userInput.nextLine().trim();
		}
		System.out.println("Thanks for racing!");
		userInput.close();
	}
}