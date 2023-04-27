package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJsonFiles {

	/*
	 * saves the car parameters into the out file
	 * 
	 * @param filename  the file name
	 * @param car  the car object to save to out file
	 * @param appead   append the item to the next
	 * @return void
	 */
	private static void saveToFile(String filename, Car car, boolean append) {
		PrintWriter pw;
		try {
			File file = new File(filename);
			FileWriter fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);
			
			ObjectMapper objectMapper = new ObjectMapper();
			//String json = objectMapper.writeValueAString(car);
			pw.flush();
			//pw.println(json);
			
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		Car[] cars = new Car[5];
		cars[0] = new Car(2018, "Ford", "Mustang", 0, 1.5d);
		cars[1] = new Car(2018, "Ford", "Mustang", 0, 1.5d);
		cars[2] = new Car(2019, "Ford", "Mustang", 0, 1.5d);
		cars[3] = new Car(2018, "Ford", "Mustang", 0, 1.5d);
		cars[4] = new Car(2010, "Ford", "Mustang", 0, 1.5d);
		
		for(int x=0; x <= 4; ++x) {
			saveToFile("out.json", cars[x], true);
		}
		
		ArrayList<Car>carsList = readFromFile("out.json");
		
		for(Car car : carsList) {
			String text = Integer.toString(car.getYear()) + "," +
											car.getMake() + "," + 
											car.getModel() + "," +
											Integer.toString(car.getOdometer()) + "," +
											Double.toString(car.getEngingeLiters());
			
			System.out.println(text);
		}
	}

	/*
	 * saves the car parameters into the out file
	 * 
	 * @param filename  the file name
	 * @return ArrayList<Car>  returns an arraylist of cars
	 * 
	 */
	private static ArrayList<Car> readFromFile(String filename) {
		ArrayList<Car> cars = new ArrayList<Car>();
		try {
			File file = new File(filename);
			Scanner s = new Scanner(file);
			
			while(s.hasNext()) {
				String json = s.nextLine();
				ObjectMapper objectMapper = new ObjectMapper();
				Car car = objectMapper.readValue(json, Car.class);
				cars.add(car);
			}
			s.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return cars;
	}
}
