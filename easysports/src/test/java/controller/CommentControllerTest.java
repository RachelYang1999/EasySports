package controller;

import com.elec5619.easysports.controller.CommentController;
import com.elec5619.easysports.controller.SearchResultController;
import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.service.CommentService;
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

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class CommentControllerTest {
    @Configuration
    static class MyWebConfig {

        @Bean
        public CommentController myCommentController() {
            return new CommentController();
        }

        @Bean
        public PlaygroundService playgroundService() {
            return Mockito.mock(PlaygroundService.class);
        }

        @Bean
        public CommentService commentService() {
            return Mockito.mock(CommentService.class);
        }
    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private CommentController commentController;

    @Autowired
    private PlaygroundService playgroundService;


    private Comment comment;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(commentController)
                .setViewResolvers(viewResolver)
                .build();

        comment = new Comment();
        comment.setId(1);
        Comment comment = new Comment();
        comment.setCreateTime(new Date());
        comment.setDescription("testDescription");
        comment.setUserId(1);
        comment.setPlaygroundId(1);
        comment.setName("testPlaygroundName");


    }

    @Test
    public void testViewCommentGet() throws Exception {

        this.mockMvc.perform(get("/viewComments"))
                .andExpect(status().isOk())
                .andExpect(view().name("viewComments"));
    }





}
