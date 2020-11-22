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
public class PasswordControllerTest {

    @Configuration
    static class MyWebConfig {

        @Bean
        public LoginController myLoginController() {
            return new LoginController();
        }

        @Bean
        public PasswordController myPasswordController() {
            return new PasswordController();
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
    private PasswordController passwordController;

    @Autowired
    private UserService userService;

    private User user;


    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(passwordController)
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
    public void testForgotPasswordGet() throws Exception {
        this.mockMvc.perform(get("/forgotPassword"))
                .andExpect(status().isOk())
                .andExpect(view().name("forgotPassword"));
    }

    @Test
    public void testCorrectEmail() throws Exception {

        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/forgotPassword")
                .param("email", "testEmail"))
                .andExpect(view().name("redirect:/verifySecurityAnswer"));
        verify(userService, times(1)).findByEmail("testEmail");
    }

    @Test
    public void testWrongEmail() throws Exception {

        when(userService.findByEmail("wrongEmail")).thenReturn(null);
        mockMvc.perform(post("/forgotPassword")
                .param("email", "wrongEmail"))
                .andExpect(view().name("forgotPassword"))
                .andExpect(model().attribute("message","Your email is wrong, please try again"));;
        verify(userService, times(1)).findByEmail("wrongEmail");
    }

    @Test
    public void testVerifySecurityAnswerGet() throws Exception {
//        System.out.println(user.getSecurityQuestion());
        when(userService.findByEmail("testEmail")).thenReturn(user);
//        when(userService.findByEmail("testEmail").getSecurityQuestion()).thenReturn("1");
        this.mockMvc.perform(get("/verifySecurityAnswer"))
                .andExpect(status().isOk())
                .andExpect(view().name("verifySecurityAnswer"));
    }

    @Test
    public void testWrongSecurityAnswer() throws Exception {

        when(userService.findByEmail("wrongEmail")).thenReturn(null);
        mockMvc.perform(post("/verifySecurityAnswer")
                .param("answer", "wrongAnswer"))
                .andExpect(view().name("verifySecurityAnswer"));
    }

    @Test
    public void testChangePasswordVerifiedGet() throws Exception {
        this.mockMvc.perform(get("/changePasswordVerified"))
                .andExpect(status().isOk())
                .andExpect(view().name("changePasswordVerified"));
    }

    @Test
    public void testAfterChangePassword() throws Exception {
        when(userService.findByEmail("testEmail")).thenReturn(user);
        this.mockMvc.perform(get("/afterChangePassword"))
                .andExpect(status().isOk())
                .andExpect(view().name("afterChangePassword"));
    }

    @Test
    public void testChangePasswordVerified() throws Exception {
        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/changePasswordVerified")
                .param("newPassword", "123")
                .param("verifyPassword", "123"))
                .andExpect(view().name("redirect:/afterChangePassword"));
    }

    @Test
    public void testChangePasswordVerifiedFail() throws Exception {
        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/changePasswordVerified")
                .param("newPassword", "1")
                .param("verifyPassword", "123"))
                .andExpect(view().name("changePasswordVerified"));
    }

    @Test
    public void testChangePasswordGet() throws Exception {
        when(userService.findByEmail("testEmail")).thenReturn(user);
        this.mockMvc.perform(get("/changePassword"))
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/login"));
    }

    @Test
    public void testChangePassword() throws Exception {
        when(userService.findByEmail("testEmail")).thenReturn(user);
        mockMvc.perform(post("/changePassword")
                .param("previousPassword", "1")
                .param("newPassword", "123")
                .param("verifyPassword", "123"))
                .andExpect(view().name("redirect:/login"))
                .andExpect(model().attribute("message","You are currently not logged in, please log in first to proceed."));;
    }
}
