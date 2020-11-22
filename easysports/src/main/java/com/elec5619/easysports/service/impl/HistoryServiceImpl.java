package com.elec5619.easysports.service.impl;

import com.elec5619.easysports.dao.HistoryDao;
import com.elec5619.easysports.dao.impl.HistoryDaoImpl;
import com.elec5619.easysports.dao.impl.PlaygroundDaoImpl;
import com.elec5619.easysports.domain.VisitRecord;
import com.elec5619.easysports.service.HistoryService;
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
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;

    @Override
    public VisitRecord getHistoryByID(int id) {
        return historyDao.getVisitRecordByID(id);
    }


    @Override
    public List<VisitRecord> getAllVisitRecord() {
        return historyDao.getVisitRecordList();
    }

    @Override
    public void addToHistory(VisitRecord visitRecord) {
        historyDao.saveVisitRecord(visitRecord);
    }

    @Override
    public String getHistoryJson(int userID) throws IOException {
        List<VisitRecord> list = historyDao.findAllByProperty("userID", userID);

        ObjectMapper objectMapper = new ObjectMapper();//jackson
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        objectMapper.writeValue(out, list);
        byte[] data = out.toByteArray();
        System.out.println(new String(data, StandardCharsets.UTF_8));
        return new String(data, StandardCharsets.UTF_8);
    }

    @Override
    public List<VisitRecord> findAllByProperty(String property, Object value) {
        return historyDao.findAllByProperty(property, value);
    }

}
