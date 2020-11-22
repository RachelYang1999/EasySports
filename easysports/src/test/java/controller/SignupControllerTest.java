package controller;

import com.elec5619.easysports.controller.LoginController;
import com.elec5619.easysports.controller.SignupController;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class SignupControllerTest {
    @Configuration
    static class MyWebConfig {

        @Bean
        public SignupController mySignupController() {
            return new SignupController();
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
    private SignupController signupController;

    @Autowired
    private UserService userService;

    private User user;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(signupController)
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
    public void testSignupGet() throws Exception {
        this.mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(view().name("signup"));
    }

    @Test
    public void testSignupPostSuccess() throws Exception {

        when(userService.findByEmail("testEmail")).thenReturn(null);
        mockMvc.perform(post("/signup")
                .param("userName", "testUserName")
                .param("email", "testEmail")
                .param("password", "testPassword")
                .param("confirmPassword", "testPassword")
                .param("securityQuestion", "testSecurityQuestion")
                .param("answer", "testAnswer"))
                .andExpect(view().name("redirect:/login"))
                .andExpect(model().attribute("message","Successfully Registered"));

        verify(userService, times(1)).findByEmail("testEmail");
    }

    @Test
    public void testSignupPostAlreadyRegistered() throws Exception {

        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/signup")
                .param("userName", "testUserName")
                .param("email", "testEmail")
                .param("password", "testPassword")
                .param("confirmPassword", "testPassword")
                .param("securityQuestion", "testSecurityQuestion")
                .param("answer", "testAnswer"))
                .andExpect(view().name("signup"))
                .andExpect(model().attribute("message","Sorry, this email have been registered. You can signup with other email or directly login"));

    }

    @Test
    public void testSignupPostConfirmedPasswordNotEqual() throws Exception {

        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/signup")
                .param("userName", "testUserName")
                .param("email", "testEmail")
                .param("password", "testPassword")
                .param("confirmPassword", "testPassword11111")
                .param("securityQuestion", "testSecurityQuestion")
                .param("answer", "testAnswer"))
                .andExpect(view().name("signup"))
                .andExpect(model().attribute("message","Your password is not same."));

    }
}
