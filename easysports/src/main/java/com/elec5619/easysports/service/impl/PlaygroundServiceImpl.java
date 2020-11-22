package com.elec5619.easysports.service.impl;

import com.elec5619.easysports.dao.PlaygroundDao;
import com.elec5619.easysports.dao.impl.PlaygroundDaoImpl;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.service.PlaygroundService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Transactional
public class PlaygroundServiceImpl implements PlaygroundService {

    @Autowired
    private PlaygroundDao playgroundDao;


    @Override
    public Playground getById(int playgroundID) {
        return playgroundDao.getById(playgroundID);
    }


    @Override
    public List<Playground> findAllByProperty(String propertyName, Object value) {
        return playgroundDao.findAllByProperty(propertyName, value);
    }

    @Override
    public Playground findOneByProperty(String propertyName, Object value) {
        return playgroundDao.findOneByProperty(propertyName, value);
    }

    @Override
    public void deletePlayground(int playgroundId) {
        playgroundDao.deletePlayground(playgroundId);
    }

    @Override
    public int insert(Playground playground) {
        return playgroundDao.savePlayground(playground);
    }

    @Override
    public String getPlaygroundJson(List<Playground> playgrounds) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        objectMapper.writeValue(out, playgrounds);
        byte[] data = out.toByteArray();
        System.out.println(new String(data, StandardCharsets.UTF_8));
        return new String(data, StandardCharsets.UTF_8);
    }

    @Override
    public List<Playground> findAllPlayground() {
        return playgroundDao.findAllPlayground();
    }


}
