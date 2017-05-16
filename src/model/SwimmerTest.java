package model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * Class Description: Class to test Swimmer Class
 * 
 * @author: Eashan Tilve
 */

public class SwimmerTest {

	/**
	 * Test to check addPoints(int newPoints)
	 * 
	 */
	@Test
	public void testAddPoints() {
		Swimmer swimmer = new Swimmer("name", "20", "VIC", "oz1234");
		swimmer.addPoints(5);
		assertTrue(swimmer.getPoints() == 5);
	}

	/**
	 * Test to check compete()
	 * 
	 */
	@Test
	public void testCompete() {
		Swimmer swimmer = new Swimmer("name", "20", "VIC", "oz1234");
		float time = swimmer.compete();
		assertTrue(time >= 100 && time <= 200);
	}

}
