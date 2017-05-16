package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 *
 * Class Description: Class to test SuperAthlete Class
 * 
 * @author: Eashan Tilve
 */


public class SuperAthleteTest {

	private SuperAthlete superAthlete;
	@Before
	public void initialize() {
		superAthlete = new SuperAthlete( "name", "20",  "VIC",  "oz1234");

	}
	
	
	/**
	 * Test to check addPoints(int newPoints)
	 * 
	 */
	@Test
	public void testAddPoints() {
		superAthlete.addPoints(5);
		assertTrue(superAthlete.getPoints()==5);
	}
	
	/**
	 * Test to check compete() if super athlete is swimming
	 * 
	 */
	@Test
	public void testCompeteSwimming() {
		superAthlete.setCurrentGame('S');
		float time = superAthlete.compete();
		assertTrue(time >= 100 && time <= 200);
	}
	
	/**
	 * Test to check compete() if super athlete is cycling
	 * 
	 */
	@Test
	public void testCompeteCycling() {
		superAthlete.setCurrentGame('C');
		float time = superAthlete.compete();
		assertTrue(time >= 500 && time <= 800);
	}
	
	/**
	 * Test to check compete() if super athlete is running
	 * 
	 */
	@Test
	public void testCompeteRunning() {
		superAthlete.setCurrentGame('R');
		float time = superAthlete.compete();
		assertTrue(time >= 10 && time <= 20);
	}


}
