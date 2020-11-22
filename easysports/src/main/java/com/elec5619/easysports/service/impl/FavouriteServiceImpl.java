package com.elec5619.easysports.service.impl;

import com.elec5619.easysports.dao.FavouriteDao;
import com.elec5619.easysports.domain.Favourite;
import com.elec5619.easysports.service.FavouriteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Transactional
public class FavouriteServiceImpl implements FavouriteService {
    @Autowired
    private FavouriteDao favouriteDao;

    @Override
    public Favourite getById(int favouriteID) {
      return favouriteDao.getById(favouriteID);
    }

    @Override
    public List<Favourite> findAllByProperty(String propertyName, Object value) {
        return favouriteDao.findAllByProperty(propertyName, value);
    }

    @Override
    public void deleteFavourite(int favouriteID) {
        favouriteDao.deleteFavourite(favouriteID);
    }

    @Override
    public int insert(Favourite favourite) {

        return favouriteDao.saveFavourite(favourite);

    }

    @Override
    public List<Favourite> getFavouritesByUserId(int userId){
        return favouriteDao.findAllByProperty("userId", userId);
    }

    @Override
    public List<Favourite> getAllFav() {
        return favouriteDao.findAllBy();
    }

    @Override
    public String getFavouriteJson(List<Favourite> favourites) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        objectMapper.writeValue(out, favourites);
        byte[] data = out.toByteArray();
        System.out.println(new String(data, StandardCharsets.UTF_8));
        return new String(data, StandardCharsets.UTF_8);
    }
}
