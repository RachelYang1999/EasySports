package service;

import com.elec5619.easysports.dao.CommentDao;
import com.elec5619.easysports.dao.PlaygroundDao;
import com.elec5619.easysports.dao.UserDao;
import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.CommentService;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.service.impl.CommentServiceImpl;
import com.elec5619.easysports.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CommentServiceTest {
    @Configuration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public CommentService commentService() {
            return new CommentServiceImpl();
        }

        @Bean
        public CommentDao commentRepository() {
            return Mockito.mock(CommentDao.class);
        }
        @Bean
        public PlaygroundDao playgroundRepository() {
            return Mockito.mock(PlaygroundDao.class);
        }
    }

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private PlaygroundDao playgroundDao;

    Comment comment;
    List<Comment> comments;

    Playground playground;

    Date date = new Date();

    @Before
    public void setup() {
        comments = new ArrayList<>();
        comment = new Comment();
        comment.setId(1);
        comment.setDescription("Description");
        comment.setUserId(1);
        comment.setPlaygroundId(1);
        comment.setName("testName");

        comment.setCreateTime(date);
        comments.add(comment);

        playground = new Playground();
        playground.setId(1);
        playground.setName("testName");

        Mockito.when(commentDao.getCommentList(1)).thenReturn(comments);

        Mockito.when(playgroundDao.getById(1)).thenReturn(playground);
    }

    private String getString(List<Comment> comments) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();//jackson
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        objectMapper.writeValue(out, comments);
        byte[] data = out.toByteArray();
        System.out.println(new String(data, StandardCharsets.UTF_8));
        return new String(data, StandardCharsets.UTF_8);
    }

    @Test
    public void testCommentList() throws IOException {

        Assert.assertEquals(getString(comments), commentService.getAllComments(1).trim());

    }
}
