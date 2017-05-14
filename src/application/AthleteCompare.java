package application;

import java.util.Comparator;

import model.Athlete;

public class AthleteCompare implements Comparator<Athlete> {

	@Override
	public int compare(Athlete o1, Athlete o2) {
		// TODO Auto-generated method stub
		return o2.getPoints() - o1.getPoints() ;
	}
	
}