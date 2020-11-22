package domain;

import com.elec5619.easysports.domain.Booking;
import com.elec5619.easysports.domain.Comment;
import junit.framework.TestCase;

import java.util.Date;

public class CommentTest extends TestCase {
    private Comment comment;

    protected void setUp() throws Exception {
        comment = new Comment();
    }
    public void testSetAndGetId() {
        int testId = 1;
        assertEquals(0, comment.getId(), 0);
        comment.setId(testId);
        assertEquals(testId, comment.getId(), 0);
    }
    public void testSetAndGetDescription() {
        String testDescription = "testDescription";
        assertNull(comment.getDescription());
        comment.setDescription(testDescription);
        assertEquals(testDescription, comment.getDescription());
    }
    public void testSetAndGetUserId() {
        int testUserId = 1;
        assertEquals(0, comment.getUserId(), 0);
        comment.setId(testUserId);
        assertEquals(testUserId, comment.getId(), 0);
    }
    public void testSetAndGetPlaygroundId() {
        int testPlaygroundId = 1;
        assertEquals(0, comment.getPlaygroundId(), 0);
        comment.setId(testPlaygroundId);
        assertEquals(testPlaygroundId, comment.getId(), 0);
    }
    public void testSetAndGetCreateTime() {
        Date testCreateTime = new Date();
        assertNull(comment.getCreateTime());
        comment.setCreateTime(testCreateTime);
        assertEquals(testCreateTime, comment.getCreateTime());
    }
    public void testSetAndGetName() {
        String testName = "testName";
        assertNull(comment.getName());
        comment.setName(testName);
        assertEquals(testName, comment.getName());
    }

}
