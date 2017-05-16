package controller;

/**
*
* Class Description: This class is used to check the exceptional scenario when the number of athletes in the game is less than four
* 
* @author : Eashan Tilve
*/
@SuppressWarnings("serial")
public class TooFewAthleteException  extends Exception {

	public TooFewAthleteException() {
		super("Need atleast 4 Athletes to run run this game.");
	}

}