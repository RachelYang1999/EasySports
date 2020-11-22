package com.elec5619.easysports.dao;

import com.elec5619.easysports.domain.Booking;

import java.util.List;

public interface BookingDao {
    public int add_booking(Booking booking);
    public Booking get_booking(int booking_id);
    public List<Booking> getbookinglist(int user_id);
    public void delet_booking(int booking_id);

}
