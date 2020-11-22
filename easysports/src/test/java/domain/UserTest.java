package domain;

import com.elec5619.easysports.domain.User;
import junit.framework.TestCase;

import java.util.Date;

public class UserTest extends TestCase {
    private User user;

    protected void setUp() throws Exception {
        user = new User();
    }

    public void testSetAndGetId() {
        int testId = 1;
        assertEquals(0, user.getId(), 0);
        user.setId(testId);
        assertEquals(testId, user.getId(), 0);
    }

    public void testSetAndGetUsername() {
        String testUsername = "testUsername";
        assertNull(user.getUserName());
        user.setUserName(testUsername);
        assertEquals(testUsername, user.getUserName());
    }

    public void testSetAndGetEmail() {
        String testEmail = "testEmail";
        assertNull(user.getEmail());
        user.setEmail(testEmail);
        assertEquals(testEmail, user.getEmail());
    }

    public void testSetAndGetAddress() {
        String testAddress = "testAddress";
        assertNull(user.getAddress());
        user.setAddress(testAddress);
        assertEquals(testAddress, user.getAddress());
    }

    public void testSetAndGetPassword() {
        String testPassword = "testPassword";
        assertNull(user.getPassword());
        user.setPassword(testPassword);
        assertEquals(testPassword, user.getPassword());
    }

    public void testSetAndGetDescription() {
        String testDescription = "testDescription";
        assertNull(user.getDescription());
        user.setDescription(testDescription);
        assertEquals(testDescription, user.getDescription());
    }

    public void testSetAndGetSecurityQuestion() {
        String testSecurityQuestion = "testSecurityQuestion";
        assertNull(user.getSecurityQuestion());
        user.setSecurityQuestion(testSecurityQuestion);
        assertEquals(testSecurityQuestion, user.getSecurityQuestion());
    }

    public void testSetAndGetAnswer() {
        String testAnswer= "testAnswer";
        assertNull(user.getAnswer());
        user.setAnswer(testAnswer);
        assertEquals(testAnswer, user.getAnswer());
    }

    public void testSetAndGetCreateTime() {
        Date testCreateTime = new Date();
        assertNull(user.getCreateTime());
        user.setCreateTime(testCreateTime);
        assertEquals(testCreateTime, user.getCreateTime());
    }

    public void testSetAndGetFbURL() {
        String testFbURL = "testFbURL";
        assertNull(user.getFbURL());
        user.setFbURL(testFbURL);
        assertEquals(testFbURL, user.getFbURL());
    }

    public void testSetAndGetTwitterURL() {
        String testTwitterURL= "testTwitterURL";
        assertNull(user.getTwitterURL());
        user.setTwitterURL(testTwitterURL);
        assertEquals(testTwitterURL, user.getTwitterURL());
    }




}
