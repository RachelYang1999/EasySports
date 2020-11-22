package com.elec5619.easysports.service;
import com.elec5619.easysports.domain.TimePeriod;
import com.elec5619.easysports.domain.VisitRecord;

import java.io.IOException;
import java.util.List;
public interface HistoryService {
    public VisitRecord getHistoryByID(int id);
    public List<VisitRecord> getAllVisitRecord();
    public void addToHistory(VisitRecord visitRecord);
    public String getHistoryJson(int userID) throws IOException;
    public List<VisitRecord> findAllByProperty(String property, Object value);

}
