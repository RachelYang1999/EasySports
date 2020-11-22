package com.elec5619.easysports.dao;

import com.elec5619.easysports.domain.VisitRecord;

import java.util.List;

public interface HistoryDao {
    public VisitRecord getVisitRecordByID(int VisitRecordID);
    public List<VisitRecord> getVisitRecordList();
    public int saveVisitRecord(VisitRecord visitRecord);
    public List<VisitRecord> findAllByProperty(String property, Object value);
//    public VisitRecord findOneByProperty(int userID);
}
