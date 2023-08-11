
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class userTest {
	
	private User s1;
	private User s2;
	
	private ArrayList<User> userList;
	
	public userTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		// prepare test data
		s1 = new User ("22123456", "Amelia Row", "Amelia", " ", "Student", "Hockey", "");
		s2 = new User ("22654321", "Rachelle Lim", "Rachelle", " ", "Student", "Floorball", "");
		
		userList = new ArrayList<User>();
	}
	
//================================================================================= Admin Testing =========================================================================================
	
	@Test
	public void testAddUser() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid User arraylist to add to", userList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addUser(userList, s1);
		assertEquals("Check that User arraylist size is 1", 1, userList.size());
		assertSame("Check that User is added", s1, userList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addUser(userList, s2);
		assertEquals("Check that User arraylist size is 2", 2, userList.size());
		assertSame("Check that User is added", s2, userList.get(1));
	}
	
	@Test
	public void testRetrieveAllUser() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid User arraylist to retrieve student", userList);

		//test if the list of User retrieved from the SourceCentre is empty - boundary
		String allUser= C206_CaseStudy.retrieveAllUser(userList);
		String testOutput = "";
		assertEquals("Check that viewAllStudent", testOutput, allUser);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addUser(userList, s1);
		C206_CaseStudy.addUser(userList, s2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, userList.size());

		//test if the expected output string same as the list of User retrieved from the SourceCentre	
		allUser= C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-20s %-20s %-20s %-20s\n", "Amelia Row", "22123456", "Hockey", "");
		testOutput += String.format("%-20s %-20s %-20s %-20s\n", "Rachelle Lim", "22654321", "Floorball", "");

		assertEquals("Test that viewAllStudentList", testOutput, allUser);

	}
	
	@Test
	public void testRemoveUser() {
		// Create an arraylist of students
		ArrayList<User> userList = new ArrayList<>();
		C206_CaseStudy.addUser(userList, s1);
		C206_CaseStudy.addUser(userList, s2);

		// Get the student ID to remove
		String removeStuID = "22123456";

		// Call the removeUser() method
		boolean studentFound = C206_CaseStudy.removeUser(userList);

		// Assert that the student was found and removed
		assertTrue(studentFound);
		assertEquals(1, userList.size());
		assertEquals("Rachelle Lim", userList.get(0).getName());
	}
	
	//================================================================================= End of Admin Testing =========================================================================================

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void user_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
