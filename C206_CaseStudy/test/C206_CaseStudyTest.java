import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Activities a1;
	private Activities a2;
	private Activities a3;

	private ArrayList<Activities> activityList;
	private ArrayList<User> userList;
	
	private User admin;
	private User teacher;
	private User student;
	private registration r1;
	private registration r2;
	
	 private User s1;
	 private User t1;
	
	private ArrayList<User> studentList;
	private ArrayList<User> teacherList;
	private ArrayList<registration> regiList;
	private StatusManager statusManager;
    private myTimeSlot myTimeSlot;
    
    private User student1;
    private User student2;
    
    
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
    @Before
    public void setUp() {
        statusManager = new StatusManager();
        myTimeSlot = new myTimeSlot();
        a1 = new Activities("AA0011", "Basketball", "Ball", "Basket");
		a2 = new Activities("AA0022", "Football", "Ball", "Foot");
		a3 = new Activities("AA0033", "Baseball", "Ball", "Base");

		activityList= new ArrayList<Activities>();
		
		r1=new registration("S22002200","Patrick Park","basketball");
		r2=new registration("S23002300","Susan","volleyball");
		
		studentList=new ArrayList<User>();
		teacherList= new ArrayList<User>();
		regiList=new ArrayList<registration>();
		
	    s1 = new User ("22123456", "Amelia Row", "Amelia", " ", "Student", "Hockey", "");
	    t1 = new User ("T123", "Lin Cin", "lincin", "lincin", "Teacher", " ", " ");
		
	    userList = new ArrayList<User>();
	    
	    student1 = new User("S1", "John", "john69", "john42069", "student", "Activity1", "present");
        student2 = new User("S2", "Mary", "mary69", "mary42069", "student", "Activity1", "present");

        userList = new ArrayList<>();
        userList.add(student1);
        userList.add(student2);
    }

    @After
    public void tearDown() {
        statusManager = null;
        a1 = null;
		a2 = null;
		a3 = null;
		activityList = null;
		
		r1=null;
		r2=null;
		studentList=null;
		teacherList=null;
		regiList=null;
		
		s1 = null;
		t1 = null;
		userList = null;
    }

    @Test
    public void testAddAndRetrieveApprovalStatus() {
        statusManager.addApprovalStatus("Approved", "Application is approved");
        statusManager.addApprovalStatus("Pending", "Application is pending");
        
        assertEquals(2, statusManager.getApprovalStatuses().size());
        
        ApprovalStatus approvedStatus = statusManager.getApprovalStatuses().get(0);
        assertEquals("Approved", approvedStatus.getName());
        assertEquals("Application is approved", approvedStatus.getDescription());

        ApprovalStatus pendingStatus = statusManager.getApprovalStatuses().get(1);
        assertEquals("Pending", pendingStatus.getName());
        assertEquals("Application is pending", pendingStatus.getDescription());
    }
    
    @Test
    public void testViewAttendance() {
		assertNotNull("Test if there is valid user arraylist to retrieve item", userList);
        ManageAttendance.viewAttendance(userList);
    }
    

    @Test
    public void testDeleteApprovalStatus() {
        statusManager.addApprovalStatus("Approved", "Application is approved");
        statusManager.addApprovalStatus("Pending", "Application is pending");

        statusManager.deleteApprovalStatus("Pending");
        assertEquals(1, statusManager.getApprovalStatuses().size());
        assertNull(C206_CaseStudy.findApprovalStatusByName("Pending", statusManager));
    }


    @Test
    public void testIsApprovalStatusNameUnique() {
        statusManager.addApprovalStatus("Approved", "Application is approved");
        statusManager.addApprovalStatus("Pending", "Application is pending");

        assertTrue(statusManager.isApprovalStatusNameUnique("Rejected"));
        assertFalse(statusManager.isApprovalStatusNameUnique("Approved"));
    }

        
    @Test
    public void testAddTimeSlot() {
        ArrayList<TimeSlot> timeSlotList = new ArrayList<>();
        myTimeSlot.addTimeSlot(timeSlotList);
        assertEquals(1, timeSlotList.size());
    }

    @Test
    public void testRemoveTimeSlot() {
        ArrayList<TimeSlot> timeSlotList = new ArrayList<>();
        timeSlotList.add(new TimeSlot("TS001", "Monday", "13:00", "2023/08/10"));

        boolean removed = myTimeSlot.removeTimeSlot(timeSlotList);
        assertTrue(removed);
        assertEquals(0, timeSlotList.size());

        removed = myTimeSlot.removeTimeSlot(timeSlotList);
        assertFalse(removed);
    }
    
    @Test
    public void testAddAttendance() {
		assertNotNull("Test if there is valid user arraylist to retrieve item", userList);

        ManageAttendance.addAttendance(userList, student1);
        
        assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that student is added", student1, userList.get(0));
		
		ManageAttendance.addAttendance(userList, student2);
		assertEquals("Check that user arraylist size is 2", 2, userList.size());
		assertSame("Check that student is added",student2, userList.get(1));
        
    }

    @Test
    public void testUpdateTimeSlot() {
        ArrayList<TimeSlot> timeSlotList = new ArrayList<>();
        TimeSlot timeSlot = new TimeSlot("TS001", "Monday", "13:00", "2023/08/10");
        timeSlotList.add(timeSlot);

        boolean updated = myTimeSlot.updateTimeSlot(timeSlotList);
        assertTrue(updated);

        assertEquals("NewDay", timeSlot.getDay());
        assertEquals("NewTime", timeSlot.getTime());
        assertEquals("NewDate", timeSlot.getDate());

        updated = myTimeSlot.updateTimeSlot(timeSlotList);
        assertFalse(updated);
    }

	@Test
	public void testAddActivity() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Activities arraylist to add to", activityList);
		assertEquals("Test that the Activities arraylist is empty.", 0, activityList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addActivity(activityList, a1);		
		assertEquals("Test that the Camcorder arraylist size is 1.", 1, activityList.size());

		
		// Add an item
		C206_CaseStudy.addActivity(activityList, a2);
		assertEquals("Test that the Activities arraylist size is now 2.", 2, activityList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that Activities is added to the end of the list.", a2, activityList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addActivity(activityList, a2);
		assertEquals("Test that the Activities arraylist size is unchange.", 2, activityList.size());

		// Add an item that has missing detail
		Activities a_missing = new Activities("AA0044", "", "Ball", "Ball");
		C206_CaseStudy.addActivity(activityList, a_missing);
		assertEquals("Test that the Activities arraylist size is unchange.", 2, activityList.size());
	}
	
	@Test
	public void testDeleteActivity() {
		// Given an empty list, after adding 2 items, test if the size of the list is 2.
		// After removing an item , then the size of the list become 1
			C206_CaseStudy.addActivity(activityList, a1);
			C206_CaseStudy.addActivity(activityList, a2);
			assertEquals("Test if that Activities arraylist size is 1?", 2, activityList.size());
			
			// The item just added is as same as the first item of the list
		    assertSame("Test that Activities added same as the 1st Activities of the list?", a1, activityList.get(0));

		    
		    // Test if Activities list is not null but empty, so that can add new item
		    assertNotNull("test if there is valid Activities arraylist to delete to", activityList);
		    
		 // Delete, test the size of the list is 1
		    C206_CaseStudy.doRemoveActivity(activityList, a1.getActivityId());
		    assertEquals("Test that Activities arrayList is 0?", 1, activityList.size());
		    assertSame("Test that activityList is added same as 3rd item of the list?", a2 ,activityList.get(0));
		
	}
	
	@Test
	public void testDeleteAttendance() {

			ManageAttendance.addAttendance(userList, student1);
			ManageAttendance.addAttendance(userList, student2);
			assertEquals("Test if that user arraylist size is 2", 2, userList.size());
			
		    assertSame("Test that student added is 1st student of the list", student1, userList.get(0));

		    
		    assertNotNull("test if there is valid user arraylist to delete to", userList);
		    
		    ManageAttendance.deleteAttendance(userList, student1.getName());
		    assertEquals("Test that user arrayList size is 1", 1, userList.size());
		    assertSame("Test that student is the first item", student2 ,userList.get(0));
		
	}
	
	@Test
	public void testRetrieveActivity() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Activities arraylist to add to", activityList);
		// test if the list of Activities retrieved is empty
		String allActivities = C206_CaseStudy.retrieveAllActivities(activityList);
		String testOutput = "";
		assertEquals("Test that the title row is correct", testOutput, allActivities.substring(0, testOutput.length()));

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addActivity(activityList, a1);
		C206_CaseStudy.addActivity(activityList, a2);
		assertEquals("Test if that Activities arraylist size is 2?", 2, activityList.size());

		// test if the expected output string same as the list of Activities retrieved
		allActivities = C206_CaseStudy.retrieveAllActivities(activityList);

		testOutput = String.format("%-20s %-20s %-20s %-20s\n", "AA0011", "Basketball", "Ball", "Basket");
		testOutput += String.format("%-20s %-20s %-20s %-20s\n", "AA0022", "Football", "Ball", "Foot");

		assertEquals("Check that viewAllActivities list", testOutput.trim(), allActivities.trim());
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
	    C206_CaseStudy.addUser(userList, t1);
	    assertEquals("Check that User arraylist size is 2", 2, userList.size());
	    assertSame("Check that User is added", t1, userList.get(1));
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
	    C206_CaseStudy.addUser(userList, t1);
	    assertEquals("Test that Camcorder arraylist size is 2", 2, userList.size());

	    //test if the expected output string same as the list of User retrieved from the SourceCentre  
	    allUser= C206_CaseStudy.retrieveAllUser(userList);
	    testOutput = String.format("%-20s %-20s %-20s %-20s %-20s\n", "Amelia Row", "22123456", "Hockey", " ", "Student");
	    testOutput += String.format("%-20s %-20s %-20s %-20s %-20s\n", "Lin Cin", "T123", " ", " ", "Teacher");
	    assertEquals("Test that viewAllStudentList", testOutput, allUser);

	  }
	  
	  @Test
	  public void testRemoveUser() {
	    // Create an arraylist of students
	    ArrayList<User> userList = new ArrayList<>();
	    C206_CaseStudy.addUser(userList, s1);
	    C206_CaseStudy.addUser(userList, t1);
	    assertEquals("Test if that user arraylist size is 1?", 2, userList.size());

	    assertSame("Test that user added same as the first user of the list?", s1, userList.get(0));

//	    // Assert that the user was found and removed 
//	    assertTrue(removeUserId);
//	    assertEquals(1, userList.size());
//	    assertEquals("Amelia Row", userList.get(0).getName());
	  }

}