package com.elec5619.easysports.controller;


import com.elec5619.easysports.domain.*;
import com.elec5619.easysports.service.*;
import com.elec5619.easysports.service.impl.CommentServiceImpl;
import com.elec5619.easysports.service.impl.FavouriteServiceImpl;
import com.elec5619.easysports.service.impl.TimePeriodServiceImpl;
import com.elec5619.easysports.utility.LoginUser;
import com.elec5619.easysports.utility.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class PlaygroundController {
    /**
     * Simply selects the home view to render by returning its name.
     */
    @Autowired
    private PlaygroundService playgroundService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private TimePeriodServiceImpl timePeriodService;
    @Autowired
    private FavouriteServiceImpl favouriteService;

    @Autowired
    CommentServiceImpl commentService;



    @RequestMapping(value = "/playground", method = RequestMethod.GET)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String viewplayground(@RequestParam("selectedDay")String selectedDay, Model model) throws IOException {
//        int playground_id=SessionUtil.getcurplayground().getId();
        int playground_id = Integer.parseInt(SessionUtil.getcurplayground());
        System.out.println("playground_id"+playground_id);
        System.out.println(selectedDay+"!!!!!!");
        String avaiabletime= timePeriodService.findallavaiabletime(playground_id,selectedDay);
        System.out.println(avaiabletime);
        Playground playground = playgroundService.getById(playground_id);
        model.addAttribute("playgroundtype",playgroundService.getById(playground_id).getType());
        System.out.println("playgroundtype"+playgroundService.getById(playground_id).getType());
        model.addAttribute("avaiabletime",avaiabletime);
        model.addAttribute("playgroundId", playground_id);//TODO:WYX
        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }
        model.addAttribute("playgroundname",playgroundService.getById(playground_id).getName() );
        model.addAttribute("rating", "Rating: "+playgroundService.getById(playground_id).getRating());
        model.addAttribute("image1", playgroundService.getById(playground_id).getImageUrlE());
        model.addAttribute("image2", playgroundService.getById(playground_id).getImageUrlP());
        model.addAttribute("address", "Address: "+playgroundService.getById(playground_id).getAddress());
        model.addAttribute("selectedDay", selectedDay);
        String require ="";
        if (playground.isBookingRequired()==false){
            require="No";
        }
        if (playground.isBookingRequired()==true){
            require="Yes";
        }
        model.addAttribute("bookreauire", "Booking required: "+require);
        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("commentCurr", commentService.getCommentsByPlayground(Integer.parseInt(SessionUtil.getcurplayground())));
        }
        return "playground"; //return login.jsp
    }


    @RequestMapping(value = "/playground", method = RequestMethod.POST)
    public ModelAndView booking(@RequestParam("bookingtimeid")String timePeriodId) throws DuplicateKeyException {
        Booking booking= new Booking();
        booking.setUserId(SessionUtil.getCurrentUser().getId());
        booking.setTimePeriodId(Integer.parseInt(timePeriodId));
        booking.setPlaygroundId(Integer.parseInt(SessionUtil.getcurplayground()));
        booking.setStatus("created");
        booking.setCreateTime(new Date());
        TimePeriod timePeriod=timePeriodService.getById(Integer.parseInt(timePeriodId));
        timePeriod.setAvailable(false);
        timePeriodService.update(timePeriod);
        System.out.println(timePeriodService.getById(Integer.parseInt(timePeriodId)));
        System.out.println("new booked"+booking.toString());
        bookingService.insert(booking);  //view -> controller -> service -> Dao -> database
        timePeriod.setBookingId(booking.getId());
        timePeriodService.update(timePeriod);
        return new ModelAndView("redirect:/bookings","message","Playground booked successfully!");
    }


}