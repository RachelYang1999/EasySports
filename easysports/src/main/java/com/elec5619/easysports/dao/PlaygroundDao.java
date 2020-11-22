package com.elec5619.easysports.dao;

import com.elec5619.easysports.domain.Playground;

import java.util.List;

public interface PlaygroundDao {
    Playground getById(int playgroundID);
    List<Playground> findAllByProperty(String propertyName, Object value);
    Playground findOneByProperty(String propertyName, Object value);
    void deletePlayground(int playgroundId);
    int savePlayground(Playground playground);
    List<Playground> findAllPlayground();

}
