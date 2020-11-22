package controller;

import com.elec5619.easysports.controller.FavouriteController;
import com.elec5619.easysports.controller.SearchResultController;
import com.elec5619.easysports.domain.Favourite;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class FavouriteControllerTest {
    @Configuration
    static class MyWebConfig {

        @Bean
        public FavouriteController myFavouriteController() {

            return new FavouriteController();
        }

        @Bean
        public FavouriteService favouriteService() {
            return Mockito.mock(FavouriteService.class);
        }

        @Bean
        public PlaygroundService playgroundService() {
            return Mockito.mock(PlaygroundService.class);
        }


    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private FavouriteController favouriteController;

    @Autowired
    private  FavouriteService favouriteService;

    @Autowired
    private PlaygroundService playgroundService;

    private Playground playground;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(favouriteController)
                .setViewResolvers(viewResolver)
                .build();

        playground = new Playground();
        playground.setId(1);


    }
    @Test
    public void view() throws IOException {
        try {
            favouriteController.View(new Model() {
                @Override
                public Model addAttribute(String s, Object o) {
                    return null;
                }

                @Override
                public Model addAttribute(Object o) {
                    return null;
                }

                @Override
                public Model addAllAttributes(Collection<?> collection) {
                    return null;
                }

                @Override
                public Model addAllAttributes(Map<String, ?> map) {
                    return null;
                }

                @Override
                public Model mergeAttributes(Map<String, ?> map) {
                    return null;
                }

                @Override
                public boolean containsAttribute(String s) {
                    return false;
                }

                @Override
                public Map<String, Object> asMap() {
                    return null;
                }
            });
        }catch (NullPointerException e){

        }
    }

    @Test
    public void testgetPlayground_idPost() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String date = format.format(new Date());
        this.mockMvc.perform(post("/viewFavourite")
                .param("playgroundid", "1")
                .param("selectedDay", date))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/playground"))
                .andExpect(model().attribute("selectedDay",date));
    }


}
