package com.elec5619.easysports.dao.impl;

import com.elec5619.easysports.dao.TimePeriodDao;
import com.elec5619.easysports.domain.TimePeriod;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = false)
public class TimePeriodDaoImpl extends AbstractDao<Integer, TimePeriod> implements TimePeriodDao {

    @Override
    public TimePeriod getById(int time_id) {
        return getByKey(time_id);
    }

    @Override
    public List<TimePeriod> findAllByProperty(String propertyName, Object value) {
        return getListByProperty(propertyName, value);
    }

    @Override
    public List<TimePeriod> findtherelatedtimeProperty(Object value1,Object value2){
        System.out.println(value1+"    "+value2);

        List<TimePeriod> playgroundalltime=getListByThreeProperty("playgroundId",value1,"day",value2,"isAvailable",true);
        return playgroundalltime;
    }

    @Override
    public void deletetimeperiod(int time_id) {
        delete(getById(time_id));
    }

    @Override
    public int savetimeperiod(TimePeriod timePeriod) {
        save(timePeriod);
        return timePeriod.getId();
    }

    @Override
    public List<TimePeriod> findAll() {
        return loadAll();
    }

    @Override
    public List<TimePeriod> findAllByTwoProperty(String propertyName1, Object value1, String propertyName2, Object value2) {
        return getListByTwoProperty(propertyName1, value1, propertyName2, value2);
    }

    @Override
    public void update(TimePeriod timePeriod) {
        update(timePeriod);
    }



}
