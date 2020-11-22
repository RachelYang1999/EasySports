package controller;

import com.elec5619.easysports.controller.SearchResultController;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.domain.TimePeriod;
import com.elec5619.easysports.service.FavouriteService;
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
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class SearchResultControllerTest {

    @Configuration
    static class MyWebConfig {

        @Bean
        public SearchResultController mySearchResultController() {
            return new SearchResultController();
        }

        @Bean
        public PlaygroundService playgroundService() {
            return Mockito.mock(PlaygroundService.class);
        }

        @Bean
        public TimePeriodService timePeriodService() {
            return Mockito.mock(TimePeriodService.class);
        }

        @Bean
        public HistoryService historyService() {
            return Mockito.mock(HistoryService.class);
        }

        @Bean
        public FavouriteService favouriteService() {
            return Mockito.mock(FavouriteService.class);
        }

    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private SearchResultController searchResultController;

    @Autowired
    private PlaygroundService playgroundService;

    @Autowired
    private TimePeriodService timePeriodService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private FavouriteService favouriteService;


    private Playground playground;



    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(searchResultController)
                .setViewResolvers(viewResolver)
                .build();

        playground = new Playground();
        playground.setId(1);
        playground.setType("testType");


    }

    @Test
    public void testViewSearchResultGetNoResults() throws Exception {

        List<TimePeriod> testTimePeriodList = new ArrayList<>();

        when(timePeriodService.findAllByTwoProperty("day", "testDay", "isAvailable", true)).thenReturn(testTimePeriodList);
        when(playgroundService.getById(anyInt())).thenReturn(null);

        this.mockMvc.perform(get("/viewSearchResult")
                .param("playgroundType", "testType")
                .param("preferredDay", "testDay")
                .param("preferredDistance", "testDistance"))
                .andExpect(status().isOk())
                .andExpect(view().name("viewSearchResult"))
                .andExpect(model().attribute("message","Sorry there is no suitable result."));
    }

    @Test
    public void testViewPost() throws Exception {
        this.mockMvc.perform(post("/welcome")
                .param("playgroundType", "testType")
                .param("preferredDay", "testDay")
                .param("preferredDistance", "testDistance"))
                .andExpect(view().name("redirect:/viewSearchResult"));
    }

    @Test
    public void testGetPlayground_idPost() throws Exception {
        this.mockMvc.perform(post("/viewSearchResult")
                .param("playgroundid", "1")
                .param("selectedDay", "testDay"))
                .andExpect(view().name("redirect:/playground"))
                .andExpect(model().attribute("selectedDay","testDay"));
    }


}
