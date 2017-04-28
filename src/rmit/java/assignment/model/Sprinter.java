package rmit.java.assignment.model;

import java.util.Random;

/**
 *
 * Class Description: Class that represents sprinters. Superclass: Athlete
 * 
 * @author: Eashan Tilve
 */

public class Sprinter extends Athlete {

	public static final int MINIMUM_SPRINT_TIME = 10;
	public static final int MAXIMUM_SPRINT_TIME = 20;

	private String name;
	private int age;
	private String state;
	private int uniqueID;
	private int points = 0;

	/**
	 * This method is used to increment the points of the sprinter.
	 * 
	 * @param int
	 *            newPoints are the number of points that the sprinter earned.
	 */
	@Override
	public void addPoints(int newPoints) {
		this.points += newPoints;
	}

	/**
	 * CONSTRUCTOR
	 * 
	 * @param String
	 *            name: name of the sprinter
	 * @param int
	 *            age: age of the sprinter
	 * @param String
	 *            state: state of teh sprinter
	 * @param int
	 *            uniquID: id of the sprinter
	 * 
	 */
	public Sprinter(String name, int age, String state, int uniqueID) {
		super();
		this.name = name;
		this.age = age;
		this.state = state;
		this.uniqueID = uniqueID;
	}

	/**
	 * This method is used to calculate the sprinter's game time.
	 * 
	 * @return float This returns the time taken for sprinter to complete the
	 *         race.
	 */
	@Override
	public float compete() {

		Random randomGenerator = new Random();
		return MINIMUM_SPRINT_TIME + randomGenerator.nextFloat() * (MAXIMUM_SPRINT_TIME - MINIMUM_SPRINT_TIME);

	}

	/**
	 * This method is used to get points of the sprinter.
	 * 
	 * @return int will return number of points that the sprinter has.
	 */
	@Override
	public int getPoints() {
		return this.points;
	}

	/**
	 * This method is used to get uniqueID of the sprinter.
	 * 
	 * @return int will return the sprinter's unique ID.
	 */
	@Override
	public int getUniqueID() {
		return uniqueID;
	}

	/**
	 * This method is used return a string of the sprinter's parameters for
	 * printing on console.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", state=" + state + ", uniqueID=" + uniqueID;
	}

}
