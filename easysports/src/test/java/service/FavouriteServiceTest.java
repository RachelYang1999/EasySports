package service;

import com.elec5619.easysports.dao.CommentDao;
import com.elec5619.easysports.dao.FavouriteDao;
import com.elec5619.easysports.dao.PlaygroundDao;
import com.elec5619.easysports.dao.UserDao;
import com.elec5619.easysports.domain.Favourite;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.CommentService;
import com.elec5619.easysports.service.FavouriteService;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.service.impl.CommentServiceImpl;
import com.elec5619.easysports.service.impl.FavouriteServiceImpl;
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
public class FavouriteServiceTest {
    @Configuration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public FavouriteService favouriteService() {
            return new FavouriteServiceImpl();
        }

        @Bean
        public FavouriteDao favouriteRepository() {
            return Mockito.mock(FavouriteDao.class);
        }
    }
    @Autowired
    private FavouriteService favouriteService;

    @Autowired
    private FavouriteDao favouriteDao;

    Favourite favourite;
    List<Favourite> favourites;

    @Before
    public void setup(){
        favourite = new Favourite();
        favourites = new ArrayList<>();
        favourite.setId(1);
        favourite.setUserId(1);
        favourite.setPlaygroundId(1);
        favourite.setCreateTime(new Date());
        favourites.add(favourite);

        Mockito.when(favouriteDao.getById(1)).thenReturn(favourite);
        Mockito.when(favouriteDao.findAllByProperty("id", 1)).thenReturn(favourites);
        Mockito.when(favouriteDao.findAllBy()).thenReturn(favourites);
    }

    @Test
    public void testFindUserById() {
        Assert.assertEquals(favourite, favouriteService.getById(1));
    }
    @Test
    public void testFindAllByProperty() {
        Assert.assertEquals(1, favouriteService.findAllByProperty("id", 1).size());
    }
    @Test
    public void testFindAllUsers() {
        Assert.assertEquals(1, favouriteService.getAllFav().size());
    }

}
