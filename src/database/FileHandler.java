package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

	public FileHandler() {
		try {
			FileWriter writer = new FileWriter("src/database/gameResults.txt");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToFile(String filename, String msg) {
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write(msg);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToGameResults(String msg) {
		try {
			FileWriter writer = new FileWriter("src/database/gameResults.txt", true);
			writer.append(msg);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

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
