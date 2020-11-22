package com.elec5619.easysports.controller;

import com.elec5619.easysports.domain.Booking;
import com.elec5619.easysports.domain.TimePeriod;
import com.elec5619.easysports.service.BookingService;
import com.elec5619.easysports.service.TimePeriodService;
import com.elec5619.easysports.utility.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManageController {
    /**
     * Simply selects the home view to render by returning its name.
     */
    @Autowired
    BookingService bookingService;

    @Autowired
    TimePeriodService timePeriodService;

    @RequestMapping(value = "/manage", method = RequestMethod.POST)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String cancel(@RequestParam("bookingid")String bookingid,Model model)throws DuplicateKeyException {
        System.out.println("1234567890!!!!!!!!!");
        String[] bookingids=bookingid.split(",");
        System.out.println(bookingids);
        bookingid=bookingids[0];
        System.out.println("delete the booking: "+bookingid);
        int timePeriodId = bookingService.findbooking(Integer.parseInt(bookingid)).getTimePeriodId();
        TimePeriod timePeriod =  timePeriodService.getById(timePeriodId);
        timePeriod.setAvailable(true);
        timePeriod.setBookingId(0);
        timePeriodService.update(timePeriod);
        bookingService.delete(Integer.parseInt(bookingid));

        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }

        return "redirect:/bookings"; //return manage.jsp
    }
    @RequestMapping(value = "/manage", method = RequestMethod.GET)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String getPlayground_id(@RequestParam("bookingid")String bookingid, Model model) {
        Booking booking=bookingService.findbooking(Integer.parseInt(bookingid));

        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }

        model.addAttribute("playgroundname",booking.getPlaygroundname() );
        model.addAttribute("image",booking.getPlaygroundimage() );
        model.addAttribute("date","Date: "+booking.getBookingdate());
        model.addAttribute("time","Time: "+booking.getTimeperiod());
        model.addAttribute("id",booking.getId());

        return "manage";
    }
}