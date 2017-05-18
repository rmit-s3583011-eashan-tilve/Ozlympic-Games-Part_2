package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Class Description: This class is used to handle Files Participants.txt and
 * gameResults.txt
 * 
 * @author : Eashan Tilve
 */
public class FileHandler {

	/**
	 * CONSTRUCTOR
	 * 
	 */
	public FileHandler() {
		try {
			URL url = getClass().getResource("gameResults.txt");
			FileWriter writer = new FileWriter(url.getPath());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to write data to a file
	 * 
	 * @param String
	 *            filename
	 * @param String
	 *            msg Message to be writting in the file intializes
	 *            participantList, game
	 */
	public void writeToFile(String filename, String msg) {
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write(msg);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to write data to gameResults.txt
	 * 
	 * @param String
	 *            filename
	 * @param String
	 *            msg Message to be writting in the file intializes
	 *            participantList, game
	 */
	public void writeToGameResults(String msg) {
		try {
			URL url = getClass().getResource("gameResults.txt");
			FileWriter writer = new FileWriter(url.getPath(), true);
			writer.append(msg);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to read data from a file
	 * 
	 * @param String
	 *            filename
	 * @return ArrayList<String>
	 * 				returns contents of file in ArrayList of Strings
	 */
	public ArrayList<String> readFile(String filename) {
		Scanner sc;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			URL url = getClass().getResource(filename);
			sc = new Scanner(new File(url.getPath()));

			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}

	/**
	 * This method is used to check if file exists
	 * 
	 * @param String
	 *            filename
	 * @return boolean
	 * 				returns true if file exists
	 */
	public boolean checkFile(String filename) {
		Scanner sc;
		boolean fileExists = false;
		System.out.println("Checking if file exists..");
		try {
			URL url = getClass().getResource(filename);
			sc = new Scanner(new File(url.getPath()));

			if (sc.hasNextLine()) {
				fileExists = true;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileExists;

	}
}
