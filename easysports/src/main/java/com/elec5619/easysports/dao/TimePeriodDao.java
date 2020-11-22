package com.elec5619.easysports.dao;

import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.domain.TimePeriod;

import java.util.List;

public interface TimePeriodDao {
    TimePeriod getById(int time_id);
    List<TimePeriod> findAllByProperty(String propertyName, Object value);
    void deletetimeperiod(int time_id);
    int savetimeperiod(TimePeriod timePeriod);
    List<TimePeriod> findAll();
    List<TimePeriod> findAllByTwoProperty(String propertyName1, Object value1, String propertyName2, Object value2);
    List<TimePeriod> findtherelatedtimeProperty(Object value1,Object value2);
    void update(TimePeriod timePeriod);

}
