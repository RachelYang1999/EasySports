package com.elec5619.easysports.service;

import com.elec5619.easysports.domain.Playground;

import java.io.IOException;
import java.util.List;

public interface PlaygroundService {
    public Playground getById(int playgroundID);
    List<Playground> findAllByProperty(String propertyName, Object value);
    Playground findOneByProperty(String propertyName, Object value);
    public void deletePlayground(int playgroundId);
    int insert(Playground playground);
    String getPlaygroundJson(List<Playground> playgrounds) throws IOException;
    List<Playground> findAllPlayground();
}
