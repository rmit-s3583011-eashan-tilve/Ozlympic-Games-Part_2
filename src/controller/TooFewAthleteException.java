package controller;

@SuppressWarnings("serial")
public class TooFewAthleteException  extends Exception {

	public TooFewAthleteException() {
		super("Need atleast 4 Athletes to run run this game.");
	}

}