package domain;

import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.domain.TimePeriod;
import junit.framework.TestCase;

public class TimePeriodTest extends TestCase {
    private TimePeriod timePeriod;

    protected void setUp() throws Exception {
        timePeriod = new TimePeriod();
    }
    public void testSetAndGetId() {
        int testId = 1;
        assertEquals(0, timePeriod.getId(), 0);
        timePeriod.setId(testId);
        assertEquals(testId, timePeriod.getId(), 0);
    }
    public void testSetAndGetPlaygroundId() {
        int testPlaygroundId = 1;
        assertEquals(0, timePeriod.getPlaygroundId(), 0);
        timePeriod.setPlaygroundId(testPlaygroundId);
        assertEquals(testPlaygroundId, timePeriod.getPlaygroundId(), 0);
    }
    public void testSetAndGetBookingId() {
        int testBookingId = 1;
        assertEquals(0, timePeriod.getBookingId(), 0);
        timePeriod.setBookingId(testBookingId);
        assertEquals(testBookingId, timePeriod.getBookingId(), 0);
    }
    public void testSetAndGetAvailable() {
        assertFalse(timePeriod.isAvailable());
        timePeriod.setAvailable(true);
        assertTrue(timePeriod.isAvailable());
    }
    public void testSetAndGetTimeType() {
        int testTimeType = 1;
        assertEquals(0, timePeriod.getTimeType(), 0);
        timePeriod.setTimeType(testTimeType);
        assertEquals(testTimeType, timePeriod.getTimeType(), 0);
    }
    public void testSetAndGetDay() {
        String testDay = "testDay";
        assertNull(timePeriod.getDay());
        timePeriod.setDay(testDay);
        assertEquals(testDay, timePeriod.getDay());
    }

}
