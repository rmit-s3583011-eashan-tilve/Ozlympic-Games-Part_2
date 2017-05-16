package controller;

/**
*
* Class Description: This class is used to check the exceptional scenario when a wrong type of athlete is assigned to the game
* 
* @author : Eashan Tilve
*/
@SuppressWarnings("serial")
public class WrongTypeException extends Exception {

	public WrongTypeException() {
		super("Wrong type of participant. Cannot assign this participant to this game.");
		System.out.println("Wrong type of participant. Cannot assign this participant to this game.");
	}

}
