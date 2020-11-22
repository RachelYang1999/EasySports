package controller;

import com.elec5619.easysports.controller.BookingsController;
import com.elec5619.easysports.controller.LoginController;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.domain.TimePeriod;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.BookingService;
import com.elec5619.easysports.service.UserService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class BookingControllerTest {
    @Configuration
    static class MyWebConfig {

        @Bean
        public BookingsController myBookingController() {
            return new BookingsController();
        }

        @Bean
        public BookingService bookingService() {
            return Mockito.mock(BookingService.class);
        }
    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private BookingsController bookingsController;

    @Autowired
    private BookingService bookingService;

    private Playground playground;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(bookingsController)
                .setViewResolvers(viewResolver)
                .build();

        playground = new Playground();
        playground.setId(1);
        playground.setType("testType");

    }

    @Test
    public void testViewBookingGet() throws Exception {

        this.mockMvc.perform(get("/bookings"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookings"));

    }

    @Test
    public void testViewBookingPost() throws Exception {
        this.mockMvc.perform(post("/bookings")
                .param("bookingid", "1"))
                .andExpect(view().name("redirect:/manage"));
    }

}
