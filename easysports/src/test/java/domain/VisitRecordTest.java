package domain;

import com.elec5619.easysports.domain.TimePeriod;
import com.elec5619.easysports.domain.VisitRecord;
import junit.framework.TestCase;

import java.util.Date;

public class VisitRecordTest extends TestCase {
    private VisitRecord visitRecord;

    protected void setUp() throws Exception {
        visitRecord = new VisitRecord();
    }
    public void testSetAndGetId() {
        int testId = 1;
        assertEquals(0, visitRecord.getId(), 0);
        visitRecord.setId(testId);
        assertEquals(testId, visitRecord.getId(), 0);
    }
    public void testSetAndGetUserId() {
        int testUserId = 1;
        assertEquals(0, visitRecord.getUserId(), 0);
        visitRecord.setUserId(testUserId);
        assertEquals(testUserId, visitRecord.getUserId(), 0);
    }
    public void testSetAndGetPlaygroundId() {
        int testPlaygroundId = 1;
        assertEquals(0, visitRecord.getPlaygroundId(), 0);
        visitRecord.setPlaygroundId(testPlaygroundId);
        assertEquals(testPlaygroundId, visitRecord.getPlaygroundId(), 0);
    }
    public void testSetAndGetCreateTime() {
        Date testCreateTime = new Date();
        assertNull(visitRecord.getCreateTime());
        visitRecord.setCreateTime(testCreateTime);
        assertEquals(testCreateTime, visitRecord.getCreateTime());
    }
}
