package controller;

/**
*
* Class Description: This class is used to check the exceptional scenario when there is no referee assigned to a game
* 
* @author : Eashan Tilve
*/
@SuppressWarnings("serial")
public class NoRefereeException extends Exception {

	public NoRefereeException() {
		super("Please assign a Referee To this Game.");
		System.out.println("Please assign a Referee To this Game Before running it.");
	}

}