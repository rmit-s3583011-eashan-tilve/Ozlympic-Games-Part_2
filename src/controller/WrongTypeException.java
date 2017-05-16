package controller;

@SuppressWarnings("serial")
public class WrongTypeException extends Exception {

	public WrongTypeException() {
		super("Wrong type of participant. Cannot assign this participant to this game.");
		System.out.println("Wrong type of participant. Cannot assign this participant to this game.");
	}

}
