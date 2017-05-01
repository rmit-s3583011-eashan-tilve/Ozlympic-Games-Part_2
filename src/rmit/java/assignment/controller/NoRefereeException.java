package rmit.java.assignment.controller;

public class NoRefereeException extends Exception {

	public NoRefereeException() {
		super();
		System.out.println("This game has no referee assigned to it. Cannot run this game.");
	}

}