package com.elec5619.easysports.dao;

import com.elec5619.easysports.domain.Favourite;

import java.util.List;

public interface FavouriteDao {
    public Favourite getById(int favouriteID);
    List<Favourite> findAllByProperty(String propertyName, Object value);
    public void deleteFavourite(int favouriteID);
    List<Favourite> findAllBy();

    int saveFavourite(Favourite favourite);
}
