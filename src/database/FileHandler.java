package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class FileHandler {

	private String ipAddress;
	public FileHandler() {

	}

	public void writeToFile(String filename, String msg)
	{
		try{
		    PrintWriter writer = new PrintWriter("/Applications/MAMP/htdocs/"+filename, "UTF-8");
		    writer.write(msg);
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}
	
	public String readFile(String filename)
	{
		try {
			   URL url = new URL("http://"+ipAddress+":8888/"+filename);
			   Scanner s = new Scanner(url.openStream());
			  return  s.nextLine();
			   // read from your scanner
			}
			catch(IOException ex) {
			   // there was some connection problem, or the file did not exist on the server,
			   // or your URL was not in the right format.
			   // think about what to do now, and put it here.
			   ex.printStackTrace(); // for now, simply output it.
			}
		return null;
	}
}
