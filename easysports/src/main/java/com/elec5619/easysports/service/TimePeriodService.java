package com.elec5619.easysports.service;

import com.elec5619.easysports.domain.TimePeriod;
import com.elec5619.easysports.domain.User;

import java.io.IOException;
import java.util.List;

public interface TimePeriodService {
    public TimePeriod getById(int timePeriodID);
    List<TimePeriod> findAllByProperty(String propertyName, Object value);
    List<TimePeriod> findAllByTwoProperty(String propertyName1, Object value1, String propertyName2, Object value2);
    public void deleteTimePeriod(int timePeriodID);
    int insert(TimePeriod timePeriod);
    List<TimePeriod> findAllTimePeriod();
    public String findallavaiabletime(Object value1,Object value2)throws IOException;
    void update(TimePeriod timePeriod);
}
