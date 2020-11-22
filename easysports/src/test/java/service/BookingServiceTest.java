package service;

import com.elec5619.easysports.dao.BookingDao;
import com.elec5619.easysports.dao.PlaygroundDao;
import com.elec5619.easysports.dao.TimePeriodDao;
import com.elec5619.easysports.dao.UserDao;
import com.elec5619.easysports.dao.impl.BookingDaoImpl;
import com.elec5619.easysports.dao.impl.PlaygroundDaoImpl;
import com.elec5619.easysports.dao.impl.TimePeriodDaoImpl;
import com.elec5619.easysports.domain.Booking;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.BookingService;
import com.elec5619.easysports.service.PlaygroundService;
import com.elec5619.easysports.service.TimePeriodService;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.service.impl.BookingServiceImpl;
import com.elec5619.easysports.service.impl.PlaygroundServiceImpl;
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
public class BookingServiceTest {
    @Configuration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public BookingService bookingService() {
            return new BookingServiceImpl();
        }

        @Bean
        public BookingDao bookingRepository() {
            return Mockito.mock(BookingDao.class);
        }

        @Bean
        public PlaygroundDao PlaygroundRepository() {
            return Mockito.mock(PlaygroundDao.class);
        }

        @Bean
        public TimePeriodDao TimePeriodRepository() {
            return Mockito.mock(TimePeriodDao.class);
        }
    }
    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private PlaygroundDao playgroundDao;

    @Autowired
    private TimePeriodDao timePeriodDao;

    Booking booking;
    List<Booking> bookings;

    @Before
    public void setup() {
        bookings = new ArrayList<>();
        booking = new Booking();
        booking.setId(1);
        booking.setPlaygroundId(1);
        booking.setTimeperiod(1);
        booking.setStatus("testStatus");
        booking.setCreateTime(new Date());
        bookings.add(booking);

        Booking booking2 = new Booking();
        booking2.setId(2);
        booking2.setPlaygroundId(2);
        booking2.setTimeperiod(2);
        booking2.setStatus("testStatus2");
        booking2.setCreateTime(new Date());
        bookings.add(booking2);

        Mockito.when(bookingDao.get_booking(1)).thenReturn(booking);

    }
    @Test
    public void testFindUserById() {
        Assert.assertEquals(booking, bookingService.findbooking(1));
    }
}
