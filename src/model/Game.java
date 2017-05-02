package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import controller.Driver;
import database.ParticipantList;

/**
 *
 * Class Description: Class that represents all games in ozlympics.
 * 
 * @author: Eashan Tilve
 */

public class Game {

	private ArrayList<Game> games = new ArrayList<Game>();
	private int currentGame;
	private static final char CYCLING_ID = 'C';
	private static final char RUNNING_ID = 'R';
	private static final char SWIMMING_ID = 'S';
	private static final int OFFICIALS_COUNT = 8;
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
		games.add(new Swimming(SWIMMING_ID + Integer.toString(gameCount++)));

	}

	/**
	 * This method is used to create a new instance of Cycling
	 * 
	 * @return Cycling new cycling game object
	 */
	public void CreateNewCyclingGame() {
		games.add(new Cycling(CYCLING_ID + Integer.toString(gameCount++)));

	}

	/**
	 * This method is used to create a new instance of Running
	 * 
	 * @return Running new running game object
	 */
	public void CreateNewRunningGame() {
		games.add(new Running(RUNNING_ID + Integer.toString(gameCount++)));
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
			((Swimming) game).setContestants(athletes);
		} else if (game instanceof Running) {
			((Running) game).setContestants(athletes);

		} else if (game instanceof Cycling) {
			((Cycling) game).setContestants(athletes);

		}

	}

}
