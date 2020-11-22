package service;

import com.elec5619.easysports.dao.UserDao;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceTest {

    @Configuration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }

        @Bean
        public UserDao userRepository() {
            return Mockito.mock(UserDao.class);
        }
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    User user;
    List<User> users;

    @Before
    public void setup() {
        users = new ArrayList<>();

        user = new User();
        user.setId(1);
        user.setUserName("testUserName");
        user.setEmail("testEmail");
        user.setAddress("testAddress");
        user.setPassword("testPassword");
        user.setType("normal");
        user.setAnswer("1");
        user.setSecurityQuestion("1");
        user.setCreateTime(new Date());
        user.setFbURL("testFbURL");
        user.setTwitterURL("testTwitterURL");
        user.setDescription("testDescription");
        users.add(user);

        User user2 = new User();
        user2.setId(2);
        user2.setAddress("testAddress");
        users.add(user2);



        Mockito.when(userDao.getById(1)).thenReturn(user);
        Mockito.when(userDao.findOneByProperty("email", "testEmail")).thenReturn(user);
        Mockito.when(userDao.findAllByProperty("address", "testAddress")).thenReturn(users);
        Mockito.when(userDao.findAllUsers()).thenReturn(users);
    }

    @Test
    public void testFindUserById() {
        Assert.assertEquals(user, userService.findById(1));

    }

    @Test
    public void testFindUserByProperty() {
        Assert.assertEquals(user, userService.findOneByProperty("email", "testEmail"));
    }

    @Test
    public void testFindAllByProperty() {
        Assert.assertEquals(2, userService.findAllByProperty("address", "testAddress").size());
    }

    @Test
    public void testFindAllUsers() {
        Assert.assertEquals(2, userService.findAllUsers().size());
    }



}
