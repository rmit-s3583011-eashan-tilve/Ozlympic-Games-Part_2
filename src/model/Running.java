package model;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * Class Description: Class that represents Running games. Superclass: Game
 * 
 * @author: Eashan Tilve
 */
public class Running extends Game {
	private ArrayList<Athlete> contestants = new ArrayList<Athlete>();
	private HashMap<Athlete, Float> timings = new HashMap<Athlete, Float>();
	private String gameID;
	private Official official;
	private String gameTime;

	public String getGameTime() {
		return gameTime;
	}

	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}
	

	/**
	 * CONSTRUCTOR
	 * 
	 * @param String
	 *            gameID: used to set running unique ID
	 */
	public Running(String gameID) {
		this.gameID = gameID;
	}

	
	/**
	 * This method is used to get the contestants of the running game
	 * 
	 * @return ArrayList<Athlete> contestants
	 */
	public ArrayList<Athlete> getContestants() {
		return contestants;
	}

	/**
	 * This method is used to get the running Games unique ID
	 * 
	 * @return String returns gameID
	 */
	public String getGameID() {
		return gameID;
	}

	/**
	 * This method is used to get the running Games official
	 * 
	 * @return Official official
	 */
	public Official getOfficial() {
		return official;
	}

	/**
	 * This method is used to record an athletes race time
	 * 
	 * @param float
	 *            timing : athletes game time
	 * @param Athlete
	 *            athlete : the athlete whose time needs to be recorded
	 */
	public void recordAthleteTime(float timing, Athlete athlete) {
		timings.put(athlete, timing);
	}

	/**
	 * This method is used to get the timings of all athletes
	 * 
	 * @return HashMap<Athlete, Float> timings : returns timings of all athletes
	 */
	public HashMap<Athlete, Float> getTimings() {
		return timings;
	}

	/**
	 * This method is used to set the contestants in the running game
	 * 
	 * @param ArrayList<Athlete>
	 *            contestants
	 */
	public void setContestants(ArrayList<Athlete> contestants) {
		this.contestants = contestants;
	}
	
	public void setOfficial(Official official) {
		this.official = official;
	}

}
