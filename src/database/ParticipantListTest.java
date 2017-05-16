package database;

import static org.junit.Assert.*;

import org.junit.Test;
/**
*
* Class Description: Test Class to test methods in ParticipantList
* 
* @author : Eashan Tilve
*/
public class ParticipantListTest {
	/**
	 * This method is to test validateLine method in ParticipantList
	 */
	@Test
	public void validateLineTest() {
		ParticipantList participantlist = new ParticipantList();
		assertFalse(participantlist.validateLine("test,test,test"));
		assertFalse(participantlist.validateLine("test,test,test,test"));
		assertTrue(participantlist.validateLine("test,test,test,test, test"));
	}

	/**
	 * This method is to test getNextElement method in ParticipantList
	 */
	@Test
	public void getNextElementTest() {
		ParticipantList participantlist = new ParticipantList();
		assertEquals(participantlist.getNextElement("ele1,ele2,ele3"),"ele1");
	}
	
	/**
	 * This method is to test returnReducedLine method in ParticipantList
	 */
	@Test
	public void returnReducedLineTest() {
		ParticipantList participantlist = new ParticipantList();
		assertEquals(participantlist.returnReducedLine("ele1,ele2,ele3"),"ele2,ele3");
	}
}
