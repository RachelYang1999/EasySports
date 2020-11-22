package controller;

import com.elec5619.easysports.controller.SearchHistoryController;
import com.elec5619.easysports.controller.SearchResultController;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.domain.TimePeriod;
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
public class SearchHistoryControllerTest {
    @Configuration
    static class MyWebConfig {

        @Bean
        public SearchHistoryController mySearchHistoryController() {
            return new SearchHistoryController();
        }

        @Bean
        public PlaygroundService playgroundService() {
            return Mockito.mock(PlaygroundService.class);
        }

        @Bean
        public HistoryService historyService() {
            return Mockito.mock(HistoryService.class);
        }

    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private SearchHistoryController searchHistoryController;

    @Autowired
    private PlaygroundService playgroundService;


    @Autowired
    private HistoryService historyService;

    private Playground playground;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(searchHistoryController)
                .setViewResolvers(viewResolver)
                .build();

        playground = new Playground();
        playground.setId(1);
        playground.setType("testType");


    }
    @Test
    public void testViewSearchResultGetNoResults() throws Exception {

        List<TimePeriod> testTimePeriodList = new ArrayList<>();
        when(playgroundService.getById(anyInt())).thenReturn(null);

        this.mockMvc.perform(get("/viewSearchHistory"))
                .andExpect(status().isOk())
                .andExpect(view().name("viewSearchHistory"));
    }
    @Test
    public void testViewGet() throws Exception {
        this.mockMvc.perform(get("/viewSearchHistory")
                .param("playgroundid", "4")
                .param("preferredDay", "testDay"))
                .andExpect(view().name("viewSearchHistory"));
    }

}
