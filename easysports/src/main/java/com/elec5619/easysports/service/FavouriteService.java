package com.elec5619.easysports.service;

import com.elec5619.easysports.domain.Favourite;


import java.io.IOException;
import java.util.List;

public interface FavouriteService {
    public Favourite getById(int favouriteID);
    List<Favourite> findAllByProperty(String propertyName, Object value);
    public void deleteFavourite(int favouriteID);
    int insert(Favourite favourite);
    String getFavouriteJson(List<Favourite> favourites) throws IOException;
    List<Favourite> getFavouritesByUserId(int userId);
    List<Favourite> getAllFav();
}
