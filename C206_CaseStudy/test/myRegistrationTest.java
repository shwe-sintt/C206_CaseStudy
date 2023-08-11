import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class myRegistrationTest {
	
	private User admin;
	private User teacher;
	private User student;
	private registration r1;
	private registration r2;
	
	private ArrayList<User> studentList;
	private ArrayList<User> teacherList;
	private ArrayList<registration> regiList;
	
	@Before
	public void setUp() throws Exception {
		
		r1=new registration("S22002200","Patrick Park","basketball");
		r2=new registration("S23002300","Susan","volleyball");
		
		studentList=new ArrayList<User>();
		teacherList= new ArrayList<User>();
		regiList=new ArrayList<registration>();
		
	}

	@After
	public void tearDown() throws Exception {
		
		r1=null;
		r2=null;
		studentList=null;
		teacherList=null;
		regiList=null;

	}
	@Test
	public void testAddRegistration() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid registration arraylist to add to", regiList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		myRegistration.addRegistration(regiList,r1);
		assertEquals("Check that registration arraylist size is 1", 1, regiList.size());
		assertSame("Check that registration is added", r1, regiList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		myRegistration.addRegistration(regiList,r2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, regiList.size());
		assertSame("Check that Camcorder is added", r2, regiList.get(1));
	}
	
	@Test
	public void testDeleteRegistration() {
		// Given an empty list, after adding 2 items, test if the size of the list is 2.
		// After removing an item , then the size of the list become 1
			myRegistration.addRegistration(regiList, r1);
			myRegistration.addRegistration(regiList, r2);
			assertEquals("Test if that regi arraylist size is 1?", 2, regiList.size());
			
			// The item just added is as same as the first item of the list
		    assertSame("Test that regi added same as the 1st regi of the list?", r1, regiList.get(0));

		    
		    // Test if regi list is not null but empty, so that can add new item
		    assertNotNull("test if there is valid regi arraylist to delete to", regiList);
		    
		 // Delete the regi part , test the size of the list is 1
		    myRegistration.doDeleteRegistration(regiList, r1.getStudentId());
		    assertEquals("Test that Wheels arrayList is 0?", 1, regiList.size());
		    assertSame("Test that WheelsList is added same as 3rd item of the list?", r2 ,regiList.get(0));
		
	}
	
	@Test
	public void testRetrieveAllRegistration() {
	    // Test if the registration list is not null but empty - boundary
	    assertNotNull("Test if there is a valid registration arraylist to retrieve from", regiList);

	    // Test if the list of registrations retrieved is empty - boundary
	    String allRegistrations = myRegistration.retrieveAllRegistration(regiList);
	    String testOutput = "";
	    
	    // Compare the expected title row with the actual title row
	    assertEquals("Test that the title row is correct", testOutput, allRegistrations.substring(0, testOutput.length()));

	    // Add registrations to the list
	    myRegistration.addRegistration(regiList,r1);
	    myRegistration.addRegistration(regiList,r2);

	    // Test if the expected output string is the same as the list of registrations retrieved
	    allRegistrations = myRegistration.retrieveAllRegistration(regiList);
	    
	    testOutput = String.format("%-20s %-20s %-20s\n","Patrick Park","S22002200","basketball");
	    testOutput += String.format("%-20s %-20s %-20s\n","Susan","S23002300","volleyball");
	    assertEquals("Test that ViewAllRegistration list", testOutput.trim(), allRegistrations.trim());
	}

	
	@Test
	public void myRegistrationTest() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
