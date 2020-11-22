package com.elec5619.easysports.dao.impl;

import com.elec5619.easysports.dao.FavouriteDao;
import com.elec5619.easysports.domain.Favourite;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional(readOnly = false)
public class FavouriteDaoImpl  extends AbstractDao<Integer, Favourite> implements FavouriteDao {
    @Override
    public Favourite getById(int favouriteId){return getByKey(favouriteId);}

    @Override
    public List<Favourite> findAllByProperty(String propertyName, Object value) {
        return getListByProperty(propertyName, value);
    }
    @Override
    public void deleteFavourite(int favouriteId) {
        delete(getById(favouriteId));
    }

    @Override
    public List<Favourite> findAllBy() {
        return loadAll();
    }


    @Override
    public int saveFavourite(Favourite favourite) {
        save(favourite);
        return favourite.getId();
    }

}
