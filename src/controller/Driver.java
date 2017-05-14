package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

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
 * @author : Carol Benita Saldanha
 */

public class Driver {

	private Game game;
	private ParticipantList participantList;

	public Game getGame() {
		return game;
	}

	public ParticipantList getParticipantList() {
		return participantList;
	}

	public static final int SWIMMING = 1;
	public static final int CYCLING = 2;
	public static final int RUNNING = 3;

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
	 * This method is used to display points of all the athletes in Ozlympics
	 */
	private void displayPoints() {

		HashMap<Athlete, Integer> pointsTable = new HashMap<Athlete, Integer>();

		for (Athlete swimmer : participantList.getSwimmers()) {
			pointsTable.put(swimmer, swimmer.getPoints());
		}
		for (Athlete cyclist : participantList.getCyclists()) {
			pointsTable.put(cyclist, cyclist.getPoints());
		}
		for (Athlete sprinter : participantList.getSprinters()) {
			pointsTable.put(sprinter, sprinter.getPoints());
		}
		for (Athlete superAthlete : participantList.getSuperAthletes()) {
			pointsTable.put(superAthlete, superAthlete.getPoints());
		}

		int maxPoints;
		int athleteCount = 0;
		Athlete nextAthlete = null;

		while (!pointsTable.isEmpty()) {
			maxPoints = 0;
			for (Athlete athlete : pointsTable.keySet()) {
				if (pointsTable.get(athlete) >= maxPoints) {
					maxPoints = pointsTable.get(athlete);
					nextAthlete = athlete;
				}
			}

			System.out.println(++athleteCount + ". " + nextAthlete + " Points: " + pointsTable.get(nextAthlete));

			pointsTable.remove(nextAthlete);
		}

	}

	/**
	 * This method is used to display the results of all games in Ozlympics.
	 */
	private void displayResults() {

	}

	public ArrayList<Athlete> getSelectedAthletes(ListView<String> selectedAthletes) {
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		for (String athlete : selectedAthletes.getItems()) {
			athletes.add((Athlete) participantList.findParticipant(athlete));
		}
		return athletes;
	}

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

	public void addGameResults(ArrayList<Athlete> sortedTimings, HashMap<Athlete, Float> timings) {
		System.out.println("Adding Game Results to file..");
		String pattern = "yyyy-MM-dd' 'HH:mm:ss.S";
		if (this.getGame().getSelectedGame() instanceof Cycling) {
			Cycling game = (Cycling) Ozlympic.driver.getGame().getSelectedGame();
			participantList.writeToGame(game.getGameID() + ", " + game.getOfficial().getUniqueID() + ", "
					+ new SimpleDateFormat(pattern).format(new Date()));

		} else if (this.getGame().getSelectedGame() instanceof Swimming) {
			Swimming game = (Swimming) Ozlympic.driver.getGame().getSelectedGame();
			participantList.writeToGame(game.getGameID() + ", " + game.getOfficial().getUniqueID() + ", "
					+ new SimpleDateFormat(pattern).format(new Date()));

		} else if (this.getGame().getSelectedGame() instanceof Running) {
			Running game = (Running) Ozlympic.driver.getGame().getSelectedGame();
			participantList.writeToGame(game.getGameID() + ", " + game.getOfficial().getUniqueID() + ", "
					+ new SimpleDateFormat(pattern).format(new Date()));

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

}
