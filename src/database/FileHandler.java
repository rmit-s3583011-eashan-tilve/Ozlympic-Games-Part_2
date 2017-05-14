package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
			// do something
		}
	}
	
	public void writeToGameResults(String msg) {
			try {
				FileWriter writer = new FileWriter("src/database/gameResults.txt",true);
				writer.append(msg);
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
}
