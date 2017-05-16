package application;

import java.util.Comparator;

import model.Athlete;

/**
*
* Class Description: Class used to sort athletes according to their standings from high to low points
* 
* @author : Eashan Tilve
*/
public class AthleteCompare implements Comparator<Athlete> {

	/**
	 * This method is used to compare two athletes based on their points
	 * 
	 * @return int: returns integer difference between the points of two athletes
	 */
	@Override
	public int compare(Athlete o1, Athlete o2) {
		// TODO Auto-generated method stub
		return o2.getPoints() - o1.getPoints() ;
	}
	
}