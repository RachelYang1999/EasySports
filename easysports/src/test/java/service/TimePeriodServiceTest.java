package service;

import com.elec5619.easysports.dao.TimePeriodDao;
import com.elec5619.easysports.dao.UserDao;
import com.elec5619.easysports.domain.TimePeriod;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.TimePeriodService;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.service.impl.TimePeriodServiceImpl;
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
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TimePeriodServiceTest {

    @Configuration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public TimePeriodService timePeriodService() {
            return new TimePeriodServiceImpl();
        }

        @Bean
        public TimePeriodDao timePeriodDao() {
            return Mockito.mock(TimePeriodDao.class);
        }
    }

    @Autowired
    private TimePeriodService timePeriodService;

    @Autowired
    private TimePeriodDao timePeriodDao;

    TimePeriod timePeriod;
    List<TimePeriod> timePeriods;

    @Before
    public void setup() {
        timePeriods = new ArrayList<>();

        timePeriod = new TimePeriod();
        timePeriod.setId(1);
        timePeriod.setBookingId(1);
        timePeriod.setAvailable(true);
        timePeriods.add(timePeriod);


        Mockito.when(timePeriodService.getById(1)).thenReturn(timePeriod);
        Mockito.when(timePeriodService.findAllTimePeriod()).thenReturn(timePeriods);
        Mockito.when(timePeriodService.findAllByProperty("id", 1)).thenReturn(timePeriods);
    }

    @Test
    public void testFindById() {
        Assert.assertEquals(timePeriod, timePeriodService.getById(1));

    }

    @Test
    public void testFindAllByProperty() {
        Assert.assertEquals(timePeriods, timePeriodService.findAllByProperty("id", 1));
    }


    @Test
    public void testFindAllUsers() {
        Assert.assertEquals(1, timePeriodService.findAllTimePeriod().size());
    }

}
