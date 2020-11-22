package service;

import com.elec5619.easysports.dao.HistoryDao;
import com.elec5619.easysports.dao.PlaygroundDao;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.domain.VisitRecord;
import com.elec5619.easysports.service.HistoryService;
import com.elec5619.easysports.service.PlaygroundService;
import com.elec5619.easysports.service.impl.HistoryServiceImpl;
import com.elec5619.easysports.service.impl.PlaygroundServiceImpl;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PlaygroundServiceTest {

    @Configuration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public PlaygroundService playgroundService() {
            return new PlaygroundServiceImpl();
        }

        @Bean
        public PlaygroundDao userRepository() {
            return Mockito.mock(PlaygroundDao.class);
        }
    }

    @Autowired
    private PlaygroundService playgroundService;

    @Autowired
    private PlaygroundDao playgroundDao;

    Playground playground;
    List<Playground> playgrounds;

    @Before
    public void setup() {
        playgrounds = new ArrayList<>();

        playground = new Playground();
        playground.setId(1);
        playground.setDistance(1);
        playground.setType("basketball");

        playgrounds.add(playground);



        Mockito.when(playgroundDao.getById(1)).thenReturn(playground);
        Mockito.when(playgroundDao.findOneByProperty("id", 1)).thenReturn(playground);
        Mockito.when(playgroundDao.findAllByProperty("id", "1")).thenReturn(playgrounds);
        Mockito.when(playgroundDao.findAllPlayground()).thenReturn(playgrounds);

    }

    @Test
    public void testFindPlaygroundById() {
        Assert.assertEquals(playground, playgroundService.getById(1));

    }

    @Test
    public void testFindPlaygroundsByProperty() {
        Assert.assertEquals(playgrounds, playgroundService.findAllByProperty("id", "1"));
    }

    @Test
    public void testGetPlaygroundsList() {
        Assert.assertEquals(1, playgroundService.findAllPlayground().size());
    }

    @Test
    public void testFindOneByProperty() {
        Assert.assertEquals(playground, playgroundService.findOneByProperty("id", 1));
    }
}
