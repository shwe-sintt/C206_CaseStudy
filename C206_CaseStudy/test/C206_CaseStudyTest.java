import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	

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
    }

    @After
    public void tearDown() {
        statusManager = null;
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
}

