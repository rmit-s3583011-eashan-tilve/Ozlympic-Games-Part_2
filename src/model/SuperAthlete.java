package model;

import java.util.Random;

/**
 *
 * Class Description: Class that represents swimmers. Superclass: Athlete
 * 
 * @author: Eashan Tilve
 */
public class SuperAthlete extends Athlete {

	private String name;
	private String age;
	private String state;
	private String uniqueID;
	private int points = 0;
	private char currentGame = ' ';

	/**
	 * CONSTRUCTOR
	 * 
	 * @param String
	 *            name: name of the superAthlete
	 * @param String
	 *            age: age of the superAthlete
	 * @param String
	 *            state: state of teh superAthlete
	 * @param String
	 *            uniquID: id of the superAthlete
	 * 
	 */
	public SuperAthlete(String name, String age, String state, String uniqueID) {
		super();
		this.name = name;
		this.age = age;
		this.state = state;
		this.uniqueID = uniqueID;
	}

	/**
	 * This method is used to set what is the current game that the super
	 * athlete is playing
	 * 
	 * @param int
	 *            currentGame: contains either S,C or R for swimming, cycling or
	 *            runnning respectively.
	 */
	public void setCurrentGame(char currentGame) {
		this.currentGame = currentGame;
	}

	/**
	 * This method is used to increment the points of the superAthlete.
	 * 
	 * @param int
	 *            newPoints are the number of points that the superAthlete
	 *            earned.
	 */
	@Override
	public void addPoints(int newPoints) {
		this.points += newPoints;
	}

	/**
	 * This method is used to calculate the superAthlete's game time.
	 * 
	 * @return float This returns the time taken for superAthlete's to complete
	 *         the race.
	 */
	@Override
	public float compete() {
		Random randomGenerator = new Random();
		switch (currentGame) {
		case Game.SWIMMING_ID:
			return Swimmer.MINIMUM_SWIM_TIME
					+ randomGenerator.nextFloat() * (Swimmer.MAXIMUM_SWIM_TIME - Swimmer.MINIMUM_SWIM_TIME);

		case Game.RUNNING_ID:

			return Sprinter.MINIMUM_SPRINT_TIME
					+ randomGenerator.nextFloat() * (Sprinter.MAXIMUM_SPRINT_TIME - Sprinter.MINIMUM_SPRINT_TIME);
		case Game.CYCLING_ID:

			return Cyclist.MINIMUM_CYCLING_TIME
					+ randomGenerator.nextFloat() * (Cyclist.MAXIMUM_CYCLING_TIME - Cyclist.MINIMUM_CYCLING_TIME);
		default:
			;
		}

		return 0;
	}

	/**
	 * This method is used to get uniqueID of the superAthlete.
	 * 
	 * @return int will return the superAthlete's unique ID.
	 */
	@Override
	public String getUniqueID() {
		return uniqueID;
	}

	/**
	 * This method is used return a string of the superAthlete's parameters for
	 * printing on console.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "ID: " + uniqueID + ", NAME: " + name + ", AGE: " + age + ", STATE: " + state;
	}

	/**
	 * This method is used to get points of the superAthlete.
	 * 
	 * @return int will return number of points that the superAthlete has.
	 */
	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getState() {
		return state;
	}
}
