package com.elec5619.easysports.dao.impl;


import com.elec5619.easysports.dao.BookingDao;
import com.elec5619.easysports.domain.Booking;
import com.elec5619.easysports.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional(readOnly  =false)

public class BookingDaoImpl extends AbstractDao<Integer, Booking> implements BookingDao {

    @Override
    public int add_booking(Booking booking) {
        save(booking);
        return booking.getId();

    }

    @Override
    public Booking get_booking(int booking_id) {
        return getByKey(booking_id);
    }

    @Override
    public List<Booking> getbookinglist(int user_id) {
        return getListByProperty("userId", user_id);
    }


    @Override
    public void delet_booking(int booking_id) {
        delete(get_booking(booking_id));

    }

}
