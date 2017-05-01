package model;

import java.util.Random;

/**
 *
 * Class Description: Class that represents swimmers. Superclass: Athlete
 * 
 * @author: Eashan Tilve
 */

public class Swimmer extends Athlete {

	public static final int MINIMUM_SWIM_TIME = 100;
	public static final int MAXIMUM_SWIM_TIME = 200;

	private String name;
	private int age;
	private String state;
	private int uniqueID;
	private int points;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param String
	 *            name: name of the swimmer
	 * @param int
	 *            age: age of the swimmer
	 * @param String
	 *            state: state of teh swimmer
	 * @param int
	 *            uniquID: id of the swimmer
	 * 
	 */
	public Swimmer(String name, int age, String state, int uniqueID) {
		super();
		this.name = name;
		this.age = age;
		this.state = state;
		this.uniqueID = uniqueID;
	}

	/**
	 * This method is used to get uniqueID of the swimmer.
	 * 
	 * @return int will return the swimmer's unique ID.
	 */
	@Override
	public int getUniqueID() {
		return uniqueID;
	}

	/**
	 * This method is used to increment the points of the swimmer.
	 * 
	 * @param int
	 *            newPoints are the number of points that the swimmer earned.
	 */
	@Override
	public void addPoints(int newPoints) {
		this.points += newPoints;
	}

	/**
	 * This method is used to calculate the swimmer's game time.
	 * 
	 * @return float This returns the time taken for swimmer's to complete the
	 *         race.
	 */
	@Override
	public float compete() {
		Random randomGenerator = new Random();
		return MINIMUM_SWIM_TIME + randomGenerator.nextFloat() * (MAXIMUM_SWIM_TIME - MINIMUM_SWIM_TIME);
	}

	/**
	 * This method is used to get points of the swimmer.
	 * 
	 * @return int will return number of points that the swimmer has.
	 */
	@Override
	public int getPoints() {
		return this.points;
	}

	/**
	 * This method is used return a string of the swimmer's parameters for
	 * printing on console.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", state=" + state + ", ID=" + uniqueID;
	}

}
