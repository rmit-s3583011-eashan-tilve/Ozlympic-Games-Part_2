package rmit.java.assignment.controller;

public class WrongTypeException extends Exception {

	public WrongTypeException() {
		super();
		System.out.println("Wrong type of participant. Cannot assign this participant to this game.");
	}

}
