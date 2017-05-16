package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import application.Ozlympic;
import database.ParticipantList;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.Athlete;
import model.Cycling;
import model.Game;
import model.Official;
import model.Running;
import model.Swimming;

/**
 *
 * Class Description: The driver class is where user interaction occurs, and it
 * uses other classes to manage the games.
 * 
 * @author : Eashan Tilve
 */

public class Driver {

	private Game game;
	private ParticipantList participantList;
	public static final int SWIMMING = 1;
	public static final int CYCLING = 2;
	public static final int RUNNING = 3;

	public Game getGame() {
		return game;
	}

	public ParticipantList getParticipantList() {
		return participantList;
	}

	/**
	 * CONSTRUCTOR
	 * 
	 * intializes participantList, game
	 */
	public Driver() {
		System.out.println("Initializing Driver..");
		participantList = new ParticipantList();
		game = new Game();
	}

	/**
	 * Called to get selected athletes from ListView in an ArrayList
	 * 
	 * @param ListView<String>
	 *            Strings containing details of athletes
	 * @return ArrayList<Athlete> Returns ArrayList of the same athletes in Athlete Objects
	 */
	public ArrayList<Athlete> getSelectedAthletes(ListView<String> selectedAthletes) {
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		for (String athlete : selectedAthletes.getItems()) {
			athletes.add((Athlete) participantList.findParticipant(athlete));
		}
		return athletes;
	}

	/**
	 * Called to addResults to Database
	 * 
	 * @param String
	 *            String containing the officials details
	 * @return Official Returns the Official object
	 */
	public Official getSelectedOfficial(String official) {
		return (Official) participantList.findParticipant(official);
	}

	public ArrayList<Athlete> getSelectedAthletesBy(ObservableList<String> selectedItems) {
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		for (String athlete : selectedItems) {
			athletes.add((Athlete) participantList.findParticipant(athlete));
		}

		return athletes;
	}

	/**
	 * Called to addResults to File gameResults.txt
	 *
	 */
	public void addGameResults(ArrayList<Athlete> sortedTimings, HashMap<Athlete, Float> timings) {
		System.out.println("Adding Game Results to file..");
		String pattern = "yyyy-MM-dd' 'HH:mm:ss.S";
		if (this.getGame().getSelectedGame() instanceof Cycling) {
			Cycling game = (Cycling) Ozlympic.driver.getGame().getSelectedGame();
			game.setGameTime(new SimpleDateFormat(pattern).format(new Date()));
			participantList.writeToGame(
					game.getGameID() + ", " + game.getOfficial().getUniqueID() + ", " + game.getGameTime());

		} else if (this.getGame().getSelectedGame() instanceof Swimming) {
			Swimming game = (Swimming) Ozlympic.driver.getGame().getSelectedGame();
			game.setGameTime(new SimpleDateFormat(pattern).format(new Date()));
			participantList.writeToGame(
					game.getGameID() + ", " + game.getOfficial().getUniqueID() + ", " + game.getGameTime());

		} else if (this.getGame().getSelectedGame() instanceof Running) {
			Running game = (Running) Ozlympic.driver.getGame().getSelectedGame();
			game.setGameTime(new SimpleDateFormat(pattern).format(new Date()));
			participantList.writeToGame(
					game.getGameID() + ", " + game.getOfficial().getUniqueID() + ", " + game.getGameTime());

		}
		participantList.writeToGame("\n");
		int athletePosition = 1;
		for (Athlete athlete : sortedTimings) {
			if (athletePosition == 1)
				participantList.writeToGame(athlete.getUniqueID() + ", " + timings.get(athlete) + ", 5");
			else if (athletePosition == 2)
				participantList.writeToGame(athlete.getUniqueID() + ", " + timings.get(athlete) + ", 2");
			else if (athletePosition == 3)
				participantList.writeToGame(athlete.getUniqueID() + ", " + timings.get(athlete) + ", 1");
			else
				participantList.writeToGame(athlete.getUniqueID() + ", " + timings.get(athlete) + ", 0");

			participantList.writeToGame("\n");
			athletePosition++;
		}
		participantList.writeToGame("\n");
	}

	/**
	 * Called to addResults to Database
	 *
	 */
	public void addResultsToDatabase() {
		participantList.addResultsToDatabase(this.getGame().getSelectedGame());
	}

}
