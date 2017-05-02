package database;

import java.util.ArrayList;
import java.util.Collections;

import model.Athlete;
import model.Cyclist;
import model.Official;
import model.Participants;
import model.Sprinter;
import model.SuperAthlete;
import model.Swimmer;

/**
 *
 * Class Description: Database Class that contains data of all the participants
 * 
 * @author : Carol Benita Saldanha
 */
public class ParticipantList {

	private ArrayList<Athlete> swimmers = new ArrayList<Athlete>();
	private ArrayList<Athlete> sprinters = new ArrayList<Athlete>();
	private ArrayList<Athlete> cyclists = new ArrayList<Athlete>();
	private ArrayList<Athlete> superAthletes = new ArrayList<Athlete>();
	private ArrayList<Official> officials = new ArrayList<Official>();

	/**
	 * This method is used to get all the swimmers that will be taking part in
	 * Ozlympics
	 * 
	 * @return ArrayList<Athlete> swimmer returns all the swimmers taking part
	 *         in Ozlympics
	 */
	public ArrayList<Athlete> getSwimmers() {
		return swimmers;
	}

	public Participants findParticipant(String athleteString) {
		athleteString = athleteString.substring(athleteString.indexOf(':') + 1, athleteString.length());
		athleteString = athleteString.replace(" ", "");
		athleteString = athleteString.substring(0, athleteString.indexOf(','));
		
		return (findParticipantByID(athleteString)) ;
	}

	private Participants findParticipantByID(String athleteString) {
		ArrayList<Participants> participants = new ArrayList<Participants>();
		participants.addAll(swimmers);
		participants.addAll(sprinters);
		participants.addAll(cyclists);
		participants.addAll(superAthletes);
		
		for(Participants participant: participants) {
			if(participant.getUniqueID().equals(athleteString))
			return participant;
		}
		return null;
	}

	/**
	 * This method is used to get all the sprinters that will be taking part in
	 * Ozlympics
	 * 
	 * @return ArrayList<Athlete> sprinters returns all the sprinters taking
	 *         part in Ozlympics
	 */
	public ArrayList<Athlete> getSprinters() {
		return sprinters;
	}

	/**
	 * This method is used to get all the cyclists that will be taking part in
	 * Ozlympics
	 * 
	 * @return ArrayList<Athlete> cyclists returns all the cyclists taking part
	 *         in Ozlympics
	 */
	public ArrayList<Athlete> getCyclists() {
		return cyclists;
	}

	/**
	 * This method is used to get all the superAthletes that will be taking part
	 * in Ozlympics
	 * 
	 * @return ArrayList<Athlete> superAthletes returns all the superAthletes
	 *         taking part in Ozlympics
	 */
	public ArrayList<Athlete> getSuperAthletes() {
		return superAthletes;
	}

	/**
	 * This method is used to get all the officials that will be taking part in
	 * Ozlympics
	 * 
	 * @return ArrayList<Athlete> officials returns all the officials taking
	 *         part in Ozlympics
	 */
	public ArrayList<Official> getOfficials() {
		return officials;
	}

	/**
	 * CONSTRUCTOR
	 * 
	 * creates the database of all participants
	 * 
	 */
	public ParticipantList() {
		System.out.println("Reading Participants..");
		readParticipants();
	}

	@Override
	public String toString() {
		return "ParticipantList [swimmers=" + swimmers + ", sprinters=" + sprinters + ", cyclists=" + cyclists
				+ ", superAthletes=" + superAthletes + ", officials=" + officials + "]";
	}

	private ArrayList<Participants> readParticipants() {

		FileHandler file = new FileHandler();
		ArrayList<String> lines = file.readFile("/database/Participants.txt");
		return obtainParticipants(lines);
	}

	private ArrayList<Participants> obtainParticipants(ArrayList<String> lines) {

		for (String line : lines) {
			if (!validateLine(line))
				continue;
			else {

				categorizeParticipant(line);

			}
		}

		return null;
	}

	private void categorizeParticipant(String line) {
		String id = getNextElement(line);
		line = returnReducedLine(line);
		id = id.replace(" ", "");
		
		String type = getNextElement(line);
		line = returnReducedLine(line);
		type = type.replace(" ", "");

		String name = getNextElement(line);
		line = returnReducedLine(line);

		String age = getNextElement(line);
		line = returnReducedLine(line);
		age = age.replace(" ", "");

		String state = getNextElement(line);
		line = returnReducedLine(line);
		state = state.replace(" ", "");


		if (id.length() == 0 || type.length() == 0 || name.length() == 0 || age.length() == 0 || state.length() == 0) {
			System.out.println("Missing Attribute");
		} else {
			switch (type) {
			case "swimmer": {
				addToAthlete(new Swimmer(name, age, state, id));
				break;
			}
			case "sprinter": {
				addToAthlete(new Sprinter(name, age, state, id));
				break;
			}
			case "cyclist": {
				addToAthlete(new Cyclist(name, age, state, id));
				break;
			}
			case "super": {
				addToAthlete(new SuperAthlete(name, age, state, id));
				break;
			}
			case "officer": {
				addToOfficial(new Official(name, age, state, id));
				break;
			}
			default:
				System.out.println("invalid type");
			}
		}
	}

	private void addToOfficial(Official official) {
		boolean alreadyExists = false;

		for (Official existing : officials) {
			if (existing.getUniqueID().equals(official.getUniqueID())) {
				alreadyExists = true;
			}
		}

		if (!alreadyExists) {
			officials.add(official);
		}
	}

	private void addToAthlete(Athlete athlete) {
		boolean alreadyExists = false;
		ArrayList<Athlete> athletes = null;
		if (athlete instanceof Swimmer) {
			athletes = swimmers;
		} else if (athlete instanceof Sprinter) {
			athletes = sprinters;
		} else if (athlete instanceof Cyclist) {
			athletes = cyclists;
		} else if (athlete instanceof SuperAthlete) {
			athletes = superAthletes;
		}

		for (Athlete athleteExisting : athletes) {
			if (athleteExisting.getUniqueID().equals(athlete.getUniqueID())) {
				alreadyExists = true;
			}
		}

		if (!alreadyExists) {
			athletes.add(athlete);
		}
	}

	private String returnReducedLine(String line) {
		return line.substring(line.indexOf(',') + 1, line.length());
	}

	private String getNextElement(String line) {
		int position = 0;
		String element = "";
		while (position < line.length()) {
			if (line.charAt(position) == ',') {
				break;
			}
			element = element.concat(Character.toString(line.charAt(position++)));
		}
		return element;
	}

	// checks if line has 4 commas
	private boolean validateLine(String line) {
		if (line.length() - line.replace(",", "").length() != 4)
			return false;

		return true;
	}
}
