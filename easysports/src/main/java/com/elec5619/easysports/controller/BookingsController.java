package com.elec5619.easysports.controller;

import com.elec5619.easysports.service.BookingService;
import com.elec5619.easysports.service.CommentService;
import com.elec5619.easysports.utility.SessionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class BookingsController {

    @Autowired
    BookingService bookingService;
    /**
     * Simply selects the home view to render by returning its name.
     */

    @RequestMapping(value = "/bookings", method = RequestMethod.GET)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String viewbooking(Model model) throws IOException {
        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
            model.addAttribute("booking", bookingService.getAllbookings(SessionUtil.getCurrentUser().getId()));
        }
        return "bookings"; //return
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.POST)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String manage(@RequestParam("bookingid")String bookingid,Model model) throws IOException {
        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }
        model.addAttribute("bookingid",bookingid);
        return "redirect:/manage"; //return
    }

}