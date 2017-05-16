package controller;

@SuppressWarnings("serial")
public class GameFullException extends Exception {

	public GameFullException() {
		super("The Game already has 8 contestants. Remove to add more.");
		System.out.println("The Game already has 8 contestants.");
	}

}
