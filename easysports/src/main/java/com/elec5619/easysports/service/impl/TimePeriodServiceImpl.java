package com.elec5619.easysports.service.impl;

import com.elec5619.easysports.dao.TimePeriodDao;
import com.elec5619.easysports.dao.impl.TimePeriodDaoImpl;
import com.elec5619.easysports.domain.TimePeriod;
import com.elec5619.easysports.service.TimePeriodService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TimePeriodServiceImpl implements TimePeriodService {
    @Autowired
    private TimePeriodDao timePeriodDao;

    @Override
    public TimePeriod getById(int timePeriodID) {
        return timePeriodDao.getById(timePeriodID);
    }

    @Override
    public List<TimePeriod> findAllByProperty(String propertyName, Object value) {
        return timePeriodDao.findAllByProperty(propertyName, value);
    }

    @Override
    public List<TimePeriod> findAllByTwoProperty(String propertyName1, Object value1, String propertyName2, Object value2) {
        return timePeriodDao.findAllByTwoProperty(propertyName1, value1, propertyName2, value2);
    }
    @Override
    public String findallavaiabletime(Object value1,Object value2)throws IOException{
        List<TimePeriod> timePeriods=timePeriodDao.findtherelatedtimeProperty(value1,value2);

        ObjectMapper objectMapper = new ObjectMapper();//jackson
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        objectMapper.writeValue(out, timePeriods);
        byte[] data = out.toByteArray();
        System.out.println(new String(data, StandardCharsets.UTF_8));
        return new String(data, StandardCharsets.UTF_8);

    }

    @Override
    public void update(TimePeriod timePeriod) {
        timePeriodDao.update(timePeriod);
    }

    @Override
    public void deleteTimePeriod(int timePeriodID) {
        timePeriodDao.deletetimeperiod(timePeriodID);
    }

    @Override
    public int insert(TimePeriod timePeriod) {
        return timePeriodDao.savetimeperiod(timePeriod);
    }

    @Override
    public List<TimePeriod> findAllTimePeriod() {
        return timePeriodDao.findAll();
    }
}
