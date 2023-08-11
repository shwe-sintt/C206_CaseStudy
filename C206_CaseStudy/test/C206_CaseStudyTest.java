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

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	private StatusManager statusManager;
    private myTimeSlot myTimeSlot;


    @Before
    public void setUp() {
        statusManager = new StatusManager();
        myTimeSlot = new myTimeSlot();
        a1 = new Activities("AA0011", "Basketball", "Ball", "Basket");
		a2 = new Activities("AA0022", "Football", "Ball", "Foot");
		a3 = new Activities("AA0033", "Baseball", "Ball", "Base");

		activityList= new ArrayList<Activities>();
    }

    @After
    public void tearDown() {
        statusManager = null;
        a1 = null;
		a2 = null;
		a3 = null;
		activityList = null;
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
}