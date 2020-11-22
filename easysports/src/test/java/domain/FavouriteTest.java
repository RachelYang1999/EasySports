package domain;

import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.domain.Favourite;
import junit.framework.TestCase;

import java.util.Date;

public class FavouriteTest extends TestCase {
    private Favourite favourite;

    protected void setUp() throws Exception {
        favourite = new Favourite();
    }
    public void testSetAndGetId() {
        int testId = 1;
        assertEquals(0, favourite.getId(), 0);
        favourite.setId(testId);
        assertEquals(testId, favourite.getId(), 0);
    }
    public void testSetAndGetUserId() {
        int testUserId = 1;
        assertEquals(0, favourite.getUserId(), 0);
        favourite.setUserId(testUserId);
        assertEquals(testUserId, favourite.getUserId(), 0);
    }
    public void testSetAndGetPlaygroundId() {
        int testPlaygroundId = 1;
        assertEquals(0, favourite.getPlaygroundId(), 0);
        favourite.setPlaygroundId(testPlaygroundId);
        assertEquals(testPlaygroundId, favourite.getPlaygroundId(), 0);
    }
    public void testSetAndGetCreateTime() {
        Date testCreateTime = new Date();
        assertNull(favourite.getCreateTime());
        favourite.setCreateTime(testCreateTime);
        assertEquals(testCreateTime, favourite.getCreateTime());
    }
}
