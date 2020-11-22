package controller;

import com.elec5619.easysports.controller.ManageController;
import com.elec5619.easysports.controller.SearchResultController;
import com.elec5619.easysports.domain.Booking;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.domain.TimePeriod;
import com.elec5619.easysports.service.BookingService;
import com.elec5619.easysports.service.HistoryService;
import com.elec5619.easysports.service.PlaygroundService;
import com.elec5619.easysports.service.TimePeriodService;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class ManageControllerTest {

    @Configuration
    static class MyWebConfig {

        @Bean
        public ManageController myManageController() {
            return new ManageController();
        }

        @Bean
        public BookingService bookingService() {
            return Mockito.mock(BookingService.class);
        }

        @Bean
        public TimePeriodService timePeriodService() {
            return Mockito.mock(TimePeriodService.class);
        }

    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private ManageController manageController;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private TimePeriodService timePeriodService;

    private Booking booking;

    private TimePeriod timePeriod;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(manageController)
                .setViewResolvers(viewResolver)
                .build();

        booking = new Booking();
        booking.setId(1);

        timePeriod = new TimePeriod();

    }

    @Test
    public void testViewSearchResultGetNoResults() throws Exception {

        when(bookingService.findbooking(anyInt())).thenReturn(booking);
        when(timePeriodService.getById(1)).thenReturn(timePeriod);
        this.mockMvc.perform(get("/manage")
                .param("bookingid", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("manage"));
    }

    @Test
    public void testCancelPost() throws Exception {
        when(bookingService.findbooking(anyInt())).thenReturn(booking);
        when(timePeriodService.getById(anyInt())).thenReturn(timePeriod);
        this.mockMvc.perform(post("/manage")
                .param("bookingid", "1"))
                .andExpect(view().name("redirect:/bookings"));
    }

}
