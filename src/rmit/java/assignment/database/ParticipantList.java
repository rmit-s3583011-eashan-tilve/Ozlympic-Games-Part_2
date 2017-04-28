package rmit.java.assignment.database;

import java.util.ArrayList;
import java.util.Collections;

import rmit.java.assignment.model.Athlete;
import rmit.java.assignment.model.Cyclist;
import rmit.java.assignment.model.Official;
import rmit.java.assignment.model.Sprinter;
import rmit.java.assignment.model.SuperAthlete;
import rmit.java.assignment.model.Swimmer;

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
	private ArrayList<Integer> uniqueIDList = new ArrayList<Integer>();

	/**
	 * This method is used to generates unique ID
	 * 
	 * @return int returns the ID of the participants
	 */
	public int generateUniqueID() {
		int newUniqueID = Collections.max(this.uniqueIDList) + 1;
		uniqueIDList.add(newUniqueID);
		return newUniqueID;
	}

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
		uniqueIDList.add(0);

		swimmers.add(new Swimmer("Naruto Uzumaki", 14, "VIC", this.generateUniqueID()));
		swimmers.add(new Swimmer("Sasuke Mazamaki", 14, "VIC", this.generateUniqueID()));
		swimmers.add(new Swimmer("Sakura Tuzamaki", 18, "VIC", this.generateUniqueID()));
		swimmers.add(new Swimmer("Hinata Amchi", 21, "VIC", this.generateUniqueID()));
		swimmers.add(new Swimmer("Roshi Kimchi", 24, "VIC", this.generateUniqueID()));
		swimmers.add(new Swimmer("Kiba Maka", 21, "VIC", this.generateUniqueID()));
		swimmers.add(new Swimmer("Shisui Naka", 20, "VIC", this.generateUniqueID()));
		swimmers.add(new Swimmer("Kakashi Saka", 19, "VIC", this.generateUniqueID()));

		sprinters.add(new Sprinter("Usain Bolt", 14, "VIC", this.generateUniqueID()));
		sprinters.add(new Sprinter("Tyson Gay", 14, "VIC", this.generateUniqueID()));
		sprinters.add(new Sprinter("Asafa Powell", 18, "VIC", this.generateUniqueID()));
		sprinters.add(new Sprinter("Maurice Green", 21, "VIC", this.generateUniqueID()));
		sprinters.add(new Sprinter("Deep Sharma", 24, "VIC", this.generateUniqueID()));
		sprinters.add(new Sprinter("Soumil Naik", 21, "VIC", this.generateUniqueID()));
		sprinters.add(new Sprinter("Eashan Tilve", 20, "VIC", this.generateUniqueID()));
		sprinters.add(new Sprinter("Chaitrali Inamdar", 19, "VIC", this.generateUniqueID()));

		cyclists.add(new Cyclist("Sujit Sabnis", 14, "VIC", this.generateUniqueID()));
		cyclists.add(new Cyclist("Tommy Godwin", 14, "VIC", this.generateUniqueID()));
		cyclists.add(new Cyclist("Kurt Searvogel", 18, "VIC", this.generateUniqueID()));
		cyclists.add(new Cyclist("Amanda Coker", 21, "VIC", this.generateUniqueID()));
		cyclists.add(new Cyclist("Craig Canon", 24, "VIC", this.generateUniqueID()));
		cyclists.add(new Cyclist("Christoph Strasser", 21, "VIC", this.generateUniqueID()));
		cyclists.add(new Cyclist("Jens Stotzner", 20, "VIC", this.generateUniqueID()));
		cyclists.add(new Cyclist("Steve Abraham", 19, "VIC", this.generateUniqueID()));

		superAthletes.add(new SuperAthlete("Rohit Deshpande", 14, "VIC", this.generateUniqueID()));
		superAthletes.add(new SuperAthlete("Carol Saldanha", 14, "VIC", this.generateUniqueID()));
		superAthletes.add(new SuperAthlete("King Chang", 18, "VIC", this.generateUniqueID()));
		superAthletes.add(new SuperAthlete("Niraj Bohra", 21, "VIC", this.generateUniqueID()));
		superAthletes.add(new SuperAthlete("Nick Battliwala", 24, "VIC", this.generateUniqueID()));
		superAthletes.add(new SuperAthlete("Shon Desai", 21, "VIC", this.generateUniqueID()));
		superAthletes.add(new SuperAthlete("Andrew Nicholson", 20, "VIC", this.generateUniqueID()));
		superAthletes.add(new SuperAthlete("david Hoffstadter", 19, "VIC", this.generateUniqueID()));

		officials.add(new Official("Sachin Tendulkar", 14, "VIC", this.generateUniqueID()));
		officials.add(new Official("Virat Kohli", 14, "VIC", this.generateUniqueID()));
		officials.add(new Official("Peter Saagan", 18, "VIC", this.generateUniqueID()));
		officials.add(new Official("Roger Federer", 21, "VIC", this.generateUniqueID()));
		officials.add(new Official("Bobby Root", 24, "VIC", this.generateUniqueID()));
		officials.add(new Official("Tanmay Durve", 21, "VIC", this.generateUniqueID()));
		officials.add(new Official("Shaarang Bandhekar", 20, "VIC", this.generateUniqueID()));
		officials.add(new Official("Saurabh Ganguli", 19, "VIC", this.generateUniqueID()));

	}

}
