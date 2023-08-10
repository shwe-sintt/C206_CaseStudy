import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 *
 * 
 *I declare that this code was written by me.
 *I do not copy or allow others to copy my code.
 *I understand that copying code is considered as plagiarism.
 *
 *Student Name: Trevor Toh
 *Student ID: 21014820
 *Class: W64P
 */

/**
 * @author 21014820
 *
 */
public class myTimeSlotTest {
    private myTimeSlot myTimeSlot;

	
	/**
	 * @throws java.lang.Exception
	 */
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        myTimeSlot = new myTimeSlot();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddTimeSlot_Normal() {
        myTimeSlot.addTimeSlot("Monday, 9:00 AM - 10:00 AM");
        myTimeSlot.addTimeSlot("Tuesday, 2:00 PM - 3:00 PM");

        assertEquals(2, myTimeSlot.getId().size());
        assertEquals("Monday, 9:00 AM - 10:00 AM", myTimeSlot.getId().get(0));
        assertEquals("Tuesday, 2:00 PM - 3:00 PM", myTimeSlot.getIdS().get(1));
    }

    @Test
    public void testViewAllTimeSlots_Empty() {
        String output = captureSystemOut(() -> myTimeSlot.viewAllTimeSlots());
        assertTrue(output.contains("No time slots available."));
    }

    @Test
    public void testDeleteTimeSlot_Normal() {
        myTimeSlot.addTimeSlot("Monday, 9:00 AM - 10:00 AM");
        myTimeSlot.addTimeSlot("Tuesday, 2:00 PM - 3:00 PM");

        myTimeSlot.deleteTimeSlot(1);
        assertEquals(1, myTimeSlot.getTimeSlots().size());
        assertEquals("Tuesday, 2:00 PM - 3:00 PM", myTimeSlot.getTimeSlots().get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteTimeSlot_InvalidIndex() {
        myTimeSlot.addTimeSlot("Monday, 9:00 AM - 10:00 AM");
        myTimeSlot.deleteTimeSlot(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteTimeSlot_EmptyList() {
        myTimeSlot.deleteTimeSlot(1);
    }

    private String captureSystemOut(Runnable action) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        action.run();

        System.setOut(originalOut);
        return outputStream.toString();
    }

    // Additional test cases can be added here

}