package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePlay {
	
	/*
	 * Copy's the data within inFile and output the data in a nice format in the outfile.
	 * The program also checks for exceptions if the file isn't found, IOException and NullPointer
	 * 
	 * @param InFile The text file that gets read from 
	 * @param OutFile The output file that is created and output text
	 * @return int returns number based on exception
	 * 
	 */
	private static int copyFile(String InFile, String OutFile) {
		BufferedReader in = null;  
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader(InFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
		
		try {
			out = new BufferedWriter(new FileWriter(OutFile));
		} 
		catch (IOException e) {
			e.printStackTrace();
			return -2;
		}
		
		
		String line;
		try {
			while(( line = in.readLine()) != null) {
				out.flush();
				String[] tokens = line.split("\\|");
				out.write(String.format("Name is %s %s of age %s\n", tokens[0], tokens[1], tokens[2]));
			}
		} 
		catch(NullPointerException e) {
			e.printStackTrace();
			return -1;
		}
		catch (IOException e) {
			e.printStackTrace();
			return -2;
		}
		return 0;
		 
	}
	
	public static void main(String[] args) {
		int err = FilePlay.copyFile("InUsers.txt","OutUser.txt");
		
		switch(err) {
			case 0:
				System.out.println("File was copied successfully");
				break;
			case -1:
				System.out.println("File could not be opened.");
				break;
			case -2:
				System.out.println("File I/O error");
				break;
		}
		
	}
}
