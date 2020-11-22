package com.elec5619.easysports.service.impl;

import com.elec5619.easysports.dao.BookingDao;
import com.elec5619.easysports.dao.PlaygroundDao;
import com.elec5619.easysports.dao.TimePeriodDao;
import com.elec5619.easysports.dao.impl.BookingDaoImpl;
import com.elec5619.easysports.dao.impl.CommentDaoImpl;
import com.elec5619.easysports.dao.impl.PlaygroundDaoImpl;
import com.elec5619.easysports.dao.impl.TimePeriodDaoImpl;
import com.elec5619.easysports.domain.Booking;
import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.service.BookingService;
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
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private PlaygroundDao playgroundDao;
    @Autowired
    private TimePeriodDao timePeriodDao;

    @Override
    public int insert(Booking booking) {
        return bookingDao.add_booking(booking);
    }

    @Override
    public void delete(int bookingid) {
        bookingDao.delet_booking(bookingid);
        System.out.println("delete booking id: "+bookingid);

    }

    @Override
    public void update(Booking booking) {

    }

    @Override
    public List<Booking> findallbookingsbyuserid(int userId) {
        return null;
    }

    @Override
    public Booking findbooking(int bookingid) {
        return bookingDao.get_booking(bookingid);
    }

    @Override
    public List<Booking> findallbookingsbyplaygroundid(int playgroundid) {
        return null;
    }
    @Override
    public String getAllbookings(int userID) throws IOException {
        List<Booking> bookings = bookingDao.getbookinglist(userID);
        for(Booking booking:bookings){
            booking.setPlaygroundname(playgroundDao.getById(booking.getPlaygroundId()).getName());
            booking.setBookingdate(timePeriodDao.getById(booking.getTimePeriodId()).getDay());
            booking.setTimeperiod(timePeriodDao.getById(booking.getTimePeriodId()).getTimeType());
            booking.setPlaygroundimage(playgroundDao.getById(booking.getPlaygroundId()).getImageUrl());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        objectMapper.writeValue(out, bookings);
        byte[] data = out.toByteArray();
        System.out.println(new String(data, StandardCharsets.UTF_8));
        return new String(data, StandardCharsets.UTF_8);
    }
}
