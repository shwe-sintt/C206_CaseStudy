import static org.junit.Assert.*;

import java.util.ArrayList;

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
        assertEquals("2023/08/11", timeSlot.getDate());

        updated = myTimeSlot.updateTimeSlot(timeSlotList);
        assertFalse(updated);
    }
}