package model;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 *
 * Class Description: Class to test Sprinter Class
 * 
 * @author: Eashan Tilve
 */


public class SprinterTest {

	/**
	 * Test to check addPoints(int newPoints)
	 * 
	 */
	@Test
	public void testAddPoints() {
		Sprinter sprinter = new Sprinter( "name", "20",  "VIC",  "oz1234");
		sprinter.addPoints(5);
		assertTrue(sprinter.getPoints()==5);
	}
	
	/**
	 * Test to check compete()
	 * 
	 */
	@Test
	public void testCompete() {
		Sprinter sprinter = new Sprinter( "name", "20",  "VIC",  "oz1234");
		float time = sprinter.compete();
		assertTrue(time >= 10 && time <=20);
	}


}
