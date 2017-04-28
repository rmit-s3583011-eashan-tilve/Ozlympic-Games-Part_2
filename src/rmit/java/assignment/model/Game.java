package rmit.java.assignment.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import rmit.java.assignment.database.ParticipantList;

/**
 *
 * Class Description: Class that represents all games in ozlympics.
 * 
 * @author: Eashan Tilve
 */

public class Game {

	private ArrayList<Integer> uniqueCyclingID = new ArrayList<Integer>();
	private ArrayList<Integer> uniqueRunningID = new ArrayList<Integer>();
	private ArrayList<Integer> uniqueSwimmingID = new ArrayList<Integer>();
	private ArrayList<Swimming> swimmingGames = new ArrayList<Swimming>();
	private ArrayList<Cycling> cyclingGames = new ArrayList<Cycling>();
	private ArrayList<Running> runningGames = new ArrayList<Running>();
	private int currentGame;
	private static final char CYCLING_ID = 'C';
	private static final char RUNNING_ID = 'R';
	private static final char SWIMMING_ID = 'S';
	private static final int OFFICIALS_COUNT = 8;

	/**
	 * CONSTRUCTOR
	 * 
	 * Adds starting elements in uniqueCyclingID, uniqueRunningID and
	 * uniqueSwimmingID
	 */
	public Game() {
		super();
		uniqueCyclingID.add(0);
		uniqueRunningID.add(0);
		uniqueSwimmingID.add(0);
	}

	/**
	 * This method is used to set the game that is currently selected
	 * 
	 * @param int
	 *            currentGame: contains either 1,2 or 3 for swimming, cycling or
	 *            runnning respectively.
	 */
	public void setCurrentGame(int currentGame) {
		this.currentGame = currentGame;
	}

	/**
	 * This method is used to get the game that is currently selected
	 * 
	 * @return int currentGame: contains either 1,2 or 3 for swimming, cycling
	 *         or runnning respectively.
	 */
	public int getCurrentGame() {
		return currentGame;
	}

	/**
	 * This method is used to get an array list of all swimming games selected
	 * 
	 * @return ArrayList<Swimming> swimmingGames
	 */
	public ArrayList<Swimming> getSwimmingGames() {
		return swimmingGames;
	}

	/**
	 * This method is used to get an array list of all cycling games selected
	 * 
	 * @return ArrayList<Cycling> cyclingGames
	 */
	public ArrayList<Cycling> getCyclingGames() {
		return cyclingGames;
	}

	/**
	 * This method is used to get an array list of all running games selected
	 * 
	 * @return ArrayList<Running> runningGames
	 */
	public ArrayList<Running> getRunningGames() {
		return runningGames;
	}

	/**
	 * This method is used to generate a unique ID for a new cycling game
	 * 
	 * @return String unique ID for a new cycling game
	 */
	private String generateUniqueCyclingID() {
		int maxUniqueID = Collections.max(uniqueCyclingID) + 1;
		uniqueCyclingID.add(maxUniqueID);
		return CYCLING_ID + Integer.toString(maxUniqueID);

	}

	/**
	 * This method is used to generate a unique ID for a new running game
	 * 
	 * @return String unique ID for a new running game
	 */
	private String generateUniqueRunningID() {
		int maxUniqueID = Collections.max(uniqueRunningID) + 1;
		uniqueRunningID.add(maxUniqueID);
		return RUNNING_ID + Integer.toString(maxUniqueID);

	}

	/**
	 * This method is used to generate a unique ID for a new swimming game
	 * 
	 * @return String unique ID for a new swimming game
	 */
	private String generateUniqueSwimmingID() {
		int maxUniqueID = Collections.max(uniqueSwimmingID) + 1;
		uniqueSwimmingID.add(maxUniqueID);
		return SWIMMING_ID + Integer.toString(maxUniqueID);

	}

