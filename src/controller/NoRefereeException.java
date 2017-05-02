package controller;

public class NoRefereeException extends Exception {

	public NoRefereeException() {
		super("Please assign a Referee To this Game.");
		System.out.println("Please assign a Referee To this Game Before running it.");
	}

}