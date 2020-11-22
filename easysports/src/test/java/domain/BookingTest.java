package domain;
import com.elec5619.easysports.domain.Booking;
import com.elec5619.easysports.domain.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingTest extends TestCase {
    private Booking booking;

    protected void setUp() throws Exception {
        booking = new Booking();
    }

    public void testSetAndGetId() {
        int testId = 1;
        assertEquals(0, booking.getId(), 0);
        booking.setId(testId);
        assertEquals(testId, booking.getId(), 0);
    }
    public void testSetAndGetUserId() {
        int testUserId = 1;
        assertEquals(0, booking.getUserId(), 0);
        booking.setUserId(testUserId);
        assertEquals(testUserId, booking.getUserId(), 0);
    }
    public void testSetAndGetPlaygroundId() {
        int testPlaygroundId = 1;
        assertEquals(0, booking.getPlaygroundId(), 0);
        booking.setPlaygroundId(testPlaygroundId);
        assertEquals(testPlaygroundId, booking.getPlaygroundId(), 0);
    }

    public void testSetAndGetTimePeriodId() {
        int testTimePeriodId = 1;
        assertEquals(0, booking.getTimePeriodId(), 0);
        booking.setTimePeriodId(testTimePeriodId);
        assertEquals(testTimePeriodId, booking.getTimePeriodId(), 0);
    }
    public void testSetAndGetTimePeriod() {
//        String testTimePeriod = "testTimePeriod";
        assertNull(booking.getTimeperiod());
        booking.setTimeperiod(1);
        assertEquals("9:00 - 11:00", booking.getTimeperiod());
    }


    public void testStatus() {
        String testStatus = "testStatus";
        assertNull(booking.getStatus());
        booking.setStatus(testStatus);
        assertEquals(testStatus, booking.getStatus());
    }

    public void testSetAndGetCreateTime() {
        Date testCreateTime = new Date();
        assertNull(booking.getCreateTime());
        booking.setCreateTime(testCreateTime);
        assertEquals(testCreateTime, booking.getCreateTime());
    }
    public void testPlaygroundName() {
        String testPlaygroundName = "testPlaygroundName";
        assertNull(booking.getPlaygroundname());
        booking.setPlaygroundname(testPlaygroundName);
        assertEquals(testPlaygroundName, booking.getPlaygroundname());
    }
    public void testBookingDate() {
        String testBookingDate = "testBookingDate";
        assertNull(booking.getBookingdate());
        booking.setBookingdate(testBookingDate);
        assertEquals(testBookingDate, booking.getBookingdate());
    }

}
