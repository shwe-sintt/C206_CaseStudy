import static org.junit.Assert.*;

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

    @Before
    public void setUp() {
        statusManager = new StatusManager();
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
        assertNull(C206_CaseStudy3.findApprovalStatusByName("Pending", statusManager));
    }


    @Test
    public void testIsApprovalStatusNameUnique() {
        statusManager.addApprovalStatus("Approved", "Application is approved");
        statusManager.addApprovalStatus("Pending", "Application is pending");

        assertTrue(statusManager.isApprovalStatusNameUnique("Rejected"));
        assertFalse(statusManager.isApprovalStatusNameUnique("Approved"));
    }
}
