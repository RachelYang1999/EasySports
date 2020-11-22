package service;

import com.elec5619.easysports.dao.HistoryDao;
import com.elec5619.easysports.dao.UserDao;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.domain.VisitRecord;
import com.elec5619.easysports.service.HistoryService;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.service.impl.HistoryServiceImpl;
import com.elec5619.easysports.service.impl.UserServiceImpl;
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
public class HistoryServiceTest {

    @Configuration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public HistoryService historyService() {
            return new HistoryServiceImpl();
        }

        @Bean
        public HistoryDao userRepository() {
            return Mockito.mock(HistoryDao.class);
        }
    }

    @Autowired
    private HistoryService historyService;

    @Autowired
    private HistoryDao historyDao;

    VisitRecord history;
    List<VisitRecord> histories;

    @Before
    public void setup() {
        histories = new ArrayList<>();

        history = new VisitRecord();
        history.setId(1);
        history.setPlaygroundId(1);
        history.setUserId(1);
        histories.add(history);



        Mockito.when(historyDao.getVisitRecordByID(1)).thenReturn(history);
        Mockito.when(historyDao.getVisitRecordList()).thenReturn(histories);
        Mockito.when(historyDao.findAllByProperty("id", "1")).thenReturn(histories);

    }

    @Test
    public void testFindHistoryById() {
        Assert.assertEquals(history, historyService.getHistoryByID(1));

    }

    @Test
    public void testFindHistoriesByProperty() {
        Assert.assertEquals(histories, historyService.findAllByProperty("id", "1"));
    }

    @Test
    public void testGetVisitRecordList() {
        Assert.assertEquals(1, historyService.getAllVisitRecord().size());
    }

}
