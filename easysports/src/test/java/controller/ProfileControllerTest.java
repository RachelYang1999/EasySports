package controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.elec5619.easysports.controller.LoginController;
import com.elec5619.easysports.controller.PasswordController;
import com.elec5619.easysports.controller.ProfileController;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.utility.SHA256Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class ProfileControllerTest {
    @Configuration
    static class MyWebConfig {

        @Bean
        public LoginController myLoginController() {
            return new LoginController();
        }

        @Bean
        public ProfileController myProfileController() {
            return new ProfileController();
        }

        @Bean
        public UserService userService() {
            return Mockito.mock(UserService.class);
        }
    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private LoginController loginController;

    @Autowired
    private ProfileController profileController;

    @Autowired
    private UserService userService;

    private User user;


    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(profileController)
                .setViewResolvers(viewResolver)
                .build();

        user = new User();
        user.setId(1);
        user.setUserName("testUserName");
        user.setEmail("testEmail");
        user.setAddress("testAddress");
        user.setPassword(SHA256Util.getSHA256("testPassword"));
        user.setType("normal");
        user.setAnswer("1");
        user.setSecurityQuestion("1");
        user.setCreateTime(new Date());
        user.setFbURL("testFbURL");
        user.setTwitterURL("testTwitterURL");
        user.setDescription("testDescription");
    }

    @Test
    public void testViewProfile() throws Exception {
        this.mockMvc.perform(get("/viewProfile"))
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/login"));
    }

    @Test
    public void testAccessEditProfile() throws Exception {
        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/viewProfile")
                .param("facebook", "www.facebook.com"))
                .andExpect(view().name("redirect:/login"));
    }

    @Test
    public void testEditProfileGet() throws Exception {
        this.mockMvc.perform(get("/editProfile"))
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/login"));
    }

    @Test
    public void testEditProfile() throws Exception {
        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/viewProfile")
                .param("userName", "username")
                .param("description", "Hi")
                .param("address", "1 ABC Road")
                .param("fbURL", "www.facebook.com"))
                .andExpect(view().name("redirect:/login"));
    }
}
