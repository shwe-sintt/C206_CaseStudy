import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ManageAttendanceTest {

    private User student1;
    private User student2;
    private ArrayList<User> userList;

    @Before
    public void setUp() {
        student1 = new User("S1", "John", "john69", "john42069", "student", "Activity1", "present");
        student2 = new User("S2", "Mary", "mary69", "mary42069", "student", "Activity1", "present");

        userList = new ArrayList<>();
        userList.add(student1);
        userList.add(student2);
    }

    @Test
    public void testViewAttendance() {
		assertNotNull("Test if there is valid user arraylist to retrieve item", userList);
        ManageAttendance.viewAttendance(userList);
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
	public void testDeleteRegistration() {

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
	public void tearDown() throws Exception {
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
