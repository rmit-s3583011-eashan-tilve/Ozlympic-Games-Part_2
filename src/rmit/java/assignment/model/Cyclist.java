package rmit.java.assignment.model;

import java.util.Random;

/**
 *
 * Class Description: Class that represents cyclists. Superclass: Athlete
 * 
 * @author: Eashan Tilve
 */
public class Cyclist extends Athlete {

	public static final int MAXIMUM_CYCLING_TIME = 800;
	public static final int MINIMUM_CYCLING_TIME = 500;

	private String name;
	private int age;
	private String state;
	private int uniqueID;
	private int points = 0;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param String
	 *            name: name of the cyclist
	 * @param int
	 *            age: age of the cyclist
	 * @param String
	 *            state: state of teh cyclist
	 * @param int
	 *            uniquID: id of the cyclist
	 * 
	 */
	public Cyclist(String name, int age, String state, int uniqueID) {
		super();
		this.name = name;
		this.age = age;
		this.state = state;
		this.uniqueID = uniqueID;
	}

	/**
	 * This method is used to get points of the cyclist.
	 * 
	 * @return int will return number of points that the athlete has.
	 */
	@Override
	public int getPoints() {
		return points;
	}

	/**
	 * This method is used to increment the points of the cyclist.
	 * 
	 * @param int
	 *            newPoints are the number of points that the athlete earned.
	 */
	@Override
	public void addPoints(int newPoints) {
		this.points += newPoints;
	}

	/**
	 * This method is used return a string of the cyclist's parameters for
	 * printing on console.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", state=" + state + ", ID=" + uniqueID;
	}

	/**
	 * This method is used to calculate the cyclist's game time.
	 * 
	 * @return float This returns the time taken for cyclist to complete the
	 *         race.
	 */
	@Override
	public float compete() {

		Random randomGenerator = new Random();

		return MINIMUM_CYCLING_TIME + randomGenerator.nextFloat() * (MAXIMUM_CYCLING_TIME - MINIMUM_CYCLING_TIME);

	}

	/**
	 * This method is used to get uniqueID of the cyclist.
	 * 
	 * @return int will return the cyclist's unique ID.
	 */
	@Override
	public int getUniqueID() {
		return uniqueID;
	}

}
