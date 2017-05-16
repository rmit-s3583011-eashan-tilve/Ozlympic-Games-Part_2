package controller;

/**
*
* Class Description: This class is used to check the exceptional scenario when the number of athletes in the game exceed 8
* 
* @author : Eashan Tilve
*/

@SuppressWarnings("serial")
public class GameFullException extends Exception {

	public GameFullException() {
		super("The Game already has 8 contestants. Remove to add more.");
		System.out.println("The Game already has 8 contestants.");
	}

}
