package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import database.ParticipantList;
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

	private Scanner scanInput = new Scanner(System.in);
	private ParticipantList participantList;
	private static final int OPTION_1 = 1;
	private static final int OPTION_2 = 2;
	private static final int OPTION_3 = 3;
	private static final int OPTION_4 = 4;
	private static final int OPTION_5 = 5;

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
	 * This method is used to display the options of the Game to the user
	 */
	private void showMenu() {

		System.out.println("Ozlympic Game");
		System.out.println("==========================================");
		System.out.println("1. Select a	game to	run");
		System.out.println("2. Start the game");
		System.out.println("3. Display the final results of all games");
		System.out.println("4. Display the points of all athletes");
		System.out.println("5. Exit");

	}

	/**
	 * This method is used to display the three games to the user
	 */
	private void gameMenu() {
		System.out.println("Games:");
		System.out.println("=============");
		System.out.println("1. Swimming");
		System.out.println("2. Cycling");
		System.out.println("3. Running");
		System.out.println("Which game do you want to run?");

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
			athletes.add((Athlete)participantList.findParticipant(athlete));
		}
		return athletes;
	}

	public Official getSelectedOfficial(String official) {
		return (Official)participantList.findParticipant(official);
	}

}
