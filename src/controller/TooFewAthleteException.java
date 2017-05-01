package controller;

public class TooFewAthleteException  extends Exception {

	public TooFewAthleteException() {
		super();
		System.out.println("Not enough participants to run this game.");
	}

}