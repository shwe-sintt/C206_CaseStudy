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
        // Code to be executed before running any tests in this class (if needed)
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // Code to be executed after running all tests in this class (if needed)
    }

    @Before
    public void setUp() throws Exception {
        TimeSlot = new TimeSlot("TS001", "Monday", "9:00 AM - 10:00 AM", "2023-08-15");
        // Code to set up test environment before each test case
    }

    @After
    public void tearDown() throws Exception {
        // Code to clean up after each test case (if needed)
    }

    @Test
    public void testGetId() {
        assertEquals("TS001", timeSlot.getId());
    }

    @Test
    public void testGetDay() {
        assertEquals("Monday", timeSlot.getDay());
    }

    @Test
    public void testSetDay() {
        timeSlot.setDay("Tuesday");
        assertEquals("Tuesday", timeSlot.getDay());
    }

    @Test
    public void testGetTime() {
        assertEquals("9:00 AM - 10:00 AM", timeSlot.getTime());
    }

    @Test
    public void testSetTime() {
        timeSlot.setTime("11:00 AM - 12:00 PM");
        assertEquals("11:00 AM - 12:00 PM", timeSlot.getTime());
    }

    @Test
    public void testGetDate() {
        assertEquals("2023-08-15", timeSlot.getDate());
    }

    @Test
    public void testSetDate() {
        timeSlot.setDate("2023-08-16");
        assertEquals("2023-08-16", timeSlot.getDate());
    }

    // Additional test cases can be added here

}