	/**
	 * This method is used to create a new instance of Swimming
	 * 
	 * @return Swimming new swimming game object
	 */
	public Swimming CreateNewSwimmingGame(ParticipantList participantList) {
		Swimming swimming = new Swimming(this.generateUniqueSwimmingID(), this.assignOfficial(participantList));
		return swimming;
	}

	/**
	 * This method is used to create a new instance of Cycling
	 * 
	 * @return Cycling new cycling game object
	 */
	public Cycling CreateNewCyclingGame(ParticipantList participantList) {
		Cycling cycling = new Cycling(this.generateUniqueCyclingID(), this.assignOfficial(participantList));
		return cycling;
	}

	/**
	 * This method is used to create a new instance of Running
	 * 
	 * @return Running new running game object
	 */
	public Running CreateNewRunningGame(ParticipantList participantList) {
		Running running = new Running(this.generateUniqueRunningID(), this.assignOfficial(participantList));
		return running;
	}

	/**
	 * This method is used to print the participants of the game
	 * 
	 * @return int athleteCount number of athletes that are a part of the game
	 */
	public int showParticipants(ArrayList<Athlete> athletes) {
		int athleteCount = 0;
		for (Athlete athlete : athletes) {
			System.out.print(++athleteCount + ". ");
			System.out.println(athlete);
		}
		return athleteCount;
	}


	/**
	 * This method is used to print the reults of swimming games
	 * 
	 */
	public void displaySwimmingResults() {
		ArrayList<Athlete> swimmers = null;
		HashMap<Athlete, Float> timings = null;
		int athleteCount = 0;
		System.out.println("SWIMMING GAMES:");
		for (Swimming swimming : swimmingGames) {
			swimmers = swimming.getContestants();
			timings = swimming.getTimings();
			athleteCount = 0;
			System.out.println("SWIMMING GAME " + swimming.getGameID());
			for (Athlete swimmer : swimmers) {
				System.out.println(++athleteCount + ". " + swimmer + " Time: " + timings.get(swimmer));
			}
			System.out.println("REFREE: " + swimming.getOfficial());
			System.out.println();

		}
	}

	/**
	 * This method is used to print the reults of running games
	 * 
	 */
	public void displayRunningResults() {
		ArrayList<Athlete> sprinters = null;
		HashMap<Athlete, Float> timings = null;
		int athleteCount = 0;
		System.out.println("RUNNING GAMES:");
		for (Running running : runningGames) {
			sprinters = running.getContestants();
			timings = running.getTimings();
			athleteCount = 0;
			System.out.println("RUNNING GAME " + running.getGameID());
			for (Athlete sprinter : sprinters) {
				System.out.println(++athleteCount + ". " + sprinter + " Time: " + timings.get(sprinter));
			}
			System.out.println("REFREE: " + running.getOfficial());
			System.out.println();

		}
	}

	/**
	 * This method is used to print the reults of cycling games
	 * 
	 */
	public void displayCyclingResults() {
		ArrayList<Athlete> cyclists = null;
		HashMap<Athlete, Float> timings = null;
		int athleteCount = 0;
		System.out.println("CYCLING GAMES:");
		for (Cycling cycling : cyclingGames) {
			cyclists = cycling.getContestants();
			timings = cycling.getTimings();
			athleteCount = 0;
			System.out.println("CYCLING GAME " + cycling.getGameID());
			for (Athlete cyclist : cyclists) {
				System.out.println(++athleteCount + ". " + cyclist + " Time: " + timings.get(cyclist));
			}
			System.out.println("REFREE: " + cycling.getOfficial());
			System.out.println();
		}
	}
	
	/**
	 * This method is used to get an official randomly from the participant
	 * list.
	 * 
	 * @param ParticipantList
	 *            participantList
	 * @return Official official
	 */
	public Official assignOfficial(ParticipantList participantList) {
		int random = (int) (Math.random() * OFFICIALS_COUNT);

		return participantList.getOfficials().get(random);
	}

}
