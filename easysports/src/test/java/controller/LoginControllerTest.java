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
public class LoginControllerTest {

    @Configuration
    static class MyWebConfig {

        @Bean
        public LoginController myLoginController() {
            return new LoginController();
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
    private UserService userService;

    private User user;


    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(loginController)
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
    public void testLoginGet() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void testWelcomeGet() throws Exception {
        this.mockMvc.perform(get("/welcome"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"));
    }

    @Test
    public void testLoginPost400() throws Exception {

        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/login"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testLoginPostSuccess() throws Exception {

        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/login")
                        .param("email", "testEmail")
                        .param("password", "testPassword"))
                        .andExpect(view().name("redirect:/welcome"));

        verify(userService, times(1)).findByEmail("testEmail");
    }

    @Test
    public void testLoginPostWrongEmail() throws Exception {

        when(userService.findByEmail("wrongEmail")).thenReturn(null);
        mockMvc.perform(post("/login")
                .param("email", "wrongEmail")
                .param("password", "testPassword"))
                .andExpect(view().name("login"))
                .andExpect(model().attribute("message","Enter Correct details..."));

    }

    @Test
    public void testLoginPostWrongPassword() throws Exception {

        when(userService.findByEmail("wrongPassword")).thenReturn(null);
        mockMvc.perform(post("/login")
                .param("email", "testEmail")
                .param("password", "wrongPassword"))
                .andExpect(view().name("login"))
                .andExpect(model().attribute("message","Enter Correct details..."));

    }



}
