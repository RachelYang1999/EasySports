package domain;

import com.elec5619.easysports.domain.Favourite;
import com.elec5619.easysports.domain.Playground;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlaygroundTest extends TestCase {
    private Playground playground;

    protected void setUp() throws Exception {
        playground = new Playground();
    }
    public void testSetAndGetId() {
        int testId = 1;
        assertEquals(0, playground.getId(), 0);
        playground.setId(testId);
        assertEquals(testId, playground.getId(), 0);
    }
    public void testSetAndGetName() {
        String testName = "testName";
        assertNull(playground.getName());
        playground.setName(testName);
        assertEquals(testName, playground.getName());
    }
    public void testSetAndGetAddress() {
        String testAddress = "testAddress";
        assertNull(playground.getAddress());
        playground.setAddress(testAddress);
        assertEquals(testAddress, playground.getAddress());
    }
    public void testSetAndGetRating() {
        int testRating = 1;
        assertEquals(0, playground.getRating(), 0);
        playground.setRating(testRating);
        assertEquals(testRating, playground.getRating(), 0);
    }
    public void testSetAndGetBookingRequired() {
        assertFalse(playground.isBookingRequired());
        playground.setBookingRequired(true);
        assertTrue(playground.isBookingRequired());
    }
    public void testSetAndGetImageURL() {
        String testURL = "testURL";
        assertNull(playground.getImageUrl());
        playground.setImageUrl(testURL);
        assertEquals(testURL, playground.getImageUrl());
    }
    public void testSetAndGetType() {
        String testType = "testType";
        assertNull(playground.getType());
        playground.setType(testType);
        assertEquals(testType, playground.getType());
    }
    public void testSetAndGetCreateTime() {
        Date testCreateTime = new Date();
        assertNull(playground.getCreateTime());
        playground.setCreateTime(testCreateTime);
        assertEquals(testCreateTime, playground.getCreateTime());
    }


}
