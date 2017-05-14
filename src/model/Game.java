package model;

import java.util.ArrayList;

/**
 *
 * Class Description: Class that represents all games in ozlympics.
 * 
 * @author: Eashan Tilve
 */

public class Game {

	private ArrayList<Game> games = new ArrayList<Game>();
	private char currentGame;
	public static final char CYCLING_ID = 'C';
	public static final char RUNNING_ID = 'R';
	public static final char SWIMMING_ID = 'S';
	private static final int ARRAY_OFFSET = 2;
	private static int gameCount = 1;

	/**
	 * CONSTRUCTOR
	 * 
	 * Adds starting elements in uniqueCyclingID, uniqueRunningID and
	 * uniqueSwimmingID
	 */
	public Game() {
		super();

	}

	/**
	 * This method is used to set the game that is currently selected
	 * 
	 * @param int
	 *            currentGame: contains either 1,2 or 3 for swimming, cycling or
	 *            runnning respectively.
	 */
	public void setCurrentGame(char currentGame) {
		this.currentGame = currentGame;
	}

	/**
	 * This method is used to get the game that is currently selected
	 * 
	 * @return int currentGame: contains either 1,2 or 3 for swimming, cycling
	 *         or runnning respectively.
	 */
	public char getCurrentGame() {
		return currentGame;
	}

	/**
	 * This method is used to get the game that is currently selected
	 * 
	 * @return int currentGame: contains either 1,2 or 3 for swimming, cycling
	 *         or runnning respectively.
	 */
	public Game getSelectedGame() {
		return games.get(gameCount - ARRAY_OFFSET);
	}

	/**
	 * This method is used to get an array list of all games
	 * 
	 * @return ArrayList<Game> games
	 */
	public ArrayList<Game> getGames() {
		return games;
	}

	/**
	 * This method is used to create a new instance of Swimming
	 * 
	 * @return Swimming new swimming game object
	 */
	public void CreateNewSwimmingGame() {
		String gameID;
		if (gameCount < 10)
			gameID = SWIMMING_ID + "0" + Integer.toString(gameCount++);
		else
			gameID = SWIMMING_ID + Integer.toString(gameCount++);

		games.add(new Swimming(gameID));

	}

	/**
	 * This method is used to create a new instance of Cycling
	 * 
	 * @return Cycling new cycling game object
	 */
	public void CreateNewCyclingGame() {
		String gameID;
		if (gameCount < 10)
			gameID = CYCLING_ID + "0" + Integer.toString(gameCount++);
		else
			gameID = CYCLING_ID + Integer.toString(gameCount++);

		games.add(new Cycling(gameID));
	}

	/**
	 * This method is used to create a new instance of Running
	 * 
	 * @return Running new running game object
	 */
	public void CreateNewRunningGame() {
		String gameID;
		if (gameCount < 10)
			gameID = RUNNING_ID + "0" + Integer.toString(gameCount++);
		else
			gameID = RUNNING_ID + Integer.toString(gameCount++);

		games.add(new Running(gameID));
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
	 * This method is used to get an official randomly from the participant
	 * list.
	 * 
	 * @param ParticipantList
	 *            participantList
	 * @return Official official
	 */
	public void assignOfficial(Official official) {
		System.out.println("GC " + gameCount);
		Game game = this.games.get(gameCount - ARRAY_OFFSET);
		if (game instanceof Swimming) {
			((Swimming) game).setOfficial(official);
		} else if (game instanceof Running) {
			((Running) game).setOfficial(official);

		} else if (game instanceof Cycling) {
			((Cycling) game).setOfficial(official);

		}
	}

	/**
	 * This method is used to assign the athletes and the official to the
	 * cycling game.
	 * 
	 * @param ParticipantList
	 *            participantList This parameter contains the list of all the
	 *            participants
	 */
	public void assignContestants(ArrayList<Athlete> athletes) {

		Game game = this.games.get(gameCount - ARRAY_OFFSET);
		if (game instanceof Swimming) {
			this.setCurrentGame(SWIMMING_ID);
			((Swimming) game).setContestants(athletes);
		} else if (game instanceof Running) {
			((Running) game).setContestants(athletes);
			this.setCurrentGame(RUNNING_ID);

		} else if (game instanceof Cycling) {
			((Cycling) game).setContestants(athletes);
			this.setCurrentGame(CYCLING_ID);

		}

		for (Athlete athlete : athletes) {
			if (athlete instanceof SuperAthlete) {
				((SuperAthlete) athlete).setCurrentGame(currentGame);
			}
		}

	}

	public void decrementGameCount() {
		Game.gameCount--;
	}

}
