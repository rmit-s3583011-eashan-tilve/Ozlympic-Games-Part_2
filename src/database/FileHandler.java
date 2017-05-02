package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

	private String ipAddress;

	public FileHandler() {

	}

	public void writeToFile(String filename, String msg) {
		try {
			PrintWriter writer = new PrintWriter("/Applications/MAMP/htdocs/" + filename, "UTF-8");
			writer.write(msg);
			writer.close();
		} catch (IOException e) {
			// do something
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
