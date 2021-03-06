package model;

import java.util.ArrayList;
import java.util.HashMap;

import application.Ozlympic;

/**
 *
 * Class Description: Class that assigns Officials for all the games
 * 
 * @author : Carol Benita Saldanha
 */

public class Official extends Participants {
	private String name;
	private String age;
	private String state;
	private String uniqueID;
	private static final int FIRST_PLACE = 5;
	private static final int SECOND_PLACE = 2;
	private static final int THIRD_PLACE = 1;
	
	/**
	 * CONSTRUCTOR
	 * 
	 * @param String
	 *            name: name of the official
	 * @param String
	 *            age: age of the official
	 * @param String
	 *            state: state of the official
	 * @param String
	 *            uniqueID: ID of the official
	 */

	public Official(String name, String age, String state, String uniqueID) {
		this.name = name;
		this.age = age;
		this.state = state;
		this.uniqueID = uniqueID;
	}

	/**
	 * CONSTRUCTOR
	 * 
	 */
	public Official() {
	}

	/**
	 * This method is used to return a String of Official's parameters for
	 * printing on console
	 */
	@Override
	public String toString() {
		return  "ID: " + uniqueID + ", NAME: " + name + ", AGE: " + age + ", STATE: " + state;
	}

	

	/**
	 * This method is used to get the ID of the official.
	 * 
	 * @return Official official
	 */
	@Override
	public String getUniqueID() {
		return uniqueID;
	}

	/**
	 * This method is used to compute and print the results of the game.
	 * 
	 * @param (HashMap<Athlete,
	 *            Float> timings: timings of all the athletes in the race
	 * @return ArrayList<Athlete> sortedTimings returns the arrayList of
	 *         athletes in the order of their position in the race
	 */
	public ArrayList<Athlete> computeWinners(HashMap<Athlete, Float> timings)
	{
		float minTime;
		final float MAX_TIME = 1000;
		Athlete nextAthlete = null;
		ArrayList<Athlete> sortedTimings = new ArrayList<Athlete>();
		HashMap<Athlete, Float> raceTimings = new HashMap<Athlete, Float>();
		for (Athlete athlete : timings.keySet()) {
			raceTimings.put(athlete, timings.get(athlete));
		}
		while (!raceTimings.isEmpty()) {
			minTime = MAX_TIME;
			for (Athlete athlete : raceTimings.keySet()) {
				if (raceTimings.get(athlete) <= minTime) {
					minTime = raceTimings.get(athlete);
					nextAthlete = athlete;
				}
			}
			sortedTimings.add(nextAthlete);
			raceTimings.remove(nextAthlete);
		}
		printResults(sortedTimings, timings);
		Ozlympic.driver.addGameResults(sortedTimings, timings);
		return sortedTimings;
	}


	/**
	 * This method is used to print the results of the game and give points to
	 * the top 3 athletes
	 * 
	 * @param (HashMap<Athlete,
	 *            Float> timings: timings of all the athletes in the race
	 * @param ArrayList<Athlete>
	 *            sortedTimings the arrayList of athletes in the order of their
	 *            position in the race
	 */
	private void printResults(ArrayList<Athlete> sortedTimings, HashMap<Athlete, Float> timings) {
		int resultCount = 0;
		System.out.println("Results:");

		for (Athlete athlete : sortedTimings) {
			System.out.println(++resultCount + ". " + athlete + " Time: " + timings.get(athlete));

			if (resultCount == 1)
				athlete.addPoints(FIRST_PLACE);
			else if (resultCount == 2)
				athlete.addPoints(SECOND_PLACE);
			else if (resultCount == 3)
				athlete.addPoints(THIRD_PLACE);
		}
	}

	public String getName() {
		return this.name;
	}
}
