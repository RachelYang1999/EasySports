package com.elec5619.easysports.dao.impl;
import com.elec5619.easysports.dao.HistoryDao;
import com.elec5619.easysports.domain.VisitRecord;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional(readOnly = false)
public class HistoryDaoImpl extends AbstractDao<Integer, VisitRecord> implements HistoryDao {

    @Override
    public VisitRecord getVisitRecordByID(int visitRecordID) {
        return getByKey(visitRecordID);
    }

    @Override
    public List<VisitRecord> getVisitRecordList() {
        return loadAll();
    }

    @Override
    public int saveVisitRecord(VisitRecord visitRecord) {
        save(visitRecord);
        return visitRecord.getId();
    }
    @Override
    public List<VisitRecord> findAllByProperty(String property, Object value) {
        return getListByProperty(property, value);
    }

}
