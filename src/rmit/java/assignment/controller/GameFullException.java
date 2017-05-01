package rmit.java.assignment.controller;

public class GameFullException extends Exception {

	public GameFullException() {
		super();
		System.out.println("The Game already has 8 contestants.");
	}

}
