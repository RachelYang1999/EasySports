package com.elec5619.easysports.service;

import com.elec5619.easysports.domain.Booking;

import java.io.IOException;
import java.util.List;

public interface BookingService {

    int insert(Booking booking);

    void delete(int bookingid);

    void update(Booking booking);

    List<Booking> findallbookingsbyuserid(int userId);

    Booking findbooking(int bookingid);

    List<Booking> findallbookingsbyplaygroundid(int playgroundid);

    public String getAllbookings(int userID) throws IOException;





}
