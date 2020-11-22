package com.elec5619.easysports.dao.impl;

import com.elec5619.easysports.dao.PlaygroundDao;
import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class PlaygroundDaoImpl extends AbstractDao<Integer, Playground> implements PlaygroundDao {

    @Override
    public Playground getById(int playgroundID) {
        return getByKey(playgroundID);
    }

    @Override
    public List<Playground> findAllByProperty(String propertyName, Object value) {
        return getListByProperty(propertyName, value);
    }

    @Override
    public Playground findOneByProperty(String propertyName, Object value) {
        return getOneByProperty(propertyName, value);
    }

    @Override
    public void deletePlayground(int playgroundId) {
        delete(getById(playgroundId));
    }

    @Override
    public int savePlayground(Playground playground) {
        save(playground);
        return playground.getId();
    }

    @Override
    public List<Playground> findAllPlayground() {
        return loadAll();
    }



}
