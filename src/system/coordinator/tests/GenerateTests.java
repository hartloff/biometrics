package system.coordinator.tests;


import system.allcommonclasses.Users;

/**
 * 
 * Determines which pairs of reading to test based on the users.
 *
 */
public abstract class GenerateTests {

	GenerateTests(){
	}
	
	/**
	 * Determines which pairs of reading to test based on the users.
	 *  
	 * @param enrollees
	 * @return Tests
	 */
	public abstract Tests generateTests(Users enrollees);
	
}